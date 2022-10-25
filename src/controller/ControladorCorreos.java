package controller;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import view.ContenidoHTML;

public class ControladorCorreos {

	public MimeMultipart construccionMensaje(String nombreArchivo) {
		MimeMultipart multiParte = new MimeMultipart();
		try {
			BodyPart texto = new MimeBodyPart();
			texto.setContent(new ContenidoHTML().contenido(), "text/html");

			BodyPart adjunto = new MimeBodyPart();
			adjunto.setDataHandler(new DataHandler(new FileDataSource("pdf/" + nombreArchivo + ".pdf")));
			adjunto.setFileName(nombreArchivo + ".pdf");

			multiParte.addBodyPart(texto);
			multiParte.addBodyPart(adjunto);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return multiParte;
	}

	public Session conexion(String host, String puerto, String usuario, String auth) {
		Properties props = new Properties();
		props.setProperty("mail.smtp.host", host);
		props.setProperty("mail.smtp.port", puerto);
		props.setProperty("mail.smtp.user", usuario);
		props.setProperty("mail.smtp.auth", auth);

		Session session = Session.getDefaultInstance(props);
		session.setDebug(true);
		return session;
	}

	public void enviarCorreos(String receptores, String auditores, String asunto, String nombreArchivo, String nombreDeudor, String host, String puerto, String usuario, String nombreUsuario, String auth, String contrasena) {
		try {
			MimeMessage message = new MimeMessage(conexion(host, puerto, usuario, auth));
			message.setFrom(new InternetAddress(usuario, nombreUsuario));
			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(receptores));
			message.addRecipients(Message.RecipientType.BCC, InternetAddress.parse(auditores));
			message.setSubject(asunto);
			message.setContent(construccionMensaje(nombreArchivo));

			System.out.println(contrasena);
			Transport t = conexion(host, puerto, usuario, auth).getTransport("smtp");
			t.connect(usuario, contrasena);
			t.sendMessage(message, message.getAllRecipients());
			t.close();

		} catch (MessagingException | UnsupportedEncodingException e) {
			e.getMessage();
		}
	}
}
