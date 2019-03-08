package com.apexlegendsat.springmvc.service;

import java.util.List;

import com.apexlegendsat.springmvc.entity.WeaponEntity;

public interface WeaponService {
	
	WeaponEntity findById(long id);
	
	WeaponEntity findByName(String name);
	
	void saveWeapon(WeaponEntity weapon);
	
	void updateWeapon(WeaponEntity weapon);
	
	void deleteWeaponById(long id);
	
	List<WeaponEntity> findAllWeapons(); 
	
	void purgeWeapons();
	
	public boolean doesWeaponExist(WeaponEntity weapon);
}
