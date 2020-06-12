package application;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class LevelThreeProcessAnswers {
	private static int hint=0;
	public static int QuestionNumber=0;
	public static ArrayList<WORD> levelThreeWords;
	public static void FirstQuestion() throws FileNotFoundException {
		DataBaseHelper.getAllLevelThreeQuestion();
		levelThreeWords=DataBaseHelper.LevelThreeQuestions;
		LevelThreeController.ScrambleLettersOnBoxes(levelThreeWords.get(0).getWord());
	}
	public static void GotoNextQuestion() {
		if(QuestionNumber==levelThreeWords.size()-1) {
			Alert alert=new Alert();
			alert.AlertCompletedLevel();
		}else {
			QuestionNumber+=1;
			LevelThreeController.ScrambleLettersOnBoxes(levelThreeWords.get(QuestionNumber).getWord());
		}
	}
	private static void congrats() {
		// TODO Auto-generated method stub
		
	}
	public static String getCurrentWord() {
		return levelThreeWords.get(QuestionNumber).getWord().toString();
	}
	public static String getHint() {
		// TODO Auto-generated method stub
		if(hint==5) {
			return " HINT OPPORTUNITIES EXHUATED";
		}else {
			hint++;
			return levelThreeWords.get(QuestionNumber).getHint().toString();
		}
	}
	
	

}
