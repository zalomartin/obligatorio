/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.messageReceiver;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import com.kedb.logger.MessageLoggerLocal;


@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/Queue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class MeessageReceiver implements MessageListener {

    public MeessageReceiver() {
    }

    @EJB
    private MessageLoggerLocal logger;

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                TextMessage textMessage = (TextMessage) message;
                System.out.println("MDB - Message received OK: " + textMessage.getText());
                logger.logInfo("MDB - Message received OK: " + textMessage.getText());
            } catch (JMSException ex) {
                Logger.getLogger(MeessageReceiver.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
