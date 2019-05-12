package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class HandComparator {

    public String compareHighCardHands(String playerOne, String playerTwo, Hand handOne, Hand handTwo) {
        List<Card> handOneCards = handOne.getCards();
        List<Card> handTwoCards = handTwo.getCards();
        for (int i = handOneCards.size() - 1; i >= 0; i--) {
            Card handOneCurrentHighestCard = handOneCards.get(i);
            Card handTwoCurrentHighestCard = handTwoCards.get(i);
            int comparisonOfCards = handOneCurrentHighestCard.compareTo(handTwoCurrentHighestCard);
            if (comparisonOfCards > 0) {
                return playerOne + " wins. - with high card: " + handOneCurrentHighestCard.getValue().toString();
            } else if (comparisonOfCards < 0) {
                return playerTwo + " wins. - with high card: " + handTwoCurrentHighestCard.getValue().toString();
            }
        }
        return "Tie.";
    }

    public String comparePairHands(String playerOne, String playerTwo, Hand handOne, Hand handTwo) {
        List<Card> handOneCards = new CopyOnWriteArrayList<Card>(handOne.getCards());
        List<Card> handTwoCards = new CopyOnWriteArrayList<Card>(handTwo.getCards());
        Card.Value handOnePair = handOne.getPairs().iterator().next();
        Card.Value handTwoPair = handTwo.getPairs().iterator().next();
        for (Card card : handOneCards) {
            if (card.getValue() == handOnePair) {
                handOneCards.remove(card);
            }
        }
        for (Card card : handTwoCards) {
            if (card.getValue() == handTwoPair) {
                handTwoCards.remove(card);
            }
        }
        String output;
        if (handOnePair.ordinal() > handTwoPair.ordinal()) {
            output = playerOne + " wins. - with pair of card: " + handOnePair.toString();
        } else if (handOnePair.ordinal() < handTwoPair.ordinal()) {
            output = playerTwo + " wins. - with pair of card: " + handTwoPair.toString();
        } else {
            output = compareHighCardHands(playerOne, playerTwo, handOne, handTwo).replace("with", "with pair of card: " + handOnePair.toString() + ", and");
        }
        return output;
    }

    public String compareTwoPairsHands(String playerOne, String playerTwo, Hand handOne, Hand handTwo) {
        List<Card> handOneCards = new CopyOnWriteArrayList<Card>(handOne.getCards());
        List<Card> handTwoCards = new CopyOnWriteArrayList<Card>(handTwo.getCards());
        List<Card.Value> handOnePairs = new ArrayList<Card.Value>(handOne.getPairs());
        List<Card.Value> handTwoPairs = new ArrayList<Card.Value>(handTwo.getPairs());
        Collections.sort(handOnePairs);
        Collections.sort(handTwoPairs);
        for (Card card : handOneCards) {
            if (handOnePairs.contains(card.getValue())) {
                handOneCards.remove(card);
            }
        }
        for (Card card : handTwoCards) {
            if (handTwoPairs.contains(card.getValue())) {
                handTwoCards.remove(card);
            }
        }
        for (int i = handOnePairs.size() - 1; i >= 0; i--) {
            if (handOnePairs.get(i).ordinal() > handTwoPairs.get(i).ordinal()) {
                return playerOne + " wins. - with two pairs of cards: " + handOnePairs.get(1).toString() + ", " + handOnePairs.get(0).toString();
            } else if (handOnePairs.get(i).ordinal() < handTwoPairs.get(i).ordinal()) {
                return playerTwo + " wins. - with two pairs of cards: " + handTwoPairs.get(1).toString() + ", " + handTwoPairs.get(0).toString();
            }         
        }
        return compareHighCardHands(playerOne, playerTwo, handOne, handTwo).replace("with", "with two pairs of cards: " + handOnePairs.get(1).toString() + ", " + handOnePairs.get(0).toString() + ", and");
    }

    public String compareThreeOfAKindHands(String playerOne, String playerTwo, Hand handOne, Hand handTwo) {
        Card.Value handOneValueOfThrees = handOne.getThreeOfAKind();
        Card.Value handTwoValueOfThrees = handTwo.getThreeOfAKind();
        int comparisonOfValuesOfThrees = handOneValueOfThrees.compareTo(handTwoValueOfThrees);
        String output;
        if (comparisonOfValuesOfThrees > 0) {
            output = playerOne + " wins. - with three of a kind of card: " + handOneValueOfThrees.toString();
        } else {
            output = playerTwo + " wins. - with three of a kind of card: " + handTwoValueOfThrees.toString();
        }
        return output;
    }

    public String compareStraightHands(String playerOne, String playerTwo, Hand handOne, Hand handTwo) {
        Card handOneHighestCard = handOne.getCards().get(4);
        Card handTwoHighestCard = handTwo.getCards().get(4);
        int comparisonOfHighestCards = handOneHighestCard.compareTo(handTwoHighestCard);
        String output;
        if (comparisonOfHighestCards > 0) {
            output = playerOne + " wins. - with straight with high card: " + handOneHighestCard.getValue().toString();
        } else if (comparisonOfHighestCards < 0) {
            output = playerTwo + " wins. - with straight with high card: " + handTwoHighestCard.getValue().toString();
        } else {
            output = "Tie.";
        }
        return output;
    }

    public String compareFlushHands(String playerOne, String playerTwo, Hand handOne, Hand handTwo) {
        return compareHighCardHands(playerOne, playerTwo, handOne, handTwo).replace("with", "with flush with");
    }

    public String compareFullHouseHands(String playerOne, String playerTwo, Hand handOne, Hand handTwo) {
        return compareThreeOfAKindHands(playerOne, playerTwo, handOne, handTwo).replace("with", "with full house with");
    }

    public String compareFourOfAKindHands(String playerOne, String playerTwo, Hand handOne, Hand handTwo) {
        Card.Value handOneValueOfFours = handOne.getFourOfAKind();
        Card.Value handTwoValueOfFours = handTwo.getFourOfAKind();
        int comparisonOfValuesOfFours = handOneValueOfFours.compareTo(handTwoValueOfFours);
        String output;
        if (comparisonOfValuesOfFours > 0) {
            output = playerOne + " wins. - with four of a kind of card: " + handOneValueOfFours.toString();
        } else {
            output = playerTwo + " wins. - with four of a kind of card: " + handTwoValueOfFours.toString();
        }
        return output;
    }

    public String compareStraightFlushHands(String playerOne, String playerTwo, Hand handOne, Hand handTwo) {
        return compareStraightHands(playerOne, playerTwo, handOne, handTwo).replace("straight", "straight flush");
    }
    
    public String compareDifferentRankHands(String playerOne, String playerTwo, Hand handOne, Hand handTwo) {
        String winner;
        Hand winningHand;
        if (handOne.getRank().ordinal() > handTwo.getRank().ordinal()) {
            winner = playerOne;
            winningHand = handOne;
        } else {
            winner = playerTwo;
            winningHand = handTwo;
        }
        return winner + " wins. - with " + winningHand.getRank().toString();
    }

    public String compareHands(String input) {
        String[] handTokens = input.split("  ");
        String[] playerOneTokens = handTokens[0].split(": ");
        String[] playerTwoTokens = handTokens[1].split(": ");
        
        String playerOne = playerOneTokens[0];
        Hand handOne = new Hand(playerOneTokens[1]);
        String playerTwo = playerTwoTokens[0];
        Hand handTwo = new Hand(playerTwoTokens[1]);
        
        String output;
        if (handOne.getRank().ordinal() != handTwo.getRank().ordinal()) {
            output = compareDifferentRankHands(playerOne, playerTwo, handOne, handTwo);
        } else {
            switch (handOne.getRank()) {
            case STRAIGHTFLUSH:
                output = compareStraightFlushHands(playerOne, playerTwo, handOne, handTwo);
                break;
            case FOUROFAKIND:
                output = compareFourOfAKindHands(playerOne, playerTwo, handOne, handTwo);
                break;
            case FULLHOUSE:
                output = compareFullHouseHands(playerOne, playerTwo, handOne, handTwo);
                break;
            case FLUSH:
                output = compareFlushHands(playerOne, playerTwo, handOne, handTwo);
                break;
            case STRAIGHT:
                output = compareStraightHands(playerOne, playerTwo, handOne, handTwo);
                break;
            case THREEOFAKIND:
                output = compareThreeOfAKindHands(playerOne, playerTwo, handOne, handTwo);
                break;
            case TWOPAIRS:
                output = compareTwoPairsHands(playerOne, playerTwo, handOne, handTwo);
                break;
            case PAIR:
                output = comparePairHands(playerOne, playerTwo, handOne, handTwo);
                break;
            case HIGHCARD:
                output = compareHighCardHands(playerOne, playerTwo, handOne, handTwo);
                break;
            default:
                output = "";
                break;
            }
        }
        return output;
    }

}
