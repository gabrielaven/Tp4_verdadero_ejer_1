package model;

public class Participantes {
    private RegistroParticipantes registroDeParticipantes;

    public Participantes(RegistroParticipantes registroDeParticipantes) {
        this.registroDeParticipantes = registroDeParticipantes;
    }

    public void nuevoParticipante(String nombre, String telefono, String region, String email) {
        var participante = new Participante(nombre, telefono, region, email);
        this.registroDeParticipantes.registrar(participante);
    }
}