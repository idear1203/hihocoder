import java.util.*;

public class Main{
    static void shortestPath(int[][] dis, int n){
        for (int k = 0; k < n; k++){
            for (int i = 0; i < n; i++){
                if (i == k) continue;
                for (int j = 0; j < n; j++){
                    if (i != j && j != k){
                        if (dis[i][k] != Integer.MAX_VALUE && dis[k][j] != Integer.MAX_VALUE && dis[i][k] + dis[k][j] < dis[i][j])
                            dis[i][j] = dis[i][k] + dis[k][j];
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] dis = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        for (int i = 0; i < n; i++)
            dis[i][i] = 0;
        for (int ii = 0; ii < m; ii++){
            int i = scanner.nextInt() - 1;
            int j = scanner.nextInt() - 1;
            dis[i][j] = dis[j][i] = Math.min(dis[i][j], scanner.nextInt());
        }
        shortestPath(dis, n);
        for (int i = 0; i < n; i++){
            boolean first = true;
            for (int j = 0; j < n; j++){
                if (first){
                    first = false;
                } else {
                    System.out.print(" ");
                }
                System.out.print(dis[i][j]);
            }
            System.out.println();
        }
        scanner.close();
    }
}

