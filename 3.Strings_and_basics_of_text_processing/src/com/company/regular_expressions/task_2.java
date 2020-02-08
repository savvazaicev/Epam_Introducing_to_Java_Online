package com.company.regular_expressions;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;

//Дана строка, содержащая следующий текст (xml-документ).
//Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его тип:
//открывающий тег, закрывающий тег, содержимое тега, тег без тела.
//Пользоваться готовыми парсерами XML для решения данной задачи нельзя.
public class task_2 {
    public static void main(String[] args) {
        Document xmlDocument = convertXMLFileToXMLDocument("E:\\_Android_projects\\Epam_Introducing_to_Java_online\\3.Strings_and_basics_of_text_processing\\src\\com\\company\\regular_expressions\\xml.xml");
        String xmlString = writeXmlDocumentToXmlFile(xmlDocument);
        assert xmlString != null;
        String[][] xmlContent = analyzer(xmlString);
        for (String[] strings : xmlContent) {
            System.out.println("Открывающий тег: " + strings[0]);
            System.out.println("Закрывающий тег: " + strings[1]);
            System.out.println("Содержимое тега: " + strings[2]);
            System.out.println("Тег без тела: " + strings[3]);
            if (strings[4] != null) {
                System.out.println("Атрибут тега: " + strings[4]);
                System.out.println("Значение атрибута: " + strings[5]);
            }
        }
    }

    private static String[][] analyzer(String xmlString) {
        ArrayList<String> tagName = new ArrayList<>();
        int startIndex = -1;
        while (xmlString.indexOf("<", startIndex + 1) != -1) {
            startIndex = xmlString.indexOf("<", startIndex + 1);
            if (xmlString.charAt(startIndex + 1) != '/') {
                tagName.add(xmlString.substring(startIndex + 1, xmlString.indexOf(">", startIndex)));
            }
        }
        String[][] xmlContent = new String[tagName.size()][6];
        ArrayList<String> usedTags = new ArrayList<>();
        int[][] usedIndexes = new int[tagName.size()][2];
        for (int i = 0; i < tagName.size(); i++) {
            for (int j = 0; j < tagName.size(); j++) {
                int spaceIndex = tagName.get(j).indexOf(' ');
                if (spaceIndex != -1) {
                    xmlContent[j][4] = tagName.get(j).substring(spaceIndex + 1, tagName.get(j).indexOf('='));
                    xmlContent[j][5] = tagName.get(j).substring(tagName.get(j).indexOf('"') + 1,tagName.get(j).lastIndexOf('"'));
                }
            }
            boolean usedTag = false;
            int indexOfUsedTag = i;
            for (int j = 0; j < usedTags.size(); j++) {
                int spaceIndex = tagName.get(i).indexOf(' ');
                String tagNameTemp = tagName.get(i);
                if (spaceIndex != -1) {
                    tagNameTemp = tagName.get(i).substring(0, spaceIndex);
                }
                if (compareStrings(usedTags.get(j), tagNameTemp)) {
                    usedTag = true;
                    indexOfUsedTag = j;
                }
            }
            xmlContent[i][0] = "<" + tagName.get(i) + ">";
            int spaceIndex = tagName.get(i).indexOf(' ');
            if (spaceIndex != -1) {
                tagName.add(i, tagName.get(i).substring(0, spaceIndex));
                tagName.remove(i + 1);
            }
            xmlContent[i][1] = "</" + tagName.get(i) + ">";
            usedTags.add(tagName.get(i));
            if (usedTag) {
                usedIndexes[i][0] = xmlString.indexOf(xmlContent[i][0], usedIndexes[indexOfUsedTag][0] + 1);
                usedIndexes[i][1] = xmlString.indexOf(xmlContent[i][1], usedIndexes[indexOfUsedTag][1] + 1);
                usedIndexes[indexOfUsedTag][0] = xmlString.indexOf(xmlContent[i][0], usedIndexes[indexOfUsedTag][0] + 1);
                usedIndexes[indexOfUsedTag][1] = xmlString.indexOf(xmlContent[i][1], usedIndexes[indexOfUsedTag][1] + 1);
                xmlContent[i][2] = xmlString.substring(usedIndexes[indexOfUsedTag][0] + xmlContent[i][0].length(), usedIndexes[indexOfUsedTag][1]);
            } else {
                usedIndexes[i][0] = xmlString.indexOf(xmlContent[i][0]);
                usedIndexes[i][1] = xmlString.indexOf(xmlContent[i][1]);
                xmlContent[i][2] = xmlString.substring(xmlString.indexOf(xmlContent[i][0]) + xmlContent[i][0].length(), xmlString.indexOf(xmlContent[i][1]));
            }
            xmlContent[i][3] = xmlContent[i][0] + xmlContent[i][1];
        }
        return xmlContent;
    }

    private static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static Document convertXMLFileToXMLDocument(String filePath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            return builder.parse(new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String writeXmlDocumentToXmlFile(Document xmlDocument) {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(xmlDocument), new StreamResult(writer));
            return writer.getBuffer().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}