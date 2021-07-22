package cb_CPMSoc.CPM;

import java.util.Scanner;

/*
1 4 3 2 9 7 18 22
 */
public class C121_Doubles {
    public static void main(String[] args) {
        int n, i, j , count;
        int[] a = new int[16];
        Scanner sc = new Scanner(System.in);
        a[0] = sc.nextInt();
        while (a[0] != -1){
            n= 1;
            for(; ; n++){
                a[n] = sc.nextInt();
                if (a[n] == 0)
                    break;
            }
            count =0;
            for(i =0; i < n-1; i++){
                for(j = i+1; j < n; j++){
                    if (a[i]*2 == a[j] || a[j]*2 == a[i])
                        count++;
                }
            }
            System.out.println(count);
            a[0] = sc.nextInt();
        }

    }
}












/*
        int i, j , N;
        int count;
        int[] array = new int[20];
        Scanner sc = new Scanner(System.in);
        array[0] = sc.nextInt();
        // If it is not -1, keep getting the number
        while (array[0] !=-1){
            N = 1;
            for(; ; N++){
                array[N] = sc.nextInt();
                if (array[N] == 0)
                    break;
            }
            count = 0;
            // determine how many items in the list are twice
            for(i =0; i < N-1;i++){
                for(j = i +1; j < N; j++){
                    if (array[i] * 2 == array[j] || array[j] *2 == array[i])
                        count++;
                }
            }
            System.out.println(count);
            array[0] = sc.nextInt();
        }
 */