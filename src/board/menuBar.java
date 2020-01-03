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
    private JMenu optionsMenu = new JMenu("Options");
    private JMenu helpMenu = new JMenu("Help");
    private JMenu undoMenu = new JMenu("Undo");
    private JMenu redoMenu = new JMenu("Redo");
    private JMenuItem instructionItem = new JMenuItem("Instruction");
    private JMenuItem returnToMainMenuItem = new JMenuItem("Return to main menu");
    private JMenuItem saveMenuItem = new JMenuItem("Save");
    private JMenuItem loadMenuItem = new JMenuItem("Load");
    private JFileChooser jfcLoad = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

    menuBar() {
        setPreferredSize(new Dimension(50, 50));

        add(optionsMenu);
        add(helpMenu);
        add(undoMenu);
        add(redoMenu);

        helpMenu.add(instructionItem);

        optionsMenu.add(returnToMainMenuItem);
        optionsMenu.add(saveMenuItem);
        optionsMenu.add(loadMenuItem);

        loadMenuItem.addActionListener(new loadFile());
        instructionItem.addActionListener(new popUp());
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


    static class popUp implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            JDialog dial = new dialog();
            dial.setSize(500, 500);
            dial.setVisible(true);
        }
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

