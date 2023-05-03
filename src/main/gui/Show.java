package main.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.database.EdbManager;
import main.database.models.Empleado;

import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class Show extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Show frame = new Show();
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
	public Show() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 288, 125);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Imprimir por...");
		lblNewLabel.setBounds(88, 11, 89, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Mostrar tabla");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tabla tabla = new Tabla();
				dispatchEvent(new WindowEvent(new Menu(), WindowEvent.WINDOW_CLOSING));
				tabla.main(null);
			}
		});
		btnNewButton.setBounds(141, 52, 121, 23);
		contentPane.add(btnNewButton);
		
		JButton btnBuscarPorId = new JButton("Buscar por ID");
		btnBuscarPorId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empleado empleado = new Empleado();
				EdbManager manager = new EdbManager();
				Busqueda frame;
				dispatchEvent(new WindowEvent(new Menu(), WindowEvent.WINDOW_CLOSING));
				String str = JOptionPane.showInputDialog(null,"Ingresa el id del empleado","Eliminar",3);
				empleado = manager.getObject(str);
				if(empleado.getCDE() == "NF") {
					JOptionPane.showMessageDialog(null, "No se econtro el Id", "ERROR", 0);
					Menu menu = new Menu();
					menu.main(null);
				}else {
					frame = new Busqueda(empleado);
					frame.main(null, empleado);
				}
			}
		});
		btnBuscarPorId.setBounds(10, 52, 121, 23);
		contentPane.add(btnBuscarPorId);
	}

}
