import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B5_NumberRecentCall {

    private Queue<Integer> time;

    public B5_NumberRecentCall() {
        time = new LinkedList<Integer>();
    }

    public int ping(int t) {
        time.add(t);
        while (time.peek() < t - 3000) {
            time.poll();
        }
        return time.size();
    }

    public static void main(String[] args) throws IOException {

        B5_NumberRecentCall recentCounter = new B5_NumberRecentCall();
        System.out.println(recentCounter.ping(1));// requests = [1], range is [-2999,1], return 1
        System.out.println(recentCounter.ping(100)); // requests = [1, 100], range is [-2900,100], return 2
        System.out.println(recentCounter.ping(3001)); // requests = [1, 100, 3001], range is [1,3001], return 3
        System.out.println(recentCounter.ping(3002)); // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
    }
}
