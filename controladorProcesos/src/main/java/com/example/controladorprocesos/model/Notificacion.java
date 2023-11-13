package com.example.controladorprocesos.model;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Notificacion {
    private String mensaje;
    private boolean leido;
    private int id;

    public Notificacion(String mensaje) {
        this.mensaje = mensaje;
        this.leido = false;
    }

    public Notificacion() {
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isLeido() {
        return leido;
    }

    public void marcarComoLeido() {
        this.leido = true;
    }

    public void enviarCorreoElectronico(String destinatario, String asunto, String mensaje, ConfiguracionCorreo configuracionCorreo) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");


        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(configuracionCorreo.getUsuario(), configuracionCorreo.getContrasenia());
            }
        });

        try {
            Message correo = new MimeMessage(session);
            correo.setFrom(new InternetAddress(configuracionCorreo.getUsuario()));
            correo.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            correo.setSubject(asunto);
            correo.setText(mensaje);

            Transport.send(correo);
            System.out.println("Correo electrónico enviado correctamente.");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
