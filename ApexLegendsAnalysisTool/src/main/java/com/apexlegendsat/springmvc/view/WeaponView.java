package com.apexlegendsat.springmvc.view;

public class WeaponView {

	private int id;
	private String name;
	private String imageString;
	private int lowDPS;
	private int highDPS;

	public WeaponView() {

	}

	public WeaponView(int id, String name, String imageString, int lowDPS, int highDPS) {
		super();
		this.id = id;
		this.name = name;
		this.imageString = imageString;
		this.lowDPS = lowDPS;
		this.highDPS = highDPS;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
		return "WeaponView [ id=" + id + ", name=" + name + ", imageString=" + imageString + ", lowDPS=" + lowDPS + ", highDPS="
				+ highDPS + "]";
	}
}
