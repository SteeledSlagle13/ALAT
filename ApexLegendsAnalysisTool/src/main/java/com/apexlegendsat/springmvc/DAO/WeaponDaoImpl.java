package com.apexlegendsat.springmvc.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.apexlegendsat.springmvc.entity.WeaponEntity;

@Repository("weaponDAO")
public class WeaponDaoImpl extends AbstractDAO implements WeaponDAO {

	@Override
	public void deleteWeaponEntityById(long weaponId) {
		Query deleteQuery = getSession().createSQLQuery("delete from weapon where id =: weaponId");
		deleteQuery.setLong("weaponId", weaponId);

		deleteQuery.executeUpdate();
	}

	@Override
	public List<WeaponEntity> findAllWeaponEntities() {
		Criteria criteria = getSession().createCriteria(WeaponEntity.class);
		return (List<WeaponEntity>) criteria.list();
	}

	@Override
	public WeaponEntity findWeaponEntityById(long weaponId) {
		Criteria criteria = getSession().createCriteria(WeaponEntity.class);
		criteria.add(Restrictions.eq("id", weaponId));

		return (WeaponEntity) criteria.uniqueResult();
	}

	@Override
	public WeaponEntity findWeaponEntityByName(String weaponName) {
		Query findQuery = getSession().createSQLQuery("from weapon where name =: weaponName");
		findQuery.setString("weaponName", weaponName);

		return (WeaponEntity) findQuery.uniqueResult();
	}

	@Override
	public void purgeWeaponEntities() {
		Query purgeQuery = getSession().createSQLQuery("delete from weapon");
		purgeQuery.executeUpdate();
	}

	@Override
	public void saveWeaponEntity(WeaponEntity weaponEntity) {
		persist(weaponEntity);
	}

	@Override
	public void updateWeaponEntity(WeaponEntity weaponEntity) {
		getSession().update(weaponEntity);
	}

}
