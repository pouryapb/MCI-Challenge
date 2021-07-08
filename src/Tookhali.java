import java.util.Scanner;

public class Tookhali {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		
		// first line
		for (int i = 0; i < num + 2; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		int begin = (num + 2) / 2, end = (num + 2) / 2;
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num + 2; j++) {
				if (j >= begin && j <= end)
					System.out.print(" ");
				else
					System.out.print("*");
			}
			if (i < num / 2) {
				begin--;
				end++;
			}
			else {
				begin++;
				end--;
			}
			System.out.println();
		}
		
		// last line
		for (int i = 0; i < num + 2; i++) {
			System.out.print("*");
		}
	}
}
