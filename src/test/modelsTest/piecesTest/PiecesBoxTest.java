package modelsTest.piecesTest;

import helpers.IHeld;
import models.cards.Deck;
import models.pieces.PiecesBox;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PiecesBoxTest {

//    private PiecesBox box;
//
//    private IHeld mockPiece1;
//    private IHeld mockPiece2;
//    private IHeld mockPiece3;
//
//    @Before
//    public void before() {
//        this.box = new PiecesBox();
//
//        class MockIHeld implements IHeld {
//
//            private MockIHeld() {}
//        }
//
//        this.mockPiece1 = new MockIHeld();
//        this.mockPiece2 = new MockIHeld();
//        this.mockPiece3 = new MockIHeld();
//    }
//
//    @Test
//    public void deckStartsEmpty() {
//        assertEquals(0, this.deck.getSize());
//    }
//
//    @Test
//    public void deckCanAcceptCards() {
//        this.deck.addItem(this.mockCard1);
//        this.deck.addItem(this.mockCard2);
//        assertEquals(2, this.deck.getSize());
//    }
//
//    @Test
//    public void deckWillRemoveAndReturnHeldCardsFirstInFirstOut() {
//        this.deck.addItem(this.mockCard1);
//        this.deck.addItem(this.mockCard2);
//        this.deck.addItem(this.mockCard2);
//
//        assertEquals(3, this.deck.getSize());
//
//        IHeld returnedCard1 = this.deck.getItem();
//        IHeld returnedCard2 = this.deck.getItem();
//
//        assertEquals(this.mockCard1, returnedCard1);
//        assertEquals(this.mockCard2, returnedCard2);
//        assertNotEquals(this.mockCard1, returnedCard2);
//        assertEquals(1, this.deck.getSize());
//    }
//
//    @Test
//    public void deckWillThrowErrorIfAttemptingToRemoveMoreThanExists() {
//        this.deck.addItem(this.mockCard1);
//
//        IHeld card1         = this.deck.getItem();
//        Exception exception = null;
//
//        try {
//            IHeld card2 = this.deck.getItem();
//        } catch (IndexOutOfBoundsException e) {
//            exception = e;
//        }
//
//        assertEquals(this.mockCard1, card1);
//        assertEquals(0, this.deck.getSize());
//        assertNotEquals(null, exception);
//    }
}
