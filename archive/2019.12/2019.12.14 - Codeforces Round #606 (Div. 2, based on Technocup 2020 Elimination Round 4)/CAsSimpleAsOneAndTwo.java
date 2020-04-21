package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CAsSimpleAsOneAndTwo {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        char[] s = in.readString().toCharArray();
        int n = s.length;

        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i + 1 < n; ++i) {
            String t = s[i - 1] + "" + s[i] + "" + s[i + 1];
            if (t.equals("one") || t.equals("two")) {
                if (i + 2 < n && s[i + 1] != s[i + 2]) {
                    s[i + 1] = '?';
                    ans.add(i + 2);
                } else {
                    s[i] = '?';
                    ans.add(i + 1);
                }
            }
        }
        out.printLine(ans.size());
        out.printLine(ans.toArray());

    }

}
