import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Deck deck = new Deck();
        deck.shuffleCards();

        Player human = new Player("Vivek", deck);
        String humanName = human.getName();
        Player house = new Player("Casino", deck);
        String houseName = house.getName();

        while(true) {

            int play = getInput(true);

            if(play == 1) {
                showHands(human, house, false);

                int input = getInput(false);
                while(input == 1) {
                    human.add(deck);
                    showHands(human, house, false);
                    input = getInput(false);
                }


                if(house.getSum() <= 15) {
                    house.add(deck);
                }
                showHands(human, house, true);


                //When player stands and house stands
                //Check 21 winner
                System.out.println(checkWin(human, house).getName());



                //Then empty both arraylists
                human = new Player(humanName, deck);
                house = new Player(houseName, deck);
            } else {
                break;
            }

            //restart
        }
    }

    public static void showHands(Player human, Player house, boolean end) {
        if(!end) {
            System.out.println("Player - ");
            human.getHand().showDeck();
            System.out.println("House - ");
            house.getHand().getCards().get(0).show();
        } else {
            System.out.println("Player - ");
            human.getHand().showDeck();
            System.out.println("House - ");
            house.getHand().showDeck();
        }
    }


    public static int getInput(boolean play) {
        String input;
        if(play) {
            do {
                System.out.println("Enter 0 to quit");
                System.out.println("Enter 1 to play");
                input = sc.nextLine();
            }while(!input.equals("0") && !input.equals("1"));
        } else {
            do {
                System.out.println("Enter 1 to hit");
                System.out.println("Enter 2 to stand");
                input = sc.nextLine();
            }while(!input.equals("0") && !input.equals("1") && !input.equals("2"));
        }

        return Integer.parseInt(input);
    }

    public static Player checkWin(Player human, Player house) {
        if(human.getSum() == 21) {
            return human;
        } else if(house.getSum() == 21) {
            return house;
        } else if(human.getSum() > 21) {
            return house;
        } else if(house.getSum() > 21) {
            return human;
        } else if(human.getSum() > house.getSum()) {
            return human;
        } else if(human.getSum() < house.getSum()){
            return house;
        } else {
            return human;
        }
    }
}
