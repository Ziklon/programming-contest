package net.egork.collections.intervaltree;

import org.junit.Assert;
import org.junit.Test;

public class SumIntervalTreeTest {

  @Test
  public void testSumIntervalTreeSuccess() {
    long[] seq = {1, 2, 3, 4, 5}; // initial array
    SumIntervalTree tree = new SumIntervalTree(seq);
    Assert.assertEquals(15, tree.query(0, 4));
    tree.update(0,1, 2); // will become {3 , 4, 3, 4, 5}
    Assert.assertEquals(19, tree.query(0, 4));
  }


}
