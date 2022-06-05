
public class BasePlusCommissionEmployee extends CommissionEmployee
{
	private double baseSalary;
	
	public BasePlusCommissionEmployee(String name, String socialSecurityNumber, 
			double grossSales, double commissionRate, double baseSalary)
	{
		super(name, socialSecurityNumber, grossSales, commissionRate);
		
		if(baseSalary<0.0)
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		
		this.baseSalary = baseSalary;
	}
	
	public void setBaseSalary(double baseSalary)
	{
		if (baseSalary<0.0)
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		
		this.baseSalary = baseSalary;
	}
	
	public double getBaseSalary()
	{
		return baseSalary;
	}
	
	@Override
	public double getEarnings()
	{
		return getCommissionRate() * getGrossSales() + getBaseSalary();   
	}
}
