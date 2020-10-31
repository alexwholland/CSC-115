public class Maze {
	
	private char[][] mazeData;
	private MazeLocation start;
	private MazeLocation finish;

	public Maze(char[][] textMaze, MazeLocation start, MazeLocation finish) {
		mazeData = textMaze;
		this.start = start;
		this.finish = finish;
	}
	
	public MazeLocation getStart() {
		return start;
	}
	
	public MazeLocation getFinish() {
		return finish;
	}
	
	public char getChar(int row, int col) {
		return mazeData[row][col];
	}
	
	public void setChar(int row, int col, char val) {
		mazeData[row][col] = val;
	}
	
	public int getSize() {
		if (mazeData.length > 0) {
			return mazeData.length * mazeData[0].length;
		}
		return 0;
	}
	
	public int getRows() {
		return mazeData.length;
	}
	
	public int getCols() {
		if (mazeData.length > 0) {
			return mazeData[0].length;
		}
		return 0;
	}
	
	public String toString() {
		String details = " ";
		for (int i = 0; i < mazeData[0].length; i++) {
			details += i%10;	
		}
		details += "\n";
		for (int i = 0; i < mazeData.length; i++) {
			details += i%10;
			for (int j = 0; j < mazeData[i].length; j++) {
					details += mazeData[i][j];	
			}
			details +="\n";
		}
		return details;
	}
}