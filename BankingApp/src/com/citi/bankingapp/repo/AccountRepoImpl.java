package com.citi.bankingapp.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.citi.bankingapp.dto.Account;
import com.citi.bankingapp.utils.DBUtils;

public class AccountRepoImpl implements AccountRepo {
	
	private static AccountRepo  accountRepo ;
	private AccountRepoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public static AccountRepo getInstance() {
		
		if(accountRepo ==null)
			accountRepo = new AccountRepoImpl();
		return accountRepo;
		
	}
	
	DBUtils dbUtils = DBUtils.getInstance();

	@Override
	public String createAccount(Account account) {
		
		Connection connection  = dbUtils.getConnection();
		String insertQuery = "insert into account (accountId, accountType, accountStatus, holderName, customerId, balance) values(?,?,?,?,?,?)";// insert query .
		// place holder ==> we will provide the value. &abc 
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, account.getAccountNumber());
			if(account.getAccountType()==null) {
				account.setAccountType("saving");
			}
			
			preparedStatement.setString(2, account.getAccountType());
			preparedStatement.setString(3, account.getAccountStatus());
			preparedStatement.setString(4, account.getHolderName());
			preparedStatement.setString(5, account.getCustomerId());
			preparedStatement.setFloat(6, account.getBalance());
			int result =preparedStatement.executeUpdate();// return a number : afftect rows wrt : insert update / delete.
			
			if(result>0) {
				return "sucess";
			}
			else {
				return "fail";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAccount(String accountId) {
		Connection connection  = dbUtils.getConnection();
		String deleteQuery = "delete from account where accountId=?";// insert query .
		// place holder ==> we will provide the value. &abc 
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
			
			preparedStatement.setString(1,accountId);
			
			int result =preparedStatement.executeUpdate();// return a number : afftect rows wrt : insert update / delete.
			
			if(result>0) {
				return "sucess";
			}
			else {
				return "fail";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account getAccountDetailsById(String accountId) {
		Connection connection  = dbUtils.getConnection();
		
		
		ResultSet resultSet = null;
		String query = "select * from account where accountId=?";// insert query .
		// place holder ==> we will provide the value. &abc 
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, accountId);
			
			// o max N 
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				// do we need to collect the whole info. ===> row ===> we can retrieve it on the basis of column
				Account  account = new Account();
				account.setAccountNumber(resultSet.getString("accountId"));
				account.setAccountStatus(resultSet.getString("accountStatus"));
				account.setAccountType(resultSet.getString("accountType"));
				account.setBalance(resultSet.getFloat("balance"));
				account.setCustomerId(resultSet.getString("customerId"));
				account.setHolderName(resultSet.getString("holderName"));
				
				return account;
				
				
			}
			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Account> getAllAccounts() {
		Connection connection  = dbUtils.getConnection();
		List<Account> accountList = new ArrayList<>();
		
		ResultSet resultSet = null;
		String query = "select * from account";// insert query .
		// place holder ==> we will provide the value. &abc 
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			// o max N 
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				// do we need to collect the whole info. ===> row ===> we can retrieve it on the basis of column
				Account  account = new Account();
				account.setAccountNumber(resultSet.getString("accountId"));
				account.setAccountStatus(resultSet.getString("accountStatus"));
				account.setAccountType(resultSet.getString("accountType"));
				account.setBalance(resultSet.getFloat("balance"));
				account.setCustomerId(resultSet.getString("customerId"));
				account.setHolderName(resultSet.getString("holderName"));
				
				accountList.add(account);
				
			}
			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accountList;
	}

}
