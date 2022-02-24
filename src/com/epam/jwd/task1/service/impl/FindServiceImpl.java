package com.epam.jwd.task1.service.impl;

import com.epam.jwd.task1.entity.CustomArray;
import com.epam.jwd.task1.service.FindService;
import com.epam.jwd.task1.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FindServiceImpl implements FindService {

	private static final Logger LOGGER = LogManager.getLogger();
	
	public double FindAverageValue(CustomArray array) throws ServiceException {

		int[] sourceArray = array.getArray();
		int sum = 0;
		double averageValue = 0;

		if (sourceArray.length != 0) {

			for (int j : sourceArray) {

				sum += j;

			}
			averageValue = sum / sourceArray.length;
		}
		return averageValue;
	}

	public int FindMax(CustomArray array) throws ServiceException {

		if (array == null || array.length() == 0) {
			LOGGER.info("Array equals null or array length equals 0");
			throw new ServiceException("Array equals null or array length equals 0");
		}

		int[] sourceArray = array.getArray();
		int maxNum = sourceArray[0];

		if (sourceArray.length != 0) {
			for (int j : sourceArray) {

				if (j > maxNum) {

					maxNum = j;
				}
			}
		}
		return maxNum;
	}

	public int FindMin(CustomArray array) throws ServiceException {

		int[] sourceArray = array.getArray();
		int minNum = sourceArray[0];

		if (sourceArray.length != 0) {

			for (int j : sourceArray) {

				if (j < minNum) {

					minNum = j;
				}
			}
		}
		return minNum;
	}

	public int FindPositiveNumbers(CustomArray array) throws ServiceException {

		int[] sourceArray = array.getArray();
		int positiveMumber = 0;

		if (sourceArray.length != 0) {

			for (int j : sourceArray) {

				if (j > 0) {

					positiveMumber++;

				}
			}
		}

		return positiveMumber;
	}

	public int FindNegativeNumbers(CustomArray array) throws ServiceException {

		int[] sourceArray = array.getArray();
		int negativeMumber = 0;

		if (sourceArray.length != 0) {

			for (int j : sourceArray) {

				if (j < 0) {

					negativeMumber++;

				}
			}
		}

		return negativeMumber;
	}

	public int FindSum(CustomArray array) throws ServiceException {

		int[] sourceArray = array.getArray();
		int sum = 0;

		if (sourceArray.length != 0) {

			for (int j : sourceArray) {

				sum += j;

			}
		}

		return sum;

	}

	public void ChangeElements(CustomArray array) throws ServiceException {

		int[] sourceArray = array.getArray();

		if (sourceArray.length != 0) {
			for (int j : sourceArray) {

				if (j == 0) {

					sourceArray[j] = 1;
				}
			}
		}
	} 
}
