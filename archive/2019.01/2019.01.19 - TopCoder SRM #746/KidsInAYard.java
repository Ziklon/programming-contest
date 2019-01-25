package com.darkbit.problems;

public class KidsInAYard {
  public int howMany(int r2, int r3, int r5) {
    int ans = 0;

    for (int i = 1; ; ++i) {
        if(i%2 == r2 && i%3 == r3 && i%5 == r5){
            return i;
        }
    }
  }
}
