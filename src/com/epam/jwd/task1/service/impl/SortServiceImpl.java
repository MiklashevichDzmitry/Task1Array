package com.epam.jwd.task1.service.impl;

import com.epam.jwd.task1.entity.CustomArray;
import com.epam.jwd.task1.exception.ServiceException;

public class SortServiceImpl {

	public void bubbleSort(CustomArray array) throws ServiceException {

		int[] sourceArray = array.getArray();

		if (sourceArray.length > 1) {

			boolean needIteration = true;

			while (needIteration) {
				needIteration = false;

				for (int i = 1; i < sourceArray.length; i++) {

					if (sourceArray[i] < sourceArray[i - 1]) {
						swap(sourceArray, i, i - 1);
						needIteration = true;
					}
				}
			}
		}

		array.setArray(sourceArray);
	}

	public void choiceSort(CustomArray array) {

		int[] sourceArray = array.getArray();

		if (sourceArray.length > 1) {

			for (int left = 0; left < sourceArray.length; left++) {

				int minInd = left;

				for (int i = left; i < sourceArray.length; i++) {
					if (sourceArray[i] < sourceArray[minInd]) {
						minInd = i;
					}
				}
				swap(sourceArray, left, minInd);
			}
		}

		array.setArray(sourceArray);
	}

	public void insertSort(CustomArray array) {

		int[] sourceArray = array.getArray();

		if (sourceArray.length > 1) {

			for (int left = 0; left < sourceArray.length; left++) {

				int value = sourceArray[left];

				int i = left - 1;

				for (; i >= 0; i--) {

					if (value < sourceArray[i]) {
						sourceArray[i + 1] = sourceArray[i];
					} else {

						break;
					}
				}

				sourceArray[i + 1] = value;
			}
		}

		array.setArray(sourceArray);
	}

	private void swap(int[] array, int ind1, int ind2) {
		int tmp = array[ind1];
		array[ind1] = array[ind2];
		array[ind2] = tmp;
	}

}
