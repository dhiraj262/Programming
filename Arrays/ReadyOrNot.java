import java.util.Scanner;

/*
To find out if the general is ready for battle or not.
He is ready for battle if the number of soldiers with even number of weapons are greater than the number of soldiers with odd number of weapons.

First line contains number of soldiers.
second line constains the number of weapons for each soldiers separated by spaces.
*/

public class ReadyOrNot{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, lucky=0, unlucky=0;
        n = sc.nextInt();
        int a[] = new int[n];

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }

        for(int i=0;i<n;i++){
            if(a[i]%2==0)
                lucky++;
            else
                unlucky++;
        }

        if(lucky>unlucky)
            System.out.println("READY FOR BATTLE");
        else
            System.out.println("NOT READY");
    }
}