public class Card {
    private int value;
    private String suit;
    private String name;
    private boolean ace;
    private boolean usingAceValue; //Ace value implies 1 not 11

    public Card(int value, String suit) {
        String[] names = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
        this.value = value;
        this.suit = suit;
        this.name = names[value-1];
        this.ace = value==1;

        if(this.isAce()) {
            this.usingAceValue = true;
        }
    }

    public Card(int value, String suit, String name) {
        this.value = value;
        this.suit = suit;
        this.name = name;
        this.ace = false;
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    public boolean isAce() {
        return this.ace;
    }

    public boolean isUsingAceValue() {
        return this.usingAceValue;
    }

    public void show() {
        System.out.println(this.name + " of " + this.getSuit());
    }

    public void setValue() {
        if(ace) {
            if(usingAceValue) {
                this.value = 11;
                usingAceValue = false;
            } else {
                this.value = 1;
                usingAceValue = true;
            }
        }
    }
}
