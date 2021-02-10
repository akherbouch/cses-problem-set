package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;

import java.io.PrintWriter;

public class GridPaths {

    String path;
    boolean[][] visited = new boolean[9][9];
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    char[] dirs = {'U','R','D','L'};
    long ans = 0;

    private void dfs(int r, int c, int step) {
        if (r == 7 && c == 1) {
            if (step == 48) ans++;
            return;
        }

        char dir = path.charAt(step);
        visited[r][c] = true;

        if ((dir == '?' || dir == 'U') && !visited[r - 1][c]) {
            if (!visited[r - 2][c] || visited[r - 1][c + 1] || visited[r - 1][c - 1]) {
                dfs(r - 1, c, step + 1);
            }
        }

        if ((dir == '?' || dir == 'L') && !visited[r][c - 1]) {
            if (!visited[r][c - 2] || visited[r + 1][c - 1] || visited[r - 1][c - 1]) {
                dfs(r, c - 1, step + 1);
            }
        }

        if ((dir == '?' || dir == 'D') && !visited[r + 1][c]) {
            if (!visited[r + 2][c] || visited[r + 1][c + 1] || visited[r + 1][c - 1]) {
                dfs(r + 1, c, step + 1);
            }
        }

        if ((dir == '?' || dir == 'R') && !visited[r][c + 1]) {
            if (!visited[r][c + 2] || visited[r + 1][c + 1] || visited[r - 1][c + 1]) {
                dfs(r, c + 1, step + 1);
            }
        }

        visited[r][c] = false;
    }

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        path = in.nextLine();
        for (int i = 0; i<9; i++) {
            visited[0][i] = true;
            visited[8][i] = true;
            visited[i][0] = true;
            visited[i][8] = true;
        }
        dfs(1, 1, 0);
        out.println(ans);
    }
}
