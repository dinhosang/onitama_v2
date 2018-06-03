package helpersTest;

import constants.GameMode;
import helpers.IContain;
import helpers.IHeld;
import helpers.factories.ConcurrentStaticCardFactory;
import models.cards.Card;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ConcurrentStaticCardFactoryTest {

    IContain mockDeck;

    @Before
    public void before() {


        class MockDeck implements IContain {

            private ArrayList<IHeld> cards;

            private MockDeck(){
                this.cards = new ArrayList<>();
            }

            @Override
            public void addItem(IHeld item) {
                cards.add(item);
            }

            public int getSize() {
                return cards.size();
            }

            public IHeld getItem() throws IndexOutOfBoundsException {
                try {
                    return this.cards.remove(0);
                } catch (IndexOutOfBoundsException e) {
                    throw e;
                }

            }
        }

        this.mockDeck = new MockDeck();
    }

    @Test
    public void fiveCardsWillBeMadeByNCCardFactoryForStandardModeGame() {
        ConcurrentStaticCardFactory.createItems(GameMode.STANDARD, this.mockDeck);
        
        assertEquals(6, this.mockDeck.getSize());
    }

    @Test
    public void eachCardMadeIsUnique() {
        ConcurrentStaticCardFactory.createItems(GameMode.STANDARD, this.mockDeck);

        Card card1 = (Card) this.mockDeck.getItem();
        Card card2 = (Card) this.mockDeck.getItem();
        Card card3 = (Card) this.mockDeck.getItem();
        Card card4 = (Card) this.mockDeck.getItem();
        Card card5 = (Card) this.mockDeck.getItem();
        Card card6 = (Card) this.mockDeck.getItem();

        Boolean cardsAreNotUnique = false;

        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(card1, card2, card3, card4, card5, card6));
        for(Card card : cards){
            Boolean cardMatchesItself = false;
            for(int cardIndexToCheckAgainst = 0; cardIndexToCheckAgainst < cards.size(); cardIndexToCheckAgainst++){
                if(cards.get(cardIndexToCheckAgainst).equals(card) && !cardMatchesItself) {
                    cardMatchesItself = true;
                } else if (cards.get(cardIndexToCheckAgainst).equals(card) && cardMatchesItself) {
                    cardsAreNotUnique = true;
                }
            }
        }

        assertEquals(false, cardsAreNotUnique);
    }

    @Test
    public void testingTimeToProcess20Times1KCreations() {

        System.out.println("--- Concurrent By Complete Deck Static Card Factory - 120K Cards");

        ConcurrentStaticCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);
        ConcurrentStaticCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);
        ConcurrentStaticCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);
        ConcurrentStaticCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);
        ConcurrentStaticCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);

        ConcurrentStaticCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);
        ConcurrentStaticCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);
        ConcurrentStaticCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);
        ConcurrentStaticCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);
        ConcurrentStaticCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);

        ConcurrentStaticCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);
        ConcurrentStaticCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);
        ConcurrentStaticCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);
        ConcurrentStaticCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);
        ConcurrentStaticCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);

        ConcurrentStaticCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);
        ConcurrentStaticCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);
        ConcurrentStaticCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);
        ConcurrentStaticCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);
        ConcurrentStaticCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);

        assertEquals(120000, this.mockDeck.getSize());
    }



}
