package com.apexlegendsat.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apexlegendsat.springmvc.DAO.WeaponDAO;
import com.apexlegendsat.springmvc.entity.WeaponEntity;
import com.apexlegendsat.springmvc.view.WeaponView;

@Service
@Transactional
public class WeaponServiceImpl implements WeaponService {

	static Logger logger = LogManager.getLogger(WeaponServiceImpl.class.getName());

	@Autowired
	private WeaponDAO weaponDao;

	@Override
	public void deleteWeaponById(int id) {
		weaponDao.deleteWeaponEntityById(id);
	}

	@Override
	public boolean doesWeaponExist(WeaponView weapon) {
		return findByName(weapon.getName()) != null;
	}

	@Override
	public List<WeaponView> findAllWeapons() {
		List<WeaponEntity> weaponEntities = weaponDao.findAllWeaponEntities();
		
		List<WeaponView> weaponViews = new ArrayList<WeaponView>();
		for (WeaponEntity weaponEntity : weaponEntities) {
			weaponViews.add(convertWeaponEntityToWeaponView(weaponEntity));
		}
		
		return weaponViews;
	}

	@Override
	public WeaponView findById(int id) {
		return convertWeaponEntityToWeaponView(weaponDao.findWeaponEntityById(id));
	}

	@Override
	public WeaponView findByName(String name) {
		return convertWeaponEntityToWeaponView(weaponDao.findWeaponEntityByName(name));
	}

	@Override
	public void saveWeapon(WeaponView weapon) {
		weaponDao.saveWeaponEntity(convertWeaponViewToWeaponEntity(weapon));
	}

	@Override
	public void updateWeapon(WeaponView weapon) {
		weaponDao.updateWeaponEntity(convertWeaponViewToWeaponEntity(weapon));
	}

	@Override
	public WeaponEntity convertWeaponViewToWeaponEntity(WeaponView weaponView) {
		if(weaponView == null) {
			return null;
		}
		WeaponEntity weaponEntity = new WeaponEntity();

		weaponEntity.setId(weaponView.getId());
		weaponEntity.setName(weaponView.getName());
		weaponEntity.setImageSource(weaponView.getImageSource());
		weaponEntity.setType(weaponView.getType());
		weaponEntity.setLowDps(weaponView.getLowDps());
		weaponEntity.setHighDps(weaponView.getHighDps());

		return weaponEntity;
	}

	@Override
	public WeaponView convertWeaponEntityToWeaponView(WeaponEntity weaponEnt) {
		if(weaponEnt == null) {
			return null;
		}
		WeaponView weaponView = new WeaponView();

		weaponView.setId(weaponEnt.getId());
		weaponView.setName(weaponEnt.getName());
		weaponView.setImageSource(weaponEnt.getImageSource());
		weaponView.setType(weaponEnt.getType());
		weaponView.setLowDps(weaponEnt.getLowDps());
		weaponView.setHighDps(weaponEnt.getHighDps());

		return weaponView;
	}
}
