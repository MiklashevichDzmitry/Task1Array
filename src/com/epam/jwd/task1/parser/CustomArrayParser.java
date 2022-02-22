package com.epam.jwd.task1.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.jwd.task1.exception.ServiceException;
import com.epam.jwd.task1.entity.CustomArray;
import com.epam.jwd.task1.validation.CustomArrayValidator;

public class CustomArrayParser {
	
	private static final Logger LOGGER = LogManager.getLogger(CustomArrayParser.class.getName());
    private String splitterRegex;

    public CustomArrayParser() {
        LOGGER.info("creating new CustonArrayParser()");
        splitterRegex = "\\s*;\\s*";
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
        if (line.startsWith(" ") || line.endsWith(" ")) {
            line = deleteSpacesFromStartAndEnd(line);
        }
        String[] lineParts = line.split(splitterRegex);
        int[] arrayElements = parseIntArrayFromStringArray(lineParts);
        return new CustomArray(arrayElements);
    }

    private String deleteSpacesFromStartAndEnd(String line) {
        LOGGER.info("delete spaces from start and end");
        int startIndex = foundFirstNotSpaceCharIndex(line);
        int endIndex = foundLastNotSpaceCharIndex(line) + 1;
        String newLine = line.substring(startIndex, endIndex);
        return newLine;
    }

    private int foundLastNotSpaceCharIndex(String line) {
        LOGGER.info("found last not space char");
        for (int i = line.length() - 1; i >= 0; i--) {
            if (line.charAt(i) != ' ') {
                return i;
            }
        }
        return -1;
    }

    private int foundFirstNotSpaceCharIndex(String line) {
        LOGGER.info("found first not spase char");
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) != ' ') {
                return i;
            }
        }
        return -1;
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
