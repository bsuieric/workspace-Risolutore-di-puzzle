package puzzle;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class IOWriter {
	  private static void writeContent(String content, String file) {
		  BufferedWriter writer;
		  try {
			 writer = new BufferedWriter(new OutputStreamWriter(
					 new FileOutputStream(file), "utf-8"));
			 writer.write(content);
		     writer.close();
		  } catch (IOException e) {	
			  e.printStackTrace();
		  	}
	  }
	  
	  public void print(SolvedPuzzle sp,Puzzle p, String file){
		  StringBuilder content=new StringBuilder();
		  for(int i=0;i<sp.getTileCopiedList().size();++i){
			  content.append(sp.getTileCopiedList().get(i).get_carattere());
		  }
		  content.append(System.getProperty("line.separator"));
		  for(int i=0; i<p.getRows(); ++i){
			  content.append(System.getProperty("line.separator"));
			  for(int j=0; j<p.getCols(); ++j){
				  content.append(p.getTile(i, j).get_carattere());
			  }
		  }
		  content.append(System.getProperty("line.separator"));
		  content.append(System.getProperty("line.separator"));
		  content.append(p.getRows());
		  content.append("x");
		  content.append(p.getCols());
		  
		  writeContent(content.toString(), file);
	  }
}
