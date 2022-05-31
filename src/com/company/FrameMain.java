package com.company;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FrameMain extends JFrame {
    private JPanel mainPanel;
    private JPanel editPanel;
    private JPanel deletePanel;
    private JPanel addPanel;
    private JPanel controlPanel;
    private JTextField editPrefixTextField;
    private JTextField editDestinationTextField;
    private JTextField editPriceTextField;
    private JButton editButton;
    private JTextField deletePrefixTextField;
    private JButton deleteButton;
    private JTextField addPrefixTextField;
    private JTextField addDestinationTextField;
    private JTextField addPriceTextField;
    private JButton addButton;
    private JTextField numberTextField;
    private JTextField callInSecondsTextField;
    private JTextField callInfoTextField;
    private JButton readFromFileButton;
    private JButton outputCallInfoButton;
    private JButton writeToFileButton;

    private TariffManager tariffManager = new TariffManager();

    public FrameMain() {
        setTitle("Tariffs");
        setSize(1100, 550);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        add(mainPanel);

        editButton.addActionListener(e -> {
            if (!editDestinationTextField.getText().isEmpty()) {
                tariffManager.editTariff(editPrefixTextField.getText(), editDestinationTextField.getText());
            }
            if (!editPriceTextField.getText().isEmpty()) {
                tariffManager.editTariff(editPrefixTextField.getText(), Integer.parseInt(editPriceTextField.getText()));
            }
            editPrefixTextField.setText(null);
            editDestinationTextField.setText(null);
            editPriceTextField.setText(null);
        });

        deleteButton.addActionListener(e -> {
            tariffManager.delete(deletePrefixTextField.getText());
            deletePrefixTextField.setText(null);
        });

        addButton.addActionListener(e -> {
            tariffManager.add(addPrefixTextField.getText(), addDestinationTextField.getText(),
                    Integer.parseInt(addPriceTextField.getText()));
            addPriceTextField.setText(null);
            addDestinationTextField.setText(null);
            addPriceTextField.setText(null);
        });

        readFromFileButton.addActionListener(e -> {
            try {
                tariffManager.fromString(FileUtils.readFile());
            }
            catch (FileNotFoundException ignored)
            {}
        });

        writeToFileButton.addActionListener(e -> {
            try {
                FileUtils.writeFile(tariffManager.toString());
            }
            catch (IOException ignored)
            {}
        });

        outputCallInfoButton.addActionListener(e -> {
            callInfoTextField.setText(tariffManager.getCallInfo(
                    numberTextField.getText(), Integer.parseInt(callInSecondsTextField.getText())));
        });
    }
}


