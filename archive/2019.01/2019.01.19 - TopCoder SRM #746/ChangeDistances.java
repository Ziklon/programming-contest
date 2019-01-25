package com.darkbit.problems;

public class ChangeDistances {
  final int INF = 1 << 20;

  public String[] findGraph(String[] g) {
    int n = g.length;

    for (int i = 0; i < n; ++i) {
      char[] s = new char[n];
      for (int j = 0; j < n; ++j) {
        if (i == j || g[i].charAt(j) == '1') s[j] = '0';
        else s[j] = '1';
      }
      g[i] = new String(s);
    }

    return g;
  }
}
