package com.citi.bankingapp;

import com.citi.bankingapp.dto.Account;
import com.citi.bankingapp.service.AccountService;
import com.citi.bankingapp.service.AccountServiceImpl;
import com.citi.bankingapp.utils.DBUtils;

public class Main {

	public static void main(String[] args) {
		
		AccountService accountService = AccountServiceImpl.getInstance();
		
		
//		String result = accountService.createAccount(new Account("002","active","abhinandan chivate",1000.0f,"AC001"));
//		
//		System.out.println("result "+result);
		
		String result = accountService.deleteAccount("001");
		
		System.out.println(result);
		
		
		
	}

}
