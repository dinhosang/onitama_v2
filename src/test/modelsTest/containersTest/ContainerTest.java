package modelsTest.containersTest;

import helpers.IHeld;
import models.containers.Container;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ContainerTest {

    private Container deck;

    private IHeld mockCard1;
    private IHeld mockCard2;
    private IHeld mockCard3;

    @Before
    public void before() {
        this.deck = new Container();

        class MockIHeld implements IHeld {

            private MockIHeld() {}
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
        this.deck.addItem(this.mockCard3);

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
