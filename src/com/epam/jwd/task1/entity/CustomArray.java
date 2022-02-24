package com.epam.jwd.task1.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class CustomArray {

	private static final Logger LOGGER = LogManager.getLogger();

	private int[] array;

	public CustomArray() {
		LOGGER.info("creating new CustomArray()");
		array = new int[0];
	}

	public CustomArray(int... array) {
		LOGGER.info("creating new CustomArray(" + Arrays.toString(array) + ")");
		this.array = array != null ? array.clone() : null;;
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
}
