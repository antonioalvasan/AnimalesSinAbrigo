package org.is2.asa.view;

import org.is2.asa.view.Utilities;

import java.awt.*;
import javax.swing.*;

public class AdopterBar extends JPanel {

	public AdopterBar() {
		
	}
	
	public void prepare_panel(){
		
		this.setLayout(new BorderLayout());
		
		JButton home = new JButton("Home");
		JButton refuge = new JButton("Refuge");
		JButton contact = new JButton("Contact");
		JButton FAQ = new JButton("Faq");
		
		JPanel left = new JPanel(new FlowLayout());
		left.setBackground(Color.LIGHT_GRAY);
		
		left.add(home);
		left.add(refuge);
		left.add(contact);
		left.add(FAQ);
		
		Utilities.setTransparent(home);
		Utilities.setTransparent(refuge);
		Utilities.setTransparent(contact);
		Utilities.setTransparent(FAQ);
		
		JPanel right = new JPanel(new FlowLayout());
		right.setBackground(Color.LIGHT_GRAY);
		
		JButton user_name = new JButton("Guille"); 
		JButton user_icon = new JButton(new ImageIcon("imagen.png"));

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
