import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ModifyPlayer {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyPlayer window = new ModifyPlayer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ModifyPlayer() {
		initialize();
	}

	public JFrame getFrame() {
		return this.frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(109, 53, 46, 14);
		contentPane.add(lblName);

		JTextField textField = new JTextField();
		textField.setBounds(165, 50, 134, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNotFound = new JLabel("Not found");
		lblNotFound.setBounds(337, 53, 97, 14);
		lblNotFound.setVisible(false);
		contentPane.add(lblNotFound);

		JLabel lblNewLabel = new JLabel("New name");
		lblNewLabel.setBounds(10, 153, 86, 14);
		lblNewLabel.setVisible(false);
		contentPane.add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setBounds(93, 150, 86, 20);
		textField_1.setVisible(false);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("New age");
		lblNewLabel_1.setBounds(221, 153, 86, 14);
		lblNewLabel_1.setVisible(false);
		contentPane.add(lblNewLabel_1);

		textField_2 = new JTextField();
		textField_2.setBounds(310, 150, 86, 20);
		textField_2.setVisible(false);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("New team");
		lblNewLabel_2.setBounds(10, 210, 86, 14);
		lblNewLabel_2.setVisible(false);
		contentPane.add(lblNewLabel_2);

		textField_3 = new JTextField();
		textField_3.setBounds(93, 207, 86, 20);
		textField_3.setVisible(false);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JButton btnNewButton_1 = new JButton("Modify");
		btnNewButton_1.setVisible(false);
		btnNewButton_1.setBounds(271, 206, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNotFound.setVisible(false);
				lblNewLabel.setVisible(false);
				lblNewLabel_1.setVisible(false);
				lblNewLabel_2.setVisible(false);
				textField_1.setVisible(false);
				textField_2.setVisible(false);
				textField_3.setVisible(false);
				btnNewButton_1.setVisible(false);
				ArrayList<FootballPlayer> footballPlayers = new ArrayList<FootballPlayer>();
				File playersFile = new File(
						"C:\\Users\\ik013043z1\\eclipse-workspace\\FootballWindowBuilder\\src\\Players.txt");
				boolean playersFileFound = false;
				String modPlayerName="";
				while (!playersFileFound) {
					try {
						Scanner playersScanner = new Scanner(playersFile);
						boolean playerFound=false;
						while (playersScanner.hasNext()) {
							String player = playersScanner.nextLine();
							String[] playerInformation = player.split("::");
							if (playerInformation[0].equals(textField.getText())) {
								modPlayerName=playerInformation[0];
								playerFound=true;
								lblNewLabel.setVisible(true);
								lblNewLabel_1.setVisible(true);
								lblNewLabel_2.setVisible(true);
								textField_1.setVisible(true);
								textField_2.setVisible(true);
								textField_3.setVisible(true);
								btnNewButton_1.setVisible(true);
								textField_1.setText(modPlayerName);
								textField_2.setText(playerInformation[1]);
								textField_3.setText(playerInformation[2]);
								break;
							}
						}
						if (!playerFound) {
							lblNotFound.setVisible(true);
						}
						playersScanner.close();
						playersFileFound = true;

					} catch (FileNotFoundException i) {
						System.err.println("The file which contains the players was not found, enter the correct name");
					}
				}
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<FootballPlayer> footballPlayers = new ArrayList<FootballPlayer>();
				File playersFile = new File(
						"C:\\Users\\ik013043z1\\eclipse-workspace\\FootballWindowBuilder\\src\\Players.txt");
				boolean playersFileFound = false;
				while (!playersFileFound) {
					try {
						Scanner playersScanner = new Scanner(playersFile);
						while (playersScanner.hasNext()) {
							String player = playersScanner.nextLine();
							String[] playerInformation = player.split("::");
							FootballPlayer thisPlayer = new FootballPlayer();
							thisPlayer.setPlayerName(playerInformation[0]);
							thisPlayer.setAge(Integer.parseInt(playerInformation[1]));
							thisPlayer.setTeamName(playerInformation[2]);
							footballPlayers.add(thisPlayer);
						}
						for (int i = 0; i < footballPlayers.size(); i++) {
							if (footballPlayers.get(i).getPlayerName().equals(modPlayerName)) {
								lblNewLabel.setVisible(true);
								lblNewLabel_1.setVisible(true);
								lblNewLabel_2.setVisible(true);
								textField_1.setVisible(true);
								textField_2.setVisible(true);
								textField_3.setVisible(true);
								btnNewButton_1.setVisible(true);
								textField_1.setText(footballPlayers.get(i).getPlayerName());
								textField_2.setText(String.valueOf(footballPlayers.get(i).getAge()));
								textField_3.setText(footballPlayers.get(i).getTeamName());
								break;
							}
						}
						playersScanner.close();
						playersFileFound = true;

					} catch (FileNotFoundException i) {
						System.err.println("The file which contains the players was not found, enter the correct name");
					}
				}
			}
		});
		btnNewButton.setBounds(165, 88, 117, 23);
		contentPane.add(btnNewButton);

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

		JMenu mnModifyData = new JMenu("Modify data");
		menuBar.add(mnModifyData);

		JMenuItem mntmPlayers_2 = new JMenuItem("Players");
		mntmPlayers_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ModifyPlayer player = new ModifyPlayer();
					player.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnModifyData.add(mntmPlayers_2);

		JMenuItem mntmTeams_2 = new JMenuItem("Teams");
		mnModifyData.add(mntmTeams_2);

		JMenuItem mntmMatches_2 = new JMenuItem("Matches");
		mnModifyData.add(mntmMatches_2);
	}
}
