package puzzle;
import puzzle.PuzzleToSolve;
import puzzle.IOWriter;

public class PuzzleSolver {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String inputPath = args[0];
	    //String outputPath = args[1];
//		Puzzle puzzle=new Puzzle("inputWWW.txt");
		PuzzleToSolve unsolved=new PuzzleToSolve("sofia.txt");
		unsolved.solve();
		IOWriter writer=new IOWriter();
		writer.print(unsolved, unsolved.getPuzzle() , "output-file.txt");
	}
}
