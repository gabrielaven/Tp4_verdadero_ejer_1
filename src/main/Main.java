package main;
import database.JdbcRegistroParticipantes;
import model.Participantes;
import model.RegistroConObservadores;
import ui.AgregarParticipante;
import model.EnviarEmailObserver;
import model.EmailConsola;
import java.awt.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	String url = "jdbc:mysql://localhost:3306/participa"; 
                    String user = "root"; 
                    String password = "gabriel"; 
                    var jdbcRepo = new JdbcRegistroParticipantes(url, user, password);
                    var regis = new RegistroConObservadores(jdbcRepo);
                    var emailConsola = new EmailConsola(); 
                    regis.agregarObservador(new EnviarEmailObserver(emailConsola));
                    var participantes = new Participantes(regis);
                    new AgregarParticipante(participantes);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
}