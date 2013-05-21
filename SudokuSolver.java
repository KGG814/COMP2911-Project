import java.util.LinkedList;


public class SudokuSolver {
	int[][] solutionArray;
	int runCount;
	Exception fail;
	
	SudokuSolver(SudokuBoard board) {
		fail = new Exception("Solution not found");
		runCount = 0;
		solutionArray = new int[9][9];
		for( int col = 0; col < 9; col++ ) {
		   for( int row = 0; row < 9; row++ ) {
			   solutionArray[col][row] = board.getNumber(col, row);
		   }
	   }
	}
	
	public SudokuBoard getSolution () {
		int[][] array = new int[9][9];
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				array[i][j]=solutionArray[i][j];
			}
		}
		return new SudokuBoard (array);
	}
	
	public boolean runSolve ()  {
		if (!boardIsValid()) {
			return false;
		}
		try {
			solve(0,0);
		} catch (Exception e) {
			if (e.equals(fail)) {
				return false;
			}
		}
		return true;
	}
	
	private void solve (int col, int row) throws Exception {
		runCount++;
		if (runCount>1000) {
			System.out.println("Solution not found");
			throw fail;
		}
		if (row>8) {
			System.out.println("Solved");
			throw new Exception("Solution succesful");
		}
		if (solutionArray[col][row] != 0) {
			next(col,row);
		} else {
			for( int num = 1; num < 10; num++) {
				if(checkRow(row,num)&&checkCol(col,num)&&checkBox(col,row,num)) {
					solutionArray[col][row] = num;
					next(col,row);
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
	
	 private boolean boardIsValid () {
		 LinkedList<Integer> numList = new LinkedList<Integer>();
		 int num;
		 for (int col=0;col<9;col++) {
			 numList.clear();
			 for (int row = 0; row<9; row++) {
				 num = solutionArray[col][row];
				 if(!numList.contains(num)) {
					 if (num!=0) {
						 numList.add(solutionArray[col][row]); 
					 }	
				 } else {
					 return false;
				 }
			 }
		 }
		 numList.clear();
		 for (int row=0;row<9;row++) {
			 numList.clear();
			 for (int col = 0; col<9; col++) {
				 num = solutionArray[col][row];
				 if(!numList.contains(num)) {
					 if (num!=0) {
						 numList.add(solutionArray[col][row]); 
					 }	
				 } else {
					 return false;
				 }
			 }
		 }
		 numList.clear();
		 for (int r = 0; r<3;r++) {
			 for (int c = 0; c<3; c++){
				 numList.clear();
				 for (int row = 0; row <3; row++) {
					 for (int col = 0; col<3; col++) {
						 num = solutionArray[3*c+col][3*r+row];
						 if(!numList.contains(num)) {
							 if (num!=0) {
								 numList.add(num); 
							 }	
						 } else {
							 return false;
						 }
						 
					 }
				 }
			 }
		 }
		 return true;
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
