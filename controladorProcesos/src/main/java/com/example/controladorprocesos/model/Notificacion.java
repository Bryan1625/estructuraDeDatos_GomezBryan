package com.example.controladorprocesos.model;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Clase que representa una notificación.
 */
public class Notificacion {

    // Atributos de la notificación
    private String mensaje;
    private boolean leido;
    private int id;

    // Constructores

    /**
     * Constructor que recibe el mensaje de la notificación.
     *
     * @param mensaje Mensaje de la notificación.
     */
    public Notificacion(String mensaje) {
        this.mensaje = mensaje;
        this.leido = false;
    }

    /**
     * Constructor por defecto.
     */
    public Notificacion() {
    }

    // Getters y Setters

    /**
     * Establece el estado de leído de la notificación.
     *
     * @param leido Estado de leído.
     */
    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    /**
     * Obtiene el identificador de la notificación.
     *
     * @return Identificador de la notificación.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador de la notificación.
     *
     * @param id Identificador de la notificación.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el mensaje de la notificación.
     *
     * @return Mensaje de la notificación.
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Establece el mensaje de la notificación.
     *
     * @param mensaje Mensaje de la notificación.
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Verifica si la notificación ha sido leída.
     *
     * @return `true` si la notificación ha sido leída, `false` de lo contrario.
     */
    public boolean isLeido() {
        return leido;
    }

    /**
     * Marca la notificación como leída.
     */
    public void marcarComoLeido() {
        this.leido = true;
    }

    // Métodos

    /**
     * Envía un correo electrónico utilizando la configuración proporcionada.
     *
     * @param destinatario        Dirección de correo del destinatario.
     * @param asunto              Asunto del correo.
     * @param mensaje             Cuerpo del correo.
     * @param configuracionCorreo Configuración del correo (usuario y contraseña).
     */
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
