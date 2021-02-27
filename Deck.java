import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;
    private int iterator;

    public Deck() {
        this.cards = new ArrayList<>();
        for(int k = 0; k<6; k++) {
            for(int i = 0; i<4; i++) {
                String suit;
                switch (i) {
                    case 0:
                        suit = "Spades";
                        break;
                    case 1:
                        suit = "Diamonds";
                        break;
                    case 2:
                        suit = "Clubs";
                        break;
                    default:
                        suit = "Hearts";
                        break;
                }
                for(int j = 1; j<=10; j++) {
                    this.cards.add(new Card(j, suit));
                }

                this.cards.add(new Card(10, suit, "King"));
                this.cards.add(new Card(10, suit, "Queen"));
                this.cards.add(new Card(10, suit, "Jack"));

            }
        }
        iterator = 0;
    }

    public Deck(boolean isFull) {
        this.cards = new ArrayList<>();
    }

    public int getIterator() {
        return iterator++;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void showDeck() {
        for (Card card : this.cards) {
            card.show();
        }
    }

    public void shuffleCards() {
        Collections.shuffle(this.cards);
    }
}
