package database;

import model.Participante;
import model.RegistroParticipantes;
import java.sql.*;

public class JdbcRegistroParticipantes implements RegistroParticipantes {
    private final String url;
    private final String user;
    private final String password;

    public JdbcRegistroParticipantes(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void registrar(Participante participante) {
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement st = conn.prepareStatement(
                 "INSERT INTO participantes(nombre, telefono, region) VALUES (?, ?, ?)")) {
            st.setString(1, participante.nombre());
            st.setString(2, participante.numero());
            st.setString(3, participante.region());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}