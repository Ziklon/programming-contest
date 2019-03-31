package com.darkbit.problems;

public class KerimJavati {
  public int howLong(String text) {

    int ans = 0;

    for (char c : text.toCharArray()) {
      int times = (c - 'a');
      ans += (times) * 2;
      ans += 1;
    }

    return ans;
  }
}
