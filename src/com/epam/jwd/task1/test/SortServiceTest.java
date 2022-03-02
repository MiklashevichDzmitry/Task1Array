package com.epam.jwd.task1.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.epam.jwd.task1.entity.CustomArray;
import com.epam.jwd.task1.exception.ServiceException;
import com.epam.jwd.task1.service.impl.SortServiceImpl;

class SortServiceTest {

	private final CustomArray testArray = new CustomArray();
	private SortServiceImpl sortErvice = new SortServiceImpl();
	
	@Test
	void testSort() throws ServiceException {

		sortErvice.bubbleSort(testArray);
		System.out.print(testArray);

	}
}
