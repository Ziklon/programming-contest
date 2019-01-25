package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.Stack;

public class BGameWithString {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Stack<Character> stack = new Stack<>();
    String s = in.readLine();
    int moves = 0;
    for (char c : s.toCharArray()) {
      if (stack.isEmpty() || !stack.peek().equals(c)) stack.push(c);
      else {
        stack.pop();
        moves++;
      }
    }
    out.printLine(moves % 2 == 0 ? "No" : "Yes");
  }
}
