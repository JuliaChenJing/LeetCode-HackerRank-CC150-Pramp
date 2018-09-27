package pramp.life_question;

public class BusiestTimeInOneMall {

	/*
	 * The Westfield Mall management is trying to figure out what the busiest
	 * moment at the mall was last year. You’re given data extracted from the
	 * mall’s door detectors. Each data point is represented as an integer array
	 * whose size is 3. The values at indices 0, 1 and 2 are the time stamp, the
	 * count of visitors, and whether the visitors entered or exited the mall (0
	 * for exit and 1 for entrance), respectively. Here’s an example of a data
	 * point: [ 1440084737, 4, 0 ].
	 * 
	 * Note that time is given in a Unix format called Epoch, which is a
	 * nonnegative integer holding the number of seconds that have elapsed since
	 * 00:00:00 UTC, Thursday, 1 January 1970.
	 * 
	 * Given an array, data, of data points, write a function findBusiestPeriod
	 * that returns the time at which the mall reached its busiest moment last
	 * year. The return value is the time stamp, e.g. 1480640292. Note that if
	 * there is more than one period with the same visitor peak, return the
	 * earliest one.
	 * 
	 * Assume that the array data is sorted in an ascending order by the time
	 * stamp. Explain your solution and analyze its time and space complexities.
	 */
	static int findBusiestPeriod(int[][] data) {
		int num = 0;
		int max = 0;
		int time = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i][2] == 1) {
				num += data[i][1];
				if (max < num) {
					//this moment not finished calculation yet
					if (i+1 < data.length && data[i][0] == data[i + 1][0])
						continue;
					max = num;
					time = data[i][0];
					System.out.println(max);
				}
			}
			else {
				num -= data[i][1];
			}
		}
		return time;
	}

	public static void main(String[] args) {

		int[][] data =                // entering - leaving     sum
			 { { 1487799425, 14, 1 }, //  8                      8
				{ 1487799425, 4, 0 }, 
				{ 1487799425, 2, 0 },

				{ 1487800378, 10, 1 }, // 10                     18

				{ 1487801478, 18, 0 }, //  0                     18
				{ 1487801478, 18, 1 },

				{ 1487901013, 1, 0 }, //  -1                     17

				{ 1487901211, 7, 1 }, //   0                     17
				{ 1487901211, 7, 0 } };

		System.out.println(findBusiestPeriod(data));
	}
}