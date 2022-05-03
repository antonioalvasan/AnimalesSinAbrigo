package org.is2.asa.view.adopter.views;

import org.is2.asa.control.AdopterController;
import org.is2.asa.model.Animal;
import org.is2.asa.model.states.AdoptionRequestedState;
import org.is2.asa.view.Refuge.InfoAnimalRefuge;
import org.is2.asa.view.Refuge.ModifyAnimalWindow;
import org.is2.asa.view.Refuge.RefugeAnimalPanel;
import org.is2.asa.view.Refuge.RefugeAnimalsWindow;
import org.is2.asa.view.Utilities;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

//MVC design pattern used
public class AdopterAnimalPanel extends JPanel {

	Animal animal;
	AdopterController adopterController;
	String type;

	public AdopterAnimalPanel(Animal animal, AdopterController adopterController, String type) {
		this.animal = animal;
		this.adopterController = adopterController;
		this.type = type;
	}

	private record Pair(JLabel first, JLabel second) {

		public JLabel getFirst() {
			return first;
		}

		public JLabel getSecond() {
			return second;
		}

	}

	public void prepare_panel() {

		this.setBackground(Color.GRAY);
		this.setLayout(new FlowLayout());

		JButton animalImg = new JButton(adopterController.imageIconAnimal(animal));
//		animalImg.setMinimumSize(new Dimension(267,250));
		this.add(animalImg, BorderLayout.EAST);

		Utilities.setTransparent(animalImg);

		JPanel panel_centre = new JPanel(new BorderLayout());

		Label animalName = new Label(animal.getName());
		Label animalDesc = new Label(animal.getDescription());
		animalName.setMinimumSize(new Dimension(100,30));
		animalDesc.setMinimumSize(new Dimension(100,30));
		animalName.setBackground(Color.gray);
		animalDesc.setBackground(Color.gray);


		panel_centre.add(animalName, BorderLayout.NORTH);
		panel_centre.add(animalDesc, BorderLayout.CENTER);

		this.add(panel_centre);

		JButton infoButton = new JButton("Info");
		infoButton.setBackground(Color.LIGHT_GRAY);

		infoButton.addActionListener(e->{

			adopterController.setAnimal(animal);

			JDialog infoDialog = new JDialog();


			JPanel mainPanel = new JPanel(new BorderLayout());


			//Top Panel
			JPanel topPanel = new JPanel();

			JLabel topMessage = new JLabel(adopterController.getAnimal().getName() + "'s data");
			topMessage.setFont(new Font("Arial", Font.BOLD, 30));
			topMessage.setHorizontalAlignment(JLabel.CENTER);

			topPanel.add(topMessage);
			topPanel.setBackground(Color.LIGHT_GRAY);
			topPanel.setBorder(BorderFactory.createLineBorder(Color.black));


			//Info Panel
			JPanel infoPanel = new JPanel();
			infoPanel.setBackground(Color.GRAY);
			infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

			Pair namePair = new Pair(new JLabel("Name:"), new JLabel(adopterController.getAnimal().getName()));
			Pair agePair = new Pair(new JLabel("Age:"), new JLabel(String.valueOf(adopterController.getAnimal().getAge())+" Years"));
			Pair weightPair = new Pair(new JLabel("Weight:"), new JLabel(String.valueOf(adopterController.getAnimal().getWeight()) + " Kg"));
			Pair speciePair = new Pair(new JLabel("Specie:"), new JLabel(adopterController.getAnimal().getSpecies()));
			Pair racePair = new Pair(new JLabel("Race:"), new JLabel(adopterController.getAnimal().getRace()));

			ArrayList<Pair> data = new ArrayList<>(Arrays.asList(namePair, agePair, weightPair, speciePair, racePair));
			ArrayList<JPanel> panels = new ArrayList<>();

			for (int i = 0; i < data.size(); i++) {
				panels.add(new JPanel(new FlowLayout()));
				panels.get(i).setBackground(Color.GRAY);
				data.get(i).getFirst().setFont(new Font("Arial", Font.BOLD, 25));
				data.get(i).getSecond().setFont(new Font("Arial", Font.BOLD, 25));
				panels.get(i).add(data.get(i).getFirst());
				panels.get(i).add(data.get(i).getSecond());
				infoPanel.add(panels.get(i));
			}




			mainPanel.add(topPanel, BorderLayout.NORTH);
			mainPanel.add(infoPanel, BorderLayout.CENTER);
			infoDialog.setSize(new Dimension(500, 300));
			infoDialog.add(infoPanel, BorderLayout.CENTER);
			infoDialog.setLocationRelativeTo(null);
			infoDialog.setVisible(true);
		});
		this.add(infoButton);

		if(type.equals("adopt")) {
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
				panel.setBackground(Color.WHITE);
				centre.setBackground(Color.lightGray);

				request.setSize(new Dimension(500, 200));
				request.add(panel);
				request.setLocationRelativeTo(null);
				request.setVisible(true);


				yes.addActionListener(e1 -> {
					animal.changeState(new AdoptionRequestedState(animal));
					animal.setLinkedUser(adopterController.getID());
					request.dispose();
					adopterController.changeWindow(AdopterRefugeListWindow.key);
					adopterController.run();
				});

				no.addActionListener(e1 -> {
					request.dispose();
				});

			});
			this.add(adopt, FlowLayout.RIGHT);
		}



		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setMinimumSize(new Dimension(this.getWidth(),200));
		this.setPreferredSize(new Dimension(600, 230));


	}
}
