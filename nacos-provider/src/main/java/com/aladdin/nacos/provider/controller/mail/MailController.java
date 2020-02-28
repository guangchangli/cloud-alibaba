package com.aladdin.nacos.provider.controller.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

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
        simpleMailMessage.setTo("guangchangde@126.com");
        simpleMailMessage.setFrom("ceryss@126.com");
        javaMailSender.send(simpleMailMessage);
        return HttpStatus.OK.getReasonPhrase();
    }

    /**
     * 复杂邮件
     */
    @GetMapping("/sendComplex")
    public String sendComplexMail() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setSubject("系统异常通知");
        mimeMessageHelper.setText("<b style='color:red'>系统异常</b>",true);
        mimeMessageHelper.setTo("guangchangde@126.com");
        mimeMessageHelper.setFrom("ceryss@126.com");
//        String[] ccList = new String[]{"", ""};//抄送人列表
//        String[] bccList = new String[]{"", ""};//密送人列表
//        mimeMessageHelper.setCc(ccList);
//        mimeMessageHelper.setBcc(bccList);
        //上传文件
        mimeMessageHelper.addAttachment("ts&kb_1.jpg",new File("/Users/lgc/Pictures/EPPOgyOXsAcUkEi.jpeg"));
        mimeMessageHelper.addAttachment("ts&kb_2.jpg",new File("/Users/lgc/Pictures/EPPNsBWU4AAjvve.jpeg"));
        javaMailSender.send(mimeMessage);
        return HttpStatus.OK.getReasonPhrase();
    }
}
