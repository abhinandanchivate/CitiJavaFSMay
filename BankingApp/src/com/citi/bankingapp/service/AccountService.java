package com.citi.bankingapp.service;

import java.util.List;

import com.citi.bankingapp.dto.Account;

public interface AccountService {
	
	public String createAccount(Account account);
	public String deleteAccount(String accountId);
	public Account getAccountDetailsById(String accountId);
	public List<Account> getAllAccounts();

}
