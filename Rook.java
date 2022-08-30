public class Rook extends ChessPiece{
    public Rook(int[] pos, boolean white, Board board){
        super(pos, white, board);
    }
    /* (non-Javadoc)
     * @see ChessPiece#validate(int[])
     */
    public boolean validate(int[] toPos){
        return moveStraight(toPos);
    }
}