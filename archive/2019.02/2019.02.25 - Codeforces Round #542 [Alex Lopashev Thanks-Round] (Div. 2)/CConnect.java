package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class CConnect {
  int[][] color;
  int[] dx = {0, 0, -1, 1};
  int[] dy = {1, -1, 0, 0};

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), r1 = in.readInt() - 1, c1 = in.readInt() - 1;
    int r2 = in.readInt() - 1, c2 = in.readInt() - 1;
    color = new int[n][n];
    String[] grid = new String[n];

    for (int i = 0; i < n; ++i) grid[i] = in.readString();
    dfs(r1, c1, 1, grid);

    if (color[r2][c2] == 1) {
      out.printLine(0);
      return;
    }
    dfs(r2, c2, 2, grid);
    int ans = 1 << 30;
    for (int i = 0; i < n; ++i)
      for (int j = 0; j < n; ++j) {
        if (color[i][j] == 1) {
          for (int a = 0; a < n; ++a)
            for (int b = 0; b < n; ++b)
              if (color[a][b] == 2) {
                int dist = (a - i) * (a - i) + (b - j) * (b - j);
                ans = Math.min(ans, dist);
              }
        }
      }
    out.printLine(ans);
  }

  private void dfs(int r1, int c1, int curColor, String[] grid) {
    color[r1][c1] = curColor;
    for (int i = 0; i < 4; ++i) {
      int x = r1 + dx[i];
      int y = c1 + dy[i];
      if (Math.min(x, y) >= 0 && Math.max(x, y) < grid.length && color[x][y] ==0 && grid[x].charAt(y) == '0') {
        dfs(x, y, curColor, grid);
      }
    }
  }
}
