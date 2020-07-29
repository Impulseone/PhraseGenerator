package com.skynet.phrasegenerator.generators;

import com.skynet.phrasegenerator.helpers.WordsStore;

import java.util.Random;

public class FirstLevelGenerator extends Generator {

    private WordsStore wordsStore;
    private Random random = new Random();

    public FirstLevelGenerator(WordsStore wordsStore) {
        this.wordsStore = wordsStore;
    }

    @Override
    public String generatePhrase() {
        int k = 1 + random.nextInt(6);
        if (k == randomPhraseNumber) return generatePhrase();
        else randomPhraseNumber = k;
        switch (k) {
            case 1:
                return firstFigure();
            case 2:
                return secondFigure();
            case 3:
                return thirdFigure();
            case 4:
                return fourthFigure();
            case 5:
                return fifthFigure();
            case 6:
                return sixthFigure();
        }
        return null;
    }

    private String firstFigure() {
        // Все коты - это укропы.
        // Башмаки - это коты.
        String nounA = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounB = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounC = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        if (checkEquals(new String[]{nounA, nounB, nounC})) return firstFigure();
        return "Все " + nounA + " - это " + nounB + "." + "\n" + toFirstUpperCase(nounC) + " - это " + nounA + ".";
    }

    private String secondFigure() {
        // Все коты обладают свойством мягкий.
        // Башмаки не обладают свойством мягкий.
        String nounA = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounB = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String adjA = wordsStore.getAdjectives().get(random.nextInt(wordsStore.getAdjectives().size() - 1)).getSingularMale();
        if (checkEquals(new String[]{nounA, nounB})) return secondFigure();
        return "Все " + nounA + " обладают свойством " + adjA + "." + "\n" + toFirstUpperCase(nounB) + " не обладают свойством " + adjA + ".";
    }

    private String thirdFigure() {
        // Все коты - это укропы.
        // Все коты - это гречки.
        String nounA = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounB = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounC = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        if (checkEquals(new String[]{nounA, nounB, nounC})) return thirdFigure();
        return "Все " + nounA + " - это " + nounB + "." + "\n" + "Все " + nounA + " - это " + nounC + ".";
    }

    private String fourthFigure() {
        // Все коты - это укропы.
        // Все укропы - это не гречки.
        String nounA = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounB = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounC = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        if (checkEquals(new String[]{nounA, nounB, nounC})) return fourthFigure();
        return "Все " + nounA + " - это " + nounB + "." + "\n" + "Все " + nounB + " - это не " + nounC + ".";
    }

    private String fifthFigure() {
        // Все коты - это укропы.
        // Лагеря и занавесы - это коты.
        String nounA = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounB = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounC = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounD = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        if (checkEquals(new String[]{nounA, nounB, nounC, nounD})) return fifthFigure();
        String variantOne = "Все " + nounA + " - это " + nounB + "." + "\n" + toFirstUpperCase(nounC) + " и " + nounD + " - это " + nounA + ".";
        String variantTwo = toFirstUpperCase(nounC) + " и " + nounD + " - это " + nounA + "." + "\n" + toFirstUpperCase(nounA) + " - это " + nounB + ".";
        String[] variants = new String[]{variantOne, variantTwo};
        return variants[random.nextInt(2)];
    }


    private String sixthFigure() {
        // Изгибы неправильные.
        // Неправильные предметы служат.
        String nounAPlural = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounASingular = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getSingular();
        String adjAPlural = wordsStore.getAdjectives().get(random.nextInt(wordsStore.getAdjectives().size() - 1)).getPlural();
        String adjASingular = wordsStore.getAdjectives().get(random.nextInt(wordsStore.getAdjectives().size() - 1)).getSingularMale();
        String verbA = wordsStore.getVerbs().get(random.nextInt(wordsStore.getVerbs().size() - 1)).getPlural();
        String variantOne = toFirstUpperCase(nounAPlural) + " " + adjAPlural + "." + "\n" + toFirstUpperCase(adjAPlural) + " предметы " + verbA + ". ";
        String variantTwo = toFirstUpperCase(adjAPlural) + " предметы " + verbA + ". " + "\n" + toFirstUpperCase(nounAPlural) + " " + adjAPlural + ".";
        String variantThree = toFirstUpperCase(nounASingular) + " " + adjASingular + "." + "\n" + toFirstUpperCase(adjAPlural) + " предметы " + verbA + ". ";
        String variantFour = toFirstUpperCase(adjAPlural) + " предметы " + verbA + ". " + "\n" + toFirstUpperCase(nounASingular) + " " + adjASingular + ".";
        String[] variants = new String[]{variantOne, variantTwo, variantThree, variantFour};
        return variants[random.nextInt(4)];
    }
}
