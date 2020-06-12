package application;

public class ProcessPoints {
	static int points=0;
	public static void IncreasePoints() {
		points+=3;
		if(points<10) {
		Components.scorepoints.setText("0"+points+"");
	}else {
		Components.scorepoints.setText(points+"");
	}
	}
}
