package cz.morosystems.phase8.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.morosystems.phase8.entity.BookEntity;
import cz.morosystems.phase8.entity.UserEntity;

@Repository
public class UserDaoImpl implements UserDAO  {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<UserEntity> getAllUsers() {
		//return this.sessionFactory.getCurrentSession().createQuery("from UserEntity").list();
		return this.sessionFactory.getCurrentSession().createCriteria(UserEntity.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).addOrder(Order.asc("id")).list();
	}
	@Transactional
	public UserEntity getUser(Integer userId) {
		return (UserEntity) this.sessionFactory.getCurrentSession().createQuery("from UserEntity user where user.id = :userid").setParameter("userid", userId).uniqueResult();
	}	
	@Transactional
	public UserEntity getUserWithLinks(Integer id) {
		UserEntity user = getUser(id);
		// tady toto bylo pridano jako podpora pro LAZY
		Hibernate.initialize(user.getAccounts());
		Hibernate.initialize(user.getBooks());
		Hibernate.initialize(user.getPrefferedAccount());
		Hibernate.initialize(user.getFavouriteBook());
		return user;
	}
	@Transactional
	public Integer getNUsers() {
		// mozno take pouzit
		//return ((Long)this.sessionFactory.getCurrentSession().createQuery("select count(*) from UserEntity").uniqueResult()).intValue();
		// staci tam velikost Integeru
		return ((Long)this.sessionFactory.getCurrentSession().createCriteria(UserEntity.class).setProjection(Projections.rowCount()).uniqueResult()).intValue();
	}
	@Transactional
	public void addUser(UserEntity user) {
		// novy uzivatel
		this.sessionFactory.getCurrentSession().save(user);
	}
	@Transactional
	public void editUser(UserEntity user) {
		// editace stavajiciho uzivatele
		this.sessionFactory.getCurrentSession().merge(user);
	}
	@Transactional
	public void deleteUser(Integer userId) {
		UserEntity user = (UserEntity) sessionFactory.getCurrentSession().load(
				UserEntity.class, userId);
        if (null != user) {
        	this.sessionFactory.getCurrentSession().delete(user);
        }
	}
}
