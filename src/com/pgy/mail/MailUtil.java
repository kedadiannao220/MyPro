package com.pgy.mail;

import com.idcos.cloud.biz.common.check.FormChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtil {
    private static JavaMailSenderImpl jmsi;

    private static Logger Logger = LoggerFactory.getLogger(MailUtil.class);

    private static final String DEFAULT_ENCODING = "UTF-8";

    public static void sendMail(MailBody body) {
        Logger.info("验证参数.....");
        FormChecker.check(body);
        Logger.info("开始发送短信.......");
        jmsi = getJavaMailSendImpl();
        setJavaMailProperties(body);
        setAuthenticator(body);
        sendMail(jmsi.createMimeMessage(), body);

        Logger.info("发送完成!");
    }

    private static JavaMailSenderImpl getJavaMailSendImpl() {
        return new JavaMailSenderImpl();
    }

    private static void setAuthenticator(MailBody body) {
        jmsi.setHost(body.getHost());
        jmsi.setPort(body.getPort());
        jmsi.setProtocol(body.getProtocal());
        jmsi.setUsername(body.getUsername());
        jmsi.setPassword(body.getPassword());
    }

    private static void setJavaMailProperties(MailBody body) {
        Properties javaMailProperties = new Properties();

        // 设置超时时间
        javaMailProperties.setProperty("mail.connection.timeout", "2500");
        javaMailProperties.setProperty("mail.socket.timeout", "2500");

        javaMailProperties.setProperty("mail.smtp.timeout", body.getTimeout());
        // 设置邮件服务器主机
        javaMailProperties.setProperty("mail.smtp.host", body.getHost());
        // 设置邮件服务器端口号
        javaMailProperties.setProperty("mail.smtp.port", Integer.toString(body.getPort()));
        // 开启debug调试
        javaMailProperties.setProperty("mail.debug", "true");
        // 发送服务器需要身份验证
        javaMailProperties.setProperty("mail.smtp.auth", "true");
        javaMailProperties
                .setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        javaMailProperties.setProperty("mail.smtp.socketFactory.fallback", "false");
        jmsi.setJavaMailProperties(javaMailProperties);
    }

    private static void sendMail(MimeMessage mimeMessage, MailBody body) {
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, DEFAULT_ENCODING);

            helper.setFrom(body.getFrom());
            helper.setTo(body.getTo());
            helper.setSubject(body.getSubject());
            helper.setText(body.getText(), body.isHtml());
            helper.setSentDate(body.getSendDate());

            if (body.getBcc() != null && body.getBcc().length > 0) {
                helper.setBcc(body.getBcc());
            }

            if (body.getCc() != null && body.getCc().length > 0) {
                helper.setCc(body.getCc());
            }

            if (body.getReplyTo() != null) {
                helper.setReplyTo(body.getReplyTo());
            }

            if (body.getFile() != null && body.getAttachmentFilename() != null) {
                helper.addAttachment(body.getAttachmentFilename(), body.getFile());
            }

            if (body.getFile() != null && body.getContentId() != null) {
                helper.addInline(body.getContentId(), body.getFile());
            }

            jmsi.send(mimeMessage);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
