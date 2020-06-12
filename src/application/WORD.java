package application;

public class WORD {
 private String word;
 private String hint;
 private int level;
 private int id;
 
public WORD(String word, String hint, int level, int id) {
	super();
	this.word = word;
	this.hint = hint;
	this.level = level;
	this.id = id;
}
public String getWord() {
	return word;
}
public void setWord(String word) {
	this.word = word;
}
public String getHint() {
	return hint;
}
public void setHint(String hint) {
	this.hint = hint;
}
public int getLevel() {
	return level;
}
public void setLevel(int level) {
	this.level = level;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
 
}
