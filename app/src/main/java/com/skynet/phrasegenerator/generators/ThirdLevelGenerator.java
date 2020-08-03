package com.skynet.phrasegenerator.generators;

import com.skynet.phrasegenerator.helpers.WordsStore;

import java.util.Random;

public class ThirdLevelGenerator extends Generator {

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
        // Либо дровосеки, либо коровы являются круглыми и малиновыми.
        // Некторые малиновые предметы горят.
        String nounA = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounB = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        if (checkEquals(new String[]{nounA, nounB})) return firstFigure();
        String adjA = wordsStore.getAdjectives().get(random.nextInt(wordsStore.getAdjectives().size() - 1)).getInstrumental();
        int instrumentalAdjNumber = random.nextInt(wordsStore.getAdjectives().size() - 1);
        String adjB = wordsStore.getAdjectives().get(instrumentalAdjNumber).getInstrumental();
        if (checkEquals(new String[]{nounA, nounB})) return firstFigure();
        String adjC = wordsStore.getAdjectives().get(instrumentalAdjNumber).getPlural();
        String verbA = wordsStore.getVerbs().get(random.nextInt(wordsStore.getVerbs().size() - 1)).getPlural();

        return "Либо " + nounA + ", либо " + nounB + " являются " + adjA + " и " + adjB + ".\nНекоторые " + adjC + " предметы " + verbA + ".";
    }

    private String secondFigure() {

        //Великие предметы молчат.
        //Либо еженедельники, либо истребители делятся на поздние и великие.

        String adjA = wordsStore.getAdjectives().get(random.nextInt(wordsStore.getAdjectives().size() - 1)).getPlural();
        String adjB = wordsStore.getAdjectives().get(random.nextInt(wordsStore.getAdjectives().size() - 1)).getPlural();

        if (checkEquals(new String[]{adjA, adjB})) return firstFigure();

        String verbA = wordsStore.getVerbs().get(random.nextInt(wordsStore.getVerbs().size() - 1)).getPlural();
        String nounA = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounB = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();

        if (checkEquals(new String[]{nounA, nounB})) return firstFigure();

        return toFirstUpperCase(adjA) + " предметы " + verbA + ".\n" + "Либо " + nounA + ", либо " + nounB + " делятся на " + adjA + " и " + adjB + ".";
    }

    private String thirdFigure() {
        //Либо некоторые инквизиции, либо изложения являются специальными и новыми.
        //Только новые объекты летают.
        String nounA = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounB = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        if (checkEquals(new String[]{nounA, nounB})) return firstFigure();
        String adjA = wordsStore.getAdjectives().get(random.nextInt(wordsStore.getAdjectives().size() - 1)).getInstrumental();
        int adjBNumber = random.nextInt(wordsStore.getAdjectives().size() - 1);
        String adjB = wordsStore.getAdjectives().get(adjBNumber).getInstrumental();
        if (checkEquals(new String[]{adjA, adjB})) return firstFigure();
        String adjC = wordsStore.getAdjectives().get(adjBNumber).getPlural();
        String verbA = wordsStore.getVerbs().get(random.nextInt(wordsStore.getVerbs().size() - 1)).getPlural();

        return "Либо некоторые " + nounA + ", либо " + nounB + " являются " + adjA + " и " + adjB + ".\n" + "Только " + adjC + " объекты " + verbA + ".";
    }

    private String fourthFigure() {
        //Либо только черносливы, либо только шатры делятся на конечные и хитрые.
        //Только конечные предметы не кажутся.
        String nounA = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounB = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        if (checkEquals(new String[]{nounA, nounB})) return firstFigure();
        int adjANumber = random.nextInt(wordsStore.getAdjectives().size() - 1);
        String adjA = wordsStore.getAdjectives().get(adjANumber).getPlural();
        String adjB = wordsStore.getAdjectives().get(random.nextInt(wordsStore.getAdjectives().size() - 1)).getPlural();
        if (checkEquals(new String[]{adjA, adjB})) return firstFigure();
        String adjC = wordsStore.getAdjectives().get(adjANumber).getPlural();
        String verbA = wordsStore.getVerbs().get(random.nextInt(wordsStore.getVerbs().size() - 1)).getPlural();

        return "Либо только " + nounA + ", либо только " + nounB + " делятся на " + adjA + " и " + adjB + ".\n" + "Только " + adjC + " предметы не " + verbA + ".";
    }
}
