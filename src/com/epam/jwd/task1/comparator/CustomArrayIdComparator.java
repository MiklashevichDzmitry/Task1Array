package com.epam.jwd.task1.comparator;

import com.epam.jwd.task1.entity.CustomArray;

public class CustomArrayIdComparator {

	public int compare(CustomArray firstArray, CustomArray secondArray) {
		return Integer.compare(firstArray.getId(), secondArray.getId());
	}

}
