package gui;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextField tFieldLU;
	private JTextField tFieldApellido;
	private JTextField tFieldNombre;
	private JTextField tFieldMail;
	private JTextField tFieldURL;
	private JLabel lblPhoto;
	private JLabel lblHora;

	public SimplePresentationScreen(Student studentData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 277));
		setResizable(false);
		setContentPane(contentPane);
		
		init(studentData);
	}
	
	private void init(Student stdnt) {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 211);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Informacion del alumno", null, tabInformation, "Muestra la informacion declarada por el alumno");
		tabInformation.setLayout(null);
		
		tFieldLU = new JTextField();
		tFieldLU.setEditable(false);
		tFieldLU.setBounds(89, 11, 326, 20);
		tabInformation.add(tFieldLU);
		tFieldLU.setColumns(10);
		tFieldLU.setText(Integer.toString(stdnt.getId()));
		
		tFieldApellido = new JTextField();
		tFieldApellido.setEditable(false);
		tFieldApellido.setColumns(10);
		tFieldApellido.setBounds(89, 42, 326, 20);
		tabInformation.add(tFieldApellido);
		tFieldApellido.setText(stdnt.getLastName());
		
		tFieldNombre = new JTextField();
		tFieldNombre.setEditable(false);
		tFieldNombre.setColumns(10);
		tFieldNombre.setBounds(89, 73, 326, 20);
		tabInformation.add(tFieldNombre);
		tFieldNombre.setText(stdnt.getFirstName());
		
		tFieldMail = new JTextField();
		tFieldMail.setEditable(false);
		tFieldMail.setColumns(10);
		tFieldMail.setBounds(89, 104, 326, 20);
		tabInformation.add(tFieldMail);
		tFieldMail.setText(stdnt.getMail());
		
		
		tFieldURL = new JTextField();
		tFieldURL.setEditable(false);
		tFieldURL.setColumns(10);
		tFieldURL.setBounds(89, 135, 326, 20);
		tabInformation.add(tFieldURL);
		tFieldURL.setText(stdnt.getGithubURL());
		
		JLabel lblLU = new JLabel("LU");
		lblLU.setBounds(10, 14, 46, 14);
		tabInformation.add(lblLU);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 45, 46, 14);
		tabInformation.add(lblApellido);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 76, 46, 14);
		tabInformation.add(lblNombre);
		
		JLabel lblEMail = new JLabel("E-mail");
		lblEMail.setBounds(10, 107, 58, 14);
		tabInformation.add(lblEMail);
		
		JLabel lblGitUrl = new JLabel("Github URL");
		lblGitUrl.setBounds(10, 138, 69, 14);
		tabInformation.add(lblGitUrl);
		contentPane.add(tabbedPane);
		
		lblPhoto = new JLabel();
		lblPhoto.setBounds(445, 29, 154, 154);
		lblPhoto.setIcon(new ImageIcon(SimplePresentationScreen.class.getResource(studentData.getPathPhoto())));
		contentPane.add(lblPhoto);
		
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new java.util.Date());
		try{
			lblHora = new JLabel("Esta ventana fue generada el "+timeStamp.substring(0,2)+"/"+timeStamp.substring(4,5)+"/"+timeStamp.substring(6,10)
			+" a las: "+timeStamp.substring(11,13)+":"+timeStamp.substring(14,16)+":"+timeStamp.substring(17,19) );}
		catch(Exception e) {lblHora = new JLabel();}
		lblHora.setBounds(15, 218, 420, 14);
		contentPane.add(lblHora);
	}
}
