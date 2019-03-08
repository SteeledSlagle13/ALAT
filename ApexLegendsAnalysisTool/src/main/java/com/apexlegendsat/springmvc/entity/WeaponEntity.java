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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	@Column(name="name")
	private String name;
	@Column(name="type")
	private String type;
	@Column(name="image_source")
	private String imageSource;
	@Column(name="low_dps")
	private int lowDPS;
	@Column(name="high_dps")
	private int highDPS;
	
	public WeaponEntity() {
		id = 0;
	}
	
	public WeaponEntity(long id, String name, String type, String imageSource, int lowDPS, int highDPS) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.imageSource = imageSource;
		this.lowDPS = lowDPS;
		this.highDPS = highDPS;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
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
		return "(id, name, type, low_dps, high_dps, image_source) VALUES (" + id + ", " + name + ", " + type + ", " + lowDPS + ", " + highDPS + imageSource + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof WeaponEntity)) {
			return false;
		}
		WeaponEntity other = (WeaponEntity) obj;
		if (highDPS != other.highDPS) {
			return false;
		}
		if (imageSource == null) {
			if (other.imageSource != null) {
				return false;
			}
		} else if (!imageSource.equals(other.imageSource)) {
			return false;
		}
		if (lowDPS != other.lowDPS) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		return true;
	}

}
