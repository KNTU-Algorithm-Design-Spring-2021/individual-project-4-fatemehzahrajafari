import java.util.*;
import java.util.Scanner;

public class Post {
    public static int pieceFit(int[] array) {
        if (array.length == 0) {
            return -1;
        }
        int temp = 0;
        int minimum = array[temp];

        for (int i = 1; i < array.length; i++) {
            if (array[i] <= minimum) {
                minimum = array[i];
                temp = i;
            }
        }
        return temp;

    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of box : ");
        int number=scanner.nextInt();
        int array[]=new int[number];
        System.out.println("Enter wheight of box : ");
        for (int i=0;i<number;i++){
            array[i]=scanner.nextInt();
        }
        System.out.println("Enter number of trucks : ");
        //number of trucks
        int k=scanner.nextInt();
        // int sum=0;
        //for(int i=0;i<number;i++){
        //  sum=sum+array[i];
        //}
        // Post p = new Post();

        // Arrays.sort(array);

        //     int capacity=(int)Math.ceil((sum)/k);
        //   System.out.println(capacity);
        int array2[] = new int[k];

        for (int i = 0; i < array.length; i++) {
            array2[pieceFit(array2)] += array[i];
        }
     //print assign
        for (int j=0;j<k;j++){
            System.out.println("truck number "+(j+1)+": "+ array2[j]);
        }
    }

}
