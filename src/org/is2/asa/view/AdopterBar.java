package org.is2.asa.view;

import org.is2.asa.control.AdopterController;
import org.is2.asa.view.Utilities;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		JButton refuge = new JButton("Refuge");
		JButton contact = new JButton("Contact");

		home.addActionListener(e -> {
			adopterController.changeWindow(AdopterHomeWindow.keyCode);
			adopterController.run();
		});

		//MenuPanel is used for home button and such. Is located at top left corner.
		JPanel menuPanel = new JPanel(new FlowLayout());
		menuPanel.setBackground(Color.LIGHT_GRAY);
		
		menuPanel.add(home);
		menuPanel.add(refuge);
		menuPanel.add(contact);
		
		Utilities.setTransparent(home);
		Utilities.setTransparent(refuge);
		Utilities.setTransparent(contact);

		//UserPanel is set for username and userIcon and is located at top right corner.
		JPanel userPanel = new JPanel(new FlowLayout());
		userPanel.setBackground(Color.LIGHT_GRAY);
		
		JButton user_name = new JButton(adopterController.getUsername());
		JButton user_icon = new JButton(new ImageIcon("imagen.png"));

		user_name.addActionListener(e ->{
			/*Esto se folla la POO, quiza el controler deberia tener una funcion que fuera (info) y ya que se
			* encargue de pillar los keyCodes el propio controler. Me ralla el hecho de que una ventana pueda
			* acceder a la key de otra ventana.*/
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
		this.setBackground(Color.LIGHT_GRAY);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
	}

}
