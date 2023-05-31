package com.citi.bankingapp.service;

import java.util.List;

import com.citi.bankingapp.dto.Account;
import com.citi.bankingapp.repo.AccountRepo;
import com.citi.bankingapp.repo.AccountRepoImpl;

public class AccountServiceImpl implements AccountService {
	
	private static AccountService accountService;
	private AccountServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	public static AccountService getInstance() {
		if(accountService==null)
			accountService = new AccountServiceImpl();
		return accountService;
	}
	
	private AccountRepo accountRepo = AccountRepoImpl.getInstance();

	@Override
	public String createAccount(Account account) {
		// TODO Auto-generated method stub
		return accountRepo.createAccount(account);
	}

	@Override
	public String deleteAccount(String accountId) {
		// TODO Auto-generated method stub
		return accountRepo.deleteAccount(accountId);
	}

	@Override
	public Account getAccountDetailsById(String accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return accountRepo.getAllAccounts();
	}

}
