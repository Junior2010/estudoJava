package ch03;
//
//

public class Account
{
	private String name;
	private double balance;
	
	public Account(String name, double balance)
	{
		this.name = name;
		
		//
		//
		if (balance > 0.0)
			this.balance = balance;
	}
	
	//
	public void deposit (double depositAmount)
	{
		if (depositAmount > 0.0)
			balance = balance + depositAmount;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	//método para definir o nome do objeto
	public void setName(String name)
	{
		this.name = name;
	}
	
	//métodp ára recuperar o nome do objeto
	public String getName()
	{
		return name;
	}
}
