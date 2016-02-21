package cz.morosystems.phase8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import cz.morosystems.phase8.dao.AdminDAO;
import cz.morosystems.phase8.entity.AdminEntity;

public class AdminManagerImpl implements AdminManager {
	
	@Autowired
	private AdminDAO adminDAO;
	
	@Transactional
	public List<AdminEntity> getAllAdmins() {
		return adminDAO.getAllAdmins();
	}

	@Transactional
	public AdminEntity getAdmin(Integer id) {
		return adminDAO.getAdmin(id);
	}

	@Transactional
	public void addAdmin(AdminEntity admin) {
		adminDAO.addAdmin(admin);
	}

	@Transactional
	public void editAdmin(AdminEntity admin) {
		adminDAO.editAdmin(admin);
	}

	@Transactional
	public void deleteAdmin(Integer adminId) {
		adminDAO.deleteAdmin(adminId);
	}

}
