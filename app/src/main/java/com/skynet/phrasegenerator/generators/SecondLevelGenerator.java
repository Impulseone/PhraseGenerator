package com.skynet.phrasegenerator.generators;

import com.skynet.phrasegenerator.generators.Generator;
import com.skynet.phrasegenerator.helpers.WordsStore;

public class SecondLevelGenerator extends Generator {

    @Override
    public String generatePhrase() {
        int k = 1 + random.nextInt(5);
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
        }
        return firstFigure();
    }

    private String firstFigure() {

        //Пускающие объекты сделаны из изголовий.
        //Цапли пускают.

        int possessiveNumber = random.nextInt(wordsStore.getVerbs().size() - 1);
        String possessiveA = wordsStore.getVerbs().get(possessiveNumber).getPossessivePlural();
        String nounA = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getGenitive();
        String nounB = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String verbA = wordsStore.getVerbs().get(possessiveNumber).getPlural();
        if (checkEquals(new String[]{nounA, nounB})) return firstFigure();
        return toFirstUpperCase(possessiveA) + " объекты сделаны из " + nounA + ".\n" + getRandomPronoun() + nounB + " " + verbA + ". ";
    }

    private String secondFigure() {

        //Некоторые веники делятся на телефонные и поэтические.
        //Взгляды и дятлы обладают свойством телефонный и поэтический.

        String nounA = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounB = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounC = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();

        if (checkEquals(new String[]{nounA, nounB, nounC})) return secondFigure();

        int adjANumber = random.nextInt(wordsStore.getAdjectives().size() - 1);
        int adjBNumber = random.nextInt(wordsStore.getAdjectives().size() - 1);

        String adjA = wordsStore.getAdjectives().get(adjANumber).getPlural();
        String adjB = wordsStore.getAdjectives().get(adjBNumber).getPlural();

        if (checkEquals(new String[]{adjA, adjB})) return secondFigure();

        String adjC = wordsStore.getAdjectives().get(adjANumber).getPlural();
        String adjD = wordsStore.getAdjectives().get(adjBNumber).getPlural();

        String rndPropForTwoSubjOne = getRandomPropertyForTwoSubjects();
        String rndUnionOne = getRandomUnion();

        String rndPropForTwoSubjTwo = getRandomPropertyForTwoSubjects();
        String rndUnionTwo = getRandomUnion();

        if (rndPropForTwoSubjOne.equals(" делятся на ")) rndUnionOne = " и ";
        if (rndPropForTwoSubjTwo.equals(" делятся на ")) rndUnionTwo = " и ";

        return getRandomPronoun() + nounA + rndPropForTwoSubjOne + getRandomNegation() + adjA + rndUnionOne + getRandomNegation() + adjB + "." + "\n" + toFirstUpperCase(nounB) + getRandomUnion() + nounC + rndPropForTwoSubjTwo + getRandomNegation() + adjC + rndUnionTwo + getRandomNegation() + adjD + ".";
    }

    private String thirdFigure() {

        //Либо только мемориалы, либо только искорки - это линолеумы.
        //Линолеумы - это зяблики.

        String nounA = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounB = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounC = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounD = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();

        if (checkEquals(new String[]{nounA, nounB, nounC, nounD})) return thirdFigure();

        return toFirstUpperCaseTwo(getRandomUnionBetweenTwoSubjects()) + nounA + "," + getRandomUnionBetweenTwoSubjects() + nounB + getRandomDemonstrative() + nounC + '.' + "\n" + toFirstUpperCase(nounC) + getRandomDemonstrative() + getRandomNegation() + nounD + '.';
    }

    private String fourthFigure() {
        //Изобилия сделаны из иголочек.
        //Некоторые объекты из иголочек излагают.
        String nounA = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounB = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getGenitive();
        String verbA = wordsStore.getVerbs().get(random.nextInt(wordsStore.getVerbs().size() - 1)).getPlural();

        return toFirstUpperCase(nounA) + " сделаны из " + nounB + ". " + "\n" + getRandomPronoun() + getRandomSubject() + "из " + nounB + " " + verbA + ".";
    }

    private String fifthFigure() {
        //Изобилия бывают ясными или желающими
        //Только лифты делятся на ясные и желающие.
        String nounA = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounB = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();

        int adjANumber = random.nextInt(wordsStore.getAdjectives().size() - 1);
        int adjBNumber = random.nextInt(wordsStore.getAdjectives().size() - 1);

        String adjA = wordsStore.getAdjectives().get(adjANumber).getPlural();
        String adjB = wordsStore.getAdjectives().get(adjBNumber).getPlural();

        String rndPropForTwoSubjOne = getRandomPropertyForTwoSubjects();
        String rndUnionOne = getRandomUnion();

        String rndPropForTwoSubjTwo = getRandomPropertyForTwoSubjects();
        String rndUnionTwo = getRandomUnion();

        if (rndPropForTwoSubjOne.equals(" делятся на ")) rndUnionOne = " и ";
        if (rndPropForTwoSubjTwo.equals(" делятся на ")) rndUnionTwo = " и ";

        return toFirstUpperCase(nounA) + rndPropForTwoSubjOne + getRandomNegation() + adjA + rndUnionOne + getRandomNegation() + adjB + ".\n" + toFirstUpperCaseTwo(getRandomParticle()) + nounB + rndPropForTwoSubjTwo + getRandomNegation() + adjA + rndUnionTwo + getRandomNegation() + adjB + ".";
    }

}
