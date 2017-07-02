package examples;

public class Customer{
	private String name;
	private int age;
	private int feet, inches;
	private Beverage beverage;
	private CupSize size;

	public Customer(String name, int age, int feet, int inches) throws Exception{
		this.age=age;
		this.name=name;
		this.feet=feet;
		this.inches=inches;

		CompHortons compHortons = CompHortons.getInstance();

		//to compare customer units to get cup size
		this.size = compHortons.getSizeFromCustomerHeight(getHeightInInches());

		//to get age for beverage
		this.beverage = compHortons.getBeverageFromAge(this.age);
	}

	public String getName() {
		return name;
	}

	public int getFeet() {
		return feet;
	}

	public int getInches() {
		return inches;
	}

	public CupSize getSize() {
		return size;
	}

	public int getHeightInInches(){
		return feet*12+inches;
	}

	@Override
	public String toString() {
		return this.name+" "+this.beverage+" "+this.size+" "+this.age+" "+this.feet+" "+this.inches;
	}
}