package datastructure.array.sortedArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
 */
public class CombinationSum_II {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		   List<List<Integer>> list = new LinkedList<List<Integer>>();
		   Arrays.sort(candidates);
		   backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
		   return list;
		}

		private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] cand, int remain, int start) {
		   
		   if(remain < 0) return; /** no solution */
		   else if(remain == 0) list.add(new ArrayList<>(tempList));
		   else{
		      for (int i = start; i < cand.length; i++) {
		         if(i > start && cand[i] == cand[i-1]) continue; /** skip duplicates */
		         tempList.add(cand[i]);
		         backtrack(list, tempList, cand, remain - cand[i], i+1);
		         tempList.remove(tempList.size() - 1);
		      }
		   }
		}
}
