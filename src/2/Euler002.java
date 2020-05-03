import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;



public class Euler002 {

    long[] fib = new long[27];
    int size = 0;

    public void preCompute() {
        long n = 10000000000000000L * 4L;
        long f1 = 1;
        long f2 = 2;
        long f3 = f1 + f2;
        int count = 0;

        fib[0] = f2;

        while ( f3 <= n ) {
            f1 = f2;
            f2 = f3;
            f3 = f1 + f2;
            if (f3 % 2L == 0) {
                count++;
                fib[count] = f3;
                size ++;
            }

        }
    }

    public void solve() {
        preCompute();
        System.out.println("Size = "+ size);
        int t = nextInt();
        while (t-- > 0) {
            long n = nextLong();
            int index = Arrays.binarySearch(fib, n); //it will be either next key or size

            if (index < 0) {
                index = (-index) - 1;
            }

            index = Math.min(size, index);

            if (fib[index] > n) {
                index--;
            }

            long sum = 0;

            for (int itr = 0; itr <= index; itr++) {
                sum += fib[itr];
            }

            System.out.println(sum);
        }
    }

    Euler002() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    static final Random rng = new Random();

    static int rand(int l, int r) {
        return l + rng.nextInt(r - l + 1);
    }

    public static void main(String[] args) throws IOException {
        new Euler002();
    }

    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;

    String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return st.nextToken();
    }

    String nextString() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    int nextInt() {
        return Integer.parseInt(nextToken());
    }

    long nextLong() {
        return Long.parseLong(nextToken());
    }

    double nextDouble() {
        return Double.parseDouble(nextToken());
    }
}

    