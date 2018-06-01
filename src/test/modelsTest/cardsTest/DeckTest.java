package modelsTest.cardsTest;

import constants.CoordinateAxis;
import constants.PieceFaction;
import helpers.IHeld;
import models.cards.Card;
import models.cards.Deck;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DeckTest {

    Deck deck;
    IHeld mockIHeld;
    IHeld mockCard1;
    IHeld mockCard2;
    IHeld mockCard3;

    @Before
    public void before() {
        this.deck = new Deck();

        class MockIHeld implements IHeld {

            public MockIHeld() {}
        }

        class MockDragon extends Card {

            private MockDragon() {
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

        this.mockCard1 = new MockDragon();
        this.mockCard2 = new MockDragon();
        this.mockCard3 = new MockDragon();

        this.mockIHeld = new MockIHeld();
    }

    @Test
    public void deckStartsEmpty() {
        assertEquals(0, this.deck.getSize());
    }

    @Test
    public void deckCanAcceptCards() {
        this.deck.addItem(this.mockCard1);
        this.deck.addItem(this.mockCard2);
        assertEquals(2, this.deck.getSize());
    }

    @Test
    public void deckWontAcceptNonCardIHelds() {

        Exception exception = null;

        try {
            this.deck.addItem(this.mockIHeld);
        } catch (IllegalArgumentException e) {
            exception = e;
        }

        assertEquals(0, this.deck.getSize());
        assertNotEquals(null, exception);
    }

    @Test
    public void deckWillRemoveAndReturnHeldCardsFirstInFirstOut() {
        this.deck.addItem(this.mockCard1);
        this.deck.addItem(this.mockCard2);
        this.deck.addItem(this.mockCard2);

        assertEquals(3, this.deck.getSize());

        Card returnedCard1 = (Card) this.deck.getItem();
        Card returnedCard2 = (Card) this.deck.getItem();

        assertEquals(this.mockCard1, returnedCard1);
        assertEquals(this.mockCard2, returnedCard2);
        assertNotEquals(this.mockCard1, returnedCard2);
        assertEquals(1, this.deck.getSize());
    }

    @Test
    public void deckWillThrowErrorIfAttemptingToRemoveMoreThanExists() {
        this.deck.addItem(this.mockCard1);

        IHeld card1         = this.deck.getItem();
        Exception exception = null;

        try {
            IHeld card2 = this.deck.getItem();
        } catch (IndexOutOfBoundsException e) {
            exception = e;
        }

        assertEquals(this.mockCard1, card1);
        assertEquals(0, this.deck.getSize());
        assertNotEquals(null, exception);
    }
}
