package com.epam.jwd.task1.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.jwd.task1.exception.ServiceException;
import com.epam.jwd.task1.observer.CustomArrayEvent;
import com.epam.jwd.task1.observer.CustomArrayObserver;
import com.epam.jwd.task1.observer.Observable;
import com.epam.jwd.task1.observer.impl.CustomArrayObserverImpl;
import com.epam.jwd.task1.util.IdGenerator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CustomArray implements Observable {

	private static final Logger LOGGER = LogManager.getLogger();

	private int[] array;
	private int arrayId;
	private List<CustomArrayObserver> observers = new LinkedList<>();

	public CustomArray() {
		LOGGER.info("creating new CustomArray()");
		array = new int[0];
	}

	public CustomArray(int... array) throws ServiceException {
		LOGGER.info("creating new CustomArray(" + Arrays.toString(array) + ")");
		this.array = array != null ? array.clone() : null;

		arrayId = Integer.parseInt(IdGenerator.generate());
		(CustomArrayWarehouse.getInstance()).put(arrayId, new CustomArrayParameters());
		attach(new CustomArrayObserverImpl());
		notifyObserver();
	}

	public int length() {
		return array.length;
	}

	public int[] getArray() {
		LOGGER.info("get elements");
		return array != null ? array.clone() : null;
	}

	public void setArray(int[] array) {
		LOGGER.info("setArray(" + Arrays.toString(array) + ")");
		this.array = array.clone();
	}

	public int getElement(int index) {
		if (index < 0 || index >= array.length) {
			return 0;
		}

		return array[index];
	}

	public void setElement(int index, int value) throws ServiceException {
		if (value < 0 || value > array.length) {
			LOGGER.info("for the size of array");
			throw new ServiceException("for the size of array");
		}
		array[index] = value;

		notifyObserver();
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		for (int a : array) {
			sb.append(a).append(" ");
		}

		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		CustomArray customArray = (CustomArray) o;
		if (customArray.array == null || this.array == null) {
			return this.array == null && customArray.array == null;
		}
		if (customArray.array.length != this.array.length) {
			return false;
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] != customArray.array[i]) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		return array.hashCode();
	}

	public int getId() {
		return arrayId;
	}

	@Override
	public void notifyObserver() throws ServiceException {
		CustomArrayEvent event = new CustomArrayEvent(this);
		if (!observers.isEmpty()) {
			for (CustomArrayObserver o : observers) {
				o.update(event);
			}
		}
	}

	@Override
	public void attach(CustomArrayObserver observer) {
		if (observer != null) {
			observers.add(observer);
		}
	}

	@Override
	public void detach(CustomArrayObserver observer) {
		observers.remove(observer);

	}
}
