package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class AReachableNumbers {

  int count = 0;

  Set<Integer> s;

  int f(int x) {
    x = x + 1;
    while (x % 10 == 0) x /= 10;
    return x;
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    s = new HashSet<>();

    int n = in.readInt();
    s.add(n);
    for(;;){
        int next = f(n);
        if(s.contains(next))break;
        s.add(next);
        n = next;

    }

    out.printLine(s.size());

  }
}
