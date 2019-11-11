import java.util.Arrays;

public class EargoBuySell {
	public static void main(String[] args) {
		EargoBuySell obj = new EargoBuySell();
		// testcases
		int[] caseA = { 2, 10, 1, 5, 6, 9 };
		obj.executeAndPrintResult(caseA);

		int[] caseB = { 3, 8, 8, 55, 38, 1, 7, 42, 54, 53 };
		obj.executeAndPrintResult(caseB);

		int[] caseC = { 6, 5, 4, 3, 2, 1 };
		obj.executeAndPrintResult(caseC);

		int[] caseD = { 1, 2, 3, 4, 5, 6, 7 };
		obj.executeAndPrintResult(caseD);
	}

	/**
	 * Method to get result back and print the result
	 * 
	 * @param arr
	 */

	public void executeAndPrintResult(int[] arr) {
		int result = buySellStock(arr);
		System.out.println(String.format("Input : %s - max Profit: %s ", Arrays.toString(arr), result));
	}

	/**
	 * Helper method to return the max profit
	 * 
	 * @param arr
	 * @return
	 */

	public int buySellStock(int[] arr) {
		if (arr.length == 0 || arr.length == 1)
			return 0;

		int buy = arr[0];
		int maxProfit = Integer.MIN_VALUE;

		for (int i = 1; i < arr.length; i++) {
			if (buy < arr[i]) {
				maxProfit = Math.max(maxProfit, arr[i] - buy);
			} else if (buy > arr[i]) {
				buy = arr[i];
			}
		}

		return maxProfit == Integer.MIN_VALUE ? 0 : maxProfit;
	}
}