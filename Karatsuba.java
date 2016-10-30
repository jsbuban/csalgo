
package karatsuba;

import java.util.Scanner;


public class Karatsuba {
    public static void main(String[] args) {
        
    Scanner sc = new Scanner(System.in);
    
        String x, y;
        int a, b, c, d;
        int ac,ad,bc,bd;
        int answer;
        
        System.out.println("Enter X: ");
        x = sc.nextLine();
        System.out.println("Enter Y: ");
        y = sc.nextLine();
        
        a = Integer.parseInt(x.substring(0, 2));
        b = Integer.parseInt(x.substring(2, 4));
        c = Integer.parseInt(y.substring(0, 2));
        d = Integer.parseInt(y.substring(2, 4));
        
        ac = a * c;
        ad = a * d;
        bc = b * c;
        bd = b * d;
        
        //System.out.println("ac ad bc bd: "+ac" "+ad" "+bc" "+bd");"
        answer = ac * 10000;
        answer += ((ad+bc)*100);
        answer += bd;
        
        System.out.println("The answer is: " +answer);
        
    }
    
}
