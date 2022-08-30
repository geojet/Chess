public class Queen extends ChessPiece{
    public Queen(int[] pos, boolean white, Board board){
        super(pos, white, board);
    }
    /* (non-Javadoc)
     * @see ChessPiece#validate(int[])
     */
    public boolean validate(int[] toPos){
        return moveDiagonal(toPos)?true:moveStraight(toPos);
    }
}