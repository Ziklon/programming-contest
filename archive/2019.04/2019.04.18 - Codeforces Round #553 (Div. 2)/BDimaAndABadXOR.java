package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.Arrays;

public class BDimaAndABadXOR {

  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.readInt(), m = in.readInt();

    int[][] grid = in.readIntTable(n, m);

    int ans = 0;
    for (int i = 0; i < n; ++i) ans ^= grid[i][0];

    if (ans == 0) {
      for (int i = 0; i < n; ++i) {

        for (int j = 1; j < m; ++j) {

          int ret = grid[i][0] ^ grid[i][j] ^ ans;
          if (ret != 0) {
            out.printLine("TAK");
            int arr[] = new int[n];
            Arrays.fill(arr, 1);
            arr[i] = j + 1;
            out.printLine(arr);
            return;
          }
        }
      }
      out.printLine("NIE");
    } else {
      out.printLine("TAK");
      int arr[] = new int[n];
      Arrays.fill(arr, 1);
      out.printLine(arr);
    }
  }
}
