package com.aladdin.nacos.provider.controller.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lgc
 * @create 2020-02-28
 **/
@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    JavaMailSenderImpl javaMailSender;

    @GetMapping("/send")
    public String sendMail() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("系统异常通知");
        simpleMailMessage.setText("xxxxxx");
        simpleMailMessage.setTo("");
        simpleMailMessage.setFrom("");
        javaMailSender.send(simpleMailMessage);
        return HttpStatus.OK.getReasonPhrase();
    }
}
