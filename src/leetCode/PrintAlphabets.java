package leetCode;

public class PrintAlphabets {

	public static void main(String[] args) {
//		for(int i = 0; i < 26; i++) {
//			for(int j = 0 ; j <= i; j++)
//			{
//				System.out.print( (char)(j + 'a'));
//				System.out.print(" ");
//			}
//			System.out.println();
//
//		}
//		
		
		for(int i = 0; i < 26; i++) 
		{
			for(int j = 0; j < 26 - (i + 1) ; j++) {
				System.out.print(" ");
			}
			
			
			for(int j = 0 ; j <= i; j++)
			{
				System.out.print( (char)(j + 'a'));
				System.out.print(" ");
			}
			System.out.println();

		}

	}

}
