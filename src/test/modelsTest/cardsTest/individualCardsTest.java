package modelsTest.cardsTest;

import constants.CoordinateAxis;
import constants.PieceFaction;
import constants.MoveDirection;
import helpers.convertMoves;
import models.cards.Card;
import models.cards.individualCards.*;
import org.junit.Before;
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

        assertSame(MoveDirection.RIGHT.getValue(), convertMoves.getCoordX(move1));
        assertSame(MoveDirection.DOWN.getValue(), convertMoves.getCoordY(move1));

        assertSame((MoveDirection.LEFT.getValue() + MoveDirection.LEFT.getValue()), convertMoves.getCoordX(move2));
        assertSame(0, convertMoves.getCoordY(move2));

        assertSame(MoveDirection.LEFT.getValue(), convertMoves.getCoordX(move3));
        assertSame(MoveDirection.UP.getValue(), convertMoves.getCoordY(move3));
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

        assertSame(MoveDirection.RIGHT.getValue(), convertMoves.getCoordX(move1));
        assertSame(MoveDirection.DOWN.getValue(), convertMoves.getCoordY(move1));

        assertSame(MoveDirection.LEFT.getValue(), convertMoves.getCoordX(move2));
        assertSame(0, convertMoves.getCoordY(move2));

        assertSame(MoveDirection.RIGHT.getValue(), convertMoves.getCoordX(move3));
        assertSame(MoveDirection.UP.getValue(), convertMoves.getCoordY(move3));
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

        assertSame(MoveDirection.RIGHT.getValue(), convertMoves.getCoordX(move1));
        assertSame(0, convertMoves.getCoordY(move1));

        assertSame(MoveDirection.LEFT.getValue(), convertMoves.getCoordX(move2));
        assertSame(0, convertMoves.getCoordY(move2));

        assertSame(MoveDirection.RIGHT.getValue(), convertMoves.getCoordX(move3));
        assertSame(MoveDirection.UP.getValue(), convertMoves.getCoordY(move3));

        assertSame(MoveDirection.LEFT.getValue(), convertMoves.getCoordX(move4));
        assertSame(MoveDirection.DOWN.getValue(), convertMoves.getCoordY(move4));
    }

    @Test
    public void mantisHasNameMantisAndFactionRed() {
        assertEquals("Mantis", this.mantis.getName());
        assertEquals(PieceFaction.RED, this.mantis.getFaction());
    }

    @Test
    public void mantisHasThreeSpecificMoves() {

        this.copyMoves = this.mantis.getMoves();
        assertEquals(3, this.copyMoves.size());

        this.move1 = this.copyMoves.get(0);
        this.move2 = this.copyMoves.get(1);
        this.move3 = this.copyMoves.get(2);

        assertSame(0, convertMoves.getCoordX(move1));
        assertSame(MoveDirection.DOWN.getValue(), convertMoves.getCoordY(move1));

        assertSame(MoveDirection.RIGHT.getValue(), convertMoves.getCoordX(move2));
        assertSame(MoveDirection.UP.getValue(), convertMoves.getCoordY(move2));

        assertSame(MoveDirection.LEFT.getValue(), convertMoves.getCoordX(move3));
        assertSame(MoveDirection.UP.getValue(), convertMoves.getCoordY(move3));
    }

    @Test
    public void HorseHasNameHorseAndFactionRed() {
        assertEquals("Horse", this.horse.getName());
        assertEquals(PieceFaction.RED, this.horse.getFaction());
    }

    @Test
    public void HorseHasThreeSpecificMoves() {

        this.copyMoves = this.horse.getMoves();
        assertEquals(3, this.copyMoves.size());

        this.move1 = this.copyMoves.get(0);
        this.move2 = this.copyMoves.get(1);
        this.move3 = this.copyMoves.get(2);

        assertSame(0, convertMoves.getCoordX(move1));
        assertSame(MoveDirection.UP.getValue(), convertMoves.getCoordY(move1));

        assertSame(MoveDirection.LEFT.getValue(), convertMoves.getCoordX(move2));
        assertSame(0, convertMoves.getCoordY(move2));

        assertSame(0, convertMoves.getCoordX(move3));
        assertSame(MoveDirection.DOWN.getValue(), convertMoves.getCoordY(move3));
    }

    @Test
    public void elephantHasNameElephantAndFactionRed() {
        assertEquals("Elephant", this.elephant.getName());
        assertEquals(PieceFaction.RED, this.elephant.getFaction());
    }

    @Test
    public void elephantHasFourSpecificMoves() {

        this.copyMoves = this.elephant.getMoves();
        assertEquals(4, this.copyMoves.size());

        this.move1 = this.copyMoves.get(0);
        this.move2 = this.copyMoves.get(1);
        this.move3 = this.copyMoves.get(2);
        this.move4 = this.copyMoves.get(3);

        assertSame(MoveDirection.RIGHT.getValue(), convertMoves.getCoordX(move1));
        assertSame(0, convertMoves.getCoordY(move1));

        assertSame(MoveDirection.LEFT.getValue(), convertMoves.getCoordX(move2));
        assertSame(0, convertMoves.getCoordY(move2));

        assertSame(MoveDirection.RIGHT.getValue(), convertMoves.getCoordX(move3));
        assertSame(MoveDirection.UP.getValue(), convertMoves.getCoordY(move3));

        assertSame(MoveDirection.LEFT.getValue(), convertMoves.getCoordX(move4));
        assertSame(MoveDirection.UP.getValue(), convertMoves.getCoordY(move4));
    }

    @Test
    public void boarHasNameBoarAndFactionRed() {
        assertEquals("Boar", this.boar.getName());
        assertEquals(PieceFaction.RED, this.boar.getFaction());
    }

    @Test
    public void boarHasThreeSpecificMoves() {

        this.copyMoves = this.boar.getMoves();
        assertEquals(3, this.copyMoves.size());

        this.move1 = this.copyMoves.get(0);
        this.move2 = this.copyMoves.get(1);
        this.move3 = this.copyMoves.get(2);

        assertSame(MoveDirection.RIGHT.getValue(), convertMoves.getCoordX(move1));
        assertSame(0, convertMoves.getCoordY(move1));

        assertSame(MoveDirection.LEFT.getValue(), convertMoves.getCoordX(move2));
        assertSame(0, convertMoves.getCoordY(move2));

        assertSame(0, convertMoves.getCoordX(move3));
        assertSame(MoveDirection.UP.getValue(), convertMoves.getCoordY(move3));
    }

    @Test
    public void dragonHasNameDragonAndFactionRed() {
        assertEquals("Dragon", this.dragon.getName());
        assertEquals(PieceFaction.RED, this.dragon.getFaction());
    }

    @Test
    public void dragonHasFourSpecificMoves() {

        this.copyMoves = this.dragon.getMoves();
        assertEquals(4, this.copyMoves.size());

        this.move1 = this.copyMoves.get(0);
        this.move2 = this.copyMoves.get(1);
        this.move3 = this.copyMoves.get(2);
        this.move4 = this.copyMoves.get(3);

        assertSame((MoveDirection.RIGHT.getValue() + MoveDirection.RIGHT.getValue()), convertMoves.getCoordX(move1));
        assertSame(MoveDirection.UP.getValue(), convertMoves.getCoordY(move1));

        assertSame((MoveDirection.LEFT.getValue() + MoveDirection.LEFT.getValue()), convertMoves.getCoordX(move2));
        assertSame(MoveDirection.UP.getValue(), convertMoves.getCoordY(move2));

        assertSame(MoveDirection.RIGHT.getValue(), convertMoves.getCoordX(move3));
        assertSame(MoveDirection.DOWN.getValue(), convertMoves.getCoordY(move3));

        assertSame(MoveDirection.LEFT.getValue(), convertMoves.getCoordX(move4));
        assertSame(MoveDirection.DOWN.getValue(), convertMoves.getCoordY(move4));
    }

    @Test
    public void tigerHasNameTigerAndFactionBlue() {
        assertEquals("Tiger", this.tiger.getName());
        assertEquals(PieceFaction.BLUE, this.tiger.getFaction());
    }

    @Test
    public void tigerHasTwoSpecificMoves() {

        this.copyMoves = this.tiger.getMoves();
        assertEquals(2, this.copyMoves.size());

        this.move1 = this.copyMoves.get(0);
        this.move2 = this.copyMoves.get(1);

        assertSame(0, convertMoves.getCoordX(move1));
        assertSame((MoveDirection.UP.getValue() + MoveDirection.UP.getValue()), convertMoves.getCoordY(move1));

        assertSame(0, convertMoves.getCoordX(move2));
        assertSame(MoveDirection.DOWN.getValue(), convertMoves.getCoordY(move2));
    }

    @Test
    public void crabHasNameCrabAndFactionBlue() {
        assertEquals("Crab", this.crab.getName());
        assertEquals(PieceFaction.BLUE, this.crab.getFaction());
    }

    @Test
    public void crabHasThreeSpecificMoves() {

        this.copyMoves = this.crab.getMoves();
        assertEquals(3, this.copyMoves.size());

        this.move1 = this.copyMoves.get(0);
        this.move2 = this.copyMoves.get(1);
        this.move3 = this.copyMoves.get(2);

        assertSame((MoveDirection.RIGHT.getValue() + MoveDirection.RIGHT.getValue()), convertMoves.getCoordX(move1));
        assertSame(0, convertMoves.getCoordY(move1));

        assertSame((MoveDirection.LEFT.getValue() + MoveDirection.LEFT.getValue()), convertMoves.getCoordX(move2));
        assertSame(0, convertMoves.getCoordY(move2));

        assertSame(0, convertMoves.getCoordX(move3));
        assertSame(MoveDirection.UP.getValue(), convertMoves.getCoordY(move3));
    }

    @Test
    public void oxHasNameOxAndFactionBlue() {
        assertEquals("Ox", this.ox.getName());
        assertEquals(PieceFaction.BLUE, this.ox.getFaction());
    }

    @Test
    public void oxHasThreeSpecificMoves() {

        this.copyMoves = this.ox.getMoves();
        assertEquals(3, this.copyMoves.size());

        this.move1 = this.copyMoves.get(0);
        this.move2 = this.copyMoves.get(1);
        this.move3 = this.copyMoves.get(2);

        assertSame(MoveDirection.RIGHT.getValue(), convertMoves.getCoordX(move1));
        assertSame(0, convertMoves.getCoordY(move1));

        assertSame(0, convertMoves.getCoordX(move2));
        assertSame(MoveDirection.DOWN.getValue(), convertMoves.getCoordY(move2));

        assertSame(0, convertMoves.getCoordX(move3));
        assertSame(MoveDirection.UP.getValue(), convertMoves.getCoordY(move3));
    }

    @Test
    public void eelHasNameEelAndFactionBlue() {
        assertEquals("Eel", this.eel.getName());
        assertEquals(PieceFaction.BLUE, this.eel.getFaction());
    }

    @Test
    public void eelHasThreeSpecificMoves() {

        this.copyMoves = this.eel.getMoves();
        assertEquals(3, this.copyMoves.size());

        this.move1 = this.copyMoves.get(0);
        this.move2 = this.copyMoves.get(1);
        this.move3 = this.copyMoves.get(2);

        assertSame(MoveDirection.RIGHT.getValue(), convertMoves.getCoordX(move1));
        assertSame(0, convertMoves.getCoordY(move1));

        assertSame(MoveDirection.LEFT.getValue(), convertMoves.getCoordX(move2));
        assertSame(MoveDirection.DOWN.getValue(), convertMoves.getCoordY(move2));

        assertSame(MoveDirection.LEFT.getValue(), convertMoves.getCoordX(move3));
        assertSame(MoveDirection.UP.getValue(), convertMoves.getCoordY(move3));
    }

    @Test
    public void craneHasNameCraneAndFactionBlue() {
        assertEquals("Crane", this.crane.getName());
        assertEquals(PieceFaction.BLUE, this.crane.getFaction());
    }

    @Test
    public void craneHasThreeSpecificMoves() {

        this.copyMoves = this.crane.getMoves();
        assertEquals(3, this.copyMoves.size());

        this.move1 = this.copyMoves.get(0);
        this.move2 = this.copyMoves.get(1);
        this.move3 = this.copyMoves.get(2);

        assertSame(MoveDirection.RIGHT.getValue(), convertMoves.getCoordX(move1));
        assertSame(MoveDirection.DOWN.getValue(), convertMoves.getCoordY(move1));

        assertSame(MoveDirection.LEFT.getValue(), convertMoves.getCoordX(move2));
        assertSame(MoveDirection.DOWN.getValue(), convertMoves.getCoordY(move2));

        assertSame(0, convertMoves.getCoordX(move3));
        assertSame(MoveDirection.UP.getValue(), convertMoves.getCoordY(move3));
    }

    @Test
    public void gooseHasNameGooseAndFactionBlue() {
        assertEquals("Goose", this.goose.getName());
        assertEquals(PieceFaction.BLUE, this.goose.getFaction());
    }

    @Test
    public void gooseHasFourSpecificMoves() {

        this.copyMoves = this.goose.getMoves();
        assertEquals(4, this.copyMoves.size());

        this.move1 = this.copyMoves.get(0);
        this.move2 = this.copyMoves.get(1);
        this.move3 = this.copyMoves.get(2);
        this.move4 = this.copyMoves.get(3);

        assertSame(MoveDirection.RIGHT.getValue(), convertMoves.getCoordX(move1));
        assertSame(0, convertMoves.getCoordY(move1));

        assertSame(MoveDirection.LEFT.getValue(), convertMoves.getCoordX(move2));
        assertSame(0, convertMoves.getCoordY(move2));

        assertSame(MoveDirection.LEFT.getValue(), convertMoves.getCoordX(move3));
        assertSame(MoveDirection.UP.getValue(), convertMoves.getCoordY(move3));

        assertSame(MoveDirection.RIGHT.getValue(), convertMoves.getCoordX(move4));
        assertSame(MoveDirection.DOWN.getValue(), convertMoves.getCoordY(move4));
    }

    @Test
    public void rabbitHasNameRabbitAndFactionBlue() {
        assertEquals("Rabbit", this.rabbit.getName());
        assertEquals(PieceFaction.BLUE, this.rabbit.getFaction());
    }

    @Test
    public void rabbitHasThreeSpecificMoves() {

        this.copyMoves = this.rabbit.getMoves();
        assertEquals(3, this.copyMoves.size());

        this.move1 = this.copyMoves.get(0);
        this.move2 = this.copyMoves.get(1);
        this.move3 = this.copyMoves.get(2);

        assertSame((MoveDirection.RIGHT.getValue() + MoveDirection.RIGHT.getValue()), convertMoves.getCoordX(move1));
        assertSame(0, convertMoves.getCoordY(move1));

        assertSame(MoveDirection.RIGHT.getValue(), convertMoves.getCoordX(move2));
        assertSame(MoveDirection.UP.getValue(), convertMoves.getCoordY(move2));

        assertSame(MoveDirection.LEFT.getValue(), convertMoves.getCoordX(move3));
        assertSame(MoveDirection.DOWN.getValue(), convertMoves.getCoordY(move3));
    }

    @Test
    public void monkeyHasNameMonkeyAndFactionBlue() {
        assertEquals("Monkey", this.monkey.getName());
        assertEquals(PieceFaction.BLUE, this.monkey.getFaction());
    }

    @Test
    public void monkeyHasFourSpecificMoves() {

        this.copyMoves = this.monkey.getMoves();
        assertEquals(4, this.copyMoves.size());

        this.move1 = this.copyMoves.get(0);
        this.move2 = this.copyMoves.get(1);
        this.move3 = this.copyMoves.get(2);
        this.move4 = this.copyMoves.get(3);

        assertSame(MoveDirection.RIGHT.getValue(), convertMoves.getCoordX(move1));
        assertSame(MoveDirection.DOWN.getValue(), convertMoves.getCoordY(move1));

        assertSame(MoveDirection.LEFT.getValue(), convertMoves.getCoordX(move2));
        assertSame(MoveDirection.DOWN.getValue(), convertMoves.getCoordY(move2));

        assertSame(MoveDirection.LEFT.getValue(), convertMoves.getCoordX(move3));
        assertSame(MoveDirection.UP.getValue(), convertMoves.getCoordY(move3));

        assertSame(MoveDirection.RIGHT.getValue(), convertMoves.getCoordX(move4));
        assertSame(MoveDirection.UP.getValue(), convertMoves.getCoordY(move4));
    }


}
