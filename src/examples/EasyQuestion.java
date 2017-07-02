package examples;

import java.util.Scanner;

/**
 * Created by nutph on 7/2/2017.
 */
public class EasyQuestion {

	public static void main(String[] a) throws Exception{
		EasyQuestion c = new EasyQuestion();
		c.run();
	}
	
	public void run () throws Exception{
		Scanner scanner = new Scanner(System.in);

		int[] limits = new int[3];
		int customerNumber;

		for(int i=0;i<limits.length;++i){
			limits[i] = Integer.parseInt(scanner.next());
		}
		//set limits in Comp Hortons to know cup size
		CompHortons.setInstance(limits);

		//set number of customers
		customerNumber=Integer.parseInt(scanner.next());

		//create array of customers
		Customer[] customers = new Customer[customerNumber];

		//initial of each customer
		for(int i=0;i<customerNumber;i++) {
			String name = scanner.next();
			int age = Integer.parseInt(scanner.next());
			int feet = Integer.parseInt(scanner.next());
			int inches = Integer.parseInt(scanner.next());
			customers[i] = new Customer(name, age, feet, inches);
		}

		//print customer information (see Customer.toString())
		for (Customer customer : customers) {
			System.out.println(customer);
		}

		scanner.close();
	}
}
