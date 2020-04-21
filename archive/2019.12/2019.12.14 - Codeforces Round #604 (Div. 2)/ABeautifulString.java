package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ABeautifulString {


    boolean isBeaty(char[] s, int from, int to) {
        char prev = s[from];

        for (int i = from + 1; i <= to; ++i) {
            if (s[i] == prev) return false;
            prev = s[i];
        }

        return true;
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String beaty = "abc";

        char[] s = in.readString().toCharArray();


        for (int i = 0; i < s.length; ++i) {

            int min = Math.max(0, i - 1);
            int max = Math.min(i + 1, s.length - 1);

            char cur = s[i];

            boolean hasFound = false;
            for (int j = 0; j < 3; ++j) {

                if (cur == '?') s[i] = beaty.charAt(j);

                if (isBeaty(s, min, max)) {
                    hasFound = true;
                    break;
                }
            }
            if (!hasFound) {
                out.printLine(-1);
                return;
            }

        }
        out.printLine(new String(s));

    }
}
