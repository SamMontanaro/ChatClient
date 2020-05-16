package com.github.sammontanaro;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class LoginWindow {
	
	private static Dimension loginWindowSize = new Dimension(512, 384);

	private static JFrame loginWindow;
	private static JLabel usernameLabel;
	private static JTextField usernameInput;
	
	private static void createLoginWindow() {
		loginWindow = new JFrame();
		loginWindow.setLayout(new GridBagLayout());
		loginWindow.setResizable(false);
		loginWindow.setPreferredSize(loginWindowSize);
		loginWindow.setTitle("Login");
		loginWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		loginWindow.setLocationByPlatform(true);

		GridBagConstraints inputConstraints = new GridBagConstraints();
		inputConstraints.gridy = 1;

		GridBagConstraints labelConstraints = new GridBagConstraints();
		labelConstraints.gridy = 0;
		labelConstraints.insets = new Insets(10, 10, 10, 10);

		usernameLabel = new JLabel("Enter Username:");
		usernameLabel.setFont(new Font("Helvetica", Font.BOLD, 16));

		usernameInput = new JTextField(10);
		Font usernameInputFont = usernameInput.getFont();
		usernameInput.setFont(usernameInputFont.deriveFont(16.0f));

		usernameInput.addActionListener(send -> {
			String input = usernameInput.getText().trim();
			if (!input.isEmpty()) {
				loginWindow.setVisible(false);
				loginWindow.dispose();
				ChatWindow chat = new ChatWindow(input);
			} else {
				usernameInput.setText("");
			}
		});

		loginWindow.add(usernameLabel, labelConstraints);
		loginWindow.add(usernameInput, inputConstraints);
		loginWindow.pack();
		loginWindow.setVisible(true);
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createLoginWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
