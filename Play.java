import java.io.IOException;
import java.util.Arrays;

import com.whitehatgaming.UserInput;
import com.whitehatgaming.UserInputFile;

public class Play {

    /**
     * variable to check if play continues
     */
    boolean play = true;
    /**
     * variable to store the state of the board
     */
    Board board = new Board();
    /**
     * to check which player turn
     * true if its white's turn
     */
    boolean turn = true;

    /**
     * reads the input file and loops each move till end of file
     */
    public void start(){
        try {
            UserInput userInput = new UserInputFile("/Users/geoj/Downloads/WHGPlatformTechTest/data/sample-moves-invalid.txt");
            while(play) {
                int[] nextMove = userInput.nextMove();
                    if(nextMove != null) {
                        nextMove = getNextMove(nextMove);
                        System.out.println(Arrays.toString(nextMove));
                        if(move(nextMove)) {
                            turn = !turn;
                        }
                    } else {
                        play = false;
                    }
                    board.display();
                }
            System.out.println("Game Over: " + (turn? "Black" : "White") + " wins");
        }
        catch (IOException e) {
            //
        }
    }

    /**
     * moves each turns accordingly and displays the board
     * @param move
     * @return
     */
    boolean move(int[] move) {
        ChessPiece piece = board.getPiece(move);
        System.out.println((turn? "White":"Black") + "'s turn");
        if(piece == null || piece.checkIfPieceWhite() != turn) {
            System.out.println((piece == null?"No" : (turn ? "Black":"White")) + " Piece");
            return false;
        }
        boolean moved = piece.move(Arrays.copyOfRange(move, 2, 4));
        if(moved) {
            board.move(piece, move);
        }
        return moved;
    }

    /**
     * rearrange the input so that the line reads fromRow fromColumn toRow toColumn
     * instead of fromColumn fromRow toColumn toRow 
     * @param move
     * @return
     */
    int[] getNextMove(int[] move) {
        int temp = move[0];
        move[0] = move[1];
        move[1] = temp;
        temp = move[3];
        move[3] = move[2];
        move[2] = temp;
        return move;
    }
}
