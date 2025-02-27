import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack { 
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) { // Use try-with-resources to ensure Scanner is closed
            String playAgain = "yes";

            while (playAgain.equalsIgnoreCase("yes")) { //if the answer yes play agian 
                Card card = new Card(); // creates card object
                Dealer house = new Dealer();// creates dealer object

                ArrayList<String> deck = card.newDeck(); // initialize deck
                ArrayList<String> shuffledDeck = house.shuffle(deck); // take deck and shuffle it

                house.deal(shuffledDeck); // deal to players
                house.playerMove(shuffledDeck); // initialize first player move
                house.dealerMove(shuffledDeck); // initialize first dealer move
                house.findWinner(); // determine final winner

                System.out.print("Do you want to play again? (yes/no): "); // asks if user wants to play again
                playAgain = scanner.nextLine(); // takes user input
            }
        }

        System.exit(0); // end program
    }
}
