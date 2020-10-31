/*
Alex Holland - V00928553
CSC 115 - Assignment 4
 */

public class MazeRunner {
	Maze mazeToSolve;
	A4Stack<MazeLocation> path;
	FilePrinter fileWriter;
	//int countMoves;

	public MazeRunner(Maze aMaze) {
		mazeToSolve = aMaze;
		path = new A4Stack<MazeLocation>();
		fileWriter = new FilePrinter();
		//countMoves = 0;
	}

	/*
	 * Purpose: Determines whether there is a path from start to finish in this maze
	 * Parameters: MazeLocation start - starting coordinates of this maze
	 *			   MazeLocation finish - finish coordinates of this maze
	 * Returns: true if there is a path from start to finish
	 */
	public boolean solve(MazeLocation start, MazeLocation finish) {
		fileWriter.println("Searching maze from start: "+start+" to finish: "+finish);
		path.push(start);
		return findPath(start, finish);
	}

	/*
	 * Purpose: Recursively determines if there is a path from cur to finish
	 * Parameters: MazeLocation cur - current cordinates in this maze
	 *			   MazeLocation finish - goal coordinates of this maze
	 * Returns: true if there is a path from cur to finish
	 *
	 * NOTE: This method updates the Maze's mazeData array when locations
	 *       are visited to an 'o', and further updates locations to an 'x'
	 *       if it is determined they lead to dead ends. If the finish
	 *       location is found, the Stack named path should contain all of
	 *       locations visited from the start location to the finish.
	 */
	private boolean findPath(MazeLocation cur, MazeLocation finish) {
		int row = cur.row;
		int col = cur.col;

		mazeToSolve.setChar(row, col, 'o');
		System.out.println("\n" + mazeToSolve.toString());

		//Counts the numbers of moves needed to solve the maze;
		//countMoves++;

		// Check victory condition
		if (path.top().equals(finish)) {
			System.out.println("\n*** Maze Solved ***");
			printResults(true);
			//System.out.println("Number of moves: " + countMoves);
			return true;
		}

		// Check if space below
			if (row + 1 != mazeToSolve.getRows() && mazeToSolve.getChar(row + 1, col) == ' ') {
				System.out.println("Found a path DOWN, pushing position (" + (row + 1) + ", " + col + ") onto stack");
				MazeLocation nextP = new MazeLocation(row + 1, col);
				path.push(nextP);
				return findPath(nextP, finish);
			}
		// Check if space above
			if (row > 0 && mazeToSolve.getChar(row - 1, col) == ' ') {
				System.out.println("Found a path UP, pushing position (" + (row - 1) + ", " + col + ") onto stack");
				MazeLocation nextP = new MazeLocation(row - 1, col);
				path.push(nextP);
				return findPath(nextP, finish);
			}
		// Check if space left
			if (col > 0 && mazeToSolve.getChar(row, col - 1) == ' ') {
				System.out.println("Found a path LEFT, pushing position (" + row + ", " + (col - 1) + ") onto stack");
				MazeLocation nextP = new MazeLocation(row, col - 1);
				path.push(nextP);
				return findPath(nextP, finish);
			}
		// Check if space right
			if (col + 1 != mazeToSolve.getCols() && mazeToSolve.getChar(row, col + 1) == ' ') {
				System.out.println("Found a path RIGHT, pushing position (" + row + ", " + (col + 1) + ") onto stack");
				MazeLocation nextP = new MazeLocation(row, col + 1);
				path.push(nextP);
				return findPath(nextP, finish);
			}

		// If in a dead end we need to backtrack to the previous position
		System.out.println("No path found, need to backtrack. Popping: " + path.top());
		mazeToSolve.setChar(row, col, 'x');
		path.pop();
		// Check failure condition
		if (path.isEmpty()) {
			System.out.println("\n--- No path to solution found ---");
			printResults(false);
			return false;
		}
		return findPath(path.top(), finish);
	}


	/*
	 * Purpose: Creates a string of maze locations found in the stack
	 * Parameters: None
	 * Returns: A String representation of maze locations
	 */
	public String getPathToSolution() {
		String details = "";
		while(!path.isEmpty()) {
			details = path.pop() + "\n" + details;
		}
		return details;
	}

	/*
	 * Purpose: Print the results of the maze run. Outputs the locations
	 *          visited on the path from start to finish if the maze is
	 *          solvable, or that no path was found if it is not.
	 * Parameters: boolean - whether or not the maze was solved
	 * Returns void - nothing
	 */
	public void printResults(boolean solved) {
		if (solved) {
			fileWriter.println("\n*** Maze Solved ***");
			fileWriter.println(getPathToSolution());
		} else {
			fileWriter.println("\n--- No path to solution found ---");
		}
		fileWriter.close();
	}
}