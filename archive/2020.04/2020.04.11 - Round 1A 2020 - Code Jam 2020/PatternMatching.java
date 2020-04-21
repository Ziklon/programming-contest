package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class PatternMatching {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        String[] words = new String[n];
        String[] prefixes = new String[n];
        String[] suffixes = new String[n];

        String pref = "", suf = "";
        out.print(String.format("Case #%d: ", testNumber));

        for (int i = 0; i < n; ++i) {
            words[i] = in.readString();
            prefixes[i] = words[i].substring(0, words[i].indexOf('*'));
            suffixes[i] = words[i].substring(words[i].lastIndexOf('*') + 1);

            if (prefixes[i].length() > pref.length())
                pref = prefixes[i];
            if (suffixes[i].length() > suf.length())
                suf = suffixes[i];
        }

        for (int i = 0; i < n; ++i) {
            if (!pref.startsWith(prefixes[i])) {
                out.printLine("*");
                return;
            }
            if (!suf.endsWith(suffixes[i])) {
                out.printLine("*");
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(pref);
        for (String s : words) {
            for (char c : s.toCharArray())
                if (c != '*')
                    sb.append(c);
        }
        sb.append(suf);
        out.printLine(sb.toString());
    }
}
