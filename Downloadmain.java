import java.util.Scanner;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class Downloadmain{
	static URL url;
	
	public static void main( String[] args){
		
		Scanner console = new Scanner(System.in);
		
		String urlString;
		String targetFilename;

		do {

			// This checks the url to get the download from
			// A try and catch statement are partnered together to prevent crashing of the program
			// when an error is presented.
			try {
				
				System.out.println("URL to download? "); //ASK URL
				urlString = console.nextLine(); //INPUT URL
				URL u = new URL(urlString);
				
					System.out.println("Target file name: "); //ASK FILENAME
					targetFilename = console.nextLine(); //INPUT FILENAME
					File fileName = new File(targetFilename);
					fileName.getPath();
			} catch (MalformedURLException e){
				System.out.println("Bad URL! Try again: ");	//THROWS MALFORMED URL EXCEPTION
				e.printStackTrace();
			}
			
			// try {
			// 	System.out.println("Target file name: "); //ASK FILENAME
			// 	targetFilename = console.nextLine(); //INPUT FILENAME
			// 	File fileName = new File(targetFilename);
			// 	fileName.getPath();
			// } catch (IOException e) {
			// 	System.out.println(" I/O error: " + e.getMessage()); //THROWS IO EXCEPTION
			// 	e.printStackTrace();
			// }
		} while (url == null);
			console.close();
		}

		public static void saveFileFromUrlWithCommonsIO(String targetFilename,
		String urlString) throws MalformedURLException, IOException {
		FileUtils.copyURLToFile(new URL(urlString), new File(targetFilename));
	}
}