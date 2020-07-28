package com.skynet.phrasegenerator.generators;

import com.skynet.phrasegenerator.words.WordsStore;

import java.util.Random;

public class FourthLevelGenerator extends Generator {
    private WordsStore wordsStore;

    private Random random = new Random();

    public FourthLevelGenerator(WordsStore wordsStore) {
        this.wordsStore = wordsStore;
    }

    @Override
    public String generatePhrase() {
        int k = 1 + random.nextInt(4);
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
        }
        return firstFigure();
    }

    private String firstFigure() {
        // Либо крокодилы, либо черепахи, либо самолеты делятся на мохнатые, красивые, стройные.
        // Мохнатые предметы ковыряют и тормозят и летают.
        String nounA = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounB = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounC = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();

        if (checkEquals(new String[]{nounA, nounB, nounC})) return firstFigure();

        String adjA = wordsStore.getAdjectives().get(random.nextInt(wordsStore.getAdjectives().size() - 1)).getPlural();
        String adjB = wordsStore.getAdjectives().get(random.nextInt(wordsStore.getAdjectives().size() - 1)).getPlural();
        String adjC = wordsStore.getAdjectives().get(random.nextInt(wordsStore.getAdjectives().size() - 1)).getPlural();

        if (checkEquals(new String[]{adjA, adjB, adjC})) return firstFigure();

        String verbA = wordsStore.getVerbs().get(random.nextInt(wordsStore.getVerbs().size() - 1)).getPlural();
        String verbB = wordsStore.getVerbs().get(random.nextInt(wordsStore.getVerbs().size() - 1)).getPlural();
        String verbC = wordsStore.getVerbs().get(random.nextInt(wordsStore.getVerbs().size() - 1)).getPlural();

        if (checkEquals(new String[]{verbA, verbB, verbC})) return firstFigure();

        return "Либо " + nounA + ", либо " + nounB + ", либо " + nounC + " делятся на " + adjA + ", " + adjB + ", " + adjC + ".\n" +
                toFirstUpperCase(adjA) + " предметы " + verbA + ", " + verbB + ", " + verbC + ".";
    }

    private String secondFigure() {
        //Архитектурные объекты не решают и поздравляют и приказывают.
        //Злаки и редьки и компьютеры являются лишними и валютными и не архитектурными

        int adjANumber = random.nextInt(wordsStore.getAdjectives().size() - 1);
        String adjA = wordsStore.getAdjectives().get(adjANumber).getPlural();

        String verbA = wordsStore.getVerbs().get(random.nextInt(wordsStore.getVerbs().size() - 1)).getPlural();
        String verbB = wordsStore.getVerbs().get(random.nextInt(wordsStore.getVerbs().size() - 1)).getPlural();
        String verbC = wordsStore.getVerbs().get(random.nextInt(wordsStore.getVerbs().size() - 1)).getPlural();

        if (checkEquals(new String[]{verbA, verbB, verbC})) return firstFigure();

        String nounA = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounB = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounC = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();

        if (checkEquals(new String[]{nounA, nounB, nounC})) return firstFigure();


        String adjB = wordsStore.getAdjectives().get(random.nextInt(wordsStore.getAdjectives().size() - 1)).getInstrumental();
        String adjC = wordsStore.getAdjectives().get(random.nextInt(wordsStore.getAdjectives().size() - 1)).getInstrumental();
        String adjD = wordsStore.getAdjectives().get(adjANumber).getInstrumental();

        if (checkEquals(new String[]{adjA, adjB, adjC})) return firstFigure();

        return toFirstUpperCase(adjA) + " объекты " + " не " + verbA + " и " + verbB + " и " + verbC + ".\n" +
                toFirstUpperCase(nounA) + " и " + nounB + " и " + nounC + " являются " + adjB + " и " + adjC + " и не " + adjD + ".";
    }

    private String thirdFigure() {
        //Только финские предметы мешают и просыпаются и ненавидят.
        //Шприцы и зелени и завистники бывают не коммерческие и не изящные и финские.

        String verbA = wordsStore.getVerbs().get(random.nextInt(wordsStore.getVerbs().size() - 1)).getPlural();
        String verbB = wordsStore.getVerbs().get(random.nextInt(wordsStore.getVerbs().size() - 1)).getPlural();
        String verbC = wordsStore.getVerbs().get(random.nextInt(wordsStore.getVerbs().size() - 1)).getPlural();

        if (checkEquals(new String[]{verbA, verbB, verbC})) return firstFigure();

        String nounA = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounB = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounC = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();

        if (checkEquals(new String[]{nounA, nounB, nounC})) return firstFigure();

        String adjA = wordsStore.getAdjectives().get(random.nextInt(wordsStore.getAdjectives().size() - 1)).getPlural();
        String adjB = wordsStore.getAdjectives().get(random.nextInt(wordsStore.getAdjectives().size() - 1)).getPlural();
        String adjC = wordsStore.getAdjectives().get(random.nextInt(wordsStore.getAdjectives().size() - 1)).getPlural();

        if (checkEquals(new String[]{adjA, adjB, adjC})) return firstFigure();

        return "Только " + adjA + " предметы " + verbA + " и " + verbB + " и " + verbC + ".\n"
                + toFirstUpperCase(nounA) + " и " + nounB + " и " + nounC + " бывают не " + adjB + " и не " + adjC + " и " + adjA + ".";
    }

    private String fourthFigure() {
        //Луковицы и изоляторы и чемпионы обладают или свойством западный и четкий, или свойством пожарный.
        //Западные предметы или поворачиваются и применяют, или проявляют.

        String nounA = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounB = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounC = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();

        if (checkEquals(new String[]{nounA, nounB, nounC})) return firstFigure();

        int adjANumber = random.nextInt(wordsStore.getAdjectives().size() - 1);
        String adjA = wordsStore.getAdjectives().get(adjANumber).getSingular();
        String adjB = wordsStore.getAdjectives().get(random.nextInt(wordsStore.getAdjectives().size() - 1)).getSingular();
        String adjC = wordsStore.getAdjectives().get(random.nextInt(wordsStore.getAdjectives().size() - 1)).getSingular();

        String adjD = wordsStore.getAdjectives().get(adjANumber).getPlural();

        if (checkEquals(new String[]{adjA, adjB, adjC})) return firstFigure();

        String verbA = wordsStore.getVerbs().get(random.nextInt(wordsStore.getVerbs().size() - 1)).getPlural();
        String verbB = wordsStore.getVerbs().get(random.nextInt(wordsStore.getVerbs().size() - 1)).getPlural();
        String verbC = wordsStore.getVerbs().get(random.nextInt(wordsStore.getVerbs().size() - 1)).getPlural();

        if (checkEquals(new String[]{verbA, verbB, verbC})) return firstFigure();

        return toFirstUpperCase(nounA) + " и " + nounB + " и " + nounC + " обладают или свойством " + adjA + " и " + adjB + ", или свойством " + adjC + ".\n"
                + toFirstUpperCase(adjD) + " предметы " + " или " + verbA + " и " + verbB + ", или " + verbC + ".";
    }
}
