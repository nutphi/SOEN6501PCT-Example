package examples;

import java.util.*;

/**
 * Created by nutph on 7/2/2017.
 */
public class CompHortons {

    private TreeMap<Integer,CupSize> cupSizeMap;

    private static CompHortons compHortons;

    private CompHortons(int ... cupLimit) throws Exception{

        if(cupLimit.length>3||cupLimit.length<3){
            throw new Exception("there are only 3 limits in Comp Hortons");
        }

        this.cupSizeMap = new TreeMap();
        for(int i=0;i<cupLimit.length;i++){
            cupSizeMap.put(cupLimit[i],CupSize.values()[i]);
        }
        cupSizeMap.put(Integer.MAX_VALUE,CupSize.values()[CupSize.values().length-1]);
    }

    public static CompHortons setInstance(int ... cupLimit) throws Exception{
        if(compHortons ==null) {
            compHortons = new CompHortons(cupLimit);
        }
        return compHortons;
    }

    public static CompHortons getInstance() throws Exception{
        if(compHortons ==null) {
            throw new Exception("null value; please use setInstance method to set the instance");
        }
        return compHortons;
    }

    public Beverage getBeverageFromAge(int age){
        if(age>18)
            return Beverage.BEER;
        else
            return Beverage.WATER;
    }

    public CupSize getSizeFromCustomerHeight(int heightInInches){


        //calculate customer units (for more than 5 feet)
        int customerUnits;

        //calculate customer unit size
        double heightInFeet = heightInInches/12;
        if(heightInFeet <= 5){
            //calculate 10 units per feet for 0-5 feet height
            customerUnits = heightInInches * 10 / 12;
        }else{
            //calculate units for greater than 5 feet height

            //calculate 10 units per feet for first 5 feet
            customerUnits = 5 * 10 / 12;

            //get height in inches after 5 feet
            heightInInches = heightInInches - 5 * 12;

            //calculate 8 units per feet for the rest
            customerUnits = customerUnits + heightInInches * 8 / 12;
        }

        //to get the size from limit
        Iterator<Integer> limitsIterator = cupSizeMap.keySet().iterator();
        while(limitsIterator.hasNext()){
            int limit = limitsIterator.next();
            if(customerUnits<limit){
                return cupSizeMap.get(limit);
            }
        }
        return CupSize.LARGE;
    }
}
