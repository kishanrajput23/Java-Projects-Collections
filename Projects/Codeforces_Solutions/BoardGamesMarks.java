import java.util.*;

public class BoardGamesMarks {
    static class Pair {
        int x, y, moves;

        Pair(int x, int y, int moves) {
            this.x = x;
            this.y = y;
            this.moves = moves;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        int sx = scanner.nextInt();
        int sy = scanner.nextInt();

        int dx = scanner.nextInt();
        int dy = scanner.nextInt();

        int mx = scanner.nextInt();
        int my = scanner.nextInt();

        System.out.println(bfs(grid, sx, sy, dx, dy, mx, my));
        scanner.close();
    }

    private static int bfs(int[][] grid, int sx, int sy, int dx, int dy, int mx, int my) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(sx, sy, 0));
        visited[sx][sy] = true;

        int[][] directions = {
            {mx, my},  
            {my, -mx}, 
            {-my, mx}, 
            {-mx, -my} 
        };

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            if (pair.x == dx && pair.y == dy) {
                return pair.moves;
            }

            for (int[] dir : directions) {
                int nx = pair.x + dir[0];
                int ny = pair.y + dir[1];

                if (isValid(nx, ny, grid.length, grid[0].length) && !visited[nx][ny] && grid[nx][ny] == 0) {
                    queue.offer(new Pair(nx, ny, pair.moves + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        return -1; 
    }

    private static boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
