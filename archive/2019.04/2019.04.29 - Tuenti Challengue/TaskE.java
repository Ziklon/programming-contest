package com.darkbit.problems;

import net.egork.generated.collections.pair.IntIntPair;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class TaskE {
    String[] keyboard = {"1234567890", "QWERTYUIOP", "ASDFGHJKL;", "ZXCVBNM,.-"};


    IntIntPair lookUp(char c) {
        for (int i = 0; i < keyboard.length; ++i)
            for (int j = 0; j < keyboard[i].length(); ++j) {
                if (keyboard[i].charAt(j) == c) {
                    return IntIntPair.makePair(i, j);
                }
            }
        throw new RuntimeException();

    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        char name = in.readLine().charAt(0);
        char[] text = in.readLine().toCharArray();
        char last = text[text.length - 1];

        IntIntPair p = lookUp(name);
        IntIntPair q = lookUp(last);

        int x1 = p.first - q.first;
        int y1 = p.second - q.second;

        for (int i = 0; i < text.length; ++i) {
            if (Character.isSpaceChar(text[i])) continue;
            IntIntPair r = lookUp(text[i]);
            int x2 = (r.first + x1 + 4) % 4;
            int y2 = (r.second + y1 + 10) % 10;
            text[i] = keyboard[x2].charAt(y2);
        }
        out.printLine(String.format("Case #%d: %s", testNumber, new String(text)));

    }
}
