
public class Main {

	public static void main(String[] args) {
		
		CreditCard targetInterface = new BankCustomer();
		
		targetInterface.giveBankDetails();
		String details = targetInterface.getCreditCard();
		System.out.println(details);
	}
}
