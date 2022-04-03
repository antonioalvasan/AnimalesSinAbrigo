package org.is2.asa.view;

import java.awt.*;
import javax.swing.*;

public class AnimalPanel extends JPanel {

	public AnimalPanel() {

	}

	public void prepareWindow(String nombre) {

		this.setLayout(new FlowLayout());

		JButton perrillo = new JButton(new ImageIcon("resources/images/perrillo.png"));
		this.add(perrillo, BorderLayout.EAST);

		
		JPanel panel_centro = new JPanel(new BorderLayout());
		
		Label nombre_perro = new Label(nombre);
		Label descripcion = new Label(
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla et magna a velit mollis sagittis at nec nisi. ");
		
		panel_centro.add(nombre_perro, BorderLayout.NORTH);
		panel_centro.add(descripcion, BorderLayout.CENTER);
		
		this.add(panel_centro);
		
		
		JButton adoptar = new JButton("Adoptar");
		JButton info = new JButton("info");
		this.add(info, FlowLayout.RIGHT);
		this.add(adoptar, FlowLayout.RIGHT);
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
