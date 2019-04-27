package com.sweedalplatina.task.test;

import org.junit.Test;

import com.sweedalplatina.task.StringCalculator;
import org.junit.Assert;

public class StringCalculatorTest {

	@Test
	public void stringCalcAddTest() throws Exception {

		// String Calculator - test for input given in section 1.b
		Assert.assertEquals("No elements in the String", StringCalculator.add(""), 0);

		// String Calculator - test for input given in section 1.d
		Assert.assertEquals("Addition of numbers separated by Comma", StringCalculator.add("1,2,5"), 8);

		// String Calculator - test for input given in section 2.a
		Assert.assertEquals("Addition when next line is used", StringCalculator.add("1\n,2,3"), 6);

		// String Calculator - test for input given in section 2.b
		Assert.assertEquals("Add method failed.", StringCalculator.add("1,\n2,4"), 7);

		// String Calculator - test for input given in section 3.c
		Assert.assertEquals("Add method failed.", StringCalculator.add("//;\n1;3;4"), 8);

		// String Calculator - test for input given in section 3.e.i
		Assert.assertEquals("Add method failed.", StringCalculator.add("//$\n1$2$3"), 6);

		// String Calculator - test for input given in section 3.e.ii
		Assert.assertEquals("Add method failed.", StringCalculator.add("//@\n2@3@8"), 13);

		// String Calculator - test for input given in section Bonus 1.a
		Assert.assertEquals("Numbers above 1000 to be ignored", StringCalculator.add("2,1001"), 2);

		// String Calculator - test for input given in section Bonus 2.a
		Assert.assertEquals("Arbitary delimiter length", StringCalculator.add("//***\n1***2***3"), 6);

		// String Calculator - test for input given in section Bonus 3.a
		Assert.assertEquals("Multiple delimiters", StringCalculator.add("//$,@\n1$2@3"), 6);

		// String Calculator - test for input given in section Bonus 4
		Assert.assertEquals("No elements in the String", StringCalculator.add("//$,@@,SP\n1$2@@3SP5"), 11);
	}

	@Test(expected = Exception.class)
	public void stringCalcAddFailTest() throws Exception {
		// String Calculator - test for input given in section 4
		StringCalculator.add("1,3,-4");
	}

}
