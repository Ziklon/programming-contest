package com.darkbit.problems;

public class MissingDwarf {
  public int getHeight(int[] otherHeights) {

    int sum = 0;
    int maxi = 0;
    for (int e : otherHeights) {
      sum += e;
      maxi = Math.max(e, maxi);
    }

    for (int a = maxi + 1; ; ++a) {

      if ((sum + a) % 7 == 0) {
        return a;
      }
    }
  }
}
