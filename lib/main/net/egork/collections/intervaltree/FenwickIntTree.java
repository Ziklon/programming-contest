package net.egork.collections.intervaltree;

public class FenwickIntTree {

  int[] bit;

  public FenwickIntTree(int size) {
    bit = new int[size];
  }

  public FenwickIntTree(int[] seq) {
    this(seq.length);
    for (int i = 0; i < seq.length; ++i) add(i, seq[i]);
  }

  public int sum(int idx) {
    int ret = 0;
    for (; idx >= 0; idx = (idx & (idx + 1)) - 1) ret += bit[idx];
    return ret;
  }

  public int sum(int l, int r) {
    return sum(r) - sum(r - 1);
  }

  public void add(int idx, int delta) {
    for (; idx < bit.length; idx = idx | (idx + 1)) bit[idx] += delta;
  }
}
