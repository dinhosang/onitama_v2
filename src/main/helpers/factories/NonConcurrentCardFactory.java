package helpers.factories;

import constants.GameMode;
import helpers.IContainer;
import helpers.ICreate;
import models.cards.Card;
import models.cards.individualCards.*;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class NonConcurrentCardFactory implements ICreate {

    public static void createItems(GameMode mode, IContainer deck) {

        if(mode.equals(GameMode.STANDARD)){
            setupStandardModeCardCreation(deck);
        } else if (mode.equals(GameMode.TESTSTANDARD)){
            long startTime    = System.currentTimeMillis();

            for(int numberOfSetsMade = 0; numberOfSetsMade < 1000; numberOfSetsMade++){
              setupStandardModeCardCreation(deck);
            }

            long endTime      = System.currentTimeMillis();
            System.out.println(endTime - startTime + "ms");
        } else {
            // throw exception here?
        }
    }

    private static void setupStandardModeCardCreation(IContainer deck) {
        ArrayList<Integer> randomNumbersListToCreateCardsBy = new ArrayList<>();

//        ThreadLocalRandom.current().ints(0,19).distinct().limit(5).forEach(
//                (int number) -> randomNumbersListToCreateCardsBy.add(number));

/*      above same as below - above is lambda version, below is method reference version
        below calls the ThreadLocalRandom which is a random number generator tied to this particular Thread
        the .current() returns an instance of ThreadLocalRandom which was just a static call before
        .ints(inclusiveStartPoint, exclusiveEndPoint) returns random numbers in said range of points
        .distinct() returns unique values, .limit(int) returns that number of values
        the .forEach determines what to do with each value */

        ThreadLocalRandom.current().ints(0,19).distinct().limit(5).forEach(
                randomNumbersListToCreateCardsBy::add);

        for(Integer number : randomNumbersListToCreateCardsBy){
            createCard(deck, number);
        }
    }

    private static void createCard(IContainer deck, Integer number) {

        Card card;

        switch(number){
            case 1:
                card = new Boar();
                break;
            case 2:
                card = new Cobra();
                break;
            case 3:
                card = new Crab();
                break;
            case 4:
                card = new Crane();
                break;
            case 5:
                card = new Dragon();
                break;
            case 6:
                card = new Eel();
                break;
            case 7:
                card = new Elephant();
                break;
            case 8:
                card = new Frog();
                break;
            case 9:
                card = new Goose();
                break;
            case 10:
                card = new Horse();
                break;
            case 11:
                card = new Mantis();
                break;
            case 12:
                card = new Monkey();
                break;
            case 13:
                card = new Ox();
                break;
            case 14:
                card = new Rabbit();
                break;
            case 15:
                card = new Rooster();
                break;
            default:
                card = new Tiger();
                break;
        }

        deck.addItem(card);
    }



}
