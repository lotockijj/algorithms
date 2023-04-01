package two.deck;

public class Card{
    public Suit suit;
    public Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return suit + "  " + rank;
    }
}
