import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class SudokuBoard {
		
	int[][] boardArray;
	
	public SudokuBoard() {
		boardArray = new int[9][9];
	}
	
	public SudokuBoard(int[][] boardArray) {
		this.boardArray = boardArray;
	}
	void setNumber (int col, int row, int number) {
		boardArray[col][row] = number;
	}

	int getNumber (int col, int row) {
		return boardArray[col][row];
	}
	
	boolean isLegalRow (int row, int num) {
		for (int col = 0; col<9; col++){
			if (boardArray[col][row]==num){
				return false;
			}
		}
		return true;		
	}

	boolean isLegalCol (int col, int num) {
		for (int row = 0; row<9; row++){
			if (boardArray[col][row]==num){
				return false;
			}
		}
		return true;
		
	}
	
	boolean isLegalBox (int row, int col, int num) {
		row = (row / 3) * 3 ;
		col = (col / 3) * 3 ;
		for( int r = 0; r < 3; r++ ) {
			for( int c = 0; c < 3; c++ ) {
				if( boardArray[col+c][row+r] == num ) {
					return false;
				}
			}
		}
		return true;
	}
	
	boolean numberIsLegal (int row, int col, int num) {
		if (isLegalRow(row,num)&&isLegalCol(col,num)&&isLegalBox(row,col,num)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void printBoard() {
		for (int row=8; row>=0;row--){
			for (int col=0; col<9;col++){
				System.out.print(boardArray[col][row]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}
	
	public void saveState() throws IOException {
		File save = new File("save.txt");
		FileWriter writer = new FileWriter(save,false);
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				Integer currentNum = new Integer(boardArray[col][row]);
				String output = currentNum.toString();
				writer.write(output);
				writer.write(" ");
			}
			writer.write("\n");
		}
		writer.close();
	}
}
