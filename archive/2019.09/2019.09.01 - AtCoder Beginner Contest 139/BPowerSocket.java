package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class BPowerSocket {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int a = in.readInt();
        int b = in.readInt();

        int now = 1;
        int cnt = 0;
        while (true) {
            if (now >= b) break;
            now--;
            now += a;
            cnt++;
        }
        out.printLine(cnt);
    }
}
