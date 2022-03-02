package com.epam.jwd.task1.observer.impl;

import com.epam.jwd.task1.entity.CustomArray;
import com.epam.jwd.task1.entity.CustomArrayParameters;
import com.epam.jwd.task1.entity.CustomArrayWarehouse;
import com.epam.jwd.task1.exception.ServiceException;
import com.epam.jwd.task1.observer.CustomArrayEvent;
import com.epam.jwd.task1.observer.CustomArrayObserver;
import com.epam.jwd.task1.service.impl.*;

public class CustomArrayObserverImpl implements CustomArrayObserver {
	@Override
	public void update(CustomArrayEvent event) throws ServiceException {
		
			CustomArray array = event.getSource();

			FindServiceImpl findArrayElement = new FindServiceImpl();

			CustomArrayParameters customArrayParameters = CustomArrayWarehouse.getInstance().get(array.getId());

			customArrayParameters.setMin(findArrayElement.FindMin(array));
			customArrayParameters.setMax(findArrayElement.FindMax(array));
			customArrayParameters.setAverage(findArrayElement.FindAverageValue(array));
			customArrayParameters.setSum(findArrayElement.FindSum(array));

	}
}