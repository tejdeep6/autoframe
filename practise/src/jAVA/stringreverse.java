package jAVA;

public class stringreverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String test="abcd";
		int ab =test.length();
		String reverse="";
		int i;
		for(i= ab-1;i>=0; i--)
		{
			reverse=reverse+ test.charAt(i);
			
		}
		
		 System.out.println(reverse); 
		
				
	}

}
