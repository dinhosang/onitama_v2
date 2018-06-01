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

    IHeld mockCard1;
    IHeld mockCard2;
    IHeld mockCard3;

    @Before
    public void before() {
        this.deck = new Deck();

        class MockIHeld implements IHeld {

            public MockIHeld() {}
        }

        this.mockCard1 = new MockIHeld();
        this.mockCard2 = new MockIHeld();
        this.mockCard3 = new MockIHeld();
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
    public void deckWillRemoveAndReturnHeldCardsFirstInFirstOut() {
        this.deck.addItem(this.mockCard1);
        this.deck.addItem(this.mockCard2);
        this.deck.addItem(this.mockCard2);

        assertEquals(3, this.deck.getSize());

        IHeld returnedCard1 = this.deck.getItem();
        IHeld returnedCard2 = this.deck.getItem();

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
