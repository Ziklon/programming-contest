package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CMinimalString {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.readString();

    int[] mini = new int[s.length() + 1];
    mini[s.length()] = 27;
    for (int i = s.length() - 1; i >= 0; --i) {
      mini[i] = Math.min(mini[i + 1], s.charAt(i) - 'a');
    }

    Stack<Character> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length(); ++i) {
      stack.add(s.charAt(i));
      while (!stack.isEmpty() && mini[i] >= stack.peek() - 'a') {
        sb.append(stack.pop());
      }
    }
    while (!stack.isEmpty()) sb.append(stack.pop());

    out.printLine(sb);
  }
}
