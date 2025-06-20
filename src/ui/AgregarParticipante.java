package ui;

import model.Participantes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class AgregarParticipante extends JFrame {
    private Connection dbConn;
    private JTextField nombre;
    private JTextField telefono;
    private JTextField region;
    private JTextField email;
    private Participantes listaParticipantes;

    public AgregarParticipante(Participantes participantes) throws SQLException {
        this.listaParticipantes = participantes;
        setupUIComponents();
    }


    private void setupUIComponents() {
        setTitle("Add Participant");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.nombre = new JTextField(10);
        this.telefono = new JTextField(10);
        this.region = new JTextField(10);
        this.nombre.setText("");
        this.telefono.setText("");
        this.region.setText("China");
        this.email = new JTextField(10);
        this.email.setText("");

        
        JPanel contentPane = new JPanel();
        contentPane.add(new JLabel("Email: "));
        contentPane.add(email);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new FlowLayout());
        contentPane.add(new JLabel("Nombre: "));
        contentPane.add(nombre);
        contentPane.add(new JLabel("Telefono: "));
        contentPane.add(telefono);
        contentPane.add(new JLabel("Region: "));
        contentPane.add(region);
        JButton botonCargar = new JButton("Cargar");
        botonCargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onBotonCargar();
                } catch (SQLException e1) {
                    throw new RuntimeException(e1);
                }
            }
        });
        contentPane.add(botonCargar);
        setContentPane(contentPane);
        contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pack();
        setVisible(true);
    }

    private void onBotonCargar() throws SQLException {
        try {
            this.listaParticipantes.nuevoParticipante(nombre.getText(), telefono.getText(), region.getText(), email.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            return;
        }

        dispose();
    }

}