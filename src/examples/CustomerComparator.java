package examples;

import java.util.Comparator;

/**
 * Created by nutph on 7/2/2017.
 */
public class CustomerComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer c1, Customer c2) {
        //order by name
        if(c1.getName().compareTo(c2.getName())!=0){
            return c1.getName().compareTo(c2.getName());
        }
        //order by cup size (CupSize.compare(CupSize o1, CupSize o2))
        else if(!c1.getSize().equals(c2.getSize())){
            return c1.getSize().compare(c1.getSize(),c2.getSize());
        }
        //order by customer height
        int c1Inches  = (c1.getFeet()*12)+c1.getInches();
        int c2Inches  = (c2.getFeet()*12)+c2.getInches();
        return c1Inches-c2Inches;
    }
}
