package poker;

import java.util.HashMap;
import java.util.Map;

public class Card implements Comparable<Card> {

    public enum Value {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;
        
        @Override
        public String toString() {
          switch(this) {
            case ACE: return "Ace";
            case KING: return "King";
            case QUEEN: return "Queen";
            case JACK: return "Jack";
            case TEN: return "10";
            case NINE: return "9";
            case EIGHT: return "8";
            case SEVEN: return "7";
            case SIX: return "6";
            case FIVE: return "5";
            case FOUR: return "4";
            case THREE: return "3";
            case TWO: return "2";
            default: throw new IllegalArgumentException();
          }
        }
    }
    
    public enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES
    }
    
    private static final Map<Character, Value> valuesMap = new HashMap<Character, Value>();
    static {
        valuesMap.put('2', Value.TWO);
        valuesMap.put('3', Value.THREE);
        valuesMap.put('4', Value.FOUR);
        valuesMap.put('5', Value.FIVE);
        valuesMap.put('6', Value.SIX);
        valuesMap.put('7', Value.SEVEN);
        valuesMap.put('8', Value.EIGHT);
        valuesMap.put('9', Value.NINE);
        valuesMap.put('T', Value.TEN);
        valuesMap.put('J', Value.JACK);
        valuesMap.put('Q', Value.QUEEN);
        valuesMap.put('K', Value.KING);
        valuesMap.put('A', Value.ACE);
    }
    
    private static final Map<Character, Suit> suitsMap = new HashMap<Character, Suit>();
    static {
        suitsMap.put('C', Suit.CLUBS);
        suitsMap.put('D', Suit.DIAMONDS);
        suitsMap.put('H', Suit.HEARTS);
        suitsMap.put('S', Suit.SPADES);
    }

    private Value value;
    private Suit suit;

    public Card(String card) {
        this.value = extractValue(card);
        this.suit = extractSuit(card);
    }

    private Value extractValue(String card) {
        return valuesMap.get(card.charAt(0));
    }

    private Suit extractSuit(String card) {
        return suitsMap.get(card.charAt(1));
    }

    public Value getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card otherCard) { //比较大小
        return this.value.compareTo(otherCard.value);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((suit == null) ? 0 : suit.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        if (suit != other.suit || value != other.value)
            return false;
        return true;
    }

}
