package examples;

/**
 * Created by nutph on 7/2/2017.
 */
public enum Beverage {
    WATER,BEER;

    @Override
    public String toString() {
        if(this.equals(WATER)){
            return "Water";
        }else{
            return "Beer";
        }
    }
}
