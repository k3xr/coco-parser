import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(args[0]);
	    Parser parser = new Parser(scanner);
	    parser.Parse();
	    //TL.imprimeme();
	    System.out.println("Done.");
	}
}