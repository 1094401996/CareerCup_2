package seventeenthdot02;

public class TicTacToe {
	
	
	//0 for empty, 1 for red, 2 for blue
	
	public static int haswined(int[][] board){
		
		//check rows
		for(int i = 0; i < board.length;i++){
			if(board[i][0] !=0 && 
			  board[i][0] == board[i][1]&&
			  board[i][1] == board[i][2]
			){
				return board[i][0];
			}
				
		}
		
		//check the columns
		
		for(int i = 0; i < board[0].length;i++){
			if(board[0][i] !=0 && 
			  board[0][i] == board[1][i]&&
			  board[1][i] == board[2][i] 
			  ){
				return board[0][i];
			}
		}
		
		//check diagonal
		
		
		if(board[0][0] != 0 && board[0][0] ==  board[1][1] &&board[1][1] ==  board[2][2]){
			return board[0][0];
		}
		
		//check the reverse diagonal
		if(board[0][2] != 0 && board[0][2] == board[1][1] && board[1][1] == board[2][0]){
			return board[0][2];
		}
		
		return 0;
	}
}

