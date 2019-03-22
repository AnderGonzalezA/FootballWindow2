import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddTeam {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTeam window = new AddTeam();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public JFrame getFrame() {
		return this.frame;
	}
	/**
	 * Create the application.
	 */
	
	public AddTeam() {
		initialize();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 440, 255);
		JPanel contentPane = new JPanel();
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.activeCaption);
		menuBar.setBounds(0, 0, 434, 22);
		contentPane.add(menuBar);

		JMenu mnShowData = new JMenu("Show data");
		menuBar.add(mnShowData);

		JMenuItem mntmPlayers = new JMenuItem("Players");
		mntmPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Football show = new Football(1);
					show.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnShowData.add(mntmPlayers);

		JMenuItem mntmTeams = new JMenuItem("Teams");
		mntmTeams.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Football show = new Football(2);
					show.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnShowData.add(mntmTeams);

		JMenuItem mntmMatches = new JMenuItem("Matches");
		mntmMatches.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Football show = new Football(3);
					show.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnShowData.add(mntmMatches);

		JMenu mnAddData = new JMenu("Add data");
		menuBar.add(mnAddData);

		JMenuItem mntmPlayers_1 = new JMenuItem("Players");
		mntmPlayers_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddPlayer player = new AddPlayer();
					player.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnAddData.add(mntmPlayers_1);

		JMenuItem mntmTeams_1 = new JMenuItem("Teams");
		mntmTeams_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddTeam team = new AddTeam();
					team.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		
		mnAddData.add(mntmTeams_1);

		JMenuItem mntmMatches_1 = new JMenuItem("Matches");
		mntmMatches_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddMatch match = new AddMatch();
					match.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnAddData.add(mntmMatches_1);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(52, 68, 80, 14);
		contentPane.add(lblName);
		
		JLabel lblCoach = new JLabel("Coach");
		lblCoach.setBounds(52, 120, 80, 14);
		contentPane.add(lblCoach);
		
		textField = new JTextField();
		textField.setBounds(142, 65, 137, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(142, 117, 137, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAddTeam = new JButton("Add team");
		btnAddTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File teamsFile = new File("C:\\Users\\ik013043z1\\eclipse-workspace\\WindowBuilder\\src\\Teams.txt");
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter(teamsFile,true));
					String team = "\n"+textField.getText()+"::"+textField_1.getText();
					writer.write(team);
					writer.close();
					Football show = new Football(2);
					show.getFrame().setVisible(true);
					frame.dispose();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAddTeam.setBounds(164, 173, 89, 23);
		contentPane.add(btnAddTeam);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
