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
		int[] result = buySellStock(arr);
		System.out.println(String.format("Input : %s - Buying Day: %s, Selling Day: %s ", Arrays.toString(arr), result[0], result[1]));
	}

	/**
	 * Helper method to return the buy and sell day for max profit
	 * 
	 * @param arr
	 * @return
	 */

	public int[] buySellStock(int[] arr) {
		int[] BuySellarr = new int[2];
		Arrays.fill(BuySellarr, -1);
		if (arr.length == 0 || arr.length == 1)
			return BuySellarr;
		
		int buy = 0;
		int maxProfit = Integer.MIN_VALUE;

		for (int i = 1; i < arr.length; i++) {
			if (arr[buy] < arr[i]) {
				if(arr[i]-arr[buy] > maxProfit) {
					BuySellarr[0] = buy+1;
					BuySellarr[1] = i+1;
					maxProfit = arr[i]-arr[buy];
				}				
			} else if (arr[buy]> arr[i]) {
				buy = i;
			}
		}
		
		//Print max profit
		if(maxProfit!= Integer.MIN_VALUE) {
			System.out.println("Max Profit is: "+ maxProfit);
		}
		
		return BuySellarr;
	}
}