package com.darkbit.problems;

import net.egork.generated.collections.list.IntArrayList;
import net.egork.generated.collections.list.IntList;

import java.util.Arrays;

public class OneHandSort {
  public int[] sortShelf(int[] target) {

    int n = target.length;
    int[] copy = Arrays.copyOf(target, n);

    IntList ans = new IntArrayList();

    Arrays.sort(copy);

    for (int i = 0; i < target.length; ++i) {
      if (target[i] == copy[i]) continue;
      for (int j = i + 1; j < n; ++j)
        if (target[j] == copy[i]) {
          swap(i, j, target);
          ans.add(i);
          ans.add(j);
          ans.add(n);
        }
    }
    return ans.toArray();
  }

  void swap(int i, int j, int[] arr) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
