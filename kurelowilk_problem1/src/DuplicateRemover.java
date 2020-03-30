import java.io.*;
import java.util.*;

//Create a class called DuplicateRemover. Create an instance method called remove that takes a single parameter
//called dataFile of type String (representing the path to a text file) and uses a Set of Strings to eliminate 
//duplicate words from the file referenced by dataFile. The unique words should be stored in an instance variable 
//called uniqueWords. Create an instance method called write that takes a single parameter called outputFile 
//(representing the path to a text file) and writes the words contained in uniqueWords to the file pointed to by 
//outputFile. The output file should be overwritten if it already exists, and created if it does not exist.

public class DuplicateRemover {
	
	private Set<String> stringHashSet = new HashSet<String>();
	
	public void remove(String dataFile) { //dataFile -> path to the file
		
	    File file = new File(dataFile); 
	    try {
	    	
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()){
			  String line = scanner.nextLine();
			  String[] allWordsInTheLine = line.split(" ");
			  //For each word in allWordsInTheLine check if it's already in the arrayList then add or not
			  for(String eachWord: allWordsInTheLine) {
				  stringHashSet.add(eachWord.toLowerCase());
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
			for(String eachString:stringHashSet) {
				out.write(eachString+" ");
			}
			out.close();
		} catch (IOException e) {
			System.out.println("error on writing to file.");			
		}
	
	}


}
