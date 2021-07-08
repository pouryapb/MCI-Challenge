import java.util.ArrayList;
import java.util.Scanner;

public class Contact {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();

		boolean t = false;
		while (sc.hasNextLine()) {
			list.add(new ArrayList<String>());
			if (!t) {
				t = true;
				list.get(list.size() - 1).add(sc.nextLine());
				continue;
			}
			String contact = sc.nextLine();
			String[] sep = contact.split(" ");
			
			k:
			for (ArrayList<String> l : list) {
				for (String s : l) {
					for (int i = 0; i < 2; i++) {
						if (s.matches(sep[i])) {
							l.add(contact);
							break k;
						}
					}
				}
			}

		}
		sc.close();
		
		//complete bull shit
		System.out.println(list.size() + "\n");

	}
}
