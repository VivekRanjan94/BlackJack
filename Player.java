public class Player {

    private String name;
    private Deck hand;
    private int money;
    private boolean bust;

    public Player(String name, Deck deck) {
        this.name = name;
        this.hand = new Deck(false);

        hand.add(hand, deck);
        hand.add(hand, deck);

        this.money = 500;
        this.bust = false;
    }

    public String getName() {
        return name;
    }

    public Deck getHand() {
        return hand;
    }

    public int getMoney() {
        return money;
    }

    public void add(Deck deck) {
        if(!this.bust) {
            this.hand.add(this.hand, deck);
            if(this.getHand().getSum() > 21) {
                this.bust = true;
            }
        }
    }

    public boolean isBusted() {
        return bust;
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
