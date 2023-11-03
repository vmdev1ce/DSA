import java.util.*;
public class B16_SuperPrimeNumber{
    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            Queue<Integer> dq = new LinkedList<>();
            for(int i = 2; i <= n && i < 10 ; i++){
                if(isPrime(i)){
                    dq.add(i);
                }
            }
            while(! dq.isEmpty()){
                for(int i = 1; i<= 9; i++){
                    int k = dq.peek()*10+i;
                    if(k <= n && isPrime(k)){
                        dq.add(k);
                    }
                }
                System.out.print(dq.peek() + " ");
                dq.remove();
                
            }
        }
    }
    public static boolean isPrime(int n){
        if(n<2) return false;
        if(n==2) return true;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}