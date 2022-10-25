package view;

import java.awt.BorderLayout;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class Credenciales extends javax.swing.JDialog {
	private JPanel jPanel1;
	private JLabel jLabel2;
	private JSeparator jSeparator1;
	private JButton guardar;
	private JTextField contrasena;
	private JTextField host;
	private JLabel jLabel1;

	public Credenciales(JFrame frame) {
		super(frame);
		initGUI();
	}

	public JTextField getContrasena() {
		return contrasena;
	}

	public void setContrasena(JTextField contrasena) {
		this.contrasena = contrasena;
	}

	public JTextField getHost() {
		return host;
	}

	public void setHost(JTextField host) {
		this.host = host;
	}

	public JButton getGuardar() {
		return guardar;
	}

	public void setGuardar(JButton guardar) {
		this.guardar = guardar;
	}

	private void initGUI() {
		try {
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("Host");
					jLabel1.setPreferredSize(new java.awt.Dimension(159, 25));
				}
				{
					host = new JTextField();
					jPanel1.add(host);
					host.setPreferredSize(new java.awt.Dimension(266, 32));
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText("Contraseña");
					jLabel2.setPreferredSize(new java.awt.Dimension(159, 25));
				}
				{
					contrasena = new JTextField();
					jPanel1.add(contrasena);
					contrasena.setPreferredSize(new java.awt.Dimension(266, 32));
				}
				{
					jSeparator1 = new JSeparator();
					jPanel1.add(jSeparator1);
					jSeparator1.setPreferredSize(new java.awt.Dimension(465, 10));
				}
				{
					guardar = new JButton();
					jPanel1.add(guardar);
					guardar.setText("Guardar");
					guardar.setPreferredSize(new java.awt.Dimension(385, 32));
				}
			}
			this.setSize(527, 193);
			this.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
