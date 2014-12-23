package puzzle;
import puzzle.SolvedPuzzle;
import puzzle.IOWriter;

public class PuzzleSolver {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String inputPath = args[0];
	    //String outputPath = args[1];
//		Puzzle puzzle=new Puzzle("inputWWW.txt");
		SolvedPuzzle unsolved=new SolvedPuzzle("inputWWW.txt");
		unsolved.solve();
		for(int i=0;i<unsolved.getPuzzle().getRows();++i){
			unsolved.new RemainingPuzzle(i).start();
		}
		IOWriter writer=new IOWriter();
		writer.print(unsolved, unsolved.getPuzzle() , "output-file.txt");
	}
}
