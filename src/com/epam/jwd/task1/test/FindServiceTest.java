package com.epam.jwd.task1.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.epam.jwd.task1.entity.CustomArray;
import com.epam.jwd.task1.exception.ServiceException;
import com.epam.jwd.task1.service.impl.FindServiceImpl;


class FindServiceTest {

	@Test
	void testFind() {

		int[] array = {1, 5, 4, 3, 7};
		CustomArray testArray = new CustomArray();
		testArray.setArray(array);

		FindServiceImpl findService = new FindServiceImpl();

		try {
			System.out.println(findService.FindMax(testArray) + "\n");
		} catch (ServiceException e) {
			System.out.println(e.getClass() + "\n");
		}

	}

}
