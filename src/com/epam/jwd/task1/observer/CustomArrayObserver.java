package com.epam.jwd.task1.observer;

import com.epam.jwd.task1.exception.ServiceException;

public interface CustomArrayObserver {
    void update(CustomArrayEvent customArrayEvent) throws ServiceException;
}