package datastructure.array;

import java.util.*;

//给定一个整形数组，是�?�能找出其中的两个数使其和为�?个指定的值？
/*
  输入数组是有�?的�?�？
你�?�以�?�定是无�?的。
 */
public class Sum_I {
	public static void main(String[] args) {
		System.out.println(hasSum(new int[] { 3, 4, 1, 2, 9 }, 4));
	}

	/*
	 * 举例 
	 * 输入数组为{1,5,7,3}以�?�指定的目标值为10，我们�?�以从中找出两个数3和7，和为10.
	 *  �?考
	 * 一�?�?�常直观的办法就是使用两个循环，从组里�??�?�一个数，然�?�在该数之�?�的部分找出�?�外一个数，计算这两个数之和，看看是�?�等于指定的值。
	 * 这�?暴力破解的方法显然�?是�?�试官想�?的。那么，能�?��?低暴力破解O（n*n）的时间�?�?�度呢？
	 * 
	 * �?试先把该数组排�?，排�?之�?�，从首�?两端移动，一次移动一端的指针，直至相�?�或找出两个数的和为指定的值为止。
	 * �?�设当�?首�?指针分别为i和j，其中i<j,如果A[i]与A[j]之和大于指定的值，那么�?找的两个数一定在j的左侧，因此，尾指针j往�?移动一步。
	 * 如果A[i]与A[j]之和�?于指定的值，那么�?找的两个数一定在i的�?�侧，所以首指针i往�?�移动一步。
	 * 
	 * 通过排�?，使得时间�?�?�度�?至O(nlogn)。在while循环里，至多扫�??一�??数组就�?�以得出结果。能�?�继续�?低时间�?�?�度呢？
	 * 如果�?许使用�?外的存储空间，那么答案是�?�以，详�?“两数之和II�?。
	 */
	static boolean hasSum(int[] A, int target) {
		boolean res = false;
		if (A == null || A.length < 2)
			return res;

		Arrays.sort(A);//注�?： �?�以调用系统自带的排�?算法

		int i = 0;
		int j = A.length - 1;
		while (i < j) {
			if (A[i] + A[j] == target) {
				res = true;
				break;
			} else if (A[i] + A[j] > target) {
				j--;// 目标值过�?，则�?��?移动尾部指针，�?�?两数和
			} else {
				i++;// 目标值过大，则�?��?�移动首部指针，增加两数和
			}
		}
		return res;
	}
}
