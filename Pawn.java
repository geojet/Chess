public class Pawn extends ChessPiece{
    /**
     * to check how many tiles the pawn can move in a turn
     * set to 1 after first move
     */
    int canMove = 2;
    public Pawn(int[] pos, boolean white, Board board){
        super(pos, white, board);
    }
    /* (non-Javadoc)
     * @see ChessPiece#validate(int[])
     */
    public boolean validate(int[] toPos){
        int[] pos = location();
        if(white && toPos[0] >= pos[0] - canMove || !white && toPos[0] <= pos[0] + canMove){
            canMove = 1;
            return true;
        }
        return false;
    }
}