package main.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.database.EdbManager;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Tabla extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private EdbManager manager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabla frame = new Tabla();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tabla() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1153, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1117, 317);
		contentPane.add(scrollPane);
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		
		String[] str = {"ID", "Nombres", "Ap. Paterno", "Ap. Materno", "Dia de nacimiento", "Mes de nacimiento", 
		"A\u00F1o de nacimiento", "Colonia", "Calle", "N\u00B0 Exterior", "N\u00B0 Interior", "C.P.", "Departamento", 
		"Puesto", "Dia de ingreso", "Mes de ingreso", "A\u00F1o de ingreso", "Salario"};for(int i = 0; i<= 17; i++)
		{model.addColumn(str[i]);}
		manager = new EdbManager();
		model = manager.getCantObjects(model);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnRegresar = new JButton("<- Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				dispatchEvent(new WindowEvent(new Ingresar(), WindowEvent.WINDOW_CLOSING));
				menu.main(null);
			}
		});
		btnRegresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegresar.setForeground(new Color(129, 129, 129));
				btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 11));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegresar.setForeground(new Color(0, 0, 0));
				btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			}
		});
		btnRegresar.setForeground(new Color(68, 68, 68));
		btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegresar.setBorder(null);
		btnRegresar.setBackground(new Color(240, 240, 240));
		btnRegresar.setBounds(20, 339, 74, 23);
		contentPane.add(btnRegresar);
	}
}
