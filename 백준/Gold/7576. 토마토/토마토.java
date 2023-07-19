import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Direction {
    int x;
    int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer input = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(input.nextToken());
        int row = Integer.parseInt(input.nextToken());

        int[][] field = new int[row][col];

        ArrayList<Queue<Point>> list = new ArrayList<>();
        Queue<Point> firstQ = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < arr.length; j++) {
                field[i][j] = arr[j];
                if (arr[j] == 1) {
                    firstQ.add(new Point(i, j));
                }
            }
        }
        list.add(firstQ);

        Direction[] directions = { new Direction(-1, 0), new Direction(0, 1), new Direction(1, 0),
                new Direction(0, -1) };

        for (int i = 0; i < list.size(); i++) {
            Queue<Point> curQ = list.get(i);
            Queue<Point> nextQ = new LinkedList<>();
            while (!curQ.isEmpty()) {
                Point p = curQ.poll();
                for (Direction d : directions) {
                    int x = p.x + d.x;
                    int y = p.y + d.y;
                    if (x >= 0 && x < row && y >= 0 && y < col) {
                        if (field[x][y] == 0) {
                            nextQ.add(new Point(x, y));
                            field[x][y] = 1;
                        }
                    }
                }
            }
            if (!nextQ.isEmpty()) {
                list.add(nextQ);
            }
        }
        boolean flag = true;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (field[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag) {
            System.out.println(list.size() - 1);
        } else {
            System.out.println(-1);
        }
    }
}