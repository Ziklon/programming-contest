package com.darkbit.problems;

import net.egork.chelper.task.Test;
import net.egork.chelper.tester.TestCase;

import java.util.*;

public class BMinimumTernaryStringTestCase {
  @TestCase
  public Collection<Test> createTests() {

    Random r = new Random();
    List<Test> tests = new ArrayList<>();
    for (int i = 0; i < 10; ++i) {
      int n = r.nextInt(20) + 1;
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < n; ++j) {
        char c = (char) (r.nextInt(3) + '0');
        sb.append(c);
      }

      tests.add(new Test(sb.toString(), solveStupid(sb.toString())));
    }

    return tests;
  }

  private String solveStupid(String s) {
    char[] ss = s.toCharArray();

    for (int i = 0; i + 1 < s.length(); ++i) {
      if (ss[i] - ss[i + 1] == 1) {
        char tmp = ss[i];
        ss[i + 1] = tmp;
        ss[i] = tmp;
        return solveStupid(new String(ss));
      }
    }
    return new String(ss);
  }
}
