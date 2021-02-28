public class Card {
    private int value;
    private String suit;
    private String name;
    private boolean isAce;

    public Card(int value, String suit) {
        String[] names = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
        this.value = value;
        this.suit = suit;
        this.name = names[value-1];
        this.isAce = value==1;
    }

    public Card(int value, String suit, String name) {
        this.value = value;
        this.suit = suit;
        this.name = name;
        this.isAce = false;
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    public boolean isAce() {
        return this.isAce;
    }

    public void show() {
        System.out.println(this.name + " of " + this.getSuit());
    }

    public void setValue(int value) {
        if(isAce) {
            this.value = value;
        }
    }
}
