package homework;

import java.io.Serializable;

public class UserPreferences implements Serializable {
	
	private String color;
	private String fontName;
	private int fontSize;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getFontName() {
		return fontName;
	}
	public void setFontName(String fontName) {
		this.fontName = fontName;
	}
	public int getFontSize() {
		return fontSize;
	}
	public void setFontSize(Integer integer) {
		this.fontSize = integer;
	}

}
