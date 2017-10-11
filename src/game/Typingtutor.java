package game;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Typingtutor extends JFrame implements ActionListener,KeyListener {
	private JLabel lblTimer;
	private JLabel lblScore;
	private JLabel lblWord;
	private JTextField txtWord;
	private JButton btnStart;
	private JButton btnStop;

	private Timer clocktimer = null;
	private Timer wordtimer=null;
	private int timeRemaining = 50;
	private boolean running = false;
	private int score = 0;
	private String[] word = null;

	public Typingtutor(String[] args) {
		word = args;

		GridLayout layout = new GridLayout(3, 2);
		super.setLayout(layout);

		Font font = new Font("Comic Sans MS", 1, 150);

		lblTimer = new JLabel("Time");
		lblTimer.setFont(font);
		super.add(lblTimer);

		lblScore = new JLabel("Score");
		lblScore.setFont(font);
		super.add(lblScore);

		lblWord = new JLabel("Word");
		lblWord.setFont(font);
		super.add(lblWord);

		txtWord = new JTextField("");
		txtWord.setFont(font);
		txtWord.addKeyListener(this);
		super.add(txtWord);

		btnStart = new JButton("Start");
		btnStart.setFont(font);
		btnStart.addActionListener(this);
		super.add(btnStart);

		btnStop = new JButton("Stop");
		btnStop.setFont(font);
		btnStop.addActionListener(this);
		super.add(btnStop);

		super.setTitle("TYPING TUTOR");
		super.setVisible(true); // on mac use it in end
		super.setExtendedState(MAXIMIZED_BOTH);
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		setupthegame();
	}

	private void setupthegame() {
		clocktimer = new Timer(1000, this);
		clocktimer.setInitialDelay(0);
		wordtimer=new Timer(3000,this);
		wordtimer.setInitialDelay(0);
		timeRemaining = 50;
		score = 0;
		running = false;

		lblTimer.setText("Time" + timeRemaining);
		lblScore.setText("Score" + score);
		lblWord.setText("");
		btnStart.setText("Start");
		btnStop.setText("Stop");

		txtWord.setEnabled(false);
		btnStop.setEnabled(false);
	}

	@Override
	public synchronized void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStart) {
			handleStart();
		} else if (e.getSource() == btnStop) {
			handleStop();
		} else if (e.getSource() == clocktimer) {
			handleclocktimer();
		}else if(e.getSource()==wordtimer)
		{
			handlewordtimer();
		}

	}

	private void handlewordtimer() {
		String actual = txtWord.getText();
		String expected = lblWord.getText();
		if (expected.length() > 0 && actual.equals(expected)) {
			score++;
		}
		lblScore.setText("Score" + score);
		int ridx = (int) (Math.random() * word.length);

		lblWord.setText(word[ridx]);
		txtWord.setText("");
	}

	private void handleclocktimer() {
		timeRemaining--;
		if (timeRemaining < 0) {
			handleStop();
			return;
		}
		
		lblTimer.setText("Time" + timeRemaining);
		
	}


	private void handleStop() {
		clocktimer.stop();
		wordtimer.stop();
		int choice = JOptionPane.showConfirmDialog(this, "Replay.?");
		if (choice == JOptionPane.YES_OPTION) {
			setupthegame();
		} else if (choice == JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(this, "Your Score " + score);
			super.dispose();
		} else if (choice == JOptionPane.CANCEL_OPTION) {
			if (timeRemaining <= 0) {
				setupthegame();
			} else {
				clocktimer.start();
				wordtimer.start();
			}
		}

	}

	private void handleStart() {
		if (running == false) {
			clocktimer.start();
			wordtimer.start();
			running = true;
			btnStart.setText("Pause");
			btnStop.setEnabled(true);
			txtWord.setEnabled(true);
		} else if (running == true) {
			clocktimer.stop();
			wordtimer.stop();
			running = false;
			btnStart.setText("Start");
			txtWord.setEnabled(false);
			btnStop.setEnabled(false);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		String actual = txtWord.getText();
		String expected = lblWord.getText();
		if (expected.length() > 0 && actual.equals(expected)) {
			score++;
			lblScore.setText("Score" + score);
			int ridx = (int) (Math.random() * word.length);

			lblWord.setText(word[ridx]);
			txtWord.setText("");
			wordtimer.restart();
		}
		
	}
}
