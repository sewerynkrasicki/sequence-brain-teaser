package board;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class menuBar extends JMenuBar {

    JMenu m1 = new JMenu("Options");
    JMenu m2 = new JMenu("Help");
    JMenuItem m1i = new JMenuItem("Instruction");
    JMenuItem m2i = new JMenuItem("Return to main menu");
    JMenuItem m3i = new JMenuItem("Save");
    JMenuItem m4i = new JMenuItem("Load");
    JMenu m3 = new JMenu("Undo");
    JMenu m4 = new JMenu("Redo");
    JFileChooser jfcSave = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    JFileChooser jfcLoad = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

    menuBar() {
        add(m1);
        add(m2);
        add(m3);
        add(m4);
        m2.add(m1i);
        m1.add(m2i);
        m1.add(m3i);
        m1.add(m4i);
        m3i.addActionListener(new saveFile());
        m4i.addActionListener(new loadFile());
        setPreferredSize(new Dimension(50, 50));
        m1i.addActionListener(new popUp());
    }

    class saveFile implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            jfcSave.setDialogTitle("Choose a directory to save your file: ");
            jfcSave.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnValue = jfcSave.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                if (jfcSave.getSelectedFile().isDirectory()) {
                    System.out.println("You selected the directory: " + jfcSave.getSelectedFile());
                }
            }
        }
    }

    class loadFile implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            int returnValue = jfcLoad.showOpenDialog(null);
            if(returnValue == JFileChooser.APPROVE_OPTION)
            {
                File selectedFile = jfcLoad.getSelectedFile();
                System.out.println(selectedFile.getAbsolutePath());
            }
        }
    }
}

class popUp implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent ae) {
        JDialog dial = new dialog();
        dial.setSize(500, 500);
        dial.setVisible(true);
    }
}

class dialog extends JDialog {
    JLabel jlText = new JLabel();
    ImageIcon imageIcon = new ImageIcon("./resources/image.gif");
    File file = new File("./resources/instruction.txt");

    public String readFromFile(File file) {
        String currString = "";
        String string = "";
        Scanner ins;
        {
            try {
                ins = new Scanner(file);
                while (ins.hasNextLine()) {
                    currString = "<br>" + ins.nextLine() + "</br>";
                    string = string.concat(currString);
                }
                ins.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return string;
    }

    dialog() {
        jlText.setIcon(imageIcon);
        jlText.setText("<html>" + readFromFile(file) + "</html>");
        add(jlText);
        setTitle("Instruction");
        setLocationRelativeTo(null);
    }
}

class returnToMainMenu implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {
        JFrame b = new Menu();
        b.setVisible(true);
    }
}

