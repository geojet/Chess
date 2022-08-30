public class Knight extends ChessPiece{
    public Knight(int[] pos, boolean white, Board board){
        super(pos, white, board);
    }
    /* (non-Javadoc)
     * @see ChessPiece#validate(int[])
     */
    public boolean validate(int[] toPos){
        if (Math.abs(toPos[0] - toPos[0]) == 2 && Math.abs(toPos[1] - toPos[1]) == 1){
            return true;
        }
        if (Math.abs(toPos[0] - toPos[0]) == 1 && Math.abs(toPos[1] - toPos[1]) == 2){
            return true;
        }
        return false;
    }
        
}