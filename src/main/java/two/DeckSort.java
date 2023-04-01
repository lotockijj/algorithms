package two;

import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;
import java.util.Random;

public class DeckSort {
    private static String[] rank = {"A", "B", "C", "D", "E", "F", "G", "I", "H"};
    private static String[] suit = {"spades", "hearts", "clubs", "diamonds"};

    public static void main(String[] args) {
        DeckSort deckSort = new DeckSort();
        Card[] deck = deckSort.createDeckOfCards();
        shuffleDeck(deck);
        DeckSort.CardComparator cardComparator = new DeckSort().new CardComparator();
        sortDeckInsertionSort(deck, cardComparator);
        printDeck(deck);
    }

    private static void sortDeck(Card[] deck, Comparator<Card> comparator) {
        int h = 1;
        while (h < deck.length/3) {
            h = 3*h + 1;
        }
        while(h >= 1){
            for(int i = h; i < deck.length; i++){
                for(int j = i; j >= h; j -= h){
                    if(comparator.compare(deck[j], deck[j - h]) > 0){
                        Card temp = deck[j];
                        deck[j] = deck[j - h];
                        deck[j - h] = temp;
                    } else {
                        break;
                    }
                }
            }
            h = h/3;
        }
    }

    private static void sortDeckInsertionSort(Card[] a, Comparator<Card> comparator){
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a.length; j++){
                if(j != i && comparator.compare(a[i], a[j]) > 0){
                    Card temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public class Card implements Comparable{
        public String suit;
        public String rank;

        public Card(String suit, String rank) {
            this.suit = suit;
            this.rank = rank;
        }

        @Override
        public String toString() {
            return suit + "   " + rank;
        }

        @Override
        public int compareTo(Object o) {
            Card card = (Card) o;
            int result = 0;
            if(getSuitIndex(card) < getSuitIndex(this)){
                result = 1;
            } else if(getRankIndex(card) < getRankIndex(this)){
                result = 1;
            } else if( getSuitIndex(card) == getSuitIndex(this) &&
            getRankIndex(card) == getRankIndex(this)){
                result = 0;
            } else {
                result = -1;
            }
            return result;
        }

        private int getSuitIndex(Card card) {
            for(int i = 0; i < DeckSort.suit.length; i++){
                if(card.suit == DeckSort.suit[i]){
                    return i;
                }
            }
            return 0;
        }

        private int getRankIndex(Card card) {
            for(int i = 0; i < DeckSort.rank.length; i++){
                if(card.rank == DeckSort.rank[i]){
                    return i;
                }
            }
            return 0;
        }
    }

    private Card[] createDeckOfCards() {
        Card[] deck = new Card[36];
        int count = 0;
        for(int i = 0; i < rank.length; i++){
            for(int j = 0; j < suit.length; j++){
               deck[count++] = new Card(suit[j], rank[i]);
            }
        }
        return deck;
    }

    private static void printDeck(Card[] deck){
        for(int i = 0; i < deck.length; i++){
            StdOut.println(deck[i]);
        }
    }

    private static void shuffleDeck(Card[] deck){
        Random r = new Random();
        for(int i = 0; i < deck.length; i++){
            int j = r.nextInt(deck.length - 1);
            if(i != j){
                Card temp = deck[i];
                deck[i] = deck[j];
                deck[j] = temp;
            }
        }
    }

    private class CardComparator implements Comparator<Card>{

        @Override
        public int compare(Card o1, Card o2) {
            if(getRankIndex(o1) > getRankIndex(o2)){
                return 1;
            }
            if(getSuitIndex(o1) > getSuitIndex(o2)){
                return 1;
            }
            if(getRankIndex(o1) == getRankIndex(o1) && getSuitIndex(o1) < getSuitIndex(o2)){
                return -1;
            }
            if(getSuitIndex(o1) == getSuitIndex(o2) && getRankIndex(o1) < getRankIndex(o2)){
                return -1;
            }
            if(getSuitIndex(o1) == getSuitIndex(o2) && getRankIndex(o1) == getRankIndex(o2)){
                return 0;
            }
            return -1;
        }

        private int getSuitIndex(Card card) {
            for(int i = 0; i < DeckSort.suit.length; i++){
                if(card.suit == DeckSort.suit[i]){
                    return i;
                }
            }
            return 0;
        }

        private int getRankIndex(Card card) {
            for(int i = 0; i < DeckSort.rank.length; i++){
                if(card.rank == DeckSort.rank[i]){
                    return i;
                }
            }
            return 0;
        }
    }
}