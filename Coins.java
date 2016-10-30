
package coins;

public class Coins {
    public static void main(String args[]) {
        
        int tenPeso = 0, fivePeso = 0, onePeso = 0, tfCents = 0;
        double fValue = 572.25;
        
        while (fValue - 10 >= 0) {
            fValue = fValue - 10;
            ++tenPeso;
            if (fValue < 10) {
                while (fValue - 5 >= 0) {
                    fValue = fValue - 5;
                    ++fivePeso;
                }
                if (fValue < 5) {
                    while (fValue - 1 >= 0) {
                        fValue = fValue - 1;
                        ++onePeso;
                    }
                    if (fValue < 1) {
                        while (fValue - .25 >= 0) {
                            fValue = fValue - .25;
                            ++tfCents;
                        }
                    }
                }
            }
        }
        
        System.out.println("Number of 10 peso bills: "+tenPeso);
        System.out.println("Number of 5 peso bills: "+fivePeso);
        System.out.println("Number of 1 peso bills: "+onePeso);
        System.out.println("Number of 25 centavo coins:"+tfCents);
    }
}