package com.apexlegendsat.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apexlegendsat.springmvc.DAO.WeaponDAO;
import com.apexlegendsat.springmvc.entity.WeaponEntity;

@Service("weaponService")
@Transactional
public class WeaponServiceImpl implements WeaponService {

	@Autowired
	private WeaponDAO weaponDao;
	
	@Override
	public void deleteWeaponById(long id) {
		weaponDao.deleteWeaponEntityById(id);
	}
	
	@Override
	public boolean doesWeaponExist(WeaponEntity weapon) {
		return findByName(weapon.getName()) != null;
	}
	
	@Override
	public List<WeaponEntity> findAllWeapons() {
		return weaponDao.findAllWeaponEntities();
	}
	
	@Override
	public WeaponEntity findById(long id) {
		return weaponDao.findWeaponEntityById(id);
	}

	@Override
	public WeaponEntity findByName(String name) {
		return weaponDao.findWeaponEntityByName(name);
	}

	@Override
	public void purgeWeapons() {
		weaponDao.purgeWeaponEntities();
	}
	
	@Override
	public void saveWeapon(WeaponEntity weapon) {
		weaponDao.saveWeaponEntity(weapon);
	}

	@Override
	public void updateWeapon(WeaponEntity weapon) {
		weaponDao.updateWeaponEntity(weapon);
	}

	
	
//	private static final AtomicLong counter = new AtomicLong();
//	
//	private static List<WeaponEntity> weapons;
//
//	static {
//		weapons = populateWeapons();
//	}
//	
//	@Override
//	public WeaponEntity findById(long id) {
//		for(WeaponEntity weapon : weapons) {
//			if (weapon.getId() == id) {
//				return weapon;
//			}
//		}
//		return null;
//	}
//
//	@Override
//	public WeaponEntity findByName(String name) {
//		for(WeaponEntity weapon : weapons) {
//			if(weapon.getName().equalsIgnoreCase(name)) {
//				return weapon;
//			}
//		}
//		return null;
//	}
//
//	@Override
//	public void saveWeapon(WeaponEntity weapon) {
//		weapon.setId(counter.getAndIncrement());
//		weapons.add(weapon);
//	}
//
//	@Override
//	public void updateWeapon(WeaponEntity weapon) {
//		int index = weapons.indexOf(weapon);
//		weapons.set(index, weapon);
//	}
//
//	@Override
//	public void deleteWeaponById(long id) {
//		for(Iterator<WeaponEntity> iterator = weapons.iterator(); iterator.hasNext();) {
//			WeaponEntity weapon = iterator.next();
//			if(weapon.getId() == id) {
//				iterator.remove();
//			}
//		}
//		
//	}
//
//	@Override
//	public List<WeaponEntity> findAllWeapons() {
//		return weapons;
//	}
//
//	@Override
//	public void deleteAllWeapons() {
//		weapons.clear();
//	}
//
//	@Override
//	public boolean doesWeaponExist(WeaponEntity weapon) {
//		return findByName(weapon.getName()) != null;
//	}
//	
//	private static List<WeaponEntity> populateWeapons() {
//		List<WeaponEntity> weapons = new ArrayList<WeaponEntity>();
//		
//		//AR
//		weapons.add(new WeaponEntity(counter.incrementAndGet(),"havoc rifle", "assault rifle", "static/images/ar/havoc.png", 202, 404));
//		weapons.add(new WeaponEntity(counter.incrementAndGet(),"hemlock burst ar", "assault rifle", "static/images/ar/hemlok.png", 279, 558));
//		weapons.add(new WeaponEntity(counter.incrementAndGet(),"r-301 carbine", "assault rifle", "static/images/ar/r301.png", 189, 378));
//		weapons.add(new WeaponEntity(counter.incrementAndGet(),"vk-47 flatline", "assault rifle", "static/images/ar/flatline.png", 160, 320));
//		//LMG
//		weapons.add(new WeaponEntity(counter.incrementAndGet(),"devotion lmg", "light machine gun", "static/images/lmg/devotion.png", 85, 170));
//		weapons.add(new WeaponEntity(counter.incrementAndGet(),"m600 spitfire", "light machine gun", "static/images/lmg/spitfire.png", 180, 360));
//		//PISTOL
//		weapons.add(new WeaponEntity(counter.incrementAndGet(),"re-45", "pistol", "static/images/pistol/re45.png", 143, 215));
//		weapons.add(new WeaponEntity(counter.incrementAndGet(),"p2020", "pistol", "static/images/pistol/p2020.png", 102, 153));
//		weapons.add(new WeaponEntity(counter.incrementAndGet(),"wingman", "pistol", "static/images/pistol/wingman.png", 140, 280));
//		//SHOTGUN
//		weapons.add(new WeaponEntity(counter.incrementAndGet(),"mozambique shotun", "shotgun", "static/images/shotgun/mozambique.png", 99, 149));
//		weapons.add(new WeaponEntity(counter.incrementAndGet(),"peacekeeper", "shotgun", "static/images/shotgun/peacekeeper.png", 440, 660));
//		weapons.add(new WeaponEntity(counter.incrementAndGet(),"mastiff shotgun", "shotgun", "static/images/shotgun/mastiff.png", 187, 374));
//		weapons.add(new WeaponEntity(counter.incrementAndGet(),"eva-8 shotgun", "shotgun", "static/images/shotgun/eva8.png", 126, 189));
//		//SMG
//		weapons.add(new WeaponEntity(counter.incrementAndGet(),"alternator smg", "sub machine gun", "static/images/smg/alternator.png", 130, 195));
//		weapons.add(new WeaponEntity(counter.incrementAndGet(),"prowler burst pdw", "sub machine gun", "static/images/smg/prowler.png", 294, 441));
//		weapons.add(new WeaponEntity(counter.incrementAndGet(),"r-99 smg", "sub machine gun", "static/images/smg/r99.png", 216, 324));
//		//SNIPER
//		weapons.add(new WeaponEntity(counter.incrementAndGet(),"longbow dmr", "sniper", "static/images/sniper/longbow.png", 66, 132));
//		weapons.add(new WeaponEntity(counter.incrementAndGet(),"g7 scout", "sniper", "static/images/sniper/g7scout.png", 135, 270));
//		weapons.add(new WeaponEntity(counter.incrementAndGet(),"triple take", "sniper", "static/images/sniper/tripletake.png", 86, 172));
//		weapons.add(new WeaponEntity(counter.incrementAndGet(),"kraber .50-cal sniper", "sniper", "static/images/sniper/kraber.png", 150, 300));
//		
//		return weapons;
//		
//	}

}
