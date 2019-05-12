package poker;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HandComparatorTest {

    private HandComparator handComparator;

    @Before
    public void setUp() {
        handComparator = new HandComparator();
    }

    @Test
    public void testHandComparatorCompareDifferentRankHands() {
        assertEquals("Black wins. - with full house", handComparator.compareHands("Black: 2H 4S 4C 2D 4H  White: 2S 8S AS QS 3S"));
    }

    @Test
    public void testHandComparatorCompareHighCardHands() {
        assertEquals("White wins. - with high card: Ace", handComparator.compareHands("Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH"));
        assertEquals("Black wins. - with high card: 9", handComparator.compareHands("Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C KH"));
        assertEquals("Tie.", handComparator.compareHands("Black: 2H 3D 5S 9C KD  White: 2D 3H 5C 9S KH"));
    }

    @Test
    public void testHandComparatorComparePairHands() {
        assertEquals("Black wins. - with pair of card: King", handComparator.compareHands("Black: 4H 7D JS KC KD  White: 5C 8H 9S QC QH"));
        assertEquals("Black wins. - with pair of card: King, and high card: Jack", handComparator.compareHands("Black: 4H 7D JS KC KD  White: 5C 8H 9S KC KH"));
    }
    
    @Test
    public void testHandComparatorCompareTwoPairsHands() {
        assertEquals("Black wins. - with two pairs of cards: King, Jack", handComparator.compareHands("Black: 4H KC KD JD JS  White: 5C 9H 9S KS KH"));
        assertEquals("Black wins. - with two pairs of cards: King, Jack, and high card: 9", handComparator.compareHands("Black: 9H JD JS KS KD  White: 5C JH JC KC KH"));
    }
    
    @Test
    public void testHandComparatorCompareThreeOfAKindHands() {
        assertEquals("Black wins. - with three of a kind of card: King", handComparator.compareHands("Black: 4H 7D KS KC KD  White: 5C 8H JS JC JH"));
    }
    
    @Test
    public void testHandComparatorCompareStraightHands() {
        assertEquals("White wins. - with straight with high card: 9", handComparator.compareHands("Black: 4H 5D 6S 7C 8D  White: 5C 6H 7S 8C 9H"));

    }
    
    @Test
    public void testHandComparatorCompareFlushHands() {
        assertEquals("Black wins. - with flush with high card: Ace", handComparator.compareHands("Black: 4H 5H 6H 7H AH  White: 5C 6C JC 8C 9C"));
    }
    
    @Test
    public void testHandComparatorCompareFullHouseHands() {
        assertEquals("Black wins. - with full house with three of a kind of card: King", handComparator.compareHands("Black: 7H 7D KS KC KD  White: 8C 8H JS JC JH"));
    }
    
    @Test
    public void testHandComparatorCompareFourOfAKindHands() {
        assertEquals("Black wins. - with four of a kind of card: King", handComparator.compareHands("Black: 4H KD KS KC KD  White: 5C JH JS JC JH"));
    }
    
    @Test
    public void testHandComparatorCompareStraightFlushHands() {
        assertEquals("White wins. - with straight flush with high card: 9", handComparator.compareHands("Black: 4H 5H 6H 7H 8H  White: 5C 6C 7C 8C 9C"));
    }

}
