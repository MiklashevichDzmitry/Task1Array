package com.epam.jwd.task1.entity;

import com.epam.jwd.task1.exception.ServiceException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CustomArrayWarehouse {

    private static final Logger LOGGER = LogManager.getLogger(CustomArrayWarehouse.class);
    private static CustomArrayWarehouse instance;
    private Map<Integer, CustomArrayParameters> customArrayValuesMap;

    public CustomArrayWarehouse() {
        customArrayValuesMap = new HashMap<>();
    }

    public static CustomArrayWarehouse getInstance() {
        if (instance == null) {
            instance = new CustomArrayWarehouse();
        }
        return instance;
    }

    public Map<Integer, CustomArrayParameters> getCustomArrayValuesMap() {
        return customArrayValuesMap;
    }

    public void setCustomArrayValuesMap(Map<Integer, CustomArrayParameters> customArrayValuesMap) throws ServiceException {
        if (customArrayValuesMap == null) {
            LOGGER.log(Level.ERROR, "Null pointer");
            throw new ServiceException("Null pointer");
        }
        this.customArrayValuesMap = customArrayValuesMap;
    }

    public void put(Integer id, CustomArrayParameters customArrayValues) throws ServiceException {
        if(customArrayValues==null){
            LOGGER.log(Level.ERROR, "Null pointer");
            throw new ServiceException("Null pointer");
        }
        customArrayValuesMap.put(id, customArrayValues);
    }

    public void remove(Integer id) {
        customArrayValuesMap.remove(id);
    }

    public CustomArrayParameters get(Integer id) throws ServiceException {
        CustomArrayParameters customArrayParameters = customArrayValuesMap.get(id);
        if (customArrayParameters == null) {
            LOGGER.log(Level.ERROR, "CustomArrayValues is null");
            throw new ServiceException("CustomArrayValues is null");
        }
        return customArrayParameters;
    }
}