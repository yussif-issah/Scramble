package application;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class LevelTwoProcessAnswers {
	private static int hint=0;
	public static int QuestionNumber=0;
	public static ArrayList<WORD> levelTwoWords;
	public static void FirstQuestion() throws FileNotFoundException {
		DataBaseHelper.getAllLevelTwoQuestion();
		levelTwoWords=DataBaseHelper.LevelTwoQuestions;
		LevelTwoController.ScrambleLettersOnBoxes(levelTwoWords.get(0).getWord().toUpperCase());
	}
	public static void GotoNextQuestion() {
		if(QuestionNumber==levelTwoWords.size()-1) {
			Alert alert=new Alert();
			alert.AlertCompletedLevel();
		}else {
			QuestionNumber+=1;
			LevelTwoController.ScrambleLettersOnBoxes(levelTwoWords.get(QuestionNumber).getWord().toUpperCase());
		}
	}
	private static void congrats() {
		// TODO Auto-generated method stub
		
	}
	public static String getCurrentWord() {
		return levelTwoWords.get(QuestionNumber).getWord();
	}
	public static String getHint() {
		// TODO Auto-generated method stub
		if(hint==5) {
			return " HINT OPPORTUNITIES EXHUATED";
		}else {
			hint++;
			return levelTwoWords.get(QuestionNumber).getHint().toString();
		}
	}
	

}
