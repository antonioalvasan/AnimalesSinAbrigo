package org.is2.asa.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

    public class AnimalPanelRefugee extends JPanel {

        public AnimalPanelRefugee() {

        }

        public void prepareWindow(String nombre) throws IOException {

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


            JButton adoptar = new JButton("Solicitudes");
            JButton info = new JButton("Datos");

            BufferedImage bufferedImage = ImageIO.read(new File("IMAGENES/DeleteImage.png"));
            Image deleteimage = bufferedImage.getScaledInstance(20, 20, Image.SCALE_DEFAULT);
            JButton DeleteButton= new JButton(new ImageIcon(deleteimage));


            this.add(DeleteButton, FlowLayout.RIGHT);
            this.add(info, FlowLayout.RIGHT);
            this.add(adoptar, FlowLayout.RIGHT);
            this.setBorder(BorderFactory.createLineBorder(Color.black));
            this.setPreferredSize(new Dimension(600, 100));

        }

        public AnimalPanelRefugee(LayoutManager layout) {
            super(layout);
            // TODO Auto-generated constructor stub
        }

        public AnimalPanelRefugee(boolean isDoubleBuffered) {
            super(isDoubleBuffered);
            // TODO Auto-generated constructor stub
        }

        public AnimalPanelRefugee(LayoutManager layout, boolean isDoubleBuffered) {
            super(layout, isDoubleBuffered);
            // TODO Auto-generated constructor stub
        }
    }


