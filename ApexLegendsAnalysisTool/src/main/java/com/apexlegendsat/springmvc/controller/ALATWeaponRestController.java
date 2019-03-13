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

import com.apexlegendsat.springmvc.service.WeaponService;
import com.apexlegendsat.springmvc.view.WeaponView;

@RestController
public class ALATWeaponRestController {
	
	static Logger logger = LogManager.getLogger(ALATWeaponRestController.class.getName());

	@Autowired
	private WeaponService weaponService;

	@RequestMapping(value = "/weapon/", method = RequestMethod.GET)
	public ResponseEntity<List<WeaponView>> listAllWeapons() {
		List<WeaponView> weapons = weaponService.findAllWeapons();
		if (weapons.isEmpty()) {
			return new ResponseEntity<List<WeaponView>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<WeaponView>>(weapons, HttpStatus.OK);
	}

	@RequestMapping(value = "/weapon/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WeaponView> getWeapon(@PathVariable("id") int id) {
		logger.info("Fetching Weapon with id " + id);
		WeaponView weapon = weaponService.findById(id);
		if (weapon == null) {
			logger.error("Weapon with id " + id + " not found");
			return new ResponseEntity<WeaponView>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<WeaponView>(weapon, HttpStatus.OK);
	}

	@RequestMapping(value = "/weapon/", method = RequestMethod.POST)
	public ResponseEntity<Void> createWeapon(@RequestBody WeaponView weapon) {
		logger.info("Creating Weapon " + weapon.getName());

		if (weaponService.doesWeaponExist(weapon)) {
			logger.error("A Weapon with name " + weapon.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		weaponService.saveWeapon(weapon);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/weapon/{id}", method = RequestMethod.PUT)
	public ResponseEntity<WeaponView> updateWeapon(@PathVariable("id") int id, @RequestBody WeaponView weapon) {
		logger.info("Updating Weapon " + id);
		logger.info(weapon);

		WeaponView currentWeapon = weaponService.findById(id);

		if (currentWeapon == null) {
			logger.error("Weapon with id " + id + " not found");
			return new ResponseEntity<WeaponView>(HttpStatus.NO_CONTENT);
		}

		currentWeapon.setName(weapon.getName());
		currentWeapon.setType(weapon.getType());
		currentWeapon.setImageSource(weapon.getImageSource());
		currentWeapon.setLowDps(weapon.getLowDps());
		currentWeapon.setHighDps(weapon.getHighDps());

		weaponService.updateWeapon(currentWeapon);
		return new ResponseEntity<WeaponView>(currentWeapon, HttpStatus.OK);
	}

	@RequestMapping(value = "/weapon/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<WeaponView> deleteWeapon(@PathVariable("id") int id) {
		logger.info("Fetching & Deleting Weapon with id " + id);

		WeaponView weapon = weaponService.findById(id);
		if (weapon == null) {
			logger.error("Unable to delete. Weapon with id " + id + " not found");
			return new ResponseEntity<WeaponView>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		weaponService.deleteWeaponById(id);
		return new ResponseEntity<WeaponView>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}