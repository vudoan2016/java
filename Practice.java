import java.util.Scanner;
import java.io.File;
import java.io.IOException;
    
public class Practice {
    public static void main(String[] args) {
	Scanner s = null;
	try {
	    s = new Scanner (new File("square_ut.txt"));
	} catch (IOException e) {
	    System.out.println(e);
	}
	final int max_squares = 100;
	int x[] = new int[max_squares];
	int i = 0, month = 0, day = 0, size = 0;

	if (s.hasNextInt()) {
	    size = s.nextInt();
	}
	while (i < size) {
	    x[i++] = s.nextInt();
	}
	size++;
	if (s.hasNextInt()) {
	    day = s.nextInt();
	}
	if (s.hasNextInt()) {
	    month = s.nextInt();
	}

	System.out.println(countSquares(x, size, month, day) + " of contiguous " + month +
			   "-squares of sum " + day);
    }

    /* https://www.hackerrank.com/challenges/the-birthday-bar/problem */
    private static int countSquares(int[] x, int size, int month, int day) {
	int count = 0, sum = 0;
	for (int i = 0; i < month; i++) {
	    sum += x[i];
	}
	if (sum == day)
	    count++;
	for (int i = 1; i < size-month+1; i++) {
	    sum -= x[i-1];
	    sum += x[i+month-1];
	    System.out.println("i = " + i + " sum = " + sum + " count = " + count);
	    for (int j = i; j < i+month; j++) {
		System.out.print(x[j] + " ");
	    }
	    System.out.println();
	    if (sum == day) {
		count++;
	    }
	}
	return count;
    }

    /* https://www.hackerrank.com/challenges/divisible-sum-pairs/problem */
}
