import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;
import java.util.StringTokenizer;

public class Euler001 {

    public void solve() {
        int t = nextInt();
        while (t-- > 0) {
            long startTs = System.currentTimeMillis();
            int n = nextInt();
            long ans = 0;

            int div3 = (n % 3 == 0) ? n / 3 - 1 : n / 3;
            int div5 = (n % 5 == 0) ? n / 5 - 1 : n / 5;
            int div15 = (n % 15 == 0) ? n / 15 - 1 : n / 15;

            long apSum3 = ((div3) * (long) (3 + div3 * 3)) / 2;
            long apSum5 = ((div5) * (long) (5 + div5 * 5)) / 2;
            long apSum15 = ((div15) * (long) (15 + div15 * 15)) / 2;

            ans = (apSum3 + apSum5) - apSum15;
            out.println("Time Taken is = "+ (System.currentTimeMillis() - startTs));
            out.println(ans);
            out.flush();
        }
    }

    Euler001() throws IOException {
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
        new Euler001();
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

    