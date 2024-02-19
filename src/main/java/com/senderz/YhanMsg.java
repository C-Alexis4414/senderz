package com.senderz;

import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvException;

import java.net.URI;
import java.math.BigDecimal;

public class YhanMsg {
    // Find your Account Sid and Token at twilio.com/console
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
    final String ACCOUNT_SID = dotenv.get("ACCOUNT_SID");
    final String AUTH_TOKEN = dotenv.get("AUTH_TOKEN");
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(dotenv.get("PERSONAL_PHONE_NUMBER")),
                new com.twilio.type.PhoneNumber(dotenv.get("VIRTUAL_PHONE_NUMBER")),
                "Coucou ! C'est Alexis depuis YhanMsg \uD83D\uDE00 !")

                        .create();

        System.out.println(message.getSid());
    }
}