package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

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
public class Ventana extends JFrame {
	private static final long serialVersionUID = -5751157124573573107L;
	private JTable tabla;
	private JScrollPane jScrollPane1;
	private JPanel panelLateral;
	private JButton cargar;
	private JButton enviar;
	private JButton salir;
	private DefaultTableModel modelo;

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}

	public Ventana() {
		initGUI();

	}

	public JPanel getPanelLateral() {
		return panelLateral;
	}

	public void setPanelLateral(JPanel panelLateral) {
		this.panelLateral = panelLateral;
	}

	public JButton getCargar() {
		return cargar;
	}

	public void setCargar(JButton cargar) {
		this.cargar = cargar;
	}

	public JButton getEnviar() {
		return enviar;
	}

	public void setEnviar(JButton enviar) {
		this.enviar = enviar;
	}

	public JButton getSalir() {
		return salir;
	}

	public void setSalir(JButton salir) {
		this.salir = salir;
	}
	
	public JTable getTabla() {
		return tabla;
	}

	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}

	private void initGUI() {
		try {
			{
				panelLateral = new JPanel();
				GridLayout jPanel1Layout = new GridLayout(0, 1);
				jPanel1Layout.setHgap(5);
				jPanel1Layout.setVgap(5);
				jPanel1Layout.setColumns(1);
				panelLateral.setLayout(jPanel1Layout);
				getContentPane().add(panelLateral, BorderLayout.WEST);
				{
					jScrollPane1 = new JScrollPane();
					getContentPane().add(jScrollPane1, BorderLayout.CENTER);
					{
						String[] encabezados = {"Nombre","Archivo","Correo"};
						modelo = new DefaultTableModel(null, encabezados);
						tabla = new JTable();
						jScrollPane1.setViewportView(tabla);
						tabla.setModel(modelo);
						tabla.getColumnModel().getColumn(0).setMinWidth(200);
						tabla.getColumnModel().getColumn(0).setMaxWidth(200);
						tabla.getColumnModel().getColumn(1).setMinWidth(120);
						tabla.getColumnModel().getColumn(1).setMaxWidth(120);
					}
				}
				panelLateral.setPreferredSize(new java.awt.Dimension(100, 193));
				{
					cargar = new JButton();
					panelLateral.add(cargar);
					cargar.setText("Cargar");
				}
				{
					enviar = new JButton();
					panelLateral.add(enviar);
					enviar.setText("Enviar");
				}
				{
					salir = new JButton();
					panelLateral.add(salir);
					salir.setText("Salir");
				}
			}
			{
				this.setSize(691, 249);
				this.setLocationRelativeTo(null);
				this.setVisible(true);
				this.setTitle("Envio masivo de Emails");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
