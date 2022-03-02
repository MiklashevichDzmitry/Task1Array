package com.epam.jwd.task1.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.epam.jwd.task1.exception.ServiceException;
import com.epam.jwd.task1.reader.parser.CustomArrayParser;

class ParserTest {

	private CustomArrayParser parser = new CustomArrayParser();
	private final String stringToParse = "1 -25 0 36 13 -2";

	@Test
	public void parseCorrectStringTest() throws ServiceException {
		System.out.print(parser.parse(stringToParse));
	}
}
