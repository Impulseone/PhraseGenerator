package com.skynet.phrasegenerator.generators;

import com.skynet.phrasegenerator.helpers.WordsStore;

import java.util.Random;

public abstract class Generator {

    public WordsStore wordsStore = WordsStore.getInstance();

    public Random random = new Random();

    public int randomPhraseNumber = 0;

    public abstract String generatePhrase();

    public String getRandomUnion() {
        String unionOne = " и ";
        String unionTwo = " или ";
        String[] unions = new String[]{unionOne, unionTwo};
        return unions[random.nextInt(unions.length)];
    }

    public String getRandomUnionBetweenTwoSubjects() {
        String unionTwo = " либо ";
        String unionThree = " либо только ";
        String[] unions = new String[]{unionTwo, unionThree};
        return unions[random.nextInt(unions.length)];
    }

    public String getRandomNegation() {
        String negOne = " не ";
        String negTwo = "";
        String[] negations = new String[]{negOne, negTwo};
        return negations[random.nextInt(negations.length)];
    }

    public String getRandomParticle() {
        String particleOne = " только ";
        String particleTwo = " не ";
        String[] particles = new String[]{particleOne, particleTwo};
        return particles[random.nextInt(particles.length)];
    }

    public String getRandomDemonstrative() {
        String pronounOne = " - это ";
        String pronounTwo = " - это не ";
        String pronounThree = " есть ";
        String[] pronouns = new String[]{pronounOne, pronounTwo, pronounThree};
        return pronouns[random.nextInt(pronouns.length)];
    }

    public String getRandomPronoun() {
        String pronounOne = "Все ";
        String pronounTwo = "Некоторые ";
        String[] pronouns = new String[]{pronounOne, pronounTwo};
        return pronouns[random.nextInt(pronouns.length)];
    }

    public String getRandomProperty() {
        String propOne = " обладают свойством ";
        String propTwo = " не обладают свойством ";
        String[] properties = new String[]{propOne, propTwo};
        return properties[random.nextInt(properties.length)];
    }

    public String getRandomPropertyForTwoSubjects() {
        String propOne = " обладают свойством ";
        String propTwo = " бывают ";
        String propThree = " делятся на ";
        String[] properties = new String[]{propOne, propTwo, propThree};
        return properties[random.nextInt(properties.length)];
    }

    public String getRandomSubject() {
        String subjOne = " предметы ";
        String subjTwo = " объекты ";
        String[] subjects = new String[]{subjOne, subjTwo};
        return subjects[random.nextInt(subjects.length)];
    }

    public String toFirstUpperCase(String word) {
        if (word == null || word.equals("")) return "";
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    public String toFirstUpperCaseTwo(String word) {
        if (word == null || word.equals("")) return "";
        return word.substring(1, 2).toUpperCase() + word.substring(2);
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
