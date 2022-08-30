public abstract class ChessPiece {
    /**
     * to check which player piece
     */
    boolean white;
    /**
     * position of the piece
     */
    private int[] pos = {0,0};
    /**
     * the board class on which piece is placed
     */
    Board board;
    /**
     * constructor 
     * @param pos
     * @param white
     * @param board
     */
    ChessPiece(int[] pos, boolean white, Board board){
        this.pos = pos;
        this.white = white;
        this.board = board;
    }
    /**
     * validate the to position which the piece will be placed and is valid
     * @param toPos
     * @return
     */
    public boolean validateToPos(int[] toPos) {
        ChessPiece newPiece = board.getPiece(toPos);
        if(newPiece != null) {
            return newPiece.checkIfPieceWhite() != this.checkIfPieceWhite();
        }
        return pos != null && toPos[0]<8 && toPos[0] >=0 && toPos[1]<8 && toPos[1] >=0;
    }

    /**
     * abstract method to be implemented in child classes
     * @param toPos
     * @return
     */
    public abstract boolean validate(int[] toPos);

    /**
     * move the piece to the new location
     * @param toPos
     * @return
     */
    public boolean move(int[] toPos){
        if(validateToPos(toPos) && validate(toPos)) {
            pos = toPos;
            return true;
        }
        System.out.println("Invalid Move");
        return false;
    }
    /**
     * checks if the piece is moving straight
     * @param toPos
     * @return
     */
    boolean moveStraight(int[] toPos){
        //todo check in middle
        return pos[0] == toPos[0] && pos[1] != toPos[1] || pos[0] != toPos[0] && pos[1] == toPos[1];
    }
    /**
     * checks if the piece is moving diagonally
     * @param toPos
     * @return
     */
    boolean moveDiagonal(int[] toPos){
        //todo check in middle
        return Math.abs(pos[0] - toPos[0])== Math.abs(pos[1] - toPos[1]);
    }
    /**
     * checks if piece belongs to white
     * @return true if white
     */
    boolean checkIfPieceWhite() {
        return white;
    }
    /**
     * 
     * @return current location of the piece
     */
    int[] location() {
        return pos;
    }
}
