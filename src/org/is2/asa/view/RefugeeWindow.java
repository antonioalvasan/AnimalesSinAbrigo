package org.is2.asa.view;

import org.is2.asa.control.RefugeeController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RefugeeWindow extends JPanel {
    private RefugeeController ctrl;
    public RefugeeWindow(RefugeeController ctrl){
        this.ctrl=ctrl;

    }
    public void prepareWindow() throws IOException {
        this.setLayout(new BorderLayout());
        JPanel panelsup = new JPanel(new BorderLayout());
        String[] datosperfil={"Refugio1", "1","24","50"};
        JPanel perfil= new JPanel();
        JLabel datos=new JLabel();
        datos.setText("<html><body>Nombre:"+datosperfil[0]+"<br>ID:"+datosperfil[1]+"<br>Empleados: "
                +datosperfil[2]+"<br>Animales:" + datosperfil[3]+ "</body></html>");
        perfil.add(datos);

        panelsup.add(perfil,BorderLayout.WEST);
        BufferedImage bufferedImage = ImageIO.read(new File("IMAGENES/UserImage.png"));
        Image image = bufferedImage.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
       JButton UserButton= new JButton(new ImageIcon(image));

        panelsup.add(UserButton, BorderLayout.EAST);
        panelsup.setBorder(BorderFactory.createLineBorder(Color.black));


        JPanel panelcentral =new JPanel(new BorderLayout());
        JPanel panelcentraltop= new JPanel(new FlowLayout());
        JTextField busqueda = new JTextField("Buscar...");
        busqueda.setPreferredSize(new Dimension(200, 20));
        JButton busquedaa = new JButton("Buscar");


        panelcentraltop.add(busqueda);
        panelcentraltop.add(busquedaa);
        JLabel texto1= new JLabel("                      Selección por raza:");
        panelcentraltop.add(texto1);
        JComboBox razas =new JComboBox();
        razas.addItem("todos");
        razas.addItem("perro");
        razas.addItem("gato");
        panelcentraltop.add(razas);
        panelcentraltop.setBorder(BorderFactory.createLineBorder(Color.black));


        JPanel panel_animales = new JPanel();
        panel_animales.setLayout(new BoxLayout(panel_animales, BoxLayout.Y_AXIS));

        //añadimos animales
        String[] nombres = {"Toby", "Marcelino", "Amadeo", "Juan", "Homosexual", "Eneko", "Antonio", "Fabri", "Javi", "Salgueiro"};
        AnimalPanel[] animales = new AnimalPanel[nombres.length];

        for(int i =0; i < animales.length; i++) {
            animales[i] = new AnimalPanel();
            animales[i].prepareWindow(nombres[i]);
            panel_animales.add(animales[i]);
        }
        JPanel opciones = new JPanel(new FlowLayout());

        JButton PlusButton= new JButton("Añadir animal");






        opciones.add(PlusButton);
        panel_animales.add(opciones);

        JScrollPane scroll = new JScrollPane();
        scroll.setPreferredSize(new Dimension(500,300));
        scroll.setViewportView(panel_animales);





        panelcentral.add(panelcentraltop,BorderLayout.NORTH);
        panelcentral.add(scroll,BorderLayout.CENTER);
        panelcentral.setVisible(true);
        this.add(panelsup,BorderLayout.NORTH);
        this.add(panelcentral, BorderLayout.CENTER);




    }
}
