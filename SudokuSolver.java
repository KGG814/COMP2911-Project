
public class SudokuSolver {
	int[][] solutionArray;
	
	SudokuSolver(SudokuBoard board) {
		for( int col = 0; col < 9; col++ ) {
		   for( int row = 0; row < 9; row++ ) {
			   solutionArray[col][row] = board.getNumber(col, row);
		   }
	   }
	}
	
	public int[][] getSolution () {
		return solutionArray;
	}
	
	public void runSolve ()  {
		try {
			solve(0,0);
		} catch (Exception e) {
	   
		}
	}
	
	private void solve (int col, int row) throws Exception {
		if (row>8) {
			throw new Exception("Solution succesful");
		}
		if (solutionArray[col][row] != 0) {
			next(row,col);
		} else {
			for( int num = 1; num < 10; num++) {
				if(checkRow(row,num)&&checkCol(col,num)&&checkBox(col,row,num)) {
					solutionArray[col][row] = num;
					next(row,col);
				}
			}
			solutionArray[col][row] = 0;
		}
	}
 
	 public void next (int col, int row) throws Exception {
		   if (col<8) {
			   solve(col+1,row);
		   } else {
			   solve(0,row+1);
		   }
	 }
	
	private boolean checkRow( int row, int num ) {
		for( int i = 0; i < 9; i++ ) {
			if( solutionArray[i][row] == num ) {
				return false;
			}
		}
		return true;
	}
	
	private boolean checkCol( int col, int num ) {
		for( int i = 0; i < 9; i++ ) {
			if( solutionArray[col][i] == num ) {
				return false;
			}
		}
		return true;
	}
	
	private boolean checkBox( int col, int row, int num ) {
		row = (row / 3) * 3 ;
		col = (col / 3) * 3 ;
		for( int r = 0; r < 3; r++ ) {
			for( int c = 0; c < 3; c++ ) {
				if( solutionArray[col+c][row+r] == num ) {
					return false;
				}
			}
		}
		return true ;
	}
}
