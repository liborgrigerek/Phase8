package cz.morosystems.phase8.dao;

import cz.morosystems.phase8.entity.AccountEntity;

public interface AccountDAO {
	public AccountEntity getAccount(Integer accountId);
    public void addAccount(AccountEntity account);
    public void editAccount(AccountEntity account);
    public void deleteAccount(Integer accountId);
}