import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        Deck deck = new Deck();
        deck.shuffleCards();

        while(true) {
            int play = getInput(true);

            System.out.println("Enter your name");
            String name = sc.nextLine();

            Player human = new Player(name, deck);
            Player house = new Player("The House", deck);

            while(play == 1) {
                if(human.getMoney() == 0) {
                    System.out.println("You have run out of money");
                    return;
                }
                int bet;
                do {
                    System.out.println("You have " + human.getMoney() + "$");
                    System.out.println("Enter how much you would like to bet");
                    bet = sc.nextInt();
                } while(!(bet > 0 && bet<=human.getMoney()));

                showHands(human, house, false);

                int input = getInput(false);


                while(input == 1) {
                    System.out.println("Player hit");
                    human.add(deck);
                    showHands(human, house, false);
                    input = getInput(false);
                }

                if(input == 3) {
                    if(2*bet > human.getMoney()) {
                        System.out.println("You don't have enough money to double");
                        break;
                    } else {
                        bet *= 2;
                        human.add(deck);
                    }

                }

                while(house.getHand().getSum() <= 15) {
                    house.add(deck);
                }

                showHands(human, house, true);

                //When player stands and house stands
                //Check 21 winner
                if(checkWin(human, house) == human) {
                    human.win(bet);
                } else {
                    human.lose(bet);
                }
                System.out.println(checkWin(human, house).getName());


                //Then empty both arraylists
                human.clear(deck);
                house.clear(deck);

                play = getInput(true);
            }

            System.out.println("You ended with " + human.getMoney() + "$");

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
        String input = " ";
        if(play) {
            do {
                System.out.println("Enter 0 to quit");
                System.out.println("Enter 1 to play");
                input = sc.nextLine();
            }while(!input.equals("0") && !input.equals("1"));
        } else {
            while(!input.equals("1") && !input.equals("2") && !input.equals("3")){
                System.out.println("Enter 1 to hit");
                System.out.println("Enter 2 to stand");
                System.out.println("Enter 3 to double");
                input = sc.nextLine();
            }
        }

        return Integer.parseInt(input);
    }

    public static Player checkWin(Player human, Player house) {
        if(human.getHand().getSum() == 21) {
            return human;
        } else if(house.getHand().getSum() == 21) {
            return house;
        } else if(human.isBusted()) {
            return house;
        } else if(house.isBusted()) {
            return human;
        } else if(human.getHand().getSum() > house.getHand().getSum()) {
            return human;
        } else if(human.getHand().getSum() < house.getHand().getSum()){
            return house;
        } else {
            return human;
        }
    }
}
