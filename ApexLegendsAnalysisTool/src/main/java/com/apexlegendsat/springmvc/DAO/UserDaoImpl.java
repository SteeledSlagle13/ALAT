package com.apexlegendsat.springmvc.DAO;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import org.springframework.stereotype.Repository;

import com.apexlegendsat.springmvc.entity.UserEntity;

@Repository
public class UserDaoImpl extends AbstractDAO implements UserDAO {
	
	static Logger logger = LogManager.getLogger(UserDaoImpl.class.getName());

	@Override
	public void deleteUserEntityById(int userId) {
		Query deleteQuery = getSession().createQuery("delete from UserEntity where id =:userId");
		deleteQuery.setInteger("userId", userId);

		deleteQuery.executeUpdate();
	}

	@Override
	public List<UserEntity> findAllUserEntities() {
		
		logger.info("Trying to get all users!");
		
		Criteria criteria = getSession().createCriteria(UserEntity.class);
		return (List<UserEntity>) criteria.list();
	}

	@Override
	public UserEntity findUserEntityById(int userId) {
		Criteria criteria = getSession().createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq("id", userId));

		return (UserEntity) criteria.uniqueResult();
	}

	@Override
	public UserEntity findUserEntityByName(String userName) {
		
		logger.info("Username : " + userName);
		
		String hqlString = "from UserEntity where username =:name";
		Query findQuery = getSession().createQuery(hqlString);

		findQuery.setString("name", userName);
		
		List resuList = findQuery.list();
		
		return (UserEntity) findQuery.uniqueResult();
	}

	@Override
	public void saveUserEntity(UserEntity userEntity) {
		getSession().persist(userEntity);
	}

	@Override
	public void updateUserEntity(UserEntity userEntity) {
		getSession().update(userEntity);
	}

}
