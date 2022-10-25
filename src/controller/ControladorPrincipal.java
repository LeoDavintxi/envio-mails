package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import view.Credenciales;
import view.Ventana;

public class ControladorPrincipal implements ActionListener {
	private Ventana ventana;
	private Credenciales credenciales;
	private ControladorArchivo controladorArchivo;
	private ControladorCorreos controladorCorreos;
	private ControladorCredenciales controladorCredenciales;

	public ControladorPrincipal() {
		ventana = new Ventana();
		credenciales = new Credenciales(ventana);
		asignarListener();
	}

	public void asignarListener() {
		ventana.getCargar().addActionListener(this);
		ventana.getSalir().addActionListener(this);
		ventana.getEnviar().addActionListener(this);
		ventana.getCredenciales().addActionListener(this);
		credenciales.getGuardar().addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == ventana.getCargar()) {
			while (ventana.getModelo().getRowCount() > 0) {
				ventana.getModelo().removeRow(0);
			}

			controladorArchivo = new ControladorArchivo();
			List datos = controladorArchivo.leerArchivo();
			Object[] fila = new Object[3];
			for (int i = 0; i < datos.size(); i++) {
				List celda = (List) datos.get(i);
				for (int j = 0; j < celda.size(); j++) {
					fila[0] = celda.get(0);
					fila[1] = celda.get(1);
					fila[2] = celda.get(2);
				}
				ventana.getModelo().addRow(fila);
			}
		}

		if (e.getSource() == ventana.getSalir()) {
			System.exit(0);
		}

		if (e.getSource() == ventana.getEnviar()) {
			controladorCorreos = new ControladorCorreos();
			controladorCredenciales = new ControladorCredenciales();
			for (int i = 0; i < ventana.getModelo().getRowCount(); i++) {
				controladorCorreos.enviarCorreos((String) ventana.getTabla().getValueAt(i, 2), "davidsp302@gmail.com",
						"Recordatorio pago de servicios prestados - Risks International",
						(String) ventana.getTabla().getValueAt(i, 1), (String) ventana.getTabla().getValueAt(i, 0),
						controladorCredenciales.getHost(), controladorCredenciales.getPuerto(),
						controladorCredenciales.getUsuario(), "RISKS INTERNATIONAL S.A.S",
						controladorCredenciales.getUsuario(), controladorCredenciales.getContrasena());
			}
		}

		if (e.getSource() == ventana.getCredenciales()) {
			controladorCredenciales = new ControladorCredenciales();
			credenciales.getContrasena().setText(controladorCredenciales.getContrasena());
			credenciales.getHost().setText(controladorCredenciales.getHost());
			credenciales.setVisible(true);
		}

		if (e.getSource() == credenciales.getGuardar()) {
			controladorCredenciales = new ControladorCredenciales();
			controladorCredenciales.guardarCredenciales("host",
					controladorCredenciales.cifrar(credenciales.getHost().getText()));
			controladorCredenciales.guardarCredenciales("contrasena",
					controladorCredenciales.cifrar(credenciales.getContrasena().getText()));
			JOptionPane.showMessageDialog(null, "Nuevas credenciales guardadas.");
			credenciales.dispose();
		}
	}
}
