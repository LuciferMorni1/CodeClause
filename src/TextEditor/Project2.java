package TextEditor;
//--TEXT EDITOR--//

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Project2 extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JFileChooser fileChooser;
    public Project2() {
        initialize();
    }

    private void initialize() {
        textArea = new JTextArea();
        fileChooser = new JFileChooser();

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");

        openItem.addActionListener(this);
        saveItem.addActionListener(this);

        fileMenu.add(openItem);
        fileMenu.add(saveItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        add(new JScrollPane(textArea));
        setTitle("Simple Text Editor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Open")) {
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    BufferedReader br = new BufferedReader(new FileReader(selectedFile));
                    String line;
                    textArea.setText("");
                    while ((line = br.readLine()) != null) {
                        textArea.append(line + "\n");
                    }
                    br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else if (e.getActionCommand().equals("Save")) {
            int returnValue = fileChooser.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(fileToSave));
                    bw.write(textArea.getText());
                    bw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Project2 textEditor = new Project2();
            textEditor.setVisible(true);
        }
        );
    }
}
