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

import cz.morosystems.phase8.entity.AdminEntity;
import cz.morosystems.phase8.entity.BookEntity;
import cz.morosystems.phase8.entity.UserEntity;

@Repository
public class AdminDaoImpl implements AdminDAO  {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<AdminEntity> getAllAdmins() {
		return this.sessionFactory.getCurrentSession().createCriteria(AdminEntity.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).addOrder(Order.asc("id")).list();
	}
	@Transactional
	public AdminEntity getAdmin(Integer adminId) {
		return (AdminEntity) this.sessionFactory.getCurrentSession().createQuery("from AdminEntity admin where admin.id = :adminId").setParameter("adminId", adminId).uniqueResult();
	}	
	@Transactional
	public void addAdmin(AdminEntity admin) {
		// novy admnistrator
		this.sessionFactory.getCurrentSession().save(admin);
	}
	@Transactional
	public void editAdmin(AdminEntity admin) {
		// editace stavajiciho administratora
		this.sessionFactory.getCurrentSession().merge(admin);
	}
	@Transactional
	public void deleteAdmin(Integer adminId) {
		AdminEntity admin = (AdminEntity) sessionFactory.getCurrentSession().load(
				AdminEntity.class, adminId);
        if (null != admin) {
        	this.sessionFactory.getCurrentSession().delete(admin);
        }
	}
}
