package puzzle;

import puzzle.Puzzle;
import puzzle.SolvedPuzzle;
import puzzle.IOWriter;

public class PuzzleSolver {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String inputPath = args[0];
	    //String outputPath = args[1];
		Puzzle puzzle=new Puzzle("YO2.txt");
		SolvedPuzzle unsolved=new SolvedPuzzle(puzzle);
		unsolved.solve(puzzle);
		IOWriter writer=new IOWriter();
		writer.print(unsolved, puzzle, "output-file.txt");
	}
}
