public class King extends ChessPiece{
    public King(int[] pos, boolean white, Board board){
        super(pos, white, board);
    }
    /* (non-Javadoc)
     * @see ChessPiece#validate(int[])
     */
    public boolean validate(int[] toPos){
        int[] pos = location();
        if(toPos[0] == pos[0] && (toPos[1] == pos[1] + 1 || toPos[1] == pos[1] - 1)){
            return true;
        }
        if(toPos[1] == pos[1] && (toPos[0] == pos[0] + 1 || toPos[0] == pos[0] - 1)){
            return true;
        }
        return false;
    }
}