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

    public Sentence[] getSentences() {
        return sentences;
    }

    public void setSentences(Sentence[] sentences) {
        this.sentences = sentences;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

class Sentence {
    private String sentence;
    private Word[] words;

    public Sentence(Word[] words) {
        this.sentence = wordToSentecne(words);
        this.words = words;
    }

    private String wordToSentecne(Word[] word) {
        //инициализая предложения первым словом
        StringBuilder sentence = new StringBuilder(word[0].getWord());
        //первое слово с большой буквы
        String firstLetter = sentence.substring(0,1);
        firstLetter = firstLetter.toUpperCase();
        sentence.deleteCharAt(0);
        sentence.insert(0,firstLetter);
        //добавление пробелов, слов и точки в конце предложения
        for (int i = 1; i < word.length; i++) {
            sentence.append(" ").append(word[i].getWord());
        }
        sentence.append(".");
        return sentence.toString();
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public Word[] getWords() {
        return words;
    }

    public void setWords(Word[] words) {
        this.words = words;
    }
}

class Word {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
