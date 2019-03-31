package com.darkbit.problems;

import net.egork.misc.MiscUtils;
import org.omg.CORBA.MARSHAL;

public class CCChecker2 {
  public String check(
      int n,
      int[] startRow,
      int[] startCol,
      int[] destRow,
      int[] destCol,
      int[] moveStartRow,
      int[] moveStartCol,
      int[] moveDestRow,
      int[] moveDestCol) {

    MiscUtils.decreaseByOne(startCol, startRow, destCol, destRow);
    MiscUtils.decreaseByOne(moveStartCol, moveStartRow, moveDestCol, moveDestRow);

    int grid1[][] = new int[n][n];
    int grid2[][] = new int[n][n];

    int color = 1;
    for (int i = 0; i < startCol.length; ++i) {
      grid1[startRow[i]][startCol[i]] = color++;
    }
    color = 1;
    for (int i = 0; i < destCol.length; ++i) {
      grid2[destRow[i]][destCol[i]] = color++;
    }

    for (int i = 0; i < moveStartCol.length; ++i) {
      int x1 = moveStartRow[i], y1 = moveStartCol[i];
      int x2 = moveDestRow[i], y2 = moveDestCol[i];

      int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);

      if (dist != 1) return "invalid";
      if (Math.min(x1, y1) < 0 || Math.max(x1, y1) >= n) return "invalid";
      if (Math.min(x2, y2) < 0 || Math.max(x2, y2) >= n) return "invalid";

      if (grid1[x1][y1] == 0) return "invalid";
      if (grid1[x2][y2] != 0) return "invalid";
      int val = grid1[x1][y1];
      grid1[x1][y1] -= val;
      grid1[x2][y2] += val;
    }

    for (int i = 0; i < n; ++i)
      for (int j = 0; j < n; ++j) if (grid1[i][j] != grid2[i][j]) return "invalid";

    return "valid";
  }
}
