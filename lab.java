import java.util.*;
public class lab {
    public static boolean prime(int n){
        if(n<2){
            return false;
        }
        for (int i = 2; i<n;i++) {
            if(n%i== 0) {
                return false;
            }
        }
        return true;
    }

    public static void count(int num){
        int count=0;
        while(num>0){
            count++;
            num=num/10;
        }
        System.out.print("Count is "+count);
    }

    public static void reverse(int num){
        int curr=num;
        int rev=0;
        while(num>0){
            int ld=num%10;
            rev=rev*10+ld;
            num=num/10;
        }

        if(rev==curr){
        System.out.print("Palindrome");
        }
        else{
            System.out.print("Not palindrome");
        }
    }

    public static void sum_of_digits(int num){
        int sum=0;
        while(num>0){
            int ld=num%10;
            sum+=ld;
            num=num/10;
        }
        System.out.print(sum);
    }

    public static void count_nums(int num){
        int count=0;
        while(num!=0){
            count++;
            num=num/10;
        }
        System.out.print(count);
    }

    public static void Armstrong(int num){  //cube of sum of digits is same as number the it is armstrong num
        int og=num;
        int cube=0;
        int sum=0;
        while(num>0){
            int ld=num%10;
            cube=ld*ld*ld;
            sum+=cube;
            num=num/10;
        }
        if(og==sum){
            System.out.print("number is Armstrong");
        }
        else{
            System.out.print("number is not Armstrong");
        }
    }
    public static int fibo(int n){
        if(n<=1){
            return n;
        }
        return fibo(n-1)+fibo(n-2);
    }
    public static void String_to_ascci(String str){
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            System.out.println((int)ch);
        }
    }

    public static int factorial(int n){
        if(n<=1){
            return 1;
        }
        return n*factorial(n-1);
    }
    
    public static void square_pattern(int n){
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || i==n || j==0 || j==n){
                System.out.print("*");
                }
                else if(i==j && i==(n+1)/2){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            /*for(int i=2;i<=n;i++){
                if(prime(i)==true){r
                    System.out.println(i+"");
                }
            }*/
            //count(n);
            //reverse(1661);
            //String str="r";
            //String_to_ascci(str);
            //System.out.print(factorial(5));
            //sum_of_digits(246);
            /*int n=10;
            fibo(n);
            for(int i=0;i<=n;i++){
                System.out.println(fibo(i));
            }*/
            //count_nums(6854);
            //Armstrong(370);
            square_pattern(num);
    }
}
