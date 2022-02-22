package com.epam.jwd.task1.service;

import com.epam.jwd.task1.entity.CustomArray;
import com.epam.jwd.task1.exception.ServiceException;

public interface SortService {

	void bubbleSort(CustomArray array) throws ServiceException;
	
	void choiceSort(CustomArray array) throws ServiceException;
	
	void insertSort(CustomArray array) throws ServiceException;
	
}
