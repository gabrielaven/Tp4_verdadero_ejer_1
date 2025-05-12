package main;
import database.JdbcRegistroParticipantes;
import model.Participantes;
import ui.AgregarParticipante;

import java.awt.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AgregarParticipante(new Participantes(new JdbcRegistroParticipantes("jdbc:derby:memory:participantes;create=true",
                            "app",
                            "app")));
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
}