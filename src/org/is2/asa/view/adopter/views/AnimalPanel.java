package org.is2.asa.view.adopter.views;

import org.is2.asa.control.AnimalController;
import org.is2.asa.model.Animal;
import org.is2.asa.model.states.AdoptionRequestedState;
import org.is2.asa.view.Utilities;

import java.awt.*;
import javax.swing.*;

public class AnimalPanel extends JPanel {

	Animal animal;

	public AnimalPanel(Animal animal) {
		this.animal = animal;
	}

	public void prepare_panel() {

		this.setBackground(Color.GRAY);
		this.setLayout(new FlowLayout());

		JButton animalImg = new JButton("foto del perro");
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
		JButton info = new JButton("info");


		adopt.setBackground(Color.LIGHT_GRAY);
		info.setBackground(Color.LIGHT_GRAY);

		this.add(info, FlowLayout.RIGHT);
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
