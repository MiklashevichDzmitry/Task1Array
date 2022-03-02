package com.epam.jwd.task1.specification.impl;

import com.epam.jwd.task1.entity.CustomArray;
import com.epam.jwd.task1.specification.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArrayAverageEqualsSpecification implements CustomArraySpecification {

	private double numberToCompare;

	public CustomArrayAverageEqualsSpecification(double numberToCompare) {
		this.numberToCompare = numberToCompare;
	}

	@Override
	public boolean specify(CustomArray array) {
		if (array == null || array.length() == 0) {
			return false;
		}

		boolean result = false;
		double sum = array.getElement(0);
		for (int i = 1; i < array.length(); i++) {
			sum += array.getElement(i);
		}

		result = numberToCompare == sum / array.length();

		return result;
	}
}