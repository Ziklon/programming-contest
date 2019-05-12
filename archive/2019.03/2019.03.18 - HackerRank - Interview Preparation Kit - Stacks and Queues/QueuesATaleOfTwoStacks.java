package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.Stack;

public class QueuesATaleOfTwoStacks {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int q = in.readInt();
    Stack<Integer> S = new Stack<>(), T = new Stack<>();

    for (int i = 0; i < q; ++i) {
      int t = in.readInt();
      if (t == 1) {
        int e = in.readInt();
        S.push(e);
      } else {

        if (T.isEmpty()) while (!S.isEmpty()) T.push(S.pop());

        if (t == 2) {
          T.pop();
        } else {
          out.printLine(T.peek());
        }
      }
    }
  }
}
