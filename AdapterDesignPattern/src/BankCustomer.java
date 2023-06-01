import java.util.Scanner;

public class BankCustomer extends BankDetails implements CreditCard {

	@Override
	public void giveBankDetails() {
		// TODO Auto-generated method stub
		
		// acc holder name , acc number, bank name 
		
		Scanner scanner = new Scanner(System.in);// in --> input stream 
		//-> to accept the data from the console
		System.out.println("enter the ac holder name");
		String accHolderName = scanner.next();
		
		setAccHolderName(accHolderName);
		
		System.out.println("enter the acc number");
		long  accNumber= scanner.nextLong();
		setAccNumber(accNumber);
		
		
		System.out.println("enter the bank name");
		String bankName = scanner.next();
		setBankName(bankName);
		

		// 
	}

	@Override
	public String getCreditCard() {
		// all bank details 
		// TODO Auto-generated method stub
		String accHolderName = getAccHolderName();
		String bankName = getBankName();
		long accNumber = getAccNumber();
		
		return accHolderName+ bankName + accNumber;
	}

}
