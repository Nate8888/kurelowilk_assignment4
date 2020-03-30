import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DuplicateCounter {

	private Map<String, Integer> map = new HashMap<String, Integer>();
	
	public void count(String dataFile) {
		
		File file = new File(dataFile); 
	    try {
	    	
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()){
			  String line = scanner.nextLine();
			  String[] allWordsInTheLine = line.split(" ");
			  //For each word in allWordsInTheLine check if it's already in the arrayList then add or not
			  for(String eachWord: allWordsInTheLine) {
				  
				  Integer amountOfEachWordCurrentlyOnTheMap = map.get(eachWord.toLowerCase());
				  
				  if (amountOfEachWordCurrentlyOnTheMap == null) {
					  this.map.put(eachWord.toLowerCase(), 1);
				  }
				  else {
					  this.map.put(eachWord.toLowerCase(), amountOfEachWordCurrentlyOnTheMap + 1);
				  }
			  }	  
			}
			
		}catch (FileNotFoundException e) {
			System.out.println("File doesn't exist. Exiting program.");
			//e.printStackTrace();
		} 
	}
	
	public void write(String outputFile) { //outputFile -> path to the file
		
		BufferedWriter out;
		
		try {
			out = new BufferedWriter(new FileWriter(outputFile));
			
			for(Map.Entry<String,Integer> entry : this.map.entrySet()) {
				out.write(entry.getKey()+":"+entry.getValue()+" ");
			}

			out.close();
			
		} catch (IOException e) {
			System.out.println("error on writing to file.");			
		}
	
	}

}
