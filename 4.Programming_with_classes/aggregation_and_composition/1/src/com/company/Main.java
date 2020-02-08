package com.company;

//Создать объект класса Текст, используя классы Предложение, Слово.
//Методы: дополнить текст, вывести на консоль текст, заголовок текста.
public class Main {

    public static void main(String[] args) {
        Word word1 = new Word("травка");
        Word word2 = new Word("зеленеет");
        Word word3 = new Word("солнышко");
        Word word4 = new Word("блестит");
        Word[] words1 = {word1,word2,word3,word4};
        Word word5 = new Word("создать");
        Word word6 = new Word("объект");
        Word word7 = new Word("класса");
        Word word8 = new Word("текст");
        Word[] words2 = {word5,word6,word7,word8};
        Sentence sentence1 = new Sentence(words1);
        Sentence sentence2 = new Sentence(words2);
        Sentence[] sentences = {sentence1,sentence2};
        Text text = new Text(sentences, "Заголовок текста");
        System.out.println("Вывод текста на консоль: ");
        text.output();
        System.out.println("Дополнение текста: ");
        text.addText(",",16);
        text.output();
        System.out.println("Заголовок текста: ");
        System.out.println(text.getTitle());
    }
}
