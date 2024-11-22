public class Board {
    // En array som representerar spelplanen
    private char[] board;
    private static final int SIZE = 9;  // Storleken på spelplanen (3x3)

    // Konstruktor som initierar spelplanen
    public Board() {
        board = new char[SIZE];  // Skapar en array med 9 element (för varje ruta på spelplanen)
        initializeBoard();  // Initierar spelplanen med siffror 1 till 9
    }

    // Initierar spelplanen så att varje ruta innehåller en siffra (1 till 9)
    public void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            board[i] = (char) ('1' + i);  // Fyller varje ruta med motsvarande siffra
        }
    }

    // Visar spelplanen i terminalen
    public void displayBoard() {
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---+---+---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
    }

    // Kollar om en cell är tom
    public boolean isCellEmpty(int position) {
        return board[position - 1] >= '1' && board[position - 1] <= '9';  // Om det är en siffra, är cellen tom
    }

    // Markerar en cell med en spelares symbol (X eller O)
    public void markCell(int position, char marker) {
        board[position - 1] = marker;  // Uppdaterar cellen med spelarens symbol
    }

    // Kollar om en spelare har vunnit
    public boolean checkWin(char marker) {
        // Listar alla vinstkombinationer (rader, kolumner och diagonaler)
        int[][] winPositions = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rader
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Kolumner
                {0, 4, 8}, {2, 4, 6}             // Diagonaler
        };
        // Loopar igenom varje vinstkombination och kollar om alla positioner innehåller spelarens marker
        for (int[] win : winPositions) {
            if (board[win[0]] == marker && board[win[1]] == marker && board[win[2]] == marker) {
                return true;  // Om spelaren har tre i rad
            }
        }
        return false;  // Om ingen vinst hittas
    }

    // Kollar om spelplanen är full (inga siffror kvar)
    public boolean isBoardFull() {
        for (char c : board) {
            if (c >= '1' && c <= '9') {
                return false;  // Om någon cell fortfarande har en siffra, är inte spelplanen full
            }
        }
        return true;  // Om alla celler är markerade, är spelplanen full
    }
}
