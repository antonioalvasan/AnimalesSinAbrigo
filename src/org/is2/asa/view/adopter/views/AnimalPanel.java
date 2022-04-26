package org.is2.asa.view.adopter.views;

import org.is2.asa.control.AdopterController;
import org.is2.asa.control.AnimalController;
import org.is2.asa.model.Animal;
import org.is2.asa.model.states.AdoptionRequestedState;
import org.is2.asa.view.Utilities;

import java.awt.*;
import javax.swing.*;

public class AnimalPanel extends JPanel {

	Animal animal;
	AdopterController adopterController;

	public AnimalPanel(Animal animal, AdopterController adopterController) {
		this.animal = animal;
		this.adopterController = adopterController;
	}

	public void prepare_panel() {

		this.setBackground(Color.GRAY);
		this.setLayout(new FlowLayout());

		JButton animalImg = new JButton(new ImageIcon( animal.getImg()));
		this.add(animalImg, BorderLayout.EAST);

		Utilities.setTransparent(animalImg);

		JPanel panel_centre = new JPanel(new BorderLayout());

		Label dog_name = new Label(animal.getName());
		Label dog_description = new Label(animal.getDescription());
		dog_name.setBackground(Color.GRAY);
		dog_description.setBackground(Color.GRAY);


		panel_centre.add(dog_name, BorderLayout.NORTH);
		panel_centre.add(dog_description, BorderLayout.CENTER);

		this.add(panel_centre);

		JButton adopt = new JButton("Adopt");

		adopt.setBackground(Color.LIGHT_GRAY);
		//action listener
		adopt.addActionListener(e -> {
			//dialog for adoption request commiting
			JDialog request = new JDialog();
			JPanel panel = new JPanel(new BorderLayout());

			JLabel message = new JLabel("¿Quieres adoptar a " + animal.getName() + "?");
			message.setFont(new Font("Arial", Font.BOLD, 30));
			message.setHorizontalAlignment(JLabel.CENTER);
			panel.add(message, BorderLayout.NORTH);

			JButton yes = new JButton("SI");
			JButton no = new JButton("NO");
			JPanel centre = new JPanel(new FlowLayout());
			centre.add(yes);
			centre.add(no);

			panel.add(centre, BorderLayout.CENTER);
			panel.setBackground(Color.LIGHT_GRAY);
			centre.setBackground(Color.lightGray);

			request.setSize(new Dimension(500, 500));
			request.add(panel);
			request.setVisible(true);

			yes.addActionListener(e1 -> {
				animal.changeState(new AdoptionRequestedState(animal));
				request.dispose();
				adopterController.changeWindow(AdopterRefugeListWindow.key);
				adopterController.run();
			});

			no.addActionListener(e1 -> {
				request.dispose();
			});

		});

		this.add(adopt, FlowLayout.RIGHT);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setPreferredSize(new Dimension(600, 100));

	}

	public AnimalPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public AnimalPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public AnimalPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

}
