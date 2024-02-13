package com.lightbringer.medapp.infra.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValueNotFoundException extends RuntimeException {

    private static final Logger logger = LoggerFactory.getLogger(ValueNotFoundException.class);

    public ValueNotFoundException(String message) {
        super(message);
        logger.error(message, this);
    }

}
