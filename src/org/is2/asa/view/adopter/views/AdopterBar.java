package org.is2.asa.view.adopter.views;

import org.is2.asa.control.AdopterController;
import org.is2.asa.view.Utilities;

import java.awt.*;
import javax.swing.*;

public class AdopterBar extends JPanel {

	/*
	* AdopterBar
	*
	* Used by AdopterHomeWindow, is a customized JPanel used as MenuBar.
	* Parameter: adopterController. Is used to get user's name and to change windows when required.
	*/

	AdopterController adopterController;

	public AdopterBar(AdopterController adopterController) {
		this.adopterController = adopterController;
	}
	
	public void prepare_panel(){
		
		this.setLayout(new BorderLayout());
		
		JButton home = new JButton("Home");
		JButton refuge = new JButton("Refuges");

		JButton myAnimals = new JButton("My Animals");


		home.addActionListener(e -> {
			adopterController.changeWindow(AdopterHomeWindow.key);
			adopterController.run();
		});

		refuge.addActionListener(e ->{
			adopterController.changeWindow(AdopterRefugeListWindow.key);
			adopterController.run();
		});

		myAnimals.addActionListener(e->{
			adopterController.changeWindow(AdopterAnimalsWindow.key);
			adopterController.run();
		});


		//MenuPanel is used for home button and such. Is located at top left corner.
		JPanel menuPanel = new JPanel(new FlowLayout());
		menuPanel.setBackground(new Color(197, 237, 253, 207));
		
		menuPanel.add(home);
		menuPanel.add(refuge);

		menuPanel.add(myAnimals);
		
		Utilities.setTransparent(home);
		Utilities.setTransparent(refuge);

		Utilities.setTransparent(myAnimals);

		//UserPanel is set for username and userIcon and is located at top right corner.
		JPanel userPanel = new JPanel(new FlowLayout());
		userPanel.setBackground(new Color(197, 237, 253, 207));
		
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
		
		userPanel.add(user_name);
		userPanel.add(user_icon);
		
		this.add(menuPanel, BorderLayout.WEST);
		this.add(userPanel, BorderLayout.EAST);
		this.setBackground(new Color(197, 237, 253, 207));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
	}

}
