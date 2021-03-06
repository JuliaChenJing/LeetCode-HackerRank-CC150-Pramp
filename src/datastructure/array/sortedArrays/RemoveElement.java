package datastructure.array.sortedArrays;

//https://leetcode.com/problems/remove-element/description/
public class RemoveElement {

	/*
	 * Given an array and a value, remove all instances of that value in place
	 * and return the new length.
	 * 
	 * Do not allocate extra space for another array, you must do this in place
	 * with constant memory.
	 * 
	 * The order of elements can be changed. It doesn't matter what you leave
	 * beyond the new length.
	 * 
	 * Example: Given input array nums = [3,2,2,3], val = 3
	 * 
	 * Your function should return length = 2, with the first two elements of
	 * nums being 2.
	 */

	public static void main(String[] args) {
		System.out.println(removeElement(new int[] {}, 1));
		System.out.println(removeElement(new int[] { 1, 1 }, 1));
		System.out.println(removeElement(new int[] { 1, 3, 2 }, 1));
	}

	public static int removeElement(int[] nums, int val) {
		if (nums == null || nums.length == 0)
			return 0;
		int i = 0;
		for (int n : nums)
			if (n != val)
				nums[i++] = n;
		return i;
	}
}
