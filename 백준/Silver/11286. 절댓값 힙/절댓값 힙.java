import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>((v1, v2) -> {
            int abs1 = Math.abs(v1);
            int abs2 = Math.abs(v2);
            if (abs1 == abs2) {
                return v1 - v2;
            }
            return abs1 - abs2;
        });
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                q.add(num);
            } else {
                if (q.isEmpty()) {
                    bw.write("0" + "\n");
                } else {
                    bw.write(String.valueOf(q.poll()) + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}