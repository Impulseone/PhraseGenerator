package com.skynet.phrasegenerator.generators;

public abstract class Generator {

    int randomPhraseNumber = 0;

    public abstract String generatePhrase();

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
