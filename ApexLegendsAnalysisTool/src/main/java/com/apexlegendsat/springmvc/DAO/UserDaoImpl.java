package com.apexlegendsat.springmvc.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.apexlegendsat.springmvc.entity.UserEntity;

@Repository("userDAO")
public class UserDaoImpl extends AbstractDAO implements UserDAO {

	@Override
	public void deleteUserEntityById(long userId) {
		Query deleteQuery = getSession().createSQLQuery("delete from user where id =: userId");
		deleteQuery.setLong("userId", userId);

		deleteQuery.executeUpdate();
	}

	@Override
	public List<UserEntity> findAllUserEntities() {
		Criteria criteria = getSession().createCriteria(UserEntity.class);
		return (List<UserEntity>) criteria.list();
	}

	@Override
	public UserEntity findUserEntityById(long userId) {
		Criteria criteria = getSession().createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq("id", userId));

		return (UserEntity) criteria.uniqueResult();
	}

	@Override
	public UserEntity findUserEntityByName(String userName) {
		Query findQuery = getSession().createSQLQuery("from user where username =: userName");
		findQuery.setString("userName", userName);

		return (UserEntity) findQuery.uniqueResult();
	}

	@Override
	public void saveUserEntity(UserEntity userEntity) {
		persist(userEntity);
	}

	@Override
	public void purgeUserEntities() {
		Query purgeQuery = getSession().createSQLQuery("delete from user");
		purgeQuery.executeUpdate();

	}

	@Override
	public void updateUserEntity(UserEntity userEntity) {
		getSession().update(userEntity);
	}

}
