package com.apexlegendsat.springmvc.view;

public class WeaponView {

	private int id;
	private String name;
	private String type;
	private String imageSource;
	private int lowDps;
	private int highDps;

	public WeaponView() {

	}

	public WeaponView(int id, String name, String type, String imageSource, int lowDps, int highDps) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.imageSource = imageSource;
		this.lowDps = lowDps;
		this.highDps = highDps;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImageSource() {
		return imageSource;
	}

	public void setImageSource(String imageSource) {
		this.imageSource = imageSource;
	}

	public int getLowDps() {
		return lowDps;
	}

	public void setLowDps(int lowDps) {
		this.lowDps = lowDps;
	}

	public int getHighDps() {
		return highDps;
	}

	public void setHighDps(int highDps) {
		this.highDps = highDps;
	}

	@Override
	public String toString() {
		return "WeaponView [ id=" + id + ", name=" + name + ", imageSource=" + imageSource + ", lowDps=" + lowDps + ", highDps="
				+ highDps + "]";
	}
}
