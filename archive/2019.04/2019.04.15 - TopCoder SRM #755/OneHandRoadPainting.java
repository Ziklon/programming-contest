package com.darkbit.problems;

public class OneHandRoadPainting {
  public long fastest(int[] dStart, int[] dEnd, int paintPerBrush) {

    int n = dStart.length;
    long walk = 0;
    long remaining = 0;

    for (int i = n - 1; i >= 0; --i) {
      long end = dEnd[i];
      long start = dStart[i];

      if (remaining >= (end - start)) {
        remaining -= end - start;
        continue;
      }
      end -= remaining;

      long whole = (end - start + paintPerBrush - 1) / paintPerBrush;

      long first = end;
      long last = end - (whole - 1) * paintPerBrush;
      walk += (first + last) * whole;
      remaining = whole * paintPerBrush - (end - start);
    }

    return walk;
  }
}
