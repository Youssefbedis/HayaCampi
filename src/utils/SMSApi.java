/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author user
 */
public class SMSApi {
     public SMSApi() {
    }
    public static final String ACCOUNT_SID = "AC1da0e7a237199e2c6f7ce95e27e4fa33";
    public static final String AUTH_TOKEN = "b4ad15dd9bee68dbb13c317e0ca29902";

    public void sendSMS(String num, String msg) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                new PhoneNumber("+21655986553"),
                new PhoneNumber("+19894399770"),

                "Centre added !, " + msg).create();

        System.out.println(message.getSid());

    }
    
}
