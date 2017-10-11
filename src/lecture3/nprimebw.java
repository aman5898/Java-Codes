package lecture3;

import java.util.Scanner;

public class nprimebw {

	public static void main(String args[]) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int count=2;
        while(count<=n)
        {
            if(check(count)==true)
            {
                System.out.println(count);
            }
            count++;
        }

    }
    
    public static boolean check(int num)
    {
        
        int count=2;
        boolean bl=true;
        while(count*count<=num)
        {
            if(num%count==0)
            {
                return false;
            }
            count++;
            
        }
        
        
        return true;
    }
}
