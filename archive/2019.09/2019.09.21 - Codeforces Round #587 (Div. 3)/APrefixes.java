package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class APrefixes {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        char[] s = in.readString().toCharArray();

        int a = 0, b = 0;
        StringBuilder sb = new StringBuilder();
        int cost =0;
        for (char c : s) {

            if (c == 'a') a++;
            else b++;
            sb.append(c);
            if ((a + b) % 2 == 0) {
                if (a != b) {
                    cost++;
                    sb.delete(sb.length() - 2, sb.length());
                    sb.append("ab");
                    a = b;
                }
            }
        }
        out.printLine(cost);
        out.printLine(sb);


    }
}
