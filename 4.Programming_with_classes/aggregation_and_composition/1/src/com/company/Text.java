package com.company;

//Создать объект класса Текст, используя классы Предложение, Слово.
//Методы: дополнить текст, вывести на консоль текст, заголовок текста.
public class Text {
    private String text;
    private String title;
    private Sentence[] sentences;

    public Text(Sentence[] sentences, String title) {
        this.text = sentenceToText(sentences);
        this.sentences = sentences;
        this.title = title;
    }

    private String sentenceToText(Sentence[] sentences) {
        StringBuilder text = new StringBuilder("\t" + sentences[0].getSentence());
        for (int i = 1; i < sentences.length; i++) {
            text.append(" ").append(sentences[i].getSentence());
        }
        return text.toString();
    }

    public void output() {
        System.out.println(getText());
    }

    public void addText(String str, int index) {
        StringBuilder text = new StringBuilder(getText());
        text.insert(index,str);
        setText(text.toString());
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }
}

