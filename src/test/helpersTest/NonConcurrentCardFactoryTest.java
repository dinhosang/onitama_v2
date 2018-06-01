package helpersTest;

import constants.GameMode;
import helpers.IContainer;
import helpers.IHeld;
import helpers.factories.NonConcurrentCardFactory;
import models.cards.Card;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class NonConcurrentCardFactoryTest {

    IContainer mockDeck;

    @Before
    public void before() {


        class MockDeck implements IContainer {

            private ArrayList<IHeld> cards;

            private MockDeck(){
                this.cards = new ArrayList<>();
            }

            @Override
            public void addItem(IHeld item) throws IllegalArgumentException {
                if (item instanceof Card) {
                    cards.add(item);
                } else {
                    throw new IllegalArgumentException("Wrong item passed through to Deck instance - non-Card item");
                }
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
        NonConcurrentCardFactory.createItems(GameMode.STANDARD, this.mockDeck);

        assertEquals(5, this.mockDeck.getSize());
    }

    @Test
    public void eachCardMadeIsUnique() {
        NonConcurrentCardFactory.createItems(GameMode.STANDARD, this.mockDeck);

        Card card1 = (Card) this.mockDeck.getItem();
        Card card2 = (Card) this.mockDeck.getItem();
        Card card3 = (Card) this.mockDeck.getItem();
        Card card4 = (Card) this.mockDeck.getItem();
        Card card5 = (Card) this.mockDeck.getItem();

        Boolean cardsAreNotUnique = false;

        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(card1, card2, card3, card4, card5));
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
    public void testingTimeToProcess10Times1KCreations() {
        NonConcurrentCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);
        NonConcurrentCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);
        NonConcurrentCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);
        NonConcurrentCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);
        NonConcurrentCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);

        NonConcurrentCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);
        NonConcurrentCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);
        NonConcurrentCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);
        NonConcurrentCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);
        NonConcurrentCardFactory.createItems(GameMode.TESTSTANDARD, this.mockDeck);

        assertEquals(50000, this.mockDeck.getSize());
    }


}
