package practice;

import java.util.regex.Pattern;

public class StringLinereverse {
	static String reverse(String s1){
		 Pattern pattern = Pattern.compile("\\s"); 
		 String[] temp= pattern.split(s1);
		 String result = "";
		 for(int i=0;i<temp.length;i++){
			 if(i==temp.length-1){
				 result=temp[i]+result;
			 }
			 else{
				 result=" "+temp[i]+result;
			 }
			 
		 }
		return result;
		
		
		
		
		
	}
	public static void main(String[] args) {
		
		System.out.println(reverse("vinay kumar"));
	}

}
