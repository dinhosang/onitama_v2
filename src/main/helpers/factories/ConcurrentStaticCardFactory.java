package helpers.factories;

import constants.GameMode;
import helpers.IContain;
import helpers.ICreate;
import models.cards.Card;
import models.cards.individualCards.*;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentStaticCardFactory implements ICreate {

    public static void createItems(GameMode mode, IContain deck) {


        ExecutorService threadPool = Executors.newCachedThreadPool();
        ReentrantLock lock = new ReentrantLock();


        class concurrentSingleCardCreation implements Runnable {

            private IContain        deck;
            private ReentrantLock   lock;

            private concurrentSingleCardCreation(IContain deck, ReentrantLock lock) {
                this.deck = deck;
                this.lock = lock;
            }

            public void run() {
                setupStandardModeCardCreation(deck, lock);
            }
        }


        if(mode.equals(GameMode.STANDARD)){
            concurrentSingleCardCreation cardCreator = new concurrentSingleCardCreation(deck, lock);
            
            threadPool.execute(cardCreator);

            awaitThreadPoolCompletion(threadPool);
        } else if (mode.equals(GameMode.TESTSTANDARD)){
            long startTime    = System.currentTimeMillis();

            for(int numberOfSetsMade = 0; numberOfSetsMade < 1000; numberOfSetsMade++){
                concurrentSingleCardCreation cardCreator = new concurrentSingleCardCreation(deck, lock);
                threadPool.execute(cardCreator);
            }

            awaitThreadPoolCompletion(threadPool);
            long endTime      = System.currentTimeMillis();
            System.out.println(endTime - startTime + "ms");
        } else {
            // throw exception here?
        }


    }

    private static void awaitThreadPoolCompletion(ExecutorService threadPool) {
        threadPool.shutdown();

        try {
            threadPool.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void setupStandardModeCardCreation(IContain deck, ReentrantLock lock) {
        ArrayList<Integer> randomNumbersListToCreateCardsBy = new ArrayList<>();

//        ThreadLocalRandom.current().ints(0,19).distinct().limit(5).forEach(
//                (int number) -> randomNumbersListToCreateCardsBy.add(number));

/*      above same as below - above is lambda version, below is method reference version
        below calls the ThreadLocalRandom which is a random number generator tied to this particular Thread
        the .current() returns an instance of ThreadLocalRandom which was just a static call before
        .ints(inclusiveStartPoint, exclusiveEndPoint) returns random numbers in said range of points
        .distinct() returns unique values, .limit(int) returns that number of values
        the .forEach determines what to do with each value */

        ThreadLocalRandom.current().ints(0, 19).distinct().limit(6).forEach(
                randomNumbersListToCreateCardsBy::add);

        lock.lock();

        for (Integer number : randomNumbersListToCreateCardsBy) {
            createCard(deck, number);
        }

        lock.unlock();
    }

    private static void createCard (IContain deck, Integer number){

        Card card;

        switch (number) {
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