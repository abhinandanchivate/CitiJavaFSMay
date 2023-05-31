package com.citi.bankingapp.repo;

import java.util.List;

import com.citi.bankingapp.dto.Account;

public interface AccountRepo {
	
	public String createAccount(Account account);
	public String deleteAccount(String accountId);
	public Account getAccountDetailsById(String accountId);
	public List<Account> getAllAccounts();
	

}
