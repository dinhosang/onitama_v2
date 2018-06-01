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

        class mockDragon extends Card {

            private mockDragon() {
                super("Dragon", PieceFaction.RED);
                this.prepareMoves();
            }

            @Override
            protected void prepareMoves() {
                ArrayList<HashMap<CoordinateAxis, Integer>> cardMoves;
                HashMap<CoordinateAxis, Integer> move1;
                HashMap<CoordinateAxis, Integer> move2;

                move1 = new HashMap<>();
                move2 = new HashMap<>();

                move1.put(CoordinateAxis.X, 2);
                move1.put(CoordinateAxis.Y, -1);

                move2.put(CoordinateAxis.X, -3);
                move2.put(CoordinateAxis.Y, 0);

                cardMoves = new ArrayList<>(Arrays.asList(move1, move2));

                this.setMoves(cardMoves);
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

    @Test
    public void canAccessMovesList() {
        ArrayList<HashMap<CoordinateAxis, Integer>> movesOnCard = this.dragon.getMoves();
        assertEquals(2, movesOnCard.size());
    }

    @Test
    public void movesListReturnedFromCardIsACopyAndCannotModifyOriginal() {
        ArrayList<HashMap<CoordinateAxis, Integer>> copyMovesOnCard = this.dragon.getMoves();

        HashMap<CoordinateAxis, Integer> move3;
        move3 = new HashMap<>();

        move3.put(CoordinateAxis.X, 0);
        move3.put(CoordinateAxis.Y, 0);
        copyMovesOnCard.add(move3);

        assertEquals(3, copyMovesOnCard.size());
        assertEquals(2, this.dragon.getMoves().size());
    }



}
