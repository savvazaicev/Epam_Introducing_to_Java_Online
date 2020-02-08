package com.company;

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
}
