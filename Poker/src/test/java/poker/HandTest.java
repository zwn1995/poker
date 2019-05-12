package poker;

import static org.junit.Assert.*;

import org.junit.Test;

public class HandTest {

    @Test
    public void testHandContains() {
        Hand handUnderTest = new Hand("2H 3D 5S 9C KD");
        assertEquals(5, handUnderTest.size());
        assertEquals(true, handUnderTest.contains(new Card("2H")));
        assertEquals(true, handUnderTest.contains(new Card("3D")));
        assertEquals(true, handUnderTest.contains(new Card("5S")));
        assertEquals(true, handUnderTest.contains(new Card("9C")));
        assertEquals(true, handUnderTest.contains(new Card("KD")));
        assertEquals(false, handUnderTest.contains(new Card("2D")));
        assertEquals(false, handUnderTest.contains(new Card("AD")));
    }
    
    @Test
    public void testHandHasPair() {
        Hand handUnderTest = new Hand("2S 2H TC JD QD");
        assertEquals(true, handUnderTest.hasPair());
        
        handUnderTest = new Hand("2S 8D AS QS 3C");
        assertEquals(false, handUnderTest.hasPair());
    }
    
    @Test
    public void testHandHasTwoPairs() {
        Hand handUnderTest = new Hand("2S 2H TC QD QD");
        assertEquals(true, handUnderTest.hasTwoPairs());
        
        handUnderTest = new Hand("2S 2D AS QS 3C");
        assertEquals(false, handUnderTest.hasTwoPairs());
    }
    
    @Test
    public void testHandHasThreeOfAKind() {
        Hand handUnderTest = new Hand("2S 2H 2C KC QD");
        assertEquals(true, handUnderTest.hasThreeOfAKind());
        
        handUnderTest = new Hand("2S 2D AS QS 9C");
        assertEquals(false, handUnderTest.hasThreeOfAKind());
    }
    
    @Test
    public void testHandIsStraight() {
        Hand handUnderTest = new Hand("8S 9S TC JS QS");
        assertEquals(true, handUnderTest.isStraight());
        
        handUnderTest = new Hand("2S 8S AS QS 3C");
        assertEquals(false, handUnderTest.isStraight());
    }
    
    @Test
    public void testHandIsFlush() {
        Hand handUnderTest = new Hand("2S 8S AS QS 3S");
        assertEquals(true, handUnderTest.isFlush());
        
        handUnderTest = new Hand("2S 8S AS QS 3C");
        assertEquals(false, handUnderTest.isFlush());
    }
    
    @Test
    public void testHandIsFullHouse() {
        Hand handUnderTest = new Hand("8H 8S 8D QS QC");
        assertEquals(true, handUnderTest.isFullHouse());
        
        handUnderTest = new Hand("9H 9S 9D QS 3C");
        assertEquals(false, handUnderTest.isFullHouse());
    }
    
    @Test
    public void testHandHasFourOfAKind() {
        Hand handUnderTest = new Hand("2S 2H 2C 2D QD");
        assertEquals(true, handUnderTest.hasFourOfAKind());
        
        handUnderTest = new Hand("4S 4D 4C QS 9C");
        assertEquals(false, handUnderTest.hasFourOfAKind());
    }
    
    @Test
    public void testHandIsStraightFlush() {
        Hand handUnderTest = new Hand("9S TS JS QS KS");
        assertEquals(true, handUnderTest.isStraightFlush());
        
        handUnderTest = new Hand("2S 8S AS QS 3S");
        assertEquals(false, handUnderTest.isStraightFlush());
        
        handUnderTest = new Hand("8S 9S TC JS QS");
        assertEquals(false, handUnderTest.isStraightFlush());
    }
    
    @Test
    public void testHandGetRank() {
        Hand handUnderTest = new Hand("9S TS JS QS KS");
        assertEquals(Hand.Rank.STRAIGHTFLUSH, handUnderTest.getRank());
        
        handUnderTest = new Hand("2S 2H 2C 2D QD");
        assertEquals(Hand.Rank.FOUROFAKIND, handUnderTest.getRank());
        
        handUnderTest = new Hand("8H 8S 8D QS QC");
        assertEquals(Hand.Rank.FULLHOUSE, handUnderTest.getRank());
        
        handUnderTest = new Hand("2S 8S AS QS 3S");
        assertEquals(Hand.Rank.FLUSH, handUnderTest.getRank());
        
        handUnderTest = new Hand("8S 9S TC JS QS");
        assertEquals(Hand.Rank.STRAIGHT, handUnderTest.getRank());
        
        handUnderTest = new Hand("2S 2H 2C KC QD");
        assertEquals(Hand.Rank.THREEOFAKIND, handUnderTest.getRank());
        
        handUnderTest = new Hand("2S 2H TC QD QD");
        assertEquals(Hand.Rank.TWOPAIRS, handUnderTest.getRank());
        
        handUnderTest = new Hand("2S 2H TC JD QD");
        assertEquals(Hand.Rank.PAIR, handUnderTest.getRank());
        
        handUnderTest = new Hand("2S 4H 9C JD QD");
        assertEquals(Hand.Rank.HIGHCARD, handUnderTest.getRank());
    }

}
