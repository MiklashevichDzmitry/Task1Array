package com.epam.jwd.task1.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.epam.jwd.task1.entity.CustomArray;
import com.epam.jwd.task1.exception.ServiceException;
import com.epam.jwd.task1.service.impl.FindServiceImpl;

class FindServiceTest {

	private final CustomArray testArray = new CustomArray();
	private FindServiceImpl findService = new FindServiceImpl();

	@Test
	void testFindMax() throws ServiceException {

		int actual = findService.FindMax(testArray);
		int result = 454654;
		assertEquals(result, actual);

	}
 
	@Test
	void testFindMin() throws ServiceException {

		int actual = findService.FindMin(testArray);
		int result = -42323;
		assertEquals(result, actual);

	}

	@Test
	void testFindAverageValue() throws ServiceException {

		double actual = findService.FindAverageValue(testArray);
		double result = 58941.0;
		assertEquals(result, actual);

	}

	@Test
	void testFindNegative() throws ServiceException {

		int actual = findService.FindNegativeNumbers(testArray);
		int result = 2;
		assertEquals(result, actual);

	}
	
	@Test
	void testFindPositive() throws ServiceException {

		int actual = findService.FindPositiveNumbers(testArray);
		int result = 5;
		assertEquals(result, actual);

	}
	
	@Test
	void testChangeElements() throws ServiceException {

		findService.ChangeElements(testArray);


	}

}
