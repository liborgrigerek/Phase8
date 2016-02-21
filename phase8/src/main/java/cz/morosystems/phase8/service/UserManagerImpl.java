package cz.morosystems.phase8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.morosystems.phase8.dao.UserDAO;
import cz.morosystems.phase8.entity.AccountEntity;
import cz.morosystems.phase8.entity.BookEntity;
import cz.morosystems.phase8.entity.UserEntity;

@Service
public class UserManagerImpl implements UserManager {
	
	@Autowired
    private UserDAO userDAO;

	@Transactional
	public List<UserEntity> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Transactional
	public UserEntity getUser(Integer id) {
		return userDAO.getUser(id);
	}
	
	@Transactional
	public UserEntity getUserWithLinks(Integer id) {
		return userDAO.getUserWithLinks(id);
	}
	
	@Transactional
	public Integer getNUsers() {
		return userDAO.getNUsers();
	}
	
	@Transactional
	public void addUser(UserEntity user) {
		userDAO.addUser(user);
	}
	
	@Transactional
	public void editUser(UserEntity user) {
		userDAO.editUser(user);
	}
	
	@Transactional
	public void deleteUser(Integer userId) {
		userDAO.deleteUser(userId);
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
