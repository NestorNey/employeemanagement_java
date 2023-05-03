package main.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import main.database.EdbManager;
import main.database.models.Empleado;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import java.awt.Canvas;
import java.awt.Scrollbar;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Rectangle;
import java.awt.Insets;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ingresar extends JFrame {

	private JPanel contentPane;
	private JTextField fieldName;
	private JTextField fieldApPat;
	private JTextField fieldPst;
	private JTextField fieldSal;
	private JTextField fieldCol;
	private JTextField fieldCall;
	private JTextField fieldNext;
	private JTextField fieldNint;
	private JTextField fieldCpost;
	private JTextField fieldApMat;
	private JTextField fieldDep;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ingresar frame = new Ingresar();
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
	public Ingresar() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 438);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.setBackground(new Color(240, 240, 240));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ingresar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(0, 0, 272, 206);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, -60, 10));
		
		JLabel lblNewLabel = new JLabel("Nombres:");
		panel.add(lblNewLabel);
		
		fieldName = new JTextField();
		panel.add(fieldName);
		fieldName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido Paterno:");
		panel.add(lblNewLabel_1);
		
		fieldApPat = new JTextField();
		panel.add(fieldApPat);
		fieldApPat.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido Materno:");
		panel.add(lblNewLabel_2);
		
		fieldApMat = new JTextField();
		fieldApMat.setColumns(10);
		panel.add(fieldApMat);
		
		JLabel lblNewLabel_9 = new JLabel("Departamento:");
		panel.add(lblNewLabel_9);
		
		fieldDep = new JTextField();
		fieldDep.setColumns(10);
		panel.add(fieldDep);
		
		JLabel lblNewLabel_10 = new JLabel("Puesto:");
		panel.add(lblNewLabel_10);
		
		fieldPst = new JTextField();
		panel.add(fieldPst);
		fieldPst.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Salario:");
		panel.add(lblNewLabel_11);
		
		fieldSal = new JTextField();
		panel.add(fieldSal);
		fieldSal.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(272, 0, 162, 98);
		contentPane.add(panel_1);
		panel_1.setBorder(new TitledBorder(null, "Fecha de nacimiento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(new GridLayout(0, 2, -50, 5));
		
		JLabel lblNewLabel_3 = new JLabel("Dia:");
		panel_1.add(lblNewLabel_3);
		
		JComboBox cbDiaN = new JComboBox();
		panel_1.add(cbDiaN);
		
		JLabel lblNewLabel_4 = new JLabel("Mes:");
		panel_1.add(lblNewLabel_4);
		
		JComboBox cbMesN = new JComboBox();
		cbMesN.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int in = cbMesN.getSelectedIndex();cbDiaN.removeAllItems();
				if(in == 0 || in == 2 || in == 4 || in == 6 || in == 7 || in == 9 || in == 11) {for(int i = 1; i<=31; i++) {cbDiaN.addItem(i);}
				}else if(in == 1) {for(int i = 1; i<= 28; i++) {cbDiaN.addItem(i);}
				}else {for(int i = 1; i<= 30; i++) {cbDiaN.addItem(i);}}
			}
		});
		cbMesN.addItem("Enero");cbMesN.addItem("Febrero");cbMesN.addItem("Marzo");cbMesN.addItem("Abril");cbMesN.addItem("Mayo");
		cbMesN.addItem("Junio");cbMesN.addItem("Julio");cbMesN.addItem("Agosto");cbMesN.addItem("Septiembre");cbMesN.addItem("Octubre");
		cbMesN.addItem("Noviembre");cbMesN.addItem("Diciembre");
		panel_1.add(cbMesN);
		
		JLabel lblNewLabel_5 = new JLabel("Año:");
		panel_1.add(lblNewLabel_5);
		
		JComboBox cbAnioN = new JComboBox();
		for(int i = 1970; i<= 2004; i++) {
			cbAnioN.addItem(i);
		}
		panel_1.add(cbAnioN);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Direccion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(0, 209, 434, 145);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, -100, 5));
		
		JLabel labelcol = new JLabel("Colonia:");
		panel_2.add(labelcol);
		
		fieldCol = new JTextField();
		panel_2.add(fieldCol);
		fieldCol.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Calle:");
		panel_2.add(lblNewLabel_7);
		
		fieldCall = new JTextField();
		panel_2.add(fieldCall);
		fieldCall.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Numero exterior:");
		panel_2.add(lblNewLabel_8);
		
		fieldNext = new JTextField();
		panel_2.add(fieldNext);
		fieldNext.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Numero interior:");
		panel_2.add(lblNewLabel_12);
		
		fieldNint = new JTextField();
		panel_2.add(fieldNint);
		fieldNint.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Codigo postal:");
		panel_2.add(lblNewLabel_13);
		
		fieldCpost = new JTextField();
		panel_2.add(fieldCpost);
		fieldCpost.setColumns(10);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Fecha de Ingreso", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1.setBounds(272, 109, 162, 97);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(new GridLayout(0, 2, -50, 5));
		
		JLabel lblNewLabel_3_1 = new JLabel("Dia:");
		panel_1_1.add(lblNewLabel_3_1);
		
		JComboBox cbDiaI = new JComboBox();
		panel_1_1.add(cbDiaI);
		
		JLabel lblNewLabel_4_1 = new JLabel("Mes:");
		panel_1_1.add(lblNewLabel_4_1);
		
		JComboBox cbMesI = new JComboBox();
		cbMesI.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int in = cbMesI.getSelectedIndex();cbDiaI.removeAllItems();
				if(in == 0 || in == 2 || in == 4 || in == 6 || in == 7 || in == 9 || in == 11) {for(int i = 1; i<=31; i++) {cbDiaI.addItem(i);}
				}else if(in == 1) {for(int i = 1; i<= 28; i++) {cbDiaI.addItem(i);}
				}else {for(int i = 1; i<= 30; i++) {cbDiaI.addItem(i);}}
			}
		});
		cbMesI.addItem("Enero");cbMesI.addItem("Febrero");cbMesI.addItem("Marzo");cbMesI.addItem("Abril");cbMesI.addItem("Mayo");
		cbMesI.addItem("Junio");cbMesI.addItem("Julio");cbMesI.addItem("Agosto");cbMesI.addItem("Septiembre");cbMesI.addItem("Octubre");
		cbMesI.addItem("Noviembre");cbMesI.addItem("Diciembre");
		panel_1_1.add(cbMesI);
		
		JLabel lblNewLabel_5_1 = new JLabel("Año:");
		panel_1_1.add(lblNewLabel_5_1);
		
		JComboBox cbAnioI = new JComboBox();
		for(int i = 1970; i<= 2022; i++) {
			cbAnioI.addItem(i);
		}
		panel_1_1.add(cbAnioI);
		
		JButton btnNewButton = new JButton("Enviar ->");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empleado empleado = new Empleado();
				EdbManager manager = new EdbManager();
				Menu menu = new Menu();
				
				empleado.setNombre(fieldName.getText());empleado.setApPate(fieldApPat.getText());empleado.setApMate(fieldApMat.getText());
				empleado.setDep(fieldDep.getText());empleado.setPuesto(fieldPst.getText());empleado.setSalario(Double.parseDouble(fieldSal.getText()));
				empleado.setdDn(cbDiaN.getSelectedIndex()+1);empleado.setmDn(cbMesN.getSelectedIndex()+1);empleado.setaDn((int) cbAnioN.getSelectedItem());
				empleado.setdDi(cbDiaI.getSelectedIndex()+1);empleado.setmDi(cbMesI.getSelectedIndex()+1);empleado.setaDi((int) cbAnioI.getSelectedItem());
				empleado.setColonia(fieldCol.getText());empleado.setCalle(fieldCall.getText());empleado.setNoExt(Integer.parseInt(fieldNext.getText()));
				empleado.setNoInt(Integer.parseInt(fieldNint.getText()));empleado.setCpost(Integer.parseInt(fieldCpost.getText()));
				manager.addObject(empleado);
				
				dispatchEvent(new WindowEvent(new Ingresar(), WindowEvent.WINDOW_CLOSING));
				menu.main(null);
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setForeground(new Color(129, 129, 129));
				btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
			}
			@Override
			public void mouseExited(MouseEvent e){
				btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btnNewButton.setForeground(new Color(0, 0, 0));
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(350, 365, 74, 23);
		contentPane.add(btnNewButton);
		
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
		btnRegresar.setBounds(10, 365, 74, 23);
		contentPane.add(btnRegresar);
	}
}
