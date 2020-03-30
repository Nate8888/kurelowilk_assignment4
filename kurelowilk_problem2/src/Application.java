
public class Application {

	public static void main(String[] args) {
		DuplicateCounter first = new DuplicateCounter();
		first.count("problem2.txt");
		first.write("unique_word_counts.txt");
	}

}
