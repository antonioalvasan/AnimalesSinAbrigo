package org.is2.asa.view;

import org.is2.asa.control.AdopterController;

import java.awt.*;

import javax.swing.*;

public class AdopterWindow extends JPanel {

	AdopterController controller;

	public AdopterWindow(AdopterController ctrl) {
		this.controller = ctrl;

	}

	public void prepareWindow() {
		// Declaracion de paneles
		this.setLayout(new BorderLayout());
		JPanel panel_sup = new JPanel((new BorderLayout()));
		JPanel panel_inf = new JPanel();

		/********* Seccion superior **********/

		JPanel panel_sup0 = new JPanel(new BorderLayout());
		JPanel panel_sup1 = new JPanel(new BorderLayout());

		// panel superior
		JButton home = new JButton("Home");
		JButton refugios = new JButton("Refuges");
		JButton adoptantes = new JButton("Adopters");
		JButton voluntariado = new JButton("Volunteers");
		JButton FAQ = new JButton("FAQ");
		JLabel user = controller.getUserLabel();
		JButton userImage = new JButton(new ImageIcon("resources/images/userIcon.png"));
		
		JPanel x = new JPanel( new FlowLayout());
		x.add(home);
		x.add(refugios);
		x.add(adoptantes);
		x.add(voluntariado);
		x.add(FAQ);
		panel_sup0.add(x, BorderLayout.WEST);
		
		
		JPanel y = new JPanel( new FlowLayout());
		//y.add(usuario);
		//y.add(imagen_usuario);
		panel_sup0.add(y, BorderLayout.EAST);

		panel_sup0.setBorder(BorderFactory.createLineBorder(Color.black));
		panel_sup0.setVisible(true);

		// panel inferior

		JTextField busqueda = new JTextField("Buscar...");
		busqueda.setPreferredSize(new Dimension(200, 20));
		JButton buscar = new JButton("Buscar");

		JPanel z = new JPanel(new FlowLayout());
		z.add(busqueda);
		z.add(buscar);
		
		panel_sup1.add(z, BorderLayout.WEST);
		panel_sup1.add(new JButton("Filtros"), BorderLayout.EAST);
		
		panel_sup1.setBorder(BorderFactory.createLineBorder(Color.black));

		panel_sup1.setVisible(true);

		// añadimos paneles
		panel_sup.add(panel_sup0, BorderLayout.NORTH);
		panel_sup.add(panel_sup1, BorderLayout.SOUTH);

		panel_sup.setVisible(true);

		/********* Fin seccion superior ***********/

		/********** SECCION INFERIOR ***********/
		
		JPanel panel_animales = new JPanel();
		panel_animales.setLayout(new BoxLayout(panel_animales, BoxLayout.Y_AXIS));
		
		//añadimos animales
		String[] nombres = {"Toby", "Marcelino", "Amadeo", "Juan", "Guille", "Eneko", "Antonio", "Fabrizio", "Javier", "Salgueiro"};
		AnimalPanel[] animales = new AnimalPanel[nombres.length]; 
		
		for(int i =0; i < animales.length; i++) {
			animales[i] = new AnimalPanel();
			animales[i].prepareWindow(nombres[i]);
			panel_animales.add(animales[i]);
		}
		
		JScrollPane scroll = new JScrollPane();
		scroll.setPreferredSize(new Dimension(500,300));
		scroll.setViewportView(panel_animales);
		
		
		/********** FIN SECCION INFERIOR *********/

		// Añadimos paneles al principal

		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(panel_sup, BorderLayout.NORTH);
		this.add(scroll, BorderLayout.CENTER);
	}

}
