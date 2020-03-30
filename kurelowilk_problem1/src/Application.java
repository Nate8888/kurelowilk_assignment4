
public class Application {

	public static void main(String[] args) {
		DuplicateRemover first = new DuplicateRemover();
		first.remove("problem1.txt");
		first.write("unique_words.txt");
	}

}
