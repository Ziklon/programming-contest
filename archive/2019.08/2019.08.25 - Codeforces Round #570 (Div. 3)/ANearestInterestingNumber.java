package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.numbers.IntegerUtils;

public class ANearestInterestingNumber {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        while (IntegerUtils.sumDigits(n + "") % 4 != 0) n++;
        out.printLine(n);
    }
}
