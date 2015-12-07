/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.configurations;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private Configuration() {
    }

    public static String getString(String key) {
        String ret = null;
        Properties prop = new Properties();
        try {
            InputStream in = Configuration.class.getResourceAsStream("configuration.properties");
            prop.load(in);
            ret = prop.getProperty(key, '!' + key + '!');
            in.close();
        } catch (IOException e) {
            return '!' + key + '!';
        }
        return ret;
    }
}
