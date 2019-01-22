package de.ssmits.javaUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HasLogger is a feature interface that provides Logging capability for anyone
 * implementing it where logger needs to operate in serializable environment
 * without being static.
 * 
 * @author Sascha Smits
 */
public interface HasLogger {
    /**
     * Returns a default logger instance dedicated to the implementing class.
     * 
     * @return Logger instance
     * 
     * @see org.slf4j.Logger
     */
    default Logger getLogger() {
        return LoggerFactory.getLogger(getClass());
    }
    
    /**
     * Returns a default logger instance dedicated to the specified class.
     * 
     * @param cls Class to get a logger instance for
     * @return Logger instance
     * 
     * @see org.slf4j.Logger
     */
    default Logger getLogger(Class<?> cls) {
    	return LoggerFactory.getLogger(cls);
    }
}
