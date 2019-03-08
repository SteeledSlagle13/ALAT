package com.apexlegendsat.springmvc.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apexlegendsat.springmvc.entity.WeaponEntity;
import com.apexlegendsat.springmvc.service.WeaponService;

@RestController
public class ALATWeaponRestController {
	
	static Logger logger = LogManager.getLogger(ALATUserRestController.class.getName());

	@Autowired
	private WeaponService weaponService;

	@RequestMapping(value = "/weapon/", method = RequestMethod.GET)
	public ResponseEntity<List<WeaponEntity>> listAllWeapons() {
		List<WeaponEntity> weapons = weaponService.findAllWeapons();
		if (weapons.isEmpty()) {
			return new ResponseEntity<List<WeaponEntity>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<WeaponEntity>>(weapons, HttpStatus.OK);
	}

	@RequestMapping(value = "/weapon/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WeaponEntity> getWeapon(@PathVariable("id") long id) {
		logger.info("Fetching Weapon with id " + id);
		WeaponEntity weapon = weaponService.findById(id);
		if (weapon == null) {
			logger.error("Weapon with id " + id + " not found");
			return new ResponseEntity<WeaponEntity>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<WeaponEntity>(weapon, HttpStatus.OK);
	}

	@RequestMapping(value = "/weapon/", method = RequestMethod.POST)
	public ResponseEntity<Void> createWeapon(@RequestBody WeaponEntity weapon) {
		logger.info("Creating Weapon " + weapon.getName());

		if (weaponService.doesWeaponExist(weapon)) {
			logger.error("A Weapon with name " + weapon.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		weaponService.saveWeapon(weapon);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/weapon/{id}", method = RequestMethod.PUT)
	public ResponseEntity<WeaponEntity> updateWeapon(@PathVariable("id") long id, @RequestBody WeaponEntity weapon) {
		logger.info("Updating Weapon " + id);

		WeaponEntity currentWeapon = weaponService.findById(id);

		if (currentWeapon == null) {
			logger.error("Weapon with id " + id + " not found");
			return new ResponseEntity<WeaponEntity>(HttpStatus.NOT_FOUND);
		}

		currentWeapon.setName(weapon.getName());
		currentWeapon.setType(weapon.getType());
		currentWeapon.setImageSource(weapon.getImageSource());
		currentWeapon.setLowDPS(weapon.getLowDPS());
		currentWeapon.setHighDPS(weapon.getHighDPS());

		weaponService.updateWeapon(currentWeapon);
		return new ResponseEntity<WeaponEntity>(currentWeapon, HttpStatus.OK);
	}

	@RequestMapping(value = "/weapon/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<WeaponEntity> deleteWeapon(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Weapon with id " + id);

		WeaponEntity wepaon = weaponService.findById(id);
		if (wepaon == null) {
			logger.error("Unable to delete. Weapon with id " + id + " not found");
			return new ResponseEntity<WeaponEntity>(HttpStatus.NOT_FOUND);
		}

		weaponService.deleteWeaponById(id);
		return new ResponseEntity<WeaponEntity>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/weapon/", method = RequestMethod.DELETE)
	public ResponseEntity<WeaponEntity> deleteAllWeapons() {
		logger.info("Deleting All Weapons");

		weaponService.purgeWeapons();
		return new ResponseEntity<WeaponEntity>(HttpStatus.NO_CONTENT);
	}

}