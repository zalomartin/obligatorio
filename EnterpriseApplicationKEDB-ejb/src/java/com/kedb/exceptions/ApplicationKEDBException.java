/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.exceptions;

import javax.ejb.ApplicationException;

/**
 *
 * @author nacho
 */
@ApplicationException
public class ApplicationKEDBException extends Exception {
    private static final long serialVersionUID = 1L;
    public ApplicationKEDBException() {
        super();
    }
    public ApplicationKEDBException(String message) {
        super(message);
    }
    public ApplicationKEDBException(String message, Throwable cause) {
        super(message, cause);
    }
}
