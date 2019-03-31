package net.egork.collections.intervaltree;

public class RMQ {

  int[] A;
  int n;
  int[][] M;

  public RMQ(int[] InputArray) {
    A = InputArray;
    n = A.length;
    M = new int[n][n];
    fill_M();
  }

  private void fill_M() {
    for (int i = 0; i < n; i++)
      for (int j = i; j < n; j++) {
        if (i == j) M[i][j] = i;
        else M[i][j] = A[j] < A[M[i][j - 1]] ? j : M[i][j - 1];
        M[j][i] = M[i][j];
      }
  }

  public int query(int i, int j) {
    return M[i][j];
  }
}
