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

	boolean isLegalRow (int row, int col, int num) {
		for (int c = 0; c<9; c++){
			if (c != col) {
				if (boardArray[c][row]==num){
					return false;
				}
			}

		}
		return true;		
	}

	boolean isLegalCol (int col, int row, int num) {
		for (int r = 0; r<9; r++){
			if(r != row) {
				if (boardArray[col][r]==num){
					return false;
				}
			}
		}
		return true;

	}

	boolean isLegalBox (int row, int col, int num) {
		int x = (row / 3) * 3 ;
		int y = (col / 3) * 3 ;
		for( int r = 0; r < 3; r++ ) {
			for( int c = 0; c < 3; c++ ) {
				if(r != row && c != col) {
					if( boardArray[y+c][x+r] == num ) {
						return false;
					}
				}

			}
		}
		return true;
	}

	boolean numberIsLegal (int row, int col, int num) {
		//System.out.println(row);
		//System.out.println(col);
		System.out.println(isLegalCol(col, row, num));
		System.out.println(isLegalRow(row, col, num));
		System.out.println(isLegalBox(row, col, num));
		if (isLegalRow(row, col, num)&&isLegalCol(col, row, num)&&isLegalBox(row,col,num)) {
			return true;
		} else if (num == 0) {
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

	public void saveState(int difficulty, boolean[][] editableArray) throws IOException {
		File save = new File("save.txt");
		save.createNewFile();
		FileWriter writer = new FileWriter(save);
		Integer difficultyInteger = (Integer)difficulty;
		writer.write(difficultyInteger.toString());
		writer.write("\n");
		for (int row = 8; row >= 0; row--) {
			for (int col = 0; col < 9; col++) {
				Integer currentNum = new Integer(boardArray[col][row]);
				String output = currentNum.toString();
				writer.write(output);
				writer.write(" ");
			}
			writer.write("\n");
		}
		for (int row = 8; row >= 0; row--) {
			for (int col = 0; col < 9; col++) {
				String output;
				boolean editable = editableArray[col][row];
				if (editable) {
					output = "1";
				} else {
					output = "0";
				}		
				writer.write(output);
				writer.write(" ");
			}
			writer.write("\n");
		}
		writer.close();
	}
}
