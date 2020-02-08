package com.company.regular_expressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных
//операции: 1.отсортировать абзацы по количеству предложений; 2.в каждом предложении отсортировать слова по длине;
//3.отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по
//алфавиту.
public class task_1 {
    public static void main(String[] args) throws IllegalStateException {
        String str = "\tВесна - прекрасное время года. Весной разбухают почки, становится теплее после холодных зим," +
                " расцветают всеми любимые цветы подснежники. У всех растений начинается жизнь.\n" +
                "\tЖурчат ручьи, по крышам домов капает капель. Солнце светит всё ярче и ярче. " +
                "Тает снег, травка зеленеет, птички прилетают с югов. Весна бывает теплая, бывает холодная.\n" +
                "\tЯ надеюсь, что нынешняя весна будет тёплой и селнечной. " +
                "Природа оживает в это замечательное время года. А после весны настаёт лето.";
        String task_1 = "1.отсортировать абзацы по количеству предложений";
        String task_2 = "2.отсортировать в каждом предложении слова по длине";
        String task_3 = "3.отсортировать лексемы в предложении по убыванию";
        System.out.println("Введите номер операции:\n" + task_1 + "\n" + task_2 + "\n" + task_3);
        Scanner in = new Scanner(System.in);
        int taskNumber = in.nextInt();
        switch (taskNumber) {
            case (1):
                sortParagraphs(str);
                break;
            case (2):
                sortWordsByLength(str);
                break;
            case (3):
                System.out.println("Введите символ для сортировки (на русском!): ");
                Scanner sc = new Scanner(System.in);
                String symbol = sc.nextLine();
                sortTokensbyAmount(str, symbol.charAt(0));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + taskNumber);
        }
    }

    private static void sortTokensbyAmount(String str, char symbol) {
        str = str.replaceAll("[,\\-:—]", "");
        Pattern punctuation = Pattern.compile("[.?!]");
        String[] sentences = punctuation.split(str);
        for (String sentence : sentences) {
            Pattern space = Pattern.compile("\\s");
            String[] words = space.split(sentence);
            ArrayList<Integer> symbolCountByIndex = new ArrayList<>(words.length);
            for (int j = 0; j < words.length; j++) {
                Pattern pattern = Pattern.compile(String.valueOf(symbol));
                Matcher matcher = pattern.matcher(words[j]);
                int count = 0;
                int startIndex = -1;
                while (matcher.find(startIndex + 1)) {
                    startIndex = matcher.start();
                    count++;
                }
                symbolCountByIndex.add(j, count);
            }
            //поиск индекса слова с максимальным вхождением заданного символа
            int[] sortedIndexesOfWords = new int[symbolCountByIndex.size()];
            for (int j = 0; j < sortedIndexesOfWords.length; j++) {
                int maxCountOfSymbol = 0;
                int indexOfMax = 0;
                for (int i = 0; i < symbolCountByIndex.size(); i++) {
                    boolean sortedIndexOfWord = false;
                    for (int k = 0; k < j; k++) {
                        if (sortedIndexesOfWords[k] == i) {
                            sortedIndexOfWord = true;
                            break;
                        }
                    }
                    int count = symbolCountByIndex.get(i);
                    if (!sortedIndexOfWord) {
                        if (count != 0) {
                            if (count > maxCountOfSymbol) {
                                maxCountOfSymbol = count;
                                indexOfMax = i;
                            } else if (count == maxCountOfSymbol) {
                                if (compareByAlphabet(words[i], words[indexOfMax])) {
                                    indexOfMax = i;
                                }
                            }
                        }
                    }
                }
                if (indexOfMax != 0) {
                    sortedIndexesOfWords[j] = indexOfMax;
                } else {
                    int indexOfMaxByAlphabet = 0;
                    for (int i = 0; i < symbolCountByIndex.size(); i++) {
                        boolean wordIsSorted = false;
                        for (int k = 0; k < j; k++) {
                            if (sortedIndexesOfWords[k] == i) {
                                wordIsSorted = true;
                                break;
                            }
                        }
                        if (!wordIsSorted) {
                            indexOfMaxByAlphabet = i;
                        }
                    }
                    for (int i = 0; i < symbolCountByIndex.size(); i++) {
                        boolean sortedIndexOfWord = false;
                        for (int k = 0; k < j; k++) {
                            if (sortedIndexesOfWords[k] == i) {
                                sortedIndexOfWord = true;
                                break;
                            }
                        }
                        if (!sortedIndexOfWord) {
                            int count = symbolCountByIndex.get(i);
                            if (count == 0) {
                                if (compareByAlphabet(words[i], words[indexOfMaxByAlphabet])) {
                                    indexOfMaxByAlphabet = i;
                                }
                            }
                        }
                    }
                    sortedIndexesOfWords[j] = indexOfMaxByAlphabet;
                }
            }
            String sortedSentence = words[sortedIndexesOfWords[0]];
            for (int i = 1; i < sortedIndexesOfWords.length; i++) {
                sortedSentence += " " + words[sortedIndexesOfWords[i]];
            }
            //удаление лишних пробелов
            sortedSentence = sortedSentence.trim();
            while (sortedSentence.contains("  ")) {
                sortedSentence = sortedSentence.replaceAll("  ", " ");
            }
            System.out.println(sortedSentence);
        }
    }

    private static boolean compareByAlphabet(String word_1, String word_2) {
        String[] strings = {word_1, word_2};
        Arrays.sort(strings);
        return strings[0].equals(word_1);
    }


    private static void sortWordsByLength(String str) {
        str = str.replaceAll("[,\\-:—]", "");
        Pattern punctuation = Pattern.compile("[.?!]");
        String[] sentences = punctuation.split(str);
        for (int i = 0; i < sentences.length; i++) {
            Pattern space = Pattern.compile("\\s");
            String[] words = space.split(sentences[i]);
            ArrayList<Integer> wordsIndexesByLength = new ArrayList<>();
            int[] maxLengthIndex = new int[words.length];
            for (int k = 0; k < words.length; k++) {
                int maxLength = 0;
                for (int j = 0; j < words.length; j++) {
                    boolean flag = false;
                    for (int l = 0; l <= k; l++) {
                        if (j == maxLengthIndex[l]) {
                            flag = true;
                            break;
                        }
                    }
                    if (words[j].length() > maxLength && !flag) {
                        maxLength = words[j].length();
                        maxLengthIndex[k] = j;
                    }
                }
                wordsIndexesByLength.add(maxLengthIndex[k]);
            }
            String sortedSentence = words[wordsIndexesByLength.get(0)] + " ";
            for (int j = 1; j < words.length; j++) {
                if (j != words.length - 1) {
                    sortedSentence += words[wordsIndexesByLength.get(j)] + " ";
                } else {
                    sortedSentence += words[wordsIndexesByLength.get(j)];
                }
            }
            sentences[i] = sortedSentence.trim();
            if (i == 0) {
                str = sentences[i] + ".";
            } else {
                str += " " + sentences[i] + ".";
            }
        }
        System.out.println(str);
    }

    private static void sortParagraphs(String str) {
        Pattern pattern = Pattern.compile("\n");
        String[] paragraphs = pattern.split(str);
        ArrayList<Integer> paragraphsIndexes = new ArrayList<>();
        for (String paragraph : paragraphs) {
            int count = 0;
            for (int j = 0; j < paragraph.length(); j++) {
                char ch = paragraph.charAt(j);
                if (ch == '.' || ch == '!' || ch == '?') {
                    count++;
                }
            }
            paragraphsIndexes.add(count);
        }
        String newStr = null;
        for (int k = 0; k < paragraphsIndexes.size(); k++) {
            int max = paragraphsIndexes.get(0);
            int maxIndex = 0;
            for (int i = 1; i < paragraphs.length; i++) {
                if (paragraphsIndexes.get(i) > max) {
                    max = paragraphsIndexes.get(i);
                    maxIndex = i;
                }
            }
            paragraphsIndexes.set(maxIndex, 0);
            if (newStr != null) {
                newStr += paragraphs[maxIndex] + "\n";
            } else {
                newStr = paragraphs[maxIndex] + "\n";
            }
        }
        System.out.println(newStr);
    }
}
