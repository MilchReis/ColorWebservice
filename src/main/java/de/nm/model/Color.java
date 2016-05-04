package de.nm.model;

import de.nm.utils.ColorUtils;

public class Color {

	private int red, green, blue;
	private String hex;
	private String name;
	
	public Color(int r, int g, int b) {
		if(r < 0 || r > 255)	throw new IllegalArgumentException("r out of range [0, 255]");
		if(g < 0 || g > 255)	throw new IllegalArgumentException("r out of range [0, 255]");
		if(b < 0 || b > 255)	throw new IllegalArgumentException("r out of range [0, 255]");
		
		red = r;
		green = g;
		blue = b;
		rgb2hex();
		setName(new ColorUtils().getColorNameFromRgb(red, green, blue));
	}
	
	public Color(String hex) {
		this.hex = hex;
		hex2rgb();
		setName(new ColorUtils().getColorNameFromRgb(red, green, blue));
	}

	public void hex2rgb() {
		red = Integer.valueOf(hex.substring(0, 2), 16);
		green = Integer.valueOf(hex.substring(2, 4), 16);
		blue = Integer.valueOf(hex.substring(4, 6), 16);
	}
	
	public void rgb2hex() {
		hex = String.format("%02x%02x%02x", red, green, blue);
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}

	public String getHex() {
		return hex;
	}

	public void setHex(String hex) {
		this.hex = hex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
