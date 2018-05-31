package modelsTest.cardsTest;

import constants.CoordinateAxis;
import constants.PieceFaction;
import models.cards.Card;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class CardTest {

    private Card dragon;

    @Before
    public void before() {

        ArrayList<HashMap<CoordinateAxis, Integer>> moves;
        HashMap<CoordinateAxis, Integer> move1;
        HashMap<CoordinateAxis, Integer> move2;

        move1 = new HashMap<>();
        move2 = new HashMap<>();

        move1.put(CoordinateAxis.X, 2);
        move1.put(CoordinateAxis.Y, -1);

        move2.put(CoordinateAxis.X, -3);
        move2.put(CoordinateAxis.Y, 0);

        moves = new ArrayList<>(Arrays.asList(move1, move2));


        class mockDragon extends Card {

            private mockDragon() {
                super("Dragon", PieceFaction.RED, moves);
            }
        }

        this.dragon = new mockDragon();
    }

    @Test
    public void canReturnName() {
        assertEquals("Dragon", this.dragon.getName());
    }

    @Test
    public void canReturnFaction() {
        assertEquals(PieceFaction.RED, this.dragon.getFaction());
    }



}
