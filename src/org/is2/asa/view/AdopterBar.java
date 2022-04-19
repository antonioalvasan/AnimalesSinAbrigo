package org.is2.asa.view;

import org.is2.asa.control.AdopterController;
import org.is2.asa.view.Utilities;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdopterBar extends JPanel {

	AdopterController adopterController;

	public AdopterBar(AdopterController adopterController) {
		this.adopterController = adopterController;
	}
	
	public void prepare_panel(){
		
		this.setLayout(new BorderLayout());
		
		JButton home = new JButton("Home");
		JButton refuge = new JButton("Refuge");
		JButton contact = new JButton("Contact");

		home.addActionListener(e -> {
			adopterController.changeWindow(AdopterHomeWindow.keyCode);
			adopterController.run();
		});
		
		JPanel left = new JPanel(new FlowLayout());
		left.setBackground(Color.LIGHT_GRAY);
		
		left.add(home);
		left.add(refuge);
		left.add(contact);
		
		Utilities.setTransparent(home);
		Utilities.setTransparent(refuge);
		Utilities.setTransparent(contact);
		
		JPanel right = new JPanel(new FlowLayout());
		right.setBackground(Color.LIGHT_GRAY);
		
		JButton user_name = new JButton(adopterController.getUsername());
		JButton user_icon = new JButton(new ImageIcon("imagen.png"));

		user_name.addActionListener(e ->{
			adopterController.changeWindow(AdopterUserInfoWindow.keyCode);
			adopterController.run();
		});
		user_icon.addActionListener(e ->{
			adopterController.changeWindow(AdopterUserInfoWindow.keyCode);
			adopterController.run();
		});

		Utilities.setTransparent(user_name);
		Utilities.setTransparent(user_icon);
		
		right.add(user_name);
		right.add(user_icon);
		
		this.add(left, BorderLayout.WEST);
		this.add(right, BorderLayout.EAST);
		this.setBackground(Color.LIGHT_GRAY);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
	}

}
