package com.skynet.phrasegenerator.generators;

import com.skynet.phrasegenerator.entity.Adjective;
import com.skynet.phrasegenerator.entity.Noun;
import com.skynet.phrasegenerator.helpers.WordsStore;

public class FirstLevelGenerator extends Generator {

    private WordsStore wordsStore;

    public FirstLevelGenerator(WordsStore wordsStore) {
        this.wordsStore = wordsStore;
    }

    @Override
    public String generatePhrase() {
        int k = 1 + random.nextInt(7);
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
            case 7:
                return sevenFigure();
        }
        return null;
    }

    private String firstFigure() {
        // Коты - это укропы.
        // Башмаки - это коты.
        String nounA = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounB = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounC = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        if (checkEquals(new String[]{nounA, nounB, nounC})) return firstFigure();
        return toFirstUpperCase(nounA) + getRandomDemonstrative() + nounB + "." + "\n" + toFirstUpperCase(nounC) + getRandomDemonstrative() + nounA + ".";
    }

    private String secondFigure() {
        // Коты обладают свойством мягкий.
        // Башмаки не обладают свойством мягкий.
        String nounA = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounB = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String adjA = wordsStore.getAdjectives().get(random.nextInt(wordsStore.getAdjectives().size() - 1)).getSingularMale();
        if (checkEquals(new String[]{nounA, nounB})) return secondFigure();
        return toFirstUpperCase(nounA) + getRandomProperty() + adjA + "." + "\n" + toFirstUpperCase(nounB) + getRandomProperty() + adjA + ".";
    }

    private String thirdFigure() {
        // Коты - это укропы.
        // Коты - это гречки.
        String nounA = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounB = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounC = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        if (checkEquals(new String[]{nounA, nounB, nounC})) return thirdFigure();
        return toFirstUpperCase(nounA) + getRandomDemonstrative() + nounB + "." + "\n" + toFirstUpperCase(nounA) + getRandomDemonstrative() + nounC + ".";
    }

    private String fourthFigure() {
        // Коты - это укропы.
        // Укропы - это не гречки.
        String nounA = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounB = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounC = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        if (checkEquals(new String[]{nounA, nounB, nounC})) return fourthFigure();

        return toFirstUpperCase(nounA) + getRandomDemonstrative() + nounB + "." + "\n" + toFirstUpperCase(nounB) + getRandomDemonstrative() + nounC + ".";
    }

    private String fifthFigure() {
        // Коты - это укропы.
        // Лагеря и занавесы - это коты.
        String nounA = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounB = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounC = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounD = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        if (checkEquals(new String[]{nounA, nounB, nounC, nounD})) return fifthFigure();
        String variantOne = toFirstUpperCase(nounA) + getRandomDemonstrative() + nounB + "." + "\n" + toFirstUpperCase(nounC) + " и " + nounD + getRandomDemonstrative() + nounA + ".";
        String variantTwo = toFirstUpperCase(nounC) + " и " + nounD + getRandomDemonstrative() + nounA + "." + "\n" + toFirstUpperCase(nounA) + getRandomDemonstrative() + nounB + ".";
        String[] variants = new String[]{variantOne, variantTwo};

        return variants[random.nextInt(2)];
    }


    private String sixthFigure() {
        // Изгибы неправильные.
        // Неправильные предметы служат.
        String nounAPlural = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String adjAPlural = wordsStore.getAdjectives().get(random.nextInt(wordsStore.getAdjectives().size() - 1)).getPlural();
        String verbA = wordsStore.getVerbs().get(random.nextInt(wordsStore.getVerbs().size() - 1)).getPlural();

        String variantOne = toFirstUpperCase(nounAPlural) + " " + adjAPlural + "." + "\n" + toFirstUpperCase(adjAPlural) + getRandomSubject() + verbA + ". ";
        String variantTwo = toFirstUpperCase(adjAPlural) + getRandomSubject() + verbA + ". " + "\n" + toFirstUpperCase(nounAPlural) + " " + adjAPlural + ".";
        String[] variants = new String[]{variantOne, variantTwo};

        return variants[random.nextInt(2)];
    }

    private String sevenFigure() {
        // Неправильные предметы служат.
        // Изгиб неправильный.
        String adjASingular;
        int nounANumber = random.nextInt(wordsStore.getNouns().size() - 1);
        int adjANumber = random.nextInt(wordsStore.getAdjectives().size() - 1);
        Noun nounA = wordsStore.getNouns().get(nounANumber);
        Adjective adjectiveA = wordsStore.getAdjectives().get(adjANumber);
        if (nounA.getGender().equals("м"))
            adjASingular = adjectiveA.getSingularMale();
        else
            adjASingular = adjectiveA.getSingularFemale();

        String nounASingular = wordsStore.getNouns().get(nounANumber).getSingular();
        String adjAPlural = wordsStore.getAdjectives().get(adjANumber).getPlural();
        String verbA = wordsStore.getVerbs().get(random.nextInt(wordsStore.getVerbs().size() - 1)).getPlural();

        String variantThree = toFirstUpperCase(nounASingular) + " " + adjASingular + "." + "\n" + toFirstUpperCase(adjAPlural) + getRandomSubject() + verbA + ". ";
        String variantFour = toFirstUpperCase(adjAPlural) + getRandomSubject() + verbA + ". " + "\n" + toFirstUpperCase(nounASingular) + " " + adjASingular + ".";
        String[] variants = new String[]{variantThree, variantFour};

        return variants[random.nextInt(2)];
    }
}
