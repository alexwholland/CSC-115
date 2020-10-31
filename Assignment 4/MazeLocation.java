/*
 * MazeLocation.java
 *
 * Created for CSC 115 Assignment 4
 * Do not modify!
 */
public class MazeLocation {
    int row;
    int col;

    public MazeLocation(int row, int col) {
        this.row = row;
        this.col = col;
    }
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}

    public String toString() {
        return "(" + this.row + ", " + this.col + ")";
    }

    public boolean equals(MazeLocation loc) {
        return (this.row == loc.row && this.col == loc.col);
    }
}