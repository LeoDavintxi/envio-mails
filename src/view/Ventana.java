package view;

import java.awt.BorderLayout;
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
	private JMenuItem cargar;
	private JSeparator jSeparator1;
	private JTextField jTextField2;
	private JLabel jLabel2;
	private JTextField jTextField1;
	private JLabel jLabel1;
	private JPanel jPanel1;
	private JMenuItem jMenuItem4;
	private JMenu jMenu3;
	private JMenuItem credenciales;
	private JMenuItem salir;
	private JMenu jMenu2;
	private JMenu menuInicio;
	private JMenuBar jMenuBar1;
	private JTable tabla;
	private JScrollPane jScrollPane1;
	private JPanel panelLateral;
	private JButton enviar;
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

	public void setCargar(JButton cargar) {
	}

	public JButton getEnviar() {
		return enviar;
	}

	public void setEnviar(JButton enviar) {
		this.enviar = enviar;
		enviar.setPreferredSize(new java.awt.Dimension(624, 32));
		enviar.setHorizontalTextPosition(SwingConstants.RIGHT);
	}

	public JTable getTabla() {
		return tabla;
	}

	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}

	public JMenuItem getCredenciales() {
		return credenciales;
	}

	public void setCredenciales(JMenuItem credenciales) {
		this.credenciales = credenciales;
	}

	public JMenuItem getCargar() {
		return cargar;
	}

	public void setCargar(JMenuItem cargar) {
		this.cargar = cargar;
	}

	public JMenuItem getSalir() {
		return salir;
	}

	public void setSalir(JMenuItem salir) {
		this.salir = salir;
	}

	public JMenu getMenuInicio() {
		return menuInicio;
	}

	public void setMenuInicio(JMenu menuInicio) {
		this.menuInicio = menuInicio;
	}

	private void initGUI() {
		try {
			{
				panelLateral = new JPanel();
				getContentPane().add(panelLateral, BorderLayout.SOUTH);
				{
					jPanel1 = new JPanel();
					getContentPane().add(jPanel1, BorderLayout.CENTER);
					jPanel1.setBorder(BorderFactory.createTitledBorder("Nueva Campaña"));
					{
						jLabel1 = new JLabel();
						jPanel1.add(jLabel1);
						jLabel1.setText("Asunto Correo Masivo");
						jLabel1.setPreferredSize(new java.awt.Dimension(240, 31));
					}
					{
						jTextField1 = new JTextField();
						jPanel1.add(jTextField1);
						jTextField1.setPreferredSize(new java.awt.Dimension(387, 32));
					}
					{
						jLabel2 = new JLabel();
						jPanel1.add(jLabel2);
						jLabel2.setText("CCO:");
						jLabel2.setPreferredSize(new java.awt.Dimension(240, 31));
					}
					{
						jTextField2 = new JTextField();
						jPanel1.add(jTextField2);
						jTextField2.setPreferredSize(new java.awt.Dimension(384, 32));
					}
					{
						jScrollPane1 = new JScrollPane();
						jPanel1.add(jScrollPane1);
						jScrollPane1.setPreferredSize(new java.awt.Dimension(625, 161));
						{
							String[] encabezados = { "Nombre", "Archivo", "Correo" };
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
				}
				panelLateral.setPreferredSize(new java.awt.Dimension(669, 45));
				{
					enviar = new JButton();
					panelLateral.add(enviar);
					enviar.setText("Enviar Masivo");
				}
			}
			{
				this.setSize(691, 428);
				this.setLocationRelativeTo(null);
				this.setVisible(true);
				this.setTitle("Envio masivo de Emails");
				{
					jMenuBar1 = new JMenuBar();
					setJMenuBar(jMenuBar1);
					{
						menuInicio = new JMenu();
						jMenuBar1.add(menuInicio);
						menuInicio.setText("Inicio");
						{
							cargar = new JMenuItem();
							menuInicio.add(cargar);
							cargar.setText("Cargar Documento...");
						}
						{
							jSeparator1 = new JSeparator();
							menuInicio.add(jSeparator1);
						}
						{
							salir = new JMenuItem();
							menuInicio.add(salir);
							salir.setText("Salir");
						}
					}
					{
						jMenu2 = new JMenu();
						jMenuBar1.add(jMenu2);
						jMenu2.setText("Parametros");
						{
							credenciales = new JMenuItem();
							jMenu2.add(credenciales);
							credenciales.setText("Credenciales");
						}
					}
					{
						jMenu3 = new JMenu();
						jMenuBar1.add(jMenu3);
						jMenu3.setText("Ayuda");
						{
							jMenuItem4 = new JMenuItem();
							jMenu3.add(jMenuItem4);
							jMenuItem4.setText("Contacto");
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
