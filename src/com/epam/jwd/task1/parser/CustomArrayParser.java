package com.epam.jwd.task1.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.jwd.task1.exception.ServiceException;
import com.epam.jwd.task1.entity.CustomArray;
import com.epam.jwd.task1.validation.CustomArrayValidator;

public class CustomArrayParser {

	private static final Logger LOGGER = LogManager.getLogger(CustomArrayParser.class.getName());
	private String splitterRegex = "\\s";

	public CustomArrayParser() {
		LOGGER.info("creating new CustonArrayParser()");
	}

	public CustomArrayParser(String splitterRegex) {
		LOGGER.info("creating new CustomArrayParser(" + splitterRegex + ")");
		this.splitterRegex = splitterRegex;
	}

	public CustomArray parse(String line) throws ServiceException {
		LOGGER.info("parse");
		CustomArrayValidator validator = new CustomArrayValidator();
		if (!validator.isCustomArrayLineCorrect(line)) {
			throw new ServiceException("Incorrect line: '" + line + "'");
		}
		if (line.isEmpty()) {
			return new CustomArray();
		}
		String[] lineParts = line.split(splitterRegex);
		System.out.print(lineParts);
		int[] arrayElements = parseIntArrayFromStringArray(lineParts);
		return new CustomArray(arrayElements);
	}

	private int[] parseIntArrayFromStringArray(String[] strings) {
		LOGGER.info("parse int[] from String[]");
		int[] ints = new int[strings.length];
		for (int i = 0; i < ints.length; i++) {
			ints[i] = Integer.parseInt(strings[i]);
		}
		return ints;
	}

}
