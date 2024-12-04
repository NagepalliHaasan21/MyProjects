		package trailing0;
		
		import java.util.Scanner;
		
		public class trail {
		
			public static void main(String[] args) {
				Scanner sc=new Scanner(System.in);
				int n=sc.nextInt();
				int res=0;
				int powerof5=5;
				while(n>=powerof5) {
					res=res+(n/powerof5);
					powerof5=powerof5*5;
				}
					System.out.println(res);
		
		
			}
		
		}
