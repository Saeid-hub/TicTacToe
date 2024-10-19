public class Player {
    private char mark; // Varje spelare har en symbol, antigen X eller O

    public Player(char mark){ // När en ny spelare skapas, ger vi den antingen X eller O
        this.mark = mark;
    }

    public char getMark(){ // Den här funktionen låter oss se vilken symbol spelaren har
        return mark;
    }
}
