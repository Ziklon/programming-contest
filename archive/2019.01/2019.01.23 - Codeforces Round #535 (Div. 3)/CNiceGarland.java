package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CNiceGarland {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    String s = in.readLine();
    char[] t = "RGB".toCharArray();
    int ans = 1 << 30;

    int[] seqAns = new int[3];

    for (int i = 0; i < 3; ++i)
      for (int j = 0; j < 3; ++j)
        for (int k = 0; k < 3; ++k) {
          if (i == j || i == k || j == k) continue;
          int[] perm = {i, j, k};

          int cost = 0;
          for (int v= 0; v < n; ++v) {
            char u = t[perm[v % 3]];
            if (s.charAt(v) != u) cost++;
          }
          if(cost < ans){
            seqAns = Arrays.copyOf(perm,3);
            ans = cost;
          }
        }
    out.printLine(ans);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; ++i) sb.append(t[seqAns[i % 3]]);
    out.print(sb.toString());
  }
}
