
package selectionsort;

import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        
    Scanner scan = new Scanner(System.in);

        System.out.print("Enter size of the List:");
            int n = scan.nextInt();
        System.out.println("Enter "+n+" numbers:");
            int array[] = new int[n];

        for (n = 0; n < array.length; n++) {
            array[n] = scan.nextInt();
        }
        
        System.out.println("After Selection Sort:");
        
        for (int i = 0; i < array.length; i++) {
           int x = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[x]) {
                    x = j;
                }
            }

            if (x != i) {
                int temp = array[i];
                array[i] = array[x];
                array[x] = temp;
            }

            System.out.print(array[i]+ ",");
    
        }
    }
}