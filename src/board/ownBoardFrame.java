package board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class ownBoardFrame extends JFrame {
    JTextField size = new JTextField("Size of sequence");
    JTextField north = new JTextField("North line of numbers (separated by space)");
    JTextField south = new JTextField("South line of numbers (separated by space)");
    JTextField east = new JTextField("East line of numbers (separated by space)");
    JTextField west = new JTextField("West line of numbers (separated by space)");
    JButton complete = new JButton("Create");
    JPanel textPanel = new JPanel();

    public ownBoardFrame() {
        dispose();
        setLocationRelativeTo(null);
        setTitle("Creator");
        complete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    outPutInformation();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                File file = new File("./resources/ownGame.txt");
                fillBoard fillboard = new fillBoard(file);
                JFrame board = new Board(fillboard);
                board.setVisible(true);
                board.setSize(1000, 800);
                dispose();
            }
        });
        textPanel.add(size);
        textPanel.add(north);
        textPanel.add(south);
        textPanel.add(east);
        textPanel.add(west);
        textPanel.add(complete);
        textPanel.setLayout(new GridLayout(6, 0));
        add(textPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //get size and numbers from textfields to file
    public void outPutInformation() throws IOException {
        String getSize = size.getText();
        String getNorth = north.getText();
        String getSouth = south.getText();
        String getWest = west.getText();
        String getEast = east.getText();

        PrintWriter writer = new PrintWriter("./resources/ownGame.txt", StandardCharsets.UTF_8);

        int size = Integer.parseInt(getSize);
        String[] s1 = getNorth.split(" ");
        String[] s2 = getSouth.split(" ");
        String[] s3 = getWest.split(" ");
        String[] s4 = getEast.split(" ");

        writer.println(size);
        writer.println();
        for(int i = 0; i < size; i++)
        {
            writer.println(s1[i]);
        }
        writer.println();
        writer.println();
        for(int i = 0; i < size; i++)
        {
            writer.println(s4[i]);
        }
        writer.println();
        writer.println();
        for(int i = 0; i < size; i++)
        {
            writer.println(s2[i]);
        }
        writer.println();
        for(int i = 0; i < size; i++)
        {
            writer.println(s3[i]);
        }

         writer.close();

    }

}