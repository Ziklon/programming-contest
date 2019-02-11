package com.darkbit.problems;

public class IdenticalBags {

  boolean isOk(long bags, long bagSize, long[] candyes) {
    long sum = 0;
    for (long e : candyes) {
      sum += e / bags;
    }
    return sum >= bagSize;
  }

  public long makeBags(long[] candy, long bagSize) {

    long low = 0, hih = Long.MAX_VALUE;

    while (hih - low > 1) {
      long mid = (hih + low) >> 1;
      if (isOk(mid, bagSize, candy)) low = mid;
      else hih = mid;
    }

    return low;
  }
}
