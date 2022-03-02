package com.epam.jwd.task1.reader;

import com.epam.jwd.task1.entity.*;
import com.epam.jwd.task1.exception.ServiceException;
import com.epam.jwd.task1.reader.parser.*;
import com.epam.jwd.task1.reader.validation.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CustomReader {

	private static final Logger LOGGER = LogManager.getLogger(CustomReader.class);
	private static CustomReader instance;

	private CustomArrayParser parser = new CustomArrayParser();
	private CustomArrayValidator validator = new CustomArrayValidator();

	public static CustomReader getInstance() {
		if (instance == null) {
			instance = new CustomReader();
		}
		return instance;
	}

	public int[] read(String path) throws ServiceException {

		if (path.isEmpty()) {
			LOGGER.log(Level.ERROR, "the path is empty");
			throw new ServiceException("the path is empty");
		}
		if (!(new File(path)).exists()) {
			LOGGER.log(Level.ERROR, "file doesn't exist");
			throw new ServiceException("file doesn't exist");
		}
		try (FileReader reader = new FileReader(path)) {

			BufferedReader bufferedReader = new BufferedReader(reader);
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				if (validator.isCustomArrayLineCorrect(line)) {
					reader.close();
					parser.parse(line);
				}
			}
			LOGGER.log(Level.ERROR, "data is not valid");
			throw new ServiceException("data is not valid");
		} catch (IOException ex) {
			LOGGER.log(Level.ERROR, "failed to read file");
			throw new ServiceException("failed to read file");
		}
	}

	public List<CustomArray> readAll(String path) throws ServiceException {

		List<CustomArray> customArrays = new LinkedList<>();;

		if (path.isEmpty()) {
			LOGGER.log(Level.ERROR, "the path is empty");
			throw new ServiceException("the path is empty");
		}
		if (!(new File(path)).exists()) {
			LOGGER.log(Level.ERROR, "file doesn't exist");
			throw new ServiceException("file doesn't exist");
		}
		try (FileReader reader = new FileReader(path)) {
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				if (validator.isCustomArrayLineCorrect(line)) {
					CustomArray z = parser.parse(line);
					customArrays.add(z);
				}
			}
			return customArrays;
		} catch (IOException ex) {
			LOGGER.log(Level.ERROR, "failed to read file");
			throw new ServiceException("failed to read file");
		}
	}
}
