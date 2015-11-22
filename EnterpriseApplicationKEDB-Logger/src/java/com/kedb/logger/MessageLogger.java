/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.logger;

import javax.ejb.Singleton;
import org.apache.log4j.Logger;

/**
 *
 * @author iscuro
 */
@Singleton
public class MessageLogger implements MessageLoggerLocal {

    private static Logger logger = Logger.getLogger(MessageLogger.class);
    
    @Override
    public void logError(String message) {
        this.logger.error(message);        
    }
    
    @Override
    public void logDebug(String message) {
        this.logger.debug(message);
        //System.out.println(message);
    }

    @Override
    public void logInfo(String message) {
        this.logger.info(message);
        //System.out.println(message);
    }
    
    
}
