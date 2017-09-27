package cz.morosystems.phase8.dao;

import java.util.List;

import cz.morosystems.phase8.entity.UserEntity;

public interface UserDAO {
	public UserEntity getUser(Integer id);
	public UserEntity getUserWithLinks(Integer id);
    public List<UserEntity> getAllUsers();
    public Integer getNUsers();
    public void addUser(UserEntity user);
    public void editUser(UserEntity user);
    public void deleteUser(Integer userId);
}