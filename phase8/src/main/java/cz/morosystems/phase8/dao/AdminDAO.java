package cz.morosystems.phase8.dao;

import java.util.List;

import cz.morosystems.phase8.entity.AdminEntity;

public interface AdminDAO {
	public AdminEntity getAdmin(Integer id);
    public List<AdminEntity> getAllAdmins();
    public void addAdmin(AdminEntity admin);
    public void editAdmin(AdminEntity admin);
    public void deleteAdmin(Integer adminId);
}