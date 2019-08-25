package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class AStockArbitraging {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt(), m = in.readInt(), e = in.readInt();

        int min = ArrayUtils.minElement(in.readIntArray(n));
        int max = ArrayUtils.maxElement(in.readIntArray(m));
        if (min >= max) out.printLine(e);
        else {

            int items = (e / min);
            out.printLine(items * max + (e % min));
        }
    }
}
