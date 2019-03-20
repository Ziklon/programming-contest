package com.darkbit.problems;

public class CalkinWilf {
  public int[] findRational(String path) {

    int a = 1, b = 1;

    for (char c : path.toCharArray()) {
      if (c == 'L') {
        b = a + b;
      } else {
        a = a + b;
      }
    }

    return new int[] {a, b};
  }
}
