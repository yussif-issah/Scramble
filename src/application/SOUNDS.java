package application;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SOUNDS {
	static MediaPlayer player;
	public static void playSong() {
		String path="ZAP.mp3";
		Media media = new Media(new File(path).toURI().toString());
		player=new MediaPlayer(media);
		player.setCycleCount(player.INDEFINITE);
		if(player.getStatus().name()=="PLAYING"){
			player.pause();
			
		}else {
			player.play();
		}
	}
public static void PlayDropSound() {
	String path="pop1.mp3";
	Media media = new Media(new File(path).toURI().toString());
	MediaPlayer player=new MediaPlayer(media);
	player.play();
	
}
public static void PlayDragSound() {
	String path="play.mp3";
	Media media = new Media(new File(path).toURI().toString());
	MediaPlayer player=new MediaPlayer(media);
	player.play();
	
}
public static void PlayCorrectSong() {
	String path="coins.mp3";
	Media media = new Media(new File(path).toURI().toString());
	MediaPlayer player=new MediaPlayer(media);
	player.play();
	
}
public static void stopSong() {
	player.stop();
}
}
