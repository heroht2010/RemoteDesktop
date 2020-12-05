

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterIP;
	private Socket sk;
	private DataInputStream dis;
	private DataOutputStream dos;
	

	InputStream ois=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
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
	public Client() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\luotx\\eclipse-workspace\\RemoteComputer\\src\\Logo_tr\u01B0\u1EDDng_\u0110\u1EA1i_h\u1ECDc_C\u00F4ng_ngh\u1EC7_th\u00F4ng_tin_v\u00E0_Truy\u1EC1n_th\u00F4ng_Vi\u1EC7t_-_H\u00E0n,_\u0110\u1EA1i_h\u1ECDc_\u0110\u00E0_N\u1EB5ng.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 376);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 577, 39);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Help");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(22, 11, 54, 17);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("About");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(69, 12, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Allow Remote Control");
		lblNewLabel_2.setForeground(SystemColor.windowBorder);
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(24, 50, 205, 56);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Your IP");
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblNewLabel_3.setBounds(34, 111, 52, 17);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblIP = new JLabel("192.168.1.14");
		lblIP.setForeground(SystemColor.windowBorder);
		lblIP.setFont(new Font("Century Gothic", Font.PLAIN, 28));
		lblIP.setBounds(44, 137, 185, 23);
		contentPane.add(lblIP);
		
		try {
			lblIP.setText(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		JLabel lblNewLabel_3_1 = new JLabel("Password");
		lblNewLabel_3_1.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(34, 171, 65, 17);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblPassword = new JLabel("338wrM");
		lblPassword.setForeground(SystemColor.windowBorder);
		lblPassword.setFont(new Font("Century Gothic", Font.PLAIN, 28));
		lblPassword.setBounds(44, 197, 185, 23);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel_2_1 = new JLabel("Control Remote Computer");
		lblNewLabel_2_1.setForeground(SystemColor.windowBorder);
		lblNewLabel_2_1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(284, 50, 263, 56);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Partner IP");
		lblNewLabel_3_2.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblNewLabel_3_2.setBounds(294, 114, 65, 17);
		contentPane.add(lblNewLabel_3_2);
		
		txtEnterIP = new JTextField();
		txtEnterIP.setFont(new Font("Century Gothic", Font.PLAIN, 28));
		txtEnterIP.setText("192.168.1.11");
		txtEnterIP.setBounds(304, 137, 216, 39);
		contentPane.add(txtEnterIP);
		txtEnterIP.setColumns(10);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\luotx\\Downloads\\eclipse-jee-2020-09-R-win32-x86_64\\eclipse\\reload-icon-19.png"));
		btnNewButton.setBounds(524, 137, 43, 39);
		contentPane.add(btnNewButton);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.setBackground(new Color(30, 144, 255));
		btnConnect.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnConnect.setForeground(SystemColor.window);
		btnConnect.setBounds(294, 193, 136, 39);
		contentPane.add(btnConnect);
		
		btnConnect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					sk=new Socket(txtEnterIP.getText(),7000);
					dos=new DataOutputStream(sk.getOutputStream());
					dis=new DataInputStream(sk.getInputStream());
					JFrame frame=new JFrame();
					String password=JOptionPane.showInputDialog(frame,"Enter Password");
					dos.writeUTF(password);

					ois=sk.getInputStream();
					
					while(true) {
						
					}
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
