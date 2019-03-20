package com.darkbit.problems;

public class CalkinWilfReversed {

  public long getDepth(long a, long b) {

    if (Math.min(a, b) == 1) return Math.max(a, b) - 1;
    if (a > b) return getDepth(a % b, b) + a / b;
    return getDepth(a, b % a) + b / a;
  }
}
