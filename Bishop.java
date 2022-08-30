public class Bishop extends ChessPiece{
    public Bishop(int[] pos, boolean white, Board board){
        super(pos, white, board);
    }
    /* (non-Javadoc)
     * @see ChessPiece#validate(int[])
     */
    public boolean validate(int[] toPos){
        return moveDiagonal(toPos);
    }
}