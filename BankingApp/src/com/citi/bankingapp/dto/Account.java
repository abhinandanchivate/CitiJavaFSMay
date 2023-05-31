package com.citi.bankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
//@AllArgsConstructor // this annotation from lombok will help us to declare the constructor
// which will accept all the values.

public class Account {
	// DTO ==> transportation purpose ==> we should have a facility to retrieve / set the data
	// since all the fields are private ===> can we access them outside the class? not possible.
	// Setter and getter methods ===> should be public in nature.
	// ==> can be acccesilble to any one anywhere.
	
	// setter : set the values
	// getter : retrive the value.
	private String accountNumber; // alphaNumberic combinations  range 
	private String accountType;
	private String accountStatus;// active/ inactive /hold
	private String holderName;
	private float balance;
	private String customerId;
	public Account() {}
	public Account(String accountNumber, String accountStatus, String holderName, float balance, String customerId) {
		super();
		this.accountNumber = accountNumber;
		this.accountStatus = accountStatus;
		this.holderName = holderName;
		this.balance = balance;
		this.customerId = customerId;
	} 
	
	// when we will declare the PC then java will withdraw the facility to provide the DC.
	
	
	

}
