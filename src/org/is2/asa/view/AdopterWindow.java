package org.is2.asa.view;

import org.is2.asa.control.AdopterController;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class AdopterWindow extends JPanel {

	AdopterController controller;

	public AdopterWindow(AdopterController ctrl) {
		this.controller = ctrl;

	}

	public void prepareWindow() {
		// Panel declaration
		this.setLayout(new BorderLayout());
		JPanel panel_sup = new JPanel((new BorderLayout()));
		panel_sup.setBackground(Color.LIGHT_GRAY);


		/********* Superior section **********/

		JPanel panel_sup0 = new JPanel(new BorderLayout());
		JPanel panel_sup1 = new JPanel(new BorderLayout());
		panel_sup0.setBackground(Color.LIGHT_GRAY);
		panel_sup1.setBackground(Color.LIGHT_GRAY);

		// superior panel

		ArrayList<JButton> buttons = new ArrayList<JButton>();

		JButton home = new JButton("Home");
		JButton refuge = new JButton("Refuge");
		JButton adopters = new JButton("Adopters");
		JButton volunteers = new JButton("Volunteers");
		JButton FAQ = new JButton("FAQ");
		JButton user = new JButton(controller.getUserLabel().getText());
		JButton user_image = new JButton(new ImageIcon("imagen.png"));

		buttons.add(home);
		buttons.add(refuge);
		buttons.add(adopters);
		buttons.add(volunteers);
		buttons.add(FAQ);
		buttons.add(user);
		buttons.add(user_image);

		for(JButton b : buttons)
			Utilities.setTransparent(b);

		JPanel x = new JPanel( new FlowLayout());
		x.setBackground(Color.lightGray);
		x.add(home);
		x.add(refuge);
		x.add(adopters);
		x.add(volunteers);
		x.add(FAQ);
		panel_sup0.add(x, BorderLayout.WEST);


		JPanel y = new JPanel( new FlowLayout());
		y.setBackground(Color.LIGHT_GRAY);
		y.add(user);
		y.add(user_image);
		panel_sup0.add(y, BorderLayout.EAST);

		panel_sup0.setBorder(BorderFactory.createLineBorder(Color.black));
		panel_sup0.setVisible(true);

		// Inferior panel

		JTextField searchBar = new JTextField("Search...");
		searchBar.setPreferredSize(new Dimension(300, 20));
		JButton search_button = new JButton("Search");
		JButton filters = new JButton("Filters");

		Utilities.setTransparent(search_button);
		Utilities.setTransparent(filters);

		JPanel z = new JPanel(new FlowLayout());
		z.setBackground(Color.LIGHT_GRAY);
		z.add(searchBar);
		z.add(search_button);

		panel_sup1.add(z, BorderLayout.WEST);
		panel_sup1.add(filters, BorderLayout.EAST);

		panel_sup1.setBorder(BorderFactory.createLineBorder(Color.black));

		panel_sup1.setVisible(true);

		// adding panels
		panel_sup.add(panel_sup0, BorderLayout.NORTH);
		panel_sup.add(panel_sup1, BorderLayout.SOUTH);

		panel_sup.setVisible(true);

		/********* End of superior section ***********/

		/********** Inferior section ***********/

		JPanel animal_panel = new JPanel();
		animal_panel.setLayout(new BoxLayout(animal_panel, BoxLayout.Y_AXIS));

		//adding animal vector
		String[] names = {"Toby", "Marcelino", "Amadeo", "Juan", "Homosexual", "Eneko", "Antonio", "Fabri", "Javi", "Salgueiro"};
		AnimalPanel[] animal_vector = new AnimalPanel[names.length];

		for(int i =0; i < animal_vector.length; i++) {
			animal_vector[i] = new AnimalPanel();
			animal_vector[i].prepareWindow(names[i]);
			animal_panel.add(animal_vector[i]);
		}

		JScrollPane scroll = new JScrollPane();
		scroll.setPreferredSize(new Dimension(500,300));
		scroll.setViewportView(animal_panel);


		/********** End of inferior section *********/

		// Adding both panels to main one

		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(panel_sup, BorderLayout.NORTH);
		this.add(scroll, BorderLayout.CENTER);
	}

}
