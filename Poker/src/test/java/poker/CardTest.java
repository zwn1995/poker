package poker;

import org.junit.Test;
import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void testCardGetValue() {
        Card cardUnderTest = new Card("2C");
        assertEquals(Card.Value.TWO, cardUnderTest.getValue());

        cardUnderTest = new Card("3C");
        assertEquals(Card.Value.THREE, cardUnderTest.getValue());

        cardUnderTest = new Card("4C");
        assertEquals(Card.Value.FOUR, cardUnderTest.getValue());

        cardUnderTest = new Card("5C");
        assertEquals(Card.Value.FIVE, cardUnderTest.getValue());

        cardUnderTest = new Card("6C");
        assertEquals(Card.Value.SIX, cardUnderTest.getValue());

        cardUnderTest = new Card("7C");
        assertEquals(Card.Value.SEVEN, cardUnderTest.getValue());

        cardUnderTest = new Card("8C");
        assertEquals(Card.Value.EIGHT, cardUnderTest.getValue());

        cardUnderTest = new Card("9C");
        assertEquals(Card.Value.NINE, cardUnderTest.getValue());

        cardUnderTest = new Card("TC");
        assertEquals(Card.Value.TEN, cardUnderTest.getValue());

        cardUnderTest = new Card("JC");
        assertEquals(Card.Value.JACK, cardUnderTest.getValue());

        cardUnderTest = new Card("QC");
        assertEquals(Card.Value.QUEEN, cardUnderTest.getValue());

        cardUnderTest = new Card("KC");
        assertEquals(Card.Value.KING, cardUnderTest.getValue());

        cardUnderTest = new Card("AC");
        assertEquals(Card.Value.ACE, cardUnderTest.getValue());
        
        cardUnderTest = new Card("/C");
        assertEquals(null, cardUnderTest.getValue());
    }

    @Test
    public void testCardGetSuit() {
        Card cardUnderTest = new Card("2C");
        assertEquals(Card.Suit.CLUBS, cardUnderTest.getSuit());

        cardUnderTest = new Card("2D");
        assertEquals(Card.Suit.DIAMONDS, cardUnderTest.getSuit());

        cardUnderTest = new Card("2H");
        assertEquals(Card.Suit.HEARTS, cardUnderTest.getSuit());

        cardUnderTest = new Card("2S");
        assertEquals(Card.Suit.SPADES, cardUnderTest.getSuit());
        
        cardUnderTest = new Card("2/");
        assertEquals(null, cardUnderTest.getSuit());
    }
    
    @Test
    public void testCardCompareTo() {
        Card cardOne = new Card("2S");
        Card cardTwo = new Card("AC");
        assertTrue(cardOne.compareTo(cardTwo) < 0);
        
        cardOne = new Card("9H");
        cardTwo = new Card("6C");
        assertTrue(cardOne.compareTo(cardTwo) > 0);
        
        cardOne = new Card("JH");
        cardTwo = new Card("JD");
        assertTrue(cardOne.compareTo(cardTwo) == 0);
    }
    
    @Test
    public void testCardEquals() {
        Card cardOne = new Card("2S");
        Card cardTwo = new Card("AC");
        assertEquals(false, cardOne.equals(cardTwo));
        
        cardOne = new Card("QC");
        cardTwo = new Card("QC");
        assertEquals(true, cardOne.equals(cardTwo));
        
        cardOne = new Card("JH");
        cardTwo = new Card("JD");
        assertEquals(false, cardOne.equals(cardTwo));
        
        assertEquals(true, cardOne.equals(cardOne));
        
        cardTwo = null;
        assertEquals(false, cardOne.equals(cardTwo));
        
        assertEquals(false, cardOne.equals(new Object()));
    }
    
    @Test
    public void testCardHashCode() {
        Card cardOne = new Card("JH");
        Card cardTwo = new Card("JH");
        assertEquals(cardOne.hashCode(), cardTwo.hashCode());
        
        cardOne = new Card("8H");
        cardTwo = new Card("8S");
        assertNotEquals(cardOne.hashCode(), cardTwo.hashCode());
    }

}
