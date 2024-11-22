import java.util.Scanner;

public class TicTacToeGame {
    private final Board board;  // En instans av Board-klassen för att hantera spelplanen
    private int player1Wins = 0;  // Räknare för antal vinster för spelare 1
    private int player2Wins = 0;  // Räknare för antal vinster för spelare 2

    // Konstruktor för att skapa ett TicTacToeGame-objekt
    public TicTacToeGame() {
        board = new Board();  // Skapar en ny spelplan
    }

    // Startar spelet
    public void startGame() {
        Scanner scanner = new Scanner(System.in);  // Skapar en scanner för att ta in användarinput

        // Frågar spelare 1 om deras namn
        System.out.print("Enter Player 1 Name: ");
        String name1 = scanner.nextLine();
        Player player1 = new Player(name1, 'X');  // Skapar spelare 1 med marker X

        // Frågar spelare 2 om deras namn
        System.out.print("Enter Player 2 Name: ");
        String name2 = scanner.nextLine();
        Player player2 = new Player(name2, 'O');  // Skapar spelare 2 med marker O

        boolean playing = true;  // Spelflagga för att hålla spelet igång

        while (playing) {
            board.initializeBoard();  // Återställer spelplanen för varje nytt spel
            boolean gameWon = false;  // Flagga för att hålla reda på om någon har vunnit
            Player currentPlayer = player1;  // Bestämmer att spelare 1 börjar

            // Huvudspel-loop
            while (!board.isBoardFull() && !gameWon) {
                board.displayBoard();  // Visar den aktuella spelplanen
                System.out.print(currentPlayer.getName() + ", choose your position (1-9): ");
                int position = scanner.nextInt();  // Tar in spelarens drag

                // Validerar inmatning (position måste vara ledig och mellan 1-9)
                if (position < 1 || position > 9 || !board.isCellEmpty(position)) {
                    System.out.println("Invalid input! Try again.");
                    continue;  // Om inmatningen är ogiltig, går spelet tillbaka till nästa iteration
                }

                // Markerar spelplanen med spelarens marker
                board.markCell(position, currentPlayer.getMarker());

                // Kollar om spelaren har vunnit
                if (board.checkWin(currentPlayer.getMarker())) {
                    gameWon = true;
                    board.displayBoard();  // Visar den uppdaterade spelplanen
                    System.out.println(currentPlayer.getName() + " wins!");  // Meddelar vinnaren

                    // Uppdaterar vinsträknarna
                    if (currentPlayer == player1) {
                        player1Wins++;
                    } else {
                        player2Wins++;
                    }
                }

                // Byter spelare
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }

            // Om ingen har vunnit, är spelet oavgjort
            if (!gameWon) {
                System.out.println("It's a draw!");
            }

            // Visar resultatet av spelet
            System.out.println("Score: " + player1.getName() + " " + player1Wins + " - " + player2.getName() + " " + player2Wins);

            // Frågar om spelarna vill spela igen
            System.out.print("Play again? (yes/no): ");
            playing = scanner.next().equalsIgnoreCase("yes");  // Om de skriver 'yes' fortsätter spelet
        }

        scanner.close();  // Stänger scannern när spelet är klart
    }

    // Main-metoden som startar spelet
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();  // Skapar ett TicTacToeGame-objekt
        game.startGame();  // Startar spelet
    }
}
