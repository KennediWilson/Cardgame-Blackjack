import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain;

        do {
            playGame();
            System.out.println("Do you want to play again? y/n");
            playAgain = scanner.next();
        } while (playAgain.equalsIgnoreCase("y"));

        System.out.println("Thanks for playing!"); // thanks user for playing
        scanner.close();
    }

    public static void playGame() {
        Card card = new Card();
        Dealer house = new Dealer();

        ArrayList<String> deck = card.newDeck();
        ArrayList<String> shuffledDeck = house.shuffle(deck);

        house.deal(shuffledDeck);
        house.playerMove(shuffledDeck);
        house.dealerMove(shuffledDeck);

        boolean winnerFound = house.FindWinner();
        if (!winnerFound) {
            System.out.println("No winner found.");
        }
    }
}