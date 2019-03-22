import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Insets;
import javax.swing.JLabel;

public class Football {

	private JFrame frame;
	private int option;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Football window = new Football();
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

	public JFrame getFrame() {
		return this.frame;
	}

	public Football(int option) {
		initialize();
		this.option = option;
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
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

		JScrollPane scrollBar = new JScrollPane();
		scrollBar.setBounds(0, 22, 434, 232);

		frame.getContentPane().add(scrollBar);

		JTextPane textPane_1 = new JTextPane();
		scrollBar.setViewportView(textPane_1);
		textPane_1.setEditable(false);

		if (this.option == 1) {

			JLabel lblName = new JLabel("Players:");
			lblName.setBounds(52, 68, 80, 14);
			contentPane.add(lblName);
			File playersFile = new File(
					"C:\\Users\\ik013043z1\\eclipse-workspace\\FootballWindowBuilder\\src\\Players.txt");
			boolean playersFileFound = false;
			while (!playersFileFound) {
				try {
					Scanner playersScanner = new Scanner(playersFile);
					String player = "";
					while (playersScanner.hasNext()) {
						player = player + "\n" + playersScanner.nextLine();

					}
					textPane_1.setText(player);
					playersScanner.close();
					playersFileFound = true;
				} catch (FileNotFoundException e) {
					System.err.println("The file which contains the players was not found, enter the correct name");
				}
			}

		} else if (this.option == 2) {
			File teamsFile = new File(
					"C:\\Users\\ik013043z1\\eclipse-workspace\\FootballWindowBuilder\\src\\Teams.txt");
			boolean teamsFileFound = false;
			while (!teamsFileFound) {
				try {
					Scanner teamsScanner = new Scanner(teamsFile);
					String team = "";
					while (teamsScanner.hasNext()) {
						team = team + "\n" + teamsScanner.nextLine();

					}
					textPane_1.setText(team);
					teamsScanner.close();
					teamsFileFound = true;
				} catch (FileNotFoundException e) {
					System.err.println("The file which contains the teams was not found, enter the correct name");
				}
			}

		} else if (this.option == 3) {
			File matchesFile = new File(
					"C:\\Users\\ik013043z1\\eclipse-workspace\\FootballWindowBuilder\\src\\ChampionsMatches.txt");
			boolean matchesFileFound = false;
			while (!matchesFileFound) {
				try {
					Scanner matchesScanner = new Scanner(matchesFile);
					String match = "";
					while (matchesScanner.hasNext()) {
						match = match + "\n" + matchesScanner.nextLine();

					}
					textPane_1.setText(match);
					matchesScanner.close();
					matchesFileFound = true;
				} catch (FileNotFoundException e) {
					System.err.println("The file which contains the matches was not found, enter the correct name");
				}
			}
		}

	}

	public Football() {
		initialize();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
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

		JScrollPane scrollBar = new JScrollPane();
		scrollBar.setBounds(0, 22, 434, 239);

		frame.getContentPane().add(scrollBar);

		JTextPane textPane_1 = new JTextPane();
		scrollBar.setViewportView(textPane_1);
		textPane_1.setEditable(false);

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
