import java.util.Scanner;

public class TicTacToe {

    private Board board; // Här är spelbrädet
    private Player currentPlayer; // Nuvarande spelare
    private Player playerX; // Spelare X
    private Player playerO; // Spelare O

    public TicTacToe(){ // När vi startar spelet
        this.board = new Board(); // Skapa ett nytt bräde
        this.playerX = new Player('X'); // Spelare X
        this.playerO = new Player('O'); // Spelare O
        this.currentPlayer = playerX; // X börjar alltid
    }

    public void start (){ // Starta spelet
        Scanner scanner = new Scanner(System.in);

        while (true){
            board.resetBoard(); // Nollställ brädet
            playGame(scanner); // Kör spelet

            System.out.println("Do you want to play again? (yes/no): ");
            String answer = scanner.next(); // Fråga om de vill spela igen
            if(!answer.equalsIgnoreCase("yes")){
                break; // Avsluta spelet om de säger "nej"
            }
        }
        scanner.close(); // Stäng av inmattningen när spelet är klart
    }

    private void playGame(Scanner scanner){ // Kör själva spelet
        boolean gameWon = false;
        int turns = 0;

        while (!gameWon && turns <9){ // Kör tills någon vinner eller vi har gjort 9 drag
            board.printBoard(); // Skriv ut brädet
            boolean validMove = false;
            while (!validMove){
                System.out.println("Player " + currentPlayer.getMark() + ", enter row (1-3) and column (1-3): ");
                int row = scanner.nextInt() - 1;
                int col = scanner.nextInt() - 1;

                validMove = board.makeMove(row, col, currentPlayer.getMark());
                if(!validMove){
                    System.out.println("Invalid Move. Try again!");
                }
            }

            gameWon = board.checkWin (currentPlayer.getMark());
            if(gameWon){
                board.printBoard();
                System.out.println("Player " + currentPlayer.getMark() + " wins!");
                return;
            }

            turns++;
            switchPlayer();
        }

        board.printBoard();
        System.out.println("The game is a draw!");
    }

    private void switchPlayer(){ // Växlar tur mellan de två spelarna
        currentPlayer = ( currentPlayer == playerX) ? playerO : playerX;
    }

    public static void main(String[] args){ //Startpunkten för Java-program
        TicTacToe game = new TicTacToe();
        game.start();
    }
}
