package two.deck;

/*Dequeue sort. Explain how you would sort a deck of cards, with the restriction
that the only allowed operations are to look at the values of the top two cards, to
exchange the top two cards, and to move the top card to the bottom of the deck. */

import edu.princeton.cs.algs4.StdOut;
import java.util.Random;

public class DequeueSort {
    private static Suit[] suits = Suit.values();
    private static Rank[] ranks = Rank.values();

    public static void main(String[] args) {
        DequeueSort dequeueSort = new DequeueSort();
        Card[] deck = dequeueSort.createDeck();
        dequeueSort.shuffleDeck(deck);
        dequeueSort.sortDeck(deck);
        dequeueSort.printDeck(deck);
    }

    private void sortDeck(Card[] deck){
            for (int i = 0; i < deck.length; i++) {
                for (int j = i + 1; j < deck.length; j++) {
                    if (getIndex(deck[i]) > getIndex(deck[j])) {
                        Card temp = deck[i];
                        deck[i] = deck[j];
                        deck[j] = temp;
                    }
                }
            }

    }

    public static int getIndex(Card card) {
        int rankIndex = getIndexOfRank(card) == 0 ? 100 : getIndexOfRank(card) + 100;
        int suitIndex = getIndexOfSuit(card) == 0 ? 1 : getIndexOfSuit(card) + 1;
        return rankIndex*suitIndex;
    }

    private static int getIndexOfSuit(Card card){
        for(int i = 0; i < ranks.length; i++){
            if(suits[i] == card.suit){
                return i;
            }
        }
        return 0;
    }

    private static int getIndexOfRank(Card card){
        for(int i = 0; i < ranks.length; i++){
            if(ranks[i] == card.rank){
                return i;
            }
        }
        return 0;
    }

    private Card[] createDeck(){
        Card[] deck = new Card[Suit.values().length*Rank.values().length];
        int count = 0;
        for(Suit suit : Suit.values())
            for(Rank rank : Rank.values()){
               deck[count++] = new Card(suit, rank);
        }
        return deck;
    }

    private void shuffleDeck(Card[] deck){
        Random random = new Random();
        for(int i = 0; i < deck.length; i++){
            int j = random.nextInt(i + 1);
            if(j != i){
                excenge(deck, i, j);
            }
        }
    }

    private void excenge(Card[] deck, int i, int j) {
        Card temp = deck[i];
        deck[i] = deck[j];
        deck[j] = temp;
    }

    private void printDeck(Card[] deck){
        for(int i = 0; i < deck.length; i++) {
            StdOut.println(deck[i]);
        }
    }
}
