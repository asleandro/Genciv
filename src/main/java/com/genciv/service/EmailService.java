package com.genciv.service;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailService {

    private final String emailRemetente;
    private final String senhaRemetente;

    public EmailService(String emailRemetente, String senhaRemetente) {
        this.emailRemetente = emailRemetente;
        this.senhaRemetente = senhaRemetente;
    }

    public void enviarEmail(String destinatario, String assunto, String corpo) {
        // Configuração do servidor SMTP
        Properties propriedades = new Properties();
        propriedades.put("mail.smtp.auth", "true");
        propriedades.put("mail.smtp.starttls.enable", "true");
        propriedades.put("mail.smtp.host", "smtp.example.com"); // Substitua pelo host do seu provedor de e-mail
        propriedades.put("mail.smtp.port", "587"); // Substitua pela porta do seu provedor de e-mail

        Authenticator autenticador = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailRemetente, senhaRemetente);
            }
        };

        Session sessao = Session.getInstance(propriedades, autenticador);

        try {
            Message mensagem = new MimeMessage(sessao);
            mensagem.setFrom(new InternetAddress(emailRemetente));
            mensagem.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            mensagem.setSubject(assunto);
            mensagem.setText(corpo);

            Transport.send(mensagem);

            System.out.println("E-mail enviado com sucesso para: " + destinatario);

        } catch (MessagingException e) {
            System.err.println("Erro ao enviar e-mail: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
