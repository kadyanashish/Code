package game;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TTT extends JFrame implements ActionListener {

	public static final int BOARD_SIZE = 3;
	boolean turn = true;
	JButton[][] barray = new JButton[BOARD_SIZE][BOARD_SIZE];

	public static enum gamestatus {
		incomplete, zwins, xwins, tie
	};

	public TTT() {

		super.setTitle(" GAME");

		super.setSize(800, 800);
		GridLayout obj = new GridLayout(BOARD_SIZE, BOARD_SIZE);
		super.setLayout(obj);
		Font font = new Font("comic sans", 1, 200);

		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				JButton button = new JButton();
				super.add(button);
				barray[i][j] = button; // INITIALIZING BARRAYS
				button.setFont(font);

				button.addActionListener(this);

			}
		}

		super.setResizable(false);
		super.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) (e.getSource());

		makemove(b);
		gamestatus gs = getgamestatus();

		if (gs != gamestatus.incomplete) {
			declarewinner(gs);
			int choice = JOptionPane.showConfirmDialog(this, "Restart?");
			if (choice == JOptionPane.YES_OPTION) {
				for (int i = 0; i < BOARD_SIZE; i++) {
					for (int j = 0; j < BOARD_SIZE; j++) {
						barray[i][j].setText("");

					}
				}
				turn = true;

			} else {
				super.dispose();
			}
		}
	}

	public gamestatus getgamestatus() {
		String text;

		int col = 0;
		int row = 0;
		// for col
		for (row = 0; row < BOARD_SIZE; row++) {
			for (col = 0; col < BOARD_SIZE - 1; col++) {
				if (barray[row][col].getText() != barray[row][col + 1].getText() || barray[row][col].getText() == "") {
					break;
				}
			}

			if (col == BOARD_SIZE - 1) {
				if (barray[row][col].getText() == "X") {
					return gamestatus.xwins;
				} else {
					return gamestatus.zwins;
				}
			}

		}
		// for row
		for (col = 0; col < BOARD_SIZE; col++) {
			for (row = 0; row < BOARD_SIZE - 1; row++) {
				if (barray[row][col].getText() != barray[row + 1][col].getText() || barray[row][col].getText() == "") {
					break;
				}
			}

			if (row == BOARD_SIZE - 1) {
				if (barray[row][col].getText() == "X") {
					return gamestatus.xwins;
				} else {
					return gamestatus.zwins;
				}
			}

		}
		// diag 1
		row = 0;
		col = 0;
		for (row = 0; row < BOARD_SIZE - 1; col++, row++) {
			if (barray[row][col].getText() != barray[row + 1][col + 1].getText() || barray[row][col].getText() == "") {
				break;
			}

		}

		if (row == BOARD_SIZE - 1) {
			if (barray[row][col].getText() == "X") {
				return gamestatus.xwins;
			} else {
				return gamestatus.zwins;
			}
		}
		// diag2
		row = BOARD_SIZE - 1;
		col = 0;
		for (row = BOARD_SIZE - 1; row > 0; col++, row--) {
			if (barray[row][col].getText() != barray[row - 1][col + 1].getText() || barray[row][col].getText() == "") {
				break;
			}

		}

		if (row == 0) {
			if (barray[row][col].getText() == "X") {
				return gamestatus.xwins;
			} else {
				return gamestatus.zwins;
			}
		}

		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				text = barray[i][j].getText();
				if (text == "") {
					return gamestatus.incomplete;
				}
			}
		}
		return gamestatus.tie;

	}

	public void makemove(JButton b) {
		String text = b.getText();

		if (text.length() > 0) {
			JOptionPane.showMessageDialog(b, "INVALID INPUT");

			return;
		} else {
			if (turn) {
				b.setText("X");
			} else {
				b.setText("O");
			}
			turn = !turn;
		}

	}

	public void declarewinner(gamestatus gs) {
		if (gs == gamestatus.xwins) {
			JOptionPane.showMessageDialog(null, "xwins");
		}
		if (gs == gamestatus.zwins) {
			JOptionPane.showMessageDialog(null, "zwins");

		}

		if (gs == gamestatus.tie) {
			JOptionPane.showMessageDialog(null, "tie");
		}
	}

}
