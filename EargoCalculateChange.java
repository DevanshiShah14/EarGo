import java.util.ArrayList;
import java.util.List;

public class EargoCalculateChange {
	public static void main(String[] args) {
		EargoCalculateChange obj = new EargoCalculateChange();
		//testcases
		obj.executeAndPrintResult(2L);
		obj.executeAndPrintResult(30L);
		obj.executeAndPrintResult(37L);
		obj.executeAndPrintResult(1092L);
		obj.executeAndPrintResult(0L);
		obj.executeAndPrintResult(21L);
	}

	/**
	 * Method to get result back and print the result
	 * 
	 * @param cents
	 */
	public void executeAndPrintResult(long cents) {
		List<Long> result = calculateChange(cents);
		if (result.size() == 4) {
			System.out.println(String.format("%d cents = %d quarters, %d dimes, %d nickels, %d cents ", cents,
					result.get(0), result.get(1), result.get(2), result.get(3)));
		} else {
			throw new RuntimeException("Invalid Result");
		}
	}

	/**
	 * Method to calculate quarters,dimes, nickels,cents from cent value.
	 * 
	 * @param cents
	 * @return
	 */
	public List<Long> calculateChange(long cents) {
		long change = 0;
		List<Long> ans = new ArrayList<>();
		if (cents >= 25) { // check if change can be given in quarters
			change = cents / 25;
			ans.add(change);
			cents -= change * 25;
		} else
			ans.add(0L);
		if (cents >= 10) { // check if change can be given in dimes
			change = cents / 10;
			ans.add(change);
			cents -= change * 10;
		} else
			ans.add(0L);
		if (cents >= 5) { // check if change can be given in nickels
			change = cents / 5;
			ans.add(change);
			cents -= change * 5;
		} else
			ans.add(0L);
		if (cents >= 1) { // check if change can be given in pennies
			change = cents / 1;
			ans.add(change);
			cents -= change * 1;
		} else
			ans.add(0L);
		return ans;
	}
}
