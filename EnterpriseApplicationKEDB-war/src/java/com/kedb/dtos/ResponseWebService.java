/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.dtos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gonzalo
 */
@XmlRootElement
public class ResponseWebService {

    private String message;

    public ResponseWebService() {
    }

    public ResponseWebService(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        //TODO: definir codigos para identificar los errores
        return "ResponseWebService{message=" + message + '}';
    }
}
