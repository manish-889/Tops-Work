package com.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controller.UserController;
import Model.User;
import net.proteanit.sql.DbUtils;

class RegistrationForm{
	
	JFrame frame;
	JPanel northPanel, westPanel, fromPanel, buttonPanel, btnGridPanel, resetPanel, genderPanel, centerPanel;
	JLabel l1, l2, l3, l4, l5;
	JTextField t1, t2, t3, t4;
	JLabel lbTitle;
	JButton exitBtn, registerBtn, deleteBtn, updateBtn, resetBtn, refreshBtn;;
	JRadioButton radioMale, radioFemale;
	ButtonGroup genderGroup;
	JTable table;
	JScrollPane scrollPane;
	private UserController uc = new UserController();
	
	public RegistrationForm() {
		
		lbTitle = new JLabel("Registration From");
		
		l1 = new JLabel("ID");
		l2 = new JLabel("NAME");
		l3 = new JLabel("GENDER");
		l4 = new JLabel("ADDRESS");
		l5 = new JLabel("CONTACT");
		
		t1 = new JTextField(20);
		t1.setEnabled(false);
		t2 = new JTextField(20);
		t3 = new JTextField(20);
		t4 = new JTextField(20);
		
		exitBtn = new JButton("EXIT");
		registerBtn = new JButton("REGISTER");
		deleteBtn = new JButton("DELETE");
		deleteBtn.setEnabled(false);
		updateBtn = new JButton("UPDATE");
		updateBtn.setEnabled(false);
		resetBtn = new JButton("RESET");
		resetBtn.setPreferredSize(new Dimension(120, 25));
		refreshBtn = new JButton("Refresh Table");
		refreshBtn.setPreferredSize(new Dimension(10, 15));
		
		
		frame = new JFrame();
		frame.setTitle("Module Practical");
		frame.setSize(900, 500);
		frame.setLayout(new BorderLayout());
		
		northPanel = new JPanel(new FlowLayout() );
		northPanel.add(lbTitle);
		
		westPanel = new JPanel(new BorderLayout());
		westPanel.setPreferredSize(new Dimension(350, 0));
		westPanel.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(),"Registration Deatils", TitledBorder.CENTER, TitledBorder.TOP));
//		westPanel.setBackground(Color.BLUE);
		
		genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		radioMale = new JRadioButton("Male");
		radioFemale = new JRadioButton("Female");
		genderGroup = new ButtonGroup();
		genderGroup.add(radioMale);
		genderGroup.add(radioFemale);
		
		genderPanel.add(radioMale);
		genderPanel.add(radioFemale);
		
		fromPanel = new JPanel(new GridLayout(5, 2, 10, 10));
		fromPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		fromPanel.add(l1);
		fromPanel.add(t1);
		fromPanel.add(l2);
		fromPanel.add(t2);
		fromPanel.add(l3);
		fromPanel.add(genderPanel);
		fromPanel.add(l4);
		fromPanel.add(t3);
		fromPanel.add(l5);
		fromPanel.add(t4);
		
		
		
		buttonPanel = new JPanel(new BorderLayout());
		buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		resetPanel = new JPanel(new FlowLayout());
		resetPanel.add(resetBtn);
		
		btnGridPanel = new JPanel(new GridLayout(2, 2, 5, 5));
		
		btnGridPanel.add(exitBtn);
		btnGridPanel.add(registerBtn);
		btnGridPanel.add(updateBtn);
		btnGridPanel.add(deleteBtn);
		
		buttonPanel.add(btnGridPanel, BorderLayout.NORTH);
		buttonPanel.add(resetPanel, BorderLayout.SOUTH);
		
		westPanel.add(fromPanel, BorderLayout.NORTH);
		westPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		table = new JTable();
		
		scrollPane = new JScrollPane(table);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
		
		centerPanel = new JPanel(new BorderLayout());
		centerPanel.add(scrollPane, BorderLayout.NORTH);
		centerPanel.add(refreshBtn, BorderLayout.SOUTH);
		
		frame.add(northPanel, BorderLayout.NORTH);
		frame.add(westPanel, BorderLayout.WEST);
		frame.add(centerPanel, BorderLayout.CENTER);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		
		refreshBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refreshTable();
			}
		});
		
		registerBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = t2.getText();
				String gender = radioMale.isSelected() ? "Male" : "Female";
				
				String address = t3.getText();
				String contact = t4.getText();
				
//				System.out.println("Name : "+name);
//				System.out.println("Address :"+address);
//				System.out.println("Contact : "+contact);
//				System.out.println("Gender : "+gender);
				
				addUser(name, gender, address, contact);
			}
		});
		
		deleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(t1.getText());
				
				if(id > 0) {
					try {
						int  c = uc.deleteRecord(id);
						if(c > 0) {
							
							refreshTable();
							restFields();
							JOptionPane.showMessageDialog(frame,"Record deleted successfully.");  
							
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		updateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				User user = new User();
				user.setId(Integer.parseInt(t1.getText()));
				user.setName(t2.getText());
				user.setGender(radioMale.isSelected() ? "Male" : "Female");
				user.setAddress(t3.getText());
				user.setContact(t4.getText());
				
				try {
					int c = uc.updateUser(user);
					
					if(c > 0) {
						refreshTable();
						restFields();
						JOptionPane.showMessageDialog(frame,"Record updated successfully.");  
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		resetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				resetProgram();
			}
		});
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting()) {
					int selectedRow = table.getSelectedRow();
					if(selectedRow != -1) {
						t1.setText(table.getValueAt(selectedRow, 0).toString());
						t2.setText(table.getValueAt(selectedRow, 1).toString());
						t3.setText(table.getValueAt(selectedRow, 3).toString());
						t4.setText(table.getValueAt(selectedRow, 4).toString());
						
						String gender = table.getValueAt(selectedRow, 2).toString();
						
						if(gender.equalsIgnoreCase("Male")) {
							radioMale.setSelected(true);
						}else {
							radioFemale.setSelected(true);
						}
						
						registerBtn.setEnabled(false);
						deleteBtn.setEnabled(true);
						updateBtn.setEnabled(true);
						
					}
				}
			}
		});
		
	
		
	}
	
	protected void resetProgram() {
		t2.setText("");
		t3.setText("");
		t4.setText("");
		
		genderGroup.clearSelection();
	}

	private void refreshTable() {
		try {
			ResultSet rs = uc.readRecord();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addUser(String name, String gender, String address, String contact) {
		User user = new User();
		user.setName(name);
		user.setGender(gender);
		user.setAddress(address);
		user.setContact(contact);
		
		try {
			int row = uc.insertRecord(user);
			if(row > 0) {
				restFields();
				JOptionPane.showMessageDialog(frame,"Record saved successfully.");  
			}else {
				System.out.println("Record not saved.");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error : "+e.getMessage());
		}
		
	}

	private void restFields() {
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		
	}
	
}

public class Form {
	public static void main(String[] args) {
		new RegistrationForm();
	}
}
