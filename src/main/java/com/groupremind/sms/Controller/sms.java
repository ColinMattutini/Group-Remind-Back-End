package com.groupremind.sms.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
public class sms{

    private String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    private String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");


    @GetMapping(value = "/sendSMS")
    public ResponseEntity<String> sendSMS(@RequestBody String messageText) {

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        //TO number
        Message.creator(new PhoneNumber(""),
                //FROM Number
                new PhoneNumber(""), "Hello from Twilio 📞").create();

        return new ResponseEntity<String>("Message sent successfully", HttpStatus.OK);
    }
}