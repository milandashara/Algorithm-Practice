import java.util.Scanner;


public class StandingOvation {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int testCase=scanner.nextInt();
		
		for(int i=0;i<testCase;i++){
			//String line=scanner.nextLine();
			//Scanner lineScanner=new Scanner(line);
			int maxShynessLevel=scanner.nextInt();
			//int standing=0;
			int required=0;
			
			String s=scanner.next();
			char[] c=s.toCharArray();
			char zero='0';
			//standing=c[0];
			for(int j=0;j<c.length;j++){
				if(c[j]==zero){
					required++;
				}
			}
			System.out.println("Case #"+(i+1)+":"+ required);
		}
	}
}
