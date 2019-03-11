package com.apexlegendsat.springmvc.view;

public class WeaponView {

	private String name;
	private String imageString;
	private int lowDPS;
	private int highDPS;

	public WeaponView() {

	}

	public WeaponView(String name, String imageString, int lowDPS, int highDPS) {
		super();
		this.name = name;
		this.imageString = imageString;
		this.lowDPS = lowDPS;
		this.highDPS = highDPS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageString() {
		return imageString;
	}

	public void setImageString(String imageString) {
		this.imageString = imageString;
	}

	public int getLowDPS() {
		return lowDPS;
	}

	public void setLowDPS(int lowDPS) {
		this.lowDPS = lowDPS;
	}

	public int getHighDPS() {
		return highDPS;
	}

	public void setHighDPS(int highDPS) {
		this.highDPS = highDPS;
	}

	@Override
	public String toString() {
		return "WeaponView [name=" + name + ", imageString=" + imageString + ", lowDPS=" + lowDPS + ", highDPS="
				+ highDPS + "]";
	}
}
