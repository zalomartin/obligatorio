/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.logger;

import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author iscuro
 */
@Local
public interface MessageLoggerLocal {

    void logError(String message);

    void logDebug(String message);

    void logInfo(String message);

}
