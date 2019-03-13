package com.apexlegendsat.springmvc.service;

import java.util.List;

import com.apexlegendsat.springmvc.entity.WeaponEntity;
import com.apexlegendsat.springmvc.view.WeaponView;

public interface WeaponService {

	WeaponEntity convertWeaponViewToWeaponEntity(WeaponView weaponView);

	WeaponView convertWeaponEntityToWeaponView(WeaponEntity weaponEnt);
	
	void deleteWeaponById(int id);
	
	public boolean doesWeaponExist(WeaponView weapon);

	List<WeaponView> findAllWeapons();
	
	WeaponView findById(int id);

	WeaponView findByName(String name);

	void saveWeapon(WeaponView weapon);

	void updateWeapon(WeaponView weapon);

}
