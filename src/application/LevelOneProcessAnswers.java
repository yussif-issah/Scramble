package application;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LevelOneProcessAnswers {
	private static int hint=0;
	public static int QuestionNumber=0;
	public static ArrayList<WORD> levelOneWords;
	public static void FirstQuestion() throws FileNotFoundException {
		DataBaseHelper.getAllLevelOneQuestion();
		levelOneWords=DataBaseHelper.LevelOneQuestions;
		LevelOneController.ScrambleLettersOnBoxes(levelOneWords.get(0).getWord().toString());
	}
	public static void GotoNextQuestion() {
		if(QuestionNumber==levelOneWords.size()-1) {
			Alert alert=new Alert();
			alert.AlertCompletedLevel();
		}else {
			QuestionNumber+=1;
			LevelOneController.ScrambleLettersOnBoxes(levelOneWords.get(QuestionNumber).getWord().toString());
		}
	}
	public static String getCurrentWord() {
		return levelOneWords.get(QuestionNumber).getWord().toString();
	}
	public static String getHint() {
		if(hint==5) {
			return " HINT OPPORTUNITIES EXHUATED";
		}else {
			hint+=1;
			return levelOneWords.get(QuestionNumber).getHint().toString();
		}
		
	}
}
