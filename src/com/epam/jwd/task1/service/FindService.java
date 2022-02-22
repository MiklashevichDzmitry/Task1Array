package com.epam.jwd.task1.service;

import com.epam.jwd.task1.entity.CustomArray;
import com.epam.jwd.task1.exception.ServiceException;

public interface FindService {
	
	double FindAverageValue(CustomArray array) throws ServiceException;
	
	int FindMax(CustomArray array) throws ServiceException;
	
	int FindMin(CustomArray array) throws ServiceException;
	
	int FindPositive(CustomArray array) throws ServiceException;
	
	int FindNegative(CustomArray array) throws ServiceException;
	
	int FindSum(CustomArray array) throws ServiceException;
	
	void ChangeElements(CustomArray array) throws ServiceException;

}
