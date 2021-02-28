public class Player {

    private String name;
    private Deck hand;
    private int sum;
    private int money;

    public Player(String name, Deck deck) {
        this.name = name;
        this.hand = new Deck(false);
        this.getHand().getCards().add(deck.getCards().get(deck.getIterator()));
        this.getHand().getCards().add(deck.getCards().get(deck.getIterator()));
        this.sum = this.hand.getCards().get(0).getValue() + this.hand.getCards().get(1).getValue();
        this.money = 500;
    }

    public String getName() {
        return name;
    }

    public Deck getHand() {
        return hand;
    }

    public int getSum() {
        return sum;
    }

    public int getMoney() {
        return money;
    }

    public void add(Deck deck) {
        this.hand.getCards().add(deck.getCards().get(deck.getIterator()));
        this.sum += this.hand.getCards().get(this.hand.getCards().size()-1).getValue();
    }

    public void win(int bet) {
        this.money += bet;
    }

    public void lose(int bet) {
        this.money -= bet;
    }

    public void clear(Deck deck) {
        this.hand = new Deck(false);
        this.getHand().getCards().add(deck.getCards().get(deck.getIterator()));
        this.getHand().getCards().add(deck.getCards().get(deck.getIterator()));
    }
}
