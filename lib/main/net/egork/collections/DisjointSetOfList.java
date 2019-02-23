package net.egork.collections;

import java.util.Arrays;

public class DisjointSetOfList {
  public int[] upper;
  public int[] next;
  public int[] last;

  public DisjointSetOfList(int n) {
    upper = new int[n];
    Arrays.fill(upper, -1);
    next = new int[n];
    last = new int[n];
    Arrays.fill(next, -1);
    for (int i = 0; i < n; ++i) last[i] = i;
  }

  public int root(int u) {
    return upper[u] < 0 ? u : (upper[u] = root(upper[u]));
  }

  public boolean equiv(int u, int v) {
    return root(u) == root(v);
  }

  public boolean union(int u, int v) {
    u = root(u);
    v = root(v);
    if (u != v) {
      if (upper[v] < upper[u]) {
        int w = v;
        v = u;
        u = w;
      }
      upper[u] += upper[v];
      upper[v] = u;
      next[last[u]] = v;
      last[u] = last[v];
    }
    return u == v;
  }

  public int count() {
    int ct = 0;
    for (int e : upper) if (e < 0) ct++;
    return ct;
  }
}
