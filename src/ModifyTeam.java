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

public class ModifyTeam {

	private JFrame frame;
	private JTextField textFieldNewName;
	private JTextField textFieldNewCoach;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyTeam window = new ModifyTeam();
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
	public ModifyTeam() {
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

		JTextField textFieldName = new JTextField();
		textFieldName.setBounds(165, 50, 134, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);

		JLabel lblNotFound = new JLabel("Not found");
		lblNotFound.setBounds(337, 53, 97, 14);
		lblNotFound.setVisible(false);
		contentPane.add(lblNotFound);

		JLabel lblNewName = new JLabel("New name");
		lblNewName.setBounds(10, 92, 86, 14);
		lblNewName.setVisible(false);
		contentPane.add(lblNewName);

		textFieldNewName = new JTextField();
		textFieldNewName.setBounds(93, 89, 86, 20);
		textFieldNewName.setVisible(false);
		contentPane.add(textFieldNewName);
		textFieldNewName.setColumns(10);

		JLabel lblNewCoach = new JLabel("New coach");
		lblNewCoach.setBounds(213, 92, 86, 14);
		lblNewCoach.setVisible(false);
		contentPane.add(lblNewCoach);

		textFieldNewCoach = new JTextField();
		textFieldNewCoach.setBounds(310, 92, 86, 20);
		textFieldNewCoach.setVisible(false);
		contentPane.add(textFieldNewCoach);
		textFieldNewCoach.setColumns(10);

		JButton btnModify = new JButton("Modify");
		btnModify.setVisible(false);
		btnModify.setBounds(273, 146, 89, 23);
		contentPane.add(btnModify);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNotFound.setVisible(false);
				lblNewName.setVisible(false);
				lblNewCoach.setVisible(false);
				textFieldNewName.setVisible(false);
				textFieldNewCoach.setVisible(false);
				btnModify.setVisible(false);
				File teamsFile = new File(
						"C:\\Users\\ik013043z1\\eclipse-workspace\\FootballWindowBuilder\\src\\Teams.txt");
				boolean teamsFileFound = false;
				String modTeamName="";
				while (!teamsFileFound) {
					try {
						Scanner teamsScanner = new Scanner(teamsFile);
						boolean teamFound=false;
						while (teamsScanner.hasNext()) {
							String team = teamsScanner.nextLine();
							String[] teamInformation = team.split("::");
							if (teamInformation[0].equals(textFieldName.getText())) {
								modTeamName=teamInformation[0];
								teamFound=true;
								lblNewName.setVisible(true);
								lblNewCoach.setVisible(true);
								textFieldNewName.setVisible(true);
								textFieldNewCoach.setVisible(true);
								btnModify.setVisible(true);
								textFieldNewName.setText(modTeamName);
								textFieldNewCoach.setText(teamInformation[1]);
								lblName.setVisible(false);
								textFieldName.setVisible(false);
								btnSearch.setVisible(false);
								break;
							}
						}
						if (!teamFound) {
							lblNotFound.setVisible(true);
						}
						teamsScanner.close();
						teamsFileFound = true;

					} catch (FileNotFoundException i) {
						System.err.println("The file which contains the teams was not found, enter the correct name");
					}
				}
			}
		});
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Team> teams = new ArrayList<Team>();
				File teamsFile = new File(
						"C:\\Users\\ik013043z1\\eclipse-workspace\\FootballWindowBuilder\\src\\Teams.txt");
				boolean teamsFileFound = false;
				while (!teamsFileFound) {
					try {
						Scanner teamsScanner = new Scanner(teamsFile);
						while (teamsScanner.hasNext()) {
							String team = teamsScanner.nextLine();
							String[] teamInformation = team.split("::");
							Team thisTeam = new Team(teamInformation[0]);
							thisTeam.setCoach(teamInformation[1]);
							teams.add(thisTeam);
						}
						for (int i = 0; i < teams.size(); i++) {
							if (teams.get(i).getTeamName().equals(textFieldName.getText())) {
								teams.remove(i);
								Team newTeam = new Team(textFieldNewName.getText());
								newTeam.setCoach(textFieldNewCoach.getText());
								teams.add(newTeam);
								BufferedWriter writer = new BufferedWriter(new FileWriter(teamsFile));
								String teamInformation = "";
								for (int j = 0; j < teams.size(); j++) {
									String teamName = teams.get(j).getTeamName();
									String coach = teams.get(j).getCoach();
									teamInformation = teamName+"::"+coach;
									writer.write(teamInformation);
									writer.newLine();
								}
								writer.close();
								break;
							}
						}
						teamsScanner.close();
						teamsFileFound = true;
					} catch (FileNotFoundException i) {
						System.err.println("The file which contains the teams was not found, enter the correct name.");
					} catch (IOException e) {
						System.out.println("The 'FileWriter' object could not be created.");
					}
				}
				lblName.setVisible(true);
				textFieldName.setText("");
				textFieldName.setVisible(true);
				btnSearch.setVisible(true);
				lblNewName.setVisible(false);
				lblNewCoach.setVisible(false);
				textFieldNewName.setVisible(false);
				textFieldNewCoach.setVisible(false);
				btnModify.setVisible(false);
			}
		});
		btnSearch.setBounds(165, 88, 117, 23);
		contentPane.add(btnSearch);

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
		mntmTeams_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ModifyTeam team = new ModifyTeam();
					team.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnModifyData.add(mntmTeams_2);

		JMenuItem mntmMatches_2 = new JMenuItem("Matches");
		mntmMatches_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ModifyFootballMatch footballMatch = new ModifyFootballMatch();
					footballMatch.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnModifyData.add(mntmMatches_2);
	}
}
