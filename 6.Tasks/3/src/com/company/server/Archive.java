package com.company.server;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static com.company.server.Server.in;
import static com.company.server.Server.out;

public class Archive {
    private static volatile Archive instance;
    private final ArrayList<String> tagName = new ArrayList<>(Arrays.asList("name", "course", "averageMark", "union"));
    private final ArrayList<Dossier> dossiers = new ArrayList<>();

    public static Archive getInstance() {
        Archive localInstance = instance;
        if (localInstance == null) {
            synchronized (Archive.class) {
                localInstance = instance;
                if (localInstance == null) {
                    localInstance = new Archive();
                    instance = localInstance;
                    instance.parseDossiersFromXML();
                }
            }
        }
        return localInstance;
    }

    private static Node createDossier(Document doc, String id, String name,
                                      String course, String averageMark, String union) {

        Element dossier = doc.createElement("dossier");

        dossier.setAttribute("id", id);
        dossier.appendChild(createUserElement(doc, "name", name));
        dossier.appendChild(createUserElement(doc, "course", course));
        dossier.appendChild(createUserElement(doc, "averageMark", averageMark));
        dossier.appendChild(createUserElement(doc, "union", union));

        return dossier;
    }

    private static Node createUserElement(Document doc, String name,
                                          String value) {

        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));

        return node;
    }

    void parseDossiersFromXML() {
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File("archive.xml"));
            doc.getDocumentElement().normalize();
            NodeList listOfDossiers = doc.getElementsByTagName("dossier");
            for (int i = 0; i < listOfDossiers.getLength(); i++) {
                ArrayList<String> tagsContent = new ArrayList<>();
                Node DossierNode = listOfDossiers.item(i);
                if (DossierNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) DossierNode;
                    int id = Integer.parseInt(element.getAttribute("id"));
                    for (String s : tagName) {
                        tagsContent.add(getChildElementValue(s, element));
                    }
                    dossiers.add(new Dossier(id, tagsContent.get(0), Integer.parseInt(tagsContent.get(1)),
                            Double.parseDouble(tagsContent.get(2)),
                            Boolean.parseBoolean(tagsContent.get(3))));
                }
            }
        } catch (SAXParseException err) {
            System.out.println("** Parsing error" + ", line " + err.getLineNumber() + ", uri " + err.getSystemId());
            System.out.println(" " + err.getMessage());
        } catch (SAXException e) {
            Exception x = e.getException();
            ((x == null) ? e : x).printStackTrace();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private String getChildElementValue(String tagName, Element element) {
        Node tagNode = element.getElementsByTagName(tagName).item(0);
        if (tagNode == null) {
            return null;
        }
        NodeList nodes = tagNode.getChildNodes();
        Node node = nodes.item(0);

        return node.getNodeValue();
    }

    public void viewDossiers() {
        for (Dossier dossier : dossiers) {
            out.println("id: " + dossier.getId() + " "
                    + tagName.get(0) + ": " + dossier.getName() + " "
                    + tagName.get(1) + ": " + dossier.getCourse() + " "
                    + tagName.get(2) + ": " + dossier.getAverageMark() + " "
                    + tagName.get(3) + ": " + dossier.getUnionMember());
        }
    }

    public void changeDossier() {
        try {
            out.println("Введите id Досье, которое вы хотите изменить: ");
            out.println("?needAnswer");
            int id = Integer.parseInt(in.readLine());
            out.println("Выберите параметр, который вы хотиет изменить: ");
            for (int i = 0; i < tagName.size(); i++) {
                out.println((i + 1) + "." + tagName.get(i));
            }
            out.println("?needAnswer");
            int numberOfArgument = Integer.parseInt(in.readLine());
            for (Dossier dossier : dossiers) {
                if (dossier.getId() == id) {
                    switch (numberOfArgument) {
                        case 1:
                            out.println("Введите имя студента: ");
                            out.println("?needAnswer");
                            dossier.setName(in.readLine());
                            break;
                        case 2:
                            out.println("Введите номер курса: ");
                            out.println("?needAnswer");
                            dossier.setCourse(Integer.parseInt(in.readLine()));
                            break;
                        case 3:
                            out.println("Введите средний балл: ");
                            out.println("?needAnswer");
                            dossier.setAverageMark(Double.parseDouble(in.readLine()));
                            break;
                        case 4:
                            out.println("Введите true если, студент является членом профсоюза: ");
                            out.println("?needAnswer");
                            dossier.setUnionMember(Boolean.parseBoolean(in.readLine()));
                            break;
                        default:
                            out.println("Ошибка! Выход за диапазон значений");
                    }
                }
            }
            updateArchiveFile();
        } catch (IOException | ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private void updateArchiveFile() throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        Element root = doc.createElement("dossiers");
        doc.appendChild(root);
        for (Dossier dossier : dossiers) {
            root.appendChild(createDossier(doc, String.valueOf(dossier.getId()), dossier.getName(),
                    String.valueOf(dossier.getCourse()), String.valueOf(dossier.getAverageMark()),
                    String.valueOf(dossier.getUnionMember())));
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        DOMSource source = new DOMSource(doc);

        File myFile = new File("archiveTemp.xml");
        StreamResult file = new StreamResult(myFile);
        transformer.transform(source, file);
        updateFile(myFile);
    }

    private void updateFile(File tempFile) {
        File inputFile = new File("archive.xml");
        if (inputFile.delete()) {
            if (tempFile.renameTo(inputFile)) {
                out.println("\nФайл " + inputFile.getName() + " успешно обновлён");
            } else {
                out.println("\nНе удалось обновить файл " + inputFile.getName());
            }
        } else {
            out.println("\nНе удалось удалить файл " + inputFile.getName());
        }
    }

    public void addDossier() {
        try {
            out.println("Введите id нового осье: ");
            out.println("?needAnswer");
            int id = Integer.parseInt(in.readLine());
            out.println("Введите имя студента: ");
            out.println("?needAnswer");
            String name = in.readLine();
            out.println("Введите номер курса: ");
            out.println("?needAnswer");
            int course = Integer.parseInt(in.readLine());
            out.println("Введите средний балл: ");
            out.println("?needAnswer");
            double averageMark = Double.parseDouble(in.readLine());
            out.println("Введите true если, студент является членом профсоюза: ");
            out.println("?needAnswer");
            boolean isUnionMember = Boolean.parseBoolean(in.readLine());
            dossiers.add(new Dossier(id, name, course, averageMark, isUnionMember));
            updateArchiveFile();
        } catch (IOException | ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    public void deleteDossier() {
        try {
            out.println("Введите id досье, которое вы хотите удалить: ");
            out.println("?needAnswer");
            int id = Integer.parseInt(in.readLine());
            for (Dossier dossier : dossiers) {
                if (dossier.getId() == id) {
                    dossiers.remove(dossier);
                    updateArchiveFile();
                    out.println("Досье с id " + id + " успешно удалено!");
                    return;
                }
            }
            out.println("Досье с id " + id + " не было найдено.");
        } catch (IOException | ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}