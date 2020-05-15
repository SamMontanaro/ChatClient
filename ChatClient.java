package com.github.sammontanaro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class ChatClient {

	private static Dimension clientSize = new Dimension(600, 800);
	private static Dimension chatInputSize = new Dimension(600, 60);

	public ChatClient() {
		createWindow();
	}

	private static void createWindow() {
		JFrame window = new JFrame();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		window.setResizable(false);
		window.setPreferredSize(clientSize);
		window.setTitle("Chat Client");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationByPlatform(true);

		JTextArea chatMessageHistory = new JTextArea();
		chatMessageHistory.setLineWrap(true);
		chatMessageHistory.setWrapStyleWord(true);
		Font chatMessageHistoryFont = chatMessageHistory.getFont();
		chatMessageHistory.setFont(chatMessageHistoryFont.deriveFont(16.0f));
		chatMessageHistory.setEditable(false);
		chatMessageHistory.setBackground(new Color(240, 240, 240));

		JTextField chatInput = new JTextField();
		chatInput.setPreferredSize(chatInputSize);
		Font chatInputFont = chatInput.getFont();
		chatInput.setFont(chatInputFont.deriveFont(16.0f));

		chatInput.addActionListener(send->{
			String msg = chatInput.getText().trim();
			if (!msg.isEmpty()) {
				chatMessageHistory.setText(chatMessageHistory.getText() + chatInput.getText() + "\n");
				chatInput.setText("");
			}
			else {
				chatInput.setText("");
			}
		});
		
		JScrollPane chatMessageHistoryScroll = new JScrollPane(chatMessageHistory);
		chatMessageHistoryScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		window.add(chatMessageHistoryScroll, BorderLayout.CENTER);
		window.add(chatInput, BorderLayout.SOUTH);
		window.pack();
		window.setVisible(true);
	}

	public static void main(String[] args) {
		ChatClient chat = new ChatClient();
	}
}