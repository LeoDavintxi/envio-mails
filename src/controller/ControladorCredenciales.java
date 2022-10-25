package controller;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import java.security.Key;
import java.util.Base64;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

public class ControladorCredenciales {

	private String host;
	private String puerto;
	private String usuario;
	private String auth;
	private String contrasena;
	private Key key;
	private Cipher aes;
	private Properties propiedades;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getPuerto() {
		return puerto;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public ControladorCredenciales() {

		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(128);
			key = keyGenerator.generateKey();
			key = new SecretKeySpec("Cesar Andres Salgado".getBytes(), 0, 16, "AES");
			aes = Cipher.getInstance("AES/ECB/PKCS5Padding");

			propiedades = new Properties();
			propiedades.load(new FileInputStream("data/configuracion.ini"));
			host = descifrar(propiedades.getProperty("host"));
			puerto = propiedades.getProperty("puerto");
			usuario = propiedades.getProperty("usuario");
			auth = propiedades.getProperty("auth");
			contrasena = descifrar(propiedades.getProperty("contrasena"));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al intentar conectarse: " + e.getMessage());
		}
	}

	public String cifrar(String texto) {
		String encriptado = "";
		try {
			aes.init(Cipher.ENCRYPT_MODE, key);
			byte[] encrip = aes.doFinal(texto.getBytes());
			encriptado = Base64.getEncoder().encodeToString(encrip);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return encriptado;
	}

	public String descifrar(String texto) {
		byte[] desencriptado = null;
		try {
			aes.init(Cipher.DECRYPT_MODE, key);
			desencriptado = aes.doFinal(Base64.getDecoder().decode(texto));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new String(desencriptado);
	}

	public void guardarCredenciales(String clave, String valor) {
		try {
			propiedades.setProperty(clave, valor);
			propiedades.store(new FileWriter("data/configuracion.ini"),"Actualizacion");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
