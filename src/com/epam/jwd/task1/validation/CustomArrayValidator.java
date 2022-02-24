package com.epam.jwd.task1.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.regex.Pattern;

public class CustomArrayValidator {

	private static final Logger LOGGER = LogManager.getLogger(CustomArrayValidator.class.getName());
	private final String CUSTOM_ARRAY_REGEX = "\\s*((0|-?[1-9]\\d*)\\s+)*(0|-?[1-9]\\d*)\\s*";

	public void CustomArrayLineValidator() {
		LOGGER.info("creating new CustomArrayLineValidator()");
	}

	public boolean isCustomArrayLineCorrect(String line) {
		LOGGER.info("is CustomArray line correct");
		if (line != null && !line.isEmpty()) {
			return Pattern.matches(CUSTOM_ARRAY_REGEX, line);
		}
		return false;
	}
}
