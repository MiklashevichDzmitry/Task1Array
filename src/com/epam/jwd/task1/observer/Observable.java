package com.epam.jwd.task1.observer;

import com.epam.jwd.task1.exception.ServiceException;

public interface Observable {

    void attach(CustomArrayObserver observer);
    void detach(CustomArrayObserver observer);
    void notifyObserver() throws ServiceException;

}