package com.github.sammontanaro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ChatWindow {
	
	private static Dimension chatWindowSize = new Dimension(600, 800);
	private static Dimension chatInputSize = new Dimension(600, 60);

	private static JFrame chatWindow;
	private static JTextArea chatMessageHistory;
	private static JTextField chatInput;
	private static JScrollPane chatMessageHistoryScroll;

	private static String username;
	
	public ChatWindow(String name) {
		username = name;
		createChatWindow();
	}
	
	private static void createChatWindow() {
		chatWindow = new JFrame();
		chatWindow.setPreferredSize(chatWindowSize);
		chatWindow.setTitle("Chat Client");
		chatWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		chatWindow.setLocationByPlatform(true);

		chatMessageHistory = new JTextArea();
		chatMessageHistory.setMargin(new Insets(10, 10, 0, 10));
		chatMessageHistory.setLineWrap(true);
		chatMessageHistory.setWrapStyleWord(true);
		Font chatMessageHistoryFont = chatMessageHistory.getFont();
		chatMessageHistory.setFont(chatMessageHistoryFont.deriveFont(16.0f));
		chatMessageHistory.setEditable(false);
		chatMessageHistory.setBackground(new Color(240, 240, 240));

		chatInput = new JTextField();
		chatInput.setPreferredSize(chatInputSize);
		Font chatInputFont = chatInput.getFont();
		chatInput.setFont(chatInputFont.deriveFont(16.0f));

		chatInput.addActionListener(send -> {
			String msg = chatInput.getText().trim();
			if (!msg.isEmpty()) {
				chatMessageHistory.setText(chatMessageHistory.getText() + username + ": " + chatInput.getText() + "\n");
				chatInput.setText("");
			} else {
				chatInput.setText("");
			}
		});

		chatMessageHistoryScroll = new JScrollPane(chatMessageHistory);
		chatMessageHistoryScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		chatWindow.add(chatMessageHistoryScroll, BorderLayout.CENTER);
		chatWindow.add(chatInput, BorderLayout.SOUTH);
		chatWindow.pack();
		chatWindow.setVisible(true);
	}
}
