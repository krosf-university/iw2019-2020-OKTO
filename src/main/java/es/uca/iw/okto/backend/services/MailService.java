package es.uca.iw.okto.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

  private JavaMailSender mailSender;

  @Autowired
  private MailService(JavaMailSender mailSender) {
    this.mailSender = mailSender;
  }

  public void sendEmail(String to, String subject, String content) {
    SimpleMailMessage email = new SimpleMailMessage();

    email.setTo(to);
    email.setSubject(subject);
    email.setText(content);

    mailSender.send(email);
  }
}