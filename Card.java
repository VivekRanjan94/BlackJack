public class Card {
    private int value;
    private String suit;
    private String name;

    public Card(int value, String suit) {
        String[] names = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
        this.value = value;
        this.suit = suit;
        this.name = names[value-1];
    }

    public Card(int value, String suit, String name) {
        this.value = value;
        this.suit = suit;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    public void show() {

        System.out.println(this.name + " of " + this.getSuit());

//        if(this.value == 1) {
//            System.out.println("Ace of " + this.getSuit());
//        } else if(this.value == 11) {
//            System.out.println("Jack of " + this.getSuit());
//        } else if(this.value == 12) {
//            System.out.println("Queen of " + this.getSuit());
//        } else if(this.value == 13) {
//            System.out.println("King of " + this.getSuit());
//        } else {
//            System.out.println(this.getValue() + " of " + this.getSuit());
//        }

    }

}
