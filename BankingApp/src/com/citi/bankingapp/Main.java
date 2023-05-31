package com.citi.bankingapp;

import java.util.List;

import com.citi.bankingapp.dto.Account;
import com.citi.bankingapp.service.AccountService;
import com.citi.bankingapp.service.AccountServiceImpl;
import com.citi.bankingapp.utils.DBUtils;

public class Main {

	public static void main(String[] args) {
		
		AccountService accountService = AccountServiceImpl.getInstance();
		
		
//		String result = accountService.createAccount(new Account("005","active","abhinandan chivate",1000.0f,"AC001"));
//		
//		System.out.println("result "+result);
//		
		
		
		List<Account> accounts = accountService.getAllAccounts();
		
		
		accounts.forEach(e->System.out.println(e));
		
		
		
	}

}
