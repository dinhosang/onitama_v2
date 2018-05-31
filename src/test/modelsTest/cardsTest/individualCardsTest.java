package modelsTest.cardsTest;

import models.cards.Card;
import org.junit.Before;
import org.junit.Test;

public class individualCardsTest {

    private Card frog;
    private Card cobra;
    private Card rooster;
    private Card mantis;
    private Card horse;
    private Card elephant;
    private Card boar;
    private Card dragon;
    private Card tiger;
    private Card crab;
    private Card ox;
    private Card eel;
    private Card crane;
    private Card goose;
    private Card rabbit;
    private Card monkey;

    @Before
    public void before() {

        frog    = new Frog();
        cobra   = new Cobra();
        rooster = new Rooster();
        mantis  = new Mantis();
        horse   = new Horse();
        elephant = new Elephant();
        boar    = new Boar();
        dragon  = new Dragon();
        tiger   = new Tiger();
        crab    = new Crab();
        ox      = new Ox();
        eel     = new Eel();
        crane   = new Crane();
        goose   = new Goose();
        rabbit  = new Rabbit();
        monkey  = new Monkey();
    }

    @Test
    public void frogHasThreeMoves() {
        
    }



}
