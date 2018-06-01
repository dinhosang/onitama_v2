package modelsTest.cardsTest;

import constants.CoordinateAxis;
import constants.PieceFaction;
import helpers.convertMoves;
import models.cards.Card;
import models.cards.individualCards.Cobra;
import models.cards.individualCards.Frog;
import models.cards.individualCards.Mantis;
import models.cards.individualCards.Rooster;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

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

    private ArrayList<HashMap<CoordinateAxis, Integer>> copyMoves;
    private HashMap<CoordinateAxis, Integer> move1;
    private HashMap<CoordinateAxis, Integer> move2;
    private HashMap<CoordinateAxis, Integer> move3;
    private HashMap<CoordinateAxis, Integer> move4;

    @Before
    public void before() {

        frog    = new Frog();
        cobra   = new Cobra();
        rooster = new Rooster();
        mantis  = new Mantis();
//        horse   = new Horse();
//        elephant = new Elephant();
//        boar    = new Boar();
//        dragon  = new Dragon();
//        tiger   = new Tiger();
//        crab    = new Crab();
//        ox      = new Ox();
//        eel     = new Eel();
//        crane   = new Crane();
//        goose   = new Goose();
//        rabbit  = new Rabbit();
//        monkey  = new Monkey();
    }


    @Test
    public void frogHasNameFrogAndFactionRed() {
        assertEquals("Frog", this.frog.getName());
        assertEquals(PieceFaction.RED, this.frog.getFaction());
    }

    @Test
    public void frogHasThreeSpecificMoves() {

        this.copyMoves = this.frog.getMoves();
        assertEquals(3, this.copyMoves.size());

        this.move1 = this.copyMoves.get(0);
        this.move2 = this.copyMoves.get(1);
        this.move3 = this.copyMoves.get(2);

        assertSame(1, convertMoves.getCoordX(move1));
        assertSame(-1, convertMoves.getCoordY(move1));

        assertSame(-2, convertMoves.getCoordX(move2));
        assertSame(0, convertMoves.getCoordY(move2));

        assertSame(-1, convertMoves.getCoordX(move3));
        assertSame(1, convertMoves.getCoordY(move3));
    }

    @Test
    public void cobraHasNameCobraAndFactionRed() {
        assertEquals("Cobra", this.cobra.getName());
        assertEquals(PieceFaction.RED, this.cobra.getFaction());
    }

    @Test
    public void cobraHasThreeSpecificMoves() {

        this.copyMoves = this.cobra.getMoves();
        assertEquals(3, this.copyMoves.size());

        this.move1 = this.copyMoves.get(0);
        this.move2 = this.copyMoves.get(1);
        this.move3 = this.copyMoves.get(2);

        assertSame(1, convertMoves.getCoordX(move1));
        assertSame(-1, convertMoves.getCoordY(move1));

        assertSame(-1, convertMoves.getCoordX(move2));
        assertSame(0, convertMoves.getCoordY(move2));

        assertSame(1, convertMoves.getCoordX(move3));
        assertSame(1, convertMoves.getCoordY(move3));
    }

    @Test
    public void roosterHasNameRoosterAndFactionRed() {
        assertEquals("Rooster", this.rooster.getName());
        assertEquals(PieceFaction.RED, this.rooster.getFaction());
    }

    @Test
    public void roosterHasFourSpecificMoves() {

        this.copyMoves = this.rooster.getMoves();
        assertEquals(4, this.copyMoves.size());

        this.move1 = this.copyMoves.get(0);
        this.move2 = this.copyMoves.get(1);
        this.move3 = this.copyMoves.get(2);
        this.move4 = this.copyMoves.get(3);

        assertSame(1, convertMoves.getCoordX(move1));
        assertSame(0, convertMoves.getCoordY(move1));

        assertSame(-1, convertMoves.getCoordX(move2));
        assertSame(0, convertMoves.getCoordY(move2));

        assertSame(1, convertMoves.getCoordX(move3));
        assertSame(1, convertMoves.getCoordY(move3));

        assertSame(-1, convertMoves.getCoordX(move4));
        assertSame(-1, convertMoves.getCoordY(move4));
    }

    @Test
    public void mantisHasNameMantisAndFactionRed() {
        assertEquals("Mantis", this.mantis.getName());
        assertEquals(PieceFaction.RED, this.mantis.getFaction());
    }

    @Test
    public void mantisHasThreeSpecificMoves() {

        this.copyMoves  = this.mantis.getMoves();
        assertEquals(3, this.copyMoves.size());

        this.move1      = this.copyMoves.get(0);
        this.move2      = this.copyMoves.get(1);
        this.move3      = this.copyMoves.get(2);

        assertSame(0, convertMoves.getCoordX(move1));
        assertSame(-1, convertMoves.getCoordY(move1));

        assertSame(1, convertMoves.getCoordX(move2));
        assertSame(1, convertMoves.getCoordY(move2));

        assertSame(-1, convertMoves.getCoordX(move3));
        assertSame(1, convertMoves.getCoordY(move3));
    }

    @Ignore @Test
    public void roostserHasNameRoosterAndFactionRed() {
        assertEquals("Cobra", this.cobra.getName());
        assertEquals(PieceFaction.RED, this.cobra.getFaction());
    }

    @Ignore @Test
    public void roossterHasFourSpecificMoves() {

        this.copyMoves  = this.cobra.getMoves();
        assertEquals(3, this.copyMoves.size());

        this.move1      = this.copyMoves.get(0);
        this.move2      = this.copyMoves.get(1);
        this.move3      = this.copyMoves.get(2);

        assertSame(1, convertMoves.getCoordX(move1));
        assertSame(-1, convertMoves.getCoordY(move1));

        assertSame(-1, convertMoves.getCoordX(move2));
        assertSame(0, convertMoves.getCoordY(move2));

        assertSame(1, convertMoves.getCoordX(move3));
        assertSame(1, convertMoves.getCoordY(move3));
    }



}
