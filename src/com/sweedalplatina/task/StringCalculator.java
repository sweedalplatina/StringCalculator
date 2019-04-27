package com.sweedalplatina.task;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	/**
	 * Method to add numbers provided in a String irrespective of the
	 * delimiter/custom delimiter. Numbers greater than 1000 are ignored. Negative
	 * numbers throw an exception.
	 * 
	 * @param numbers
	 * @return integer value.
	 * @throws Exception When Negative numbers are provided as input
	 */
	public static int add(String numbers) throws Exception {
		String delimiter = ",\n";

		if (numbers.startsWith("//")) {
			delimiter = numbers.substring(numbers.indexOf("//") + 2, numbers.indexOf("\n"));

			String[] arrayOfNumbers = delimiter.split("[,]");
			for (String s : arrayOfNumbers) {
				delimiter = delimiter + s;
			}
			numbers = numbers.substring(numbers.indexOf("\n"), numbers.length());
		}
		delimiter = "[" + delimiter + "]";

		return add(numbers, delimiter);
	}

	private static int add(final String numbers, final String delimiter) throws Exception {
		int sum = 0;
		String[] arrayOfNumbers = numbers.split("[" + delimiter + "]");
		List<Integer> negativeNumbers = new ArrayList<Integer>();

		for (String result : arrayOfNumbers) {
			if (!result.trim().isEmpty()) {
				int numberSignCheck = Integer.parseInt(result.trim());
				if (numberSignCheck < 0) {
					negativeNumbers.add(numberSignCheck);
					throw new Exception("Negatives not allowed" + negativeNumbers.toString());
				} else if (numberSignCheck <= 1000) {
					sum += numberSignCheck;
				}
			}
		}

		if (negativeNumbers.size() > 0) {
			throw new Exception("Negatives not allowed" + negativeNumbers.toString());
		}
		return sum;
	}
}
