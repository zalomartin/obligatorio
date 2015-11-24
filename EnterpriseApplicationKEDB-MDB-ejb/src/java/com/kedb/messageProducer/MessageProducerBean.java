/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.messageProducer;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

/**
 *
 * @author iscuro
 */



@Stateless
public class MessageProducerBean implements MessageProducerBeanLocal {
    
    @Resource(lookup = "ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "jms/Queue")
    private Queue queue;
    
    @Override
    public void theMessage(String theMessage) {
        try{
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(queue);
            TextMessage message = session.createTextMessage();
            message.setText(theMessage);
            producer.send(message);
            connection.close();
        
        }catch (Exception ex) { 
            Logger.getLogger(MessageProducerBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
