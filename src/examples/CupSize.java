package examples;

import java.util.Comparator;

/**
 * Created by nutph on 7/2/2017.
 */
public enum CupSize implements Comparator<CupSize> {
    EXTRA_SMALL(0),SMALL(1), MEDIUM(2), LARGE(3);

    CupSize(int val) {
        value = val;
    }

    private int value;

    @Override
    public int compare(CupSize c1, CupSize c2) {
        // order by value (from small value to large)
        // return negative value means c1 is smaller than c2 (so c1 first)
        // return positive value means c1 is larger than c2 (so c2 first)
        return c1.value-c2.value;
    }

    @Override
    public String toString() {
        if(this.equals(EXTRA_SMALL)){
            return "ExtraSmall";
        }else if(this.equals(SMALL)){
            return "Small";
        }else if(this.equals(MEDIUM)){
            return "Medium";
        }else{
            return "Large";
        }
    }
}
