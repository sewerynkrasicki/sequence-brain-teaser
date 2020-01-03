package board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class ownBoardFrame extends JFrame {
    private JTextField size = new JTextField("Size of sequence");
    private JTextField north = new JTextField("North line of numbers (separated by space)");
    private JTextField south = new JTextField("South line of numbers (separated by space)");
    private JTextField east = new JTextField("East line of numbers (separated by space)");
    private JTextField west = new JTextField("West line of numbers (separated by space)");
    private JButton complete = new JButton("Create");
    private JPanel textPanel = new JPanel();

    public ownBoardFrame() {
        setLocationRelativeTo(null);
        setTitle("Creator");
        setSize(400,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        complete.addActionListener(new completeButton());

        //Add text fields
        textPanel.add(size);
        textPanel.add(north);
        textPanel.add(south);
        textPanel.add(east);
        textPanel.add(west);

        // Add complete button
        textPanel.add(complete);
        textPanel.setLayout(new GridLayout(6, 0));
        add(textPanel);
    }

    //get size and numbers from textfields to file
    public void outPutInformation(PrintWriter writer, int size, String[] north, String[] south, String[] west, String[] east) throws IOException {
        writer.println(size);
        writer.println();
        for(int i = 0; i < size; i++)
        {
            writer.println(north[i]);
        }
        writer.println();
        writer.println();
        for(int i = 0; i < size; i++)
        {
            writer.println(east[i]);
        }
        writer.println();
        writer.println();
        for(int i = 0; i < size; i++)
        {
            writer.println(south[i]);
        }
        writer.println();
        for(int i = 0; i < size; i++)
        {
            writer.println(west[i]);
        }
         writer.close();
    }

    class completeButton implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try {

                PrintWriter writer = new PrintWriter("./resources/ownGame.txt", StandardCharsets.UTF_8);
                int getSize = Integer.parseInt(size.getText());
                String[] getNorth = north.getText().split(" ");
                String[] getSouth = south.getText().split(" ");
                String[] getWest = west.getText().split(" ");
                String[] getEast = east.getText().split(" ");
                outPutInformation(writer, getSize, getNorth, getSouth, getWest, getEast);

            } catch (IOException e) {
                e.printStackTrace();
            }
            File file = new File("./resources/ownGame.txt");
            fillBoard fillboard = new fillBoard(file);
            JFrame board = new Board(fillboard);
            dispose();
        }
        }
}