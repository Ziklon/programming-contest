package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CConnect {

  int[] dx = {0, 0, -1, 1};
  int[] dy = {1, -1, 0, 0};

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int r1 = in.readInt() - 1, c1 = in.readInt() - 1;
    int r2 = in.readInt() - 1, c2 = in.readInt() - 1;

    String[] grid = new String[n];
    for (int i = 0; i < n; ++i) grid[i] = in.readString();

    int dist[][] = new int[n + 1][n + 1];
    ArrayUtils.fill(dist, Integer.MAX_VALUE);

    PriorityQueue<int[]> Q = new PriorityQueue<>(Comparator.comparingInt(p -> p[0]));
    Q.add(new int[] {0, 0, r1, c1});

    dist[r1][c1] = 0;
    while (!Q.isEmpty()) {
      int[] cur = Q.poll();

      int curDis = cur[0];

      if (cur[2] == r2 && cur[3] == c2) {
        out.printLine(curDis);
        return;
      }
      for (int i = 0; i < 4; ++i) {
        int nx = cur[2] + dx[i];
        int ny = cur[3] + dy[i];
        if (Math.min(nx, ny) < 0 || Math.max(nx, ny) >= n) continue;

        if (dist[nx][ny] > curDis && grid[nx].charAt(ny) == '0') {
          Q.add(new int[] {curDis, cur[1], nx, ny});
          dist[nx][ny] = curDis;
        }
      }
      
      if (cur[1] > 0) continue;
      for (int i = 0; i < n; i++)
        for (int j = 0; j < n; ++j) {
          if (grid[i].charAt(j) == '1') continue;

          int dis = (cur[2] - i) * (cur[2] - i) + (cur[3] - j) * (cur[3] - j);
          if (dist[i][j] > curDis + dis) {
            dist[i][j] = curDis + dis;
            Q.add(new int[] {dist[i][j], 1, i, j});
          }
        }
    }
  }
}
