package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class BBlocks {

    List<Integer> play(char[] s, char c) {
        List<Integer> ans1 = new ArrayList<>();
        for (int i = 0; i + 1 < s.length; ++i) {
            if (s[i] != c) {
                s[i] = invert(s[i]);
                s[i + 1] = invert(s[i + 1]);
                ans1.add(i + 1);
            }
        }
        for (char ci : s) if (ci != c) return null;
        return ans1;
    }

    char invert(char c) {
        if (c == 'W') return 'B';
        return 'W';
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n = in.readInt();
        char[] s = in.readString().toCharArray();

        List<Integer> ans1 = play(s.clone(), 'B');
        List<Integer> ans2 = play(s.clone(), 'W');

        if (ans1 != null) {
            out.printLine(ans1.size());
            out.printLine(ans1.toArray());
        } else if (ans2 != null) {
            out.printLine(ans2.size());
            out.printLine(ans2.toArray());
        } else {
            out.printLine(-1);
        }

    }
}
