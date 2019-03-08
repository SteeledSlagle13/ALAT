package com.apexlegendsat.springmvc.DAO;

import java.util.List;

import com.apexlegendsat.springmvc.entity.WeaponEntity;

public interface WeaponDAO {

	void deleteWeaponEntityById(long weaponId);
	
	List<WeaponEntity> findAllWeaponEntities();
	
	WeaponEntity findWeaponEntityById(long weaponId);
	
	WeaponEntity findWeaponEntityByName(String weaponName);
	
	void purgeWeaponEntities();
	
	void saveWeaponEntity(WeaponEntity weaponEntity);
	
	void updateWeaponEntity(WeaponEntity weaponEntity);
}
