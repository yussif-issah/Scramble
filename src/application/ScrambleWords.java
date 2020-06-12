package application;

import java.util.Date;

public class ScrambleWords {
	static char[] Letters = {' ',' ',' ',' ',' '};
	public static char[] scramble1(String word) {
   IntoChars(word);
	Date date=new Date();
	int time=1+date.getSeconds()%3;
	switch(time) {
	case 1:
		algorithmOne(word);
		break;
	case 2:
		algorithmTwo(word);
		break;
	case 3:
		algorithmThree(word);
		break;
		default:
			break;
	}

 return Letters;
		
	}
	
	public static char[] IntoChars(String word) {
		for(int i=0;i<word.length();i++) {
			Letters[i]=word.charAt(i);
		}
		return Letters;
		
	}

	private static void algorithmThree(String word) {
		if(word.length()==3) {
			char mid=Letters[1];
			Letters[1]=Letters[2];
			Letters[2]=mid;
			
		 }else if(word.length()==4) {
			 char mid=Letters[3];
				Letters[3]=Letters[0];
				Letters[0]=mid;
				char Smid=Letters[1];
				Letters[1]=Letters[2];
				Letters[2]=Smid;
				
			 
		 }else if(word.length()==5) {
			 char mid=Letters[4];
				Letters[4]=Letters[0];
				Letters[0]=mid;
				char Smid=Letters[2];
				Letters[2]=Letters[3];
				Letters[3]=Smid;
		 }
	}
	
	private static void algorithmTwo(String word) {
		if(word.length()==3) {
			char mid=Letters[2];
			Letters[2]=Letters[0];
			Letters[0]=mid;
			
		 }else if(word.length()==4) {
			 char mid=Letters[3];
				Letters[3]=Letters[0];
				Letters[0]=mid;
				char Smid=Letters[2];
				Letters[2]=Letters[1];
				Letters[1]=Smid;
				
			 
		 }else if(word.length()==5) {
			 char mid=Letters[4];
				Letters[4]=Letters[0];
				Letters[0]=mid;
				char Smid=Letters[1];
				Letters[1]=Letters[3];
				Letters[3]=Smid;
		 }
		
		
	}

	private static void algorithmOne(String word) {
		if(word.length()==3) {
			char mid=Letters[1];
			Letters[1]=Letters[0];
			Letters[0]=mid;
			
		 }else if(word.length()==4) {
			 char mid=Letters[1];
				Letters[1]=Letters[0];
				Letters[0]=mid;
				char Smid=Letters[2];
				Letters[2]=Letters[3];
				Letters[3]=Smid;
				
			 
		 }else if(word.length()==5) {
			 char mid=Letters[4];
				Letters[4]=Letters[0];
				Letters[0]=mid;
				char Smid=Letters[1];
				Letters[1]=Letters[2];
				Letters[2]=Smid;
		 }
		
	}

}

