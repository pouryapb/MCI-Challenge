import java.io.File;
import java.util.Scanner;

public class MarkdownSimpler {

    final File f;
    public MarkdownSimpler(File f) throws Exception {
        this.f = f;
    }

    public String seperate() throws Exception {
    	String result = "";
    	Scanner sc = new Scanner(f);
    	while (sc.hasNextLine()) {
    		String data = sc.nextLine();
    		result += data.replaceAll("(### |\\+ |\\*|\\!\\[|\\[|\\]\\(https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,4}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)\\)|`(.*)`)", "") + "\n";
    	}
    	sc.close();
    	
    	return result;
    }
}
