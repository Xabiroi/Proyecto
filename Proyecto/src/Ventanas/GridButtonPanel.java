package Ventanas;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


//FIXME cambiar al tamaño del mapa, ponerlo invisible y añadir los mouse listeners con las acciones necesarias


/**
 * @see http://stackoverflow.com/questions/7702697
 */
public class GridButtonPanel {

    private static final int N = 25;
    private final List<JButton> list = new ArrayList<JButton>();

    private JButton getGridButton(int r, int c) {
        int index = r * N + c;
        return list.get(index);
    }

    private JButton createGridButton(final int row, final int col) {
        final JButton b = new JButton("r" + row + ",c" + col);
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JButton gb = GridButtonPanel.this.getGridButton(row, col);
                System.out.println("r" + row + ",c" + col
                    + " " + (b == gb)
                    + " " + (b.equals(gb)));
            }
        });
        return b;
    }
    private Image requestImage() {
        Image image = null;

        try {
            image = ImageIO.read(new URL("http://www.bonetnatur.com/files/Formats/monalisa/grans/monalisa_3.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }
    private JPanel createGridPanel() {
    	final Image image=requestImage();
    	 JPanel p = new JPanel(new GridLayout(N, N)){
    		@Override
    	    protected void paintComponent(Graphics g) {
    	        super.paintComponent(g);
    	        g.drawImage(image, 0, 0, null);
    	    }
    	};
    
        for (int i = 0; i < N * N; i++) {
            int row = i / N;
            int col = i % N;
            JButton gb = createGridButton(row, col);
            gb.setOpaque(false);
            gb.setText(""); //Cambiando esto se consigue en invisible (para el mapa)
            gb.setBorder(null);
            gb.setBorderPainted(false);
            gb.setContentAreaFilled(false);
            list.add(gb);
            Dimension d=new Dimension(100,100);
            p.setPreferredSize(d);
            p.add(gb);
        }
        return p;
    }

    private void display() {
        JFrame f = new JFrame("GridButton");
        f.setSize(100, 100);
        f.setBounds(100, 100, 100, 100);
        f.setResizable(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(createGridPanel());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new GridButtonPanel().display();
            }
        });
    }
}