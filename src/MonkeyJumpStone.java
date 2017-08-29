
public class MonkeyJumpStone {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, -1, 0, 2, 3, 5 }, 3));// 2
		System.out.println(solution(new int[] { 3, 2, 1 }, 1));// 3
		System.out.println(solution(new int[] { 1, 2, 3, 4, -1, -1, -1 }, 3));// -1
		System.out.println(jumpleAble(new boolean[] { false, false, true }, 3));// true
		System.out.println(jumpleAble(new boolean[] { false, false, true }, 2));// false
		System.out.println(jumpleAble(new boolean[] { false, false }, 3));// true
		System.out.println(jumpleAble(new boolean[] { false, false, false }, 2));// false
		System.out.println(jumpleAble(new boolean[] { true, true, true }, 1));// true
	}

	public static int solution(int[] A, int D) {
		// write your code in Java SE 8

		boolean[] stones = new boolean[A.length];

		for (int i = 0; i < A.length; i++) {
			stones[i] = false;
			for (int j = 0; j < A.length; j++) {
				if (A[j] == -1)
					continue;
				if (A[j] <= i)
					stones[i] = true;
			}
			if (jumpleAble(stones, D)){
				
				return i;
			}
				
		}
		return -1;
	}

	private static boolean jumpleAble(boolean[] stones, int D) {
		int left = -1;
		int right = 0;
		// for (boolean b : stones)
		// System.out.print(b+" : ");
		while (right < stones.length) {
			if (stones[right]) {
				if (right - left > D)
					return false;
				else {
					right++;
					left = right;
				}
			}

			right++;

		}

		if (!stones[right - 2])
			return stones.length - left > D ? false : true;
		return true;
	}
}
