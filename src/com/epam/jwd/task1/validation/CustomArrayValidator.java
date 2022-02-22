package com.epam.jwd.task1.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArrayValidator {

	private static final Logger LOGGER = LogManager.getLogger(CustomArrayValidator.class.getName());
	private final String customArrayRegex = "\\s*-?\\d+(\\s*;\\s*-?\\d+)*\\s*";

	public void CustomArrayLineValidator() {
		LOGGER.info("creating new CustomArrayLineValidator()");
	}

	public boolean isCustomArrayLineCorrect(String line) {
		LOGGER.info("is CustomArray line correct");
		return line != null && (line.isEmpty() || line.matches(customArrayRegex));
	}

}
