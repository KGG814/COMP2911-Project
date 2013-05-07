
import java.awt.GridLayout;

import javax.swing.JPanel;


public class SudokuBoard extends JPanel {
		
   /**
	* For some reason I have to put an ID
	*/
	private static final long serialVersionUID = 1L;
	
	Cell[][] boardArray;
	int[][] solutionArray;
	
	public SudokuBoard() {
		//Set Board Properties
		setLayout(new GridLayout(9, 9, 1, 1));
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++) {
				boardArray[i][j] = new Cell();
				add(boardArray[i][j]);				
	 		}
		}
		solutionArray = new int[9][9];
	}
	void setNumber (int x, int y, int number) {
		boardArray[x][y].setNumber(number);
	}

	int getNumber (int x, int y) {
		return boardArray[x][y].getNumber();
	}
	
	public boolean checkRow( int row, int num ) {
	      for( int i = 0; i < 9; i++ ) {
	         if( solutionArray[i][row] == num ) {
	            return false;
	         }
	      }
	      return true;
	}
	
	public boolean checkCol( int col, int num ) {
	      for( int i = 0; i < 9; i++ ) {
	         if( solutionArray[col][i] == num ) {
	            return false;
	         }
	      }
	      return true;
	}
	
   protected boolean checkBox( int col, int row, int num ) {
      row = (row / 3) * 3 ;
      col = (col / 3) * 3 ;

      for( int r = 0; r < 3; r++ ) {
         for( int c = 0; c < 3; c++ ) {
	         if( solutionArray[col+c][row+r] == num ) {
	            return false ;
	         }
         }
      }   

      return true ;
   }
   
   public void runSolve ()  {
	   for( int col = 0; col < 3; col++ ) {
		   for( int row = 0; row < 3; row++ ) {
			   solutionArray[col][row] = boardArray[col][row].getNumber();
		   }
	   }
	   try {
		   solve(0,0);
	   } catch (Exception e) {
		   
	   }
	
   }
   
   public void solve (int col, int row) throws Exception {
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

}
