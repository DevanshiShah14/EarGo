import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EargoCalculateChange {
	public static void main(String[] args) {
		EargoCalculateChange obj = new EargoCalculateChange();
		Scanner reader = new Scanner(System.in);
		//testcases
				obj.executeAndPrintResult(-2L);
				obj.executeAndPrintResult(30L);
				obj.executeAndPrintResult(3L);
				obj.executeAndPrintResult(1092L);
				obj.executeAndPrintResult(0L);
				obj.executeAndPrintResult(Integer.MAX_VALUE+1L);
		// user input
				while(true) {
					System.out.print("Press -1 to exit. \n");
					System.out.print("Input: ");
			        // nextInt() reads the next integer from the keyboard
			        long number = reader.nextInt();
			        if (number == -1) {
			        	break;
			        }
			        obj.executeAndPrintResult(number);
				}
	}

	/**
	 * Method to get result back and print the result
	 * 
	 * @param cents
	 */
	public void executeAndPrintResult(long cents) {
		List<Long> result = calculateChange(cents);
		if(result==null) {
			System.out.println(cents + " cents = Invalid Input");
		}
		else {
			System.out.println(String.format("%d cents = %d quarters, %d dimes, %d nickels, %d cents ", cents,
					result.get(0), result.get(1), result.get(2), result.get(3)));
		} 
	}

	/**
	 * Method to calculate quarters,dimes, nickels,cents from cent value.
	 * 
	 * @param cents
	 * @return
	 */
	public List<Long> calculateChange(long cents) {
		if(cents< 0) {
			return null;
		}
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
