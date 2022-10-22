package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import view.Ventana;

public class ControladorPrincipal implements ActionListener {
	private Ventana ventana;
	private ControladorArchivo controladorArchivo;
	private ControladorCorreos controladorCorreos;

	public ControladorPrincipal() {
		ventana = new Ventana();
		asignarListener();
	}

	public void asignarListener() {
		ventana.getCargar().addActionListener(this);
		ventana.getEnviar().addActionListener(this);
		ventana.getSalir().addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ventana.getCargar()) {
			while(ventana.getModelo().getRowCount() > 0) {
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
			JOptionPane.showMessageDialog(null, "en controlador pr");
			controladorCorreos = new ControladorCorreos();
			JOptionPane.showMessageDialog(null, "en controlador22222");
			/*for (int i = 0; i < ventana.getModelo().getRowCount(); i++) {
				controladorCorreos.enviarCorreos((String)ventana.getTabla().getValueAt(i, 2), (String)ventana.getTabla().getValueAt(i, 1), (String)ventana.getTabla().getValueAt(i, 0));
			}*/
		}
	}
}
