package com.skynet.phrasegenerator.generators;

import java.util.Random;

public abstract class Generator {

    int randomPhraseNumber = 0;

    public abstract String generatePhrase();

    public String getRandomUnion() {
        Random random = new Random();
        String unionOne = " - это ";
        String unionTwo = " - это не ";
        String unionThree = " есть ";
        String[] unions = new String[]{unionOne, unionTwo, unionThree};
        return unions[random.nextInt(unions.length)];
    }

    public String getRandomProperty() {
        Random random = new Random();
        String propOne = " обладают свойством ";
        String propTwo = " не обладают свойством ";
        String[] properties = new String[]{propOne, propTwo};
        return properties[random.nextInt(properties.length)];
    }

    public String getRandomSubject() {
        Random random = new Random();
        String subjOne = " предметы ";
        String subjTwo = " объекты ";
        String[] subjects = new String[]{subjOne, subjTwo};
        return subjects[random.nextInt(subjects.length)];
    }

    public String toFirstUpperCase(String word) {
        if (word == null || word.equals("")) return "";
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    public boolean checkEquals(String[] words) {
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}
