public class Board {
    /**
     * to store information of each square on the board
     */
    ChessPiece[][] board = new ChessPiece[8][8];
    
    Board() {
        setup();
    }
    
    /**
     * to setup initial steps and place pieces
     */
    public void setup(){
        for(int j=0; j<8; j++){
            Pawn whitePawn = new Pawn(new int[]{1,j}, false, this);
            board[1][j] = whitePawn;
            Pawn blackPawn = new Pawn(new int[]{6,j}, true, this);
            board[6][j] = blackPawn;
        }
        board[0][0] = new Rook(new int[]{0,0}, false, this);
        board[0][7] = new Rook(new int[]{0,7}, false, this);
        board[7][0] = new Rook(new int[]{7,0}, true, this);
        board[7][7] = new Rook(new int[]{7,7}, true, this);
        board[0][1] = new Knight(new int[]{0,1}, false, this);
        board[0][6] = new Knight(new int[]{0,6}, false, this);
        board[7][1] = new Knight(new int[]{7,1}, true, this);
        board[7][6] = new Knight(new int[]{7,6}, true, this);
        board[0][2] = new Bishop(new int[]{0,2}, false, this);
        board[0][5] = new Bishop(new int[]{0,5}, false, this);
        board[7][2] = new Bishop(new int[]{7,2}, true, this);
        board[7][5] = new Bishop(new int[]{7,5}, true, this);
        board[0][3] = new Queen(new int[]{0,3}, false, this);
        board[7][3] = new Queen(new int[]{7,3}, true, this);
        board[0][4] = new King(new int[]{0,4}, false, this);
        board[7][4] = new King(new int[]{7,4}, true, this);
    }
    
    /**
     * returns the piece in the location
     * @param move
     * @return
     */
    public ChessPiece getPiece(int[] move) {
        return board[move[0]][move[1]];
    }

    /**
     * display the board
     */
    public void display() {
        for (int x = 0; x < 8; x++){
			for (int y = 0; y < 8; y++){
                ChessPiece piece = board[x][y];
                if (piece== null)
					System.out.print("|...|");
				else{
					String colour = piece.white?"|W:":"|B:";
				    if (piece instanceof Pawn)
						System.out.print(colour+"p|");
					else if (piece instanceof Knight)
						System.out.print(colour+"k|");
					else if (piece instanceof Queen)
						System.out.print(colour+"q|");
					else if (piece instanceof King)
						System.out.print(colour+"K|");
					else if (piece instanceof Rook)
						System.out.print(colour+"r|");
					else if (piece instanceof Bishop)
						System.out.print(colour+"b|");
					else
						System.out.print("x");
				}
			}
			System.out.println();
		}
        System.out.println("-------------------");
    }

    /**
     * move the piece on the board after every valid move
     * @param piece
     * @param move
     */
    public void move(ChessPiece piece, int[] move) {
        board[move[0]][move[1]] = null;
        board[move[2]][move[3]] = piece;
    }
}
