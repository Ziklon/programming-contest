package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class CLongBeautifulInteger {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt(), k = in.readInt();
        char[] s = in.readString().toCharArray();
        char[] t = s.clone();

        out.printLine(n);

        for (int i = k; i < n; ++i) {
            t[i] = t[i - k];
        }
        if (isGreaterOrEqual(t, s)) {
            out.printLine(new String(t));
        } else {

            for (int i = k - 1; i >= 0; --i) {
                if (t[i] == '9')
                    t[i] = '0';
                else {
                    ++t[i];
                    break;
                }
            }
            for (int i = k; i < n; ++i) {
                t[i] = t[i - k];
            }
            out.printLine(new String(t));
        }
    }

    boolean isGreaterOrEqual(char[] t, char[] s) {
        for (int i = 0; i < s.length; ++i) {
            if (t[i] > s[i]) return true;
            if (t[i] < s[i]) return false;
        }
        return true;
    }
}
