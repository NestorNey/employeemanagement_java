package main.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;

import main.database.EdbManager;

import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.Box;

public class Menu extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 507, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Ingresar in = new Ingresar();
				dispatchEvent(new WindowEvent(new Menu(), WindowEvent.WINDOW_CLOSING));
				in.main(null);
			}
		});
		panel.setBackground(new Color(230, 230, 230));
		panel.setBorder(new LineBorder(new Color(122, 122, 122), 1, true));
		panel.setBounds(10, 111, 104, 79);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\resources\\icons\\icons8-add-50.png"));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ingresar empleado");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EdbManager manager = new EdbManager();
				
				dispatchEvent(new WindowEvent(new Menu(), WindowEvent.WINDOW_CLOSING));
				String str = JOptionPane.showInputDialog(null,"Ingresa el id del empleado","Eliminar",3);
				manager.deleteData(str);
				Menu menu = new Menu();
				menu.main(null);
				
			}
		});
		panel_1.setBorder(new LineBorder(new Color(122, 122, 122), 1, true));
		panel_1.setBackground(new Color(230, 230, 230));
		panel_1.setBounds(194, 111, 104, 79);
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\resources\\icons\\icons8-remove-50.png"));
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Eliminar empleado");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_1.add(lblNewLabel_1_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispatchEvent(new WindowEvent(new Menu(), WindowEvent.WINDOW_CLOSING));
				Show show = new Show();show.main(null);
			}
		});
		panel_1_1.setBorder(new LineBorder(new Color(122, 122, 122), 1, true));
		panel_1_1.setBackground(new Color(230, 230, 230));
		panel_1_1.setBounds(372, 111, 104, 79);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\resources\\icons\\icons8-printer-50.png"));
		panel_1_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("        Imprimir        ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_1_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Administracion de empleados");
		lblNewLabel_2.setForeground(new Color(114, 114, 114));
		lblNewLabel_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 27));
		lblNewLabel_2.setBounds(16, 27, 460, 58);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("<- Salir");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_4.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel_4);
	}
}
