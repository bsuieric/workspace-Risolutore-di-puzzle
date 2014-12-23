package puzzle;
import java.lang.Thread;
import java.util.ArrayList;

public class SolvedPuzzle extends Thread implements SolverAlgorithm {
	private Puzzle puzzle;
	private ArrayList<Tile> copiedPuzzle=new ArrayList<Tile>();
	private int count=0;
	
	
	public SolvedPuzzle(String inputPath){
		puzzle=new Puzzle(inputPath);
		copyArrayList();
	}
	
	public void solve(){
		solveFirstCol();
//		solveRemainingTile();
		for(int i=0; i<puzzle.getRows();++i)
			new SolvedPuzzle().start();
	}
	
	private void copyArrayList(){
		for(int i=0;i<puzzle.getTileList().size();++i){
			copiedPuzzle.add(puzzle.getTileList().get(i));
		}
	}
	
	private void solveFirstCol(){
		String aux="VUOTO";
		for(int i=0; i<puzzle.getRows();++i){
			boolean ok=true;
			for(int z=0; z< copiedPuzzle.size() && ok ; ++z){
				if(copiedPuzzle.get(z).get_id_nord().equals(aux) && copiedPuzzle.get(z).get_id_ovest().equals("VUOTO")){
						puzzle.setTile(i, 0, copiedPuzzle.get(z));
						aux=copiedPuzzle.get(z).get_id_pezzo();
						ok= false;
				}
			}
		}
	}
	
//	private void solveRemainingTile(){
//		for(int i=0;i<puzzle.getRows(); ++i){
//			for(int j=1; j<puzzle.getCols(); ++j){
//				boolean present=false;
//				for(int z=0; z<copiedPuzzle.size() && !present; ++z){
//					if(copiedPuzzle.get(z).get_id_ovest().equals(puzzle.getTile(i, j-1).get_id_pezzo())){
//						puzzle.setTile(i, j, copiedPuzzle.get(z));
//						present=true;
//					}
//				}
//			}
//		}
//	}
	
	public void run(){
		for(int j=1; j<puzzle.getCols(); ++j){
			boolean present=false;
			for(int z=0; z<copiedPuzzle.size() && !present; ++z){
				if(copiedPuzzle.get(z).get_id_ovest().equals(puzzle.getTile(count, j-1).get_id_pezzo())){
					puzzle.setTile(count, j, copiedPuzzle.get(z));
					present=true;
				}
			}
		}
	}
	
	public ArrayList<Tile> getTileCopiedList(){
		return copiedPuzzle;
	}
	
	public Puzzle getPuzzle(){
		return puzzle;
	}
}
