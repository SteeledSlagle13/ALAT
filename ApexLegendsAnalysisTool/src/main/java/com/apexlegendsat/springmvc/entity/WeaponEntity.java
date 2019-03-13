package com.apexlegendsat.springmvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="weapons")
public class WeaponEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="type")
	private String type;
	@Column(name="image_source")
	private String imageSource;
	@Column(name="low_dps")
	private int lowDps;
	@Column(name="high_dps")
	private int highDps;
	
	public WeaponEntity() {
		id = 0;
	}
	
	public WeaponEntity(int id, String name, String type, String imageSource, int lowDps, int highDps) {
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
		return "WeaponEntity [id=" + id + ", name=" + name + ", type=" + type + ", imageSource=" + imageSource
				+ ", lowDps=" + lowDps + ", highDps=" + highDps + "]";
	}
	
}
