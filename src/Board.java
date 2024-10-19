public class Board {
    private char [][] board; // Det här är vårt spelbräde 3x3

    public Board(){ // Skapar ett nytt tomt bräde
        board = new char[3][3];
        resetBoard(); // Återställer brädet till tomt
    }

    public void resetBoard(){ // Gör varje ruta tom med ' '
        for(int i =0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = ' ';

            }
        }
    }

    public void printBoard(){ // Skriver ut brädet
        System.out.println("  1 2 3");
        for(int i = 0; i < 3; i++){
            System.out.print((i+1) + " ");
            for(int j = 0; j < 3; j++){
                System.out.print(board[i][j]); // Skriv ut X eller O i varje ruta
                if(j < 2) System.out.print("|"); // Skriv ut en linje mellan kollumnerna
            }
            System.out.println();
            if(i < 2) System.out.println("  -----"); // Skriv ut en linje mellan raderna
        }
    }

    public boolean makeMove(int row, int col, char mark){ //Låter en spelare sätta sin symbol(X/O) på en tom ruta
        if(row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' '){
            board[row][col] = mark;
            return true;
        }
        return false;
    }

    public boolean checkWin(char mark){ //Kollar om någon spelare har vunnit
        // Check rows
        for(int i = 0; i < 3; i++){
            if(board[i][0] == mark && board[i][1] == mark && board[i][2] == mark){
                return true; //Kolla rader
            }
        }

        //check columns
        for(int i = 0; i < 3; i++){
            if(board[0][i] == mark && board[1][i] == mark && board[2][i] == mark){
               return true; //Kolla kolumner
            }
        }

        //check diagonals
        if (board[0][0] == mark && board[1][1] == mark && board[2][2] == mark) {
            return true; //Kolla diagonalen (uppifrån vänster till ner höger)
        }
        if (board[0][2] == mark && board[1][1] == mark && board[2][0] == mark) {
            return true; //Kolla diagonalen (uppifrån höger till ner vänster)
        }

        return false; //Ingen har vunnit

    }
}
