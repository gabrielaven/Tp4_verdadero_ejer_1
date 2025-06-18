package model;

import java.util.ArrayList;
import java.util.List;

public class RegistroConObservadores implements RegistroParticipantes {
    private RegistroParticipantes base;
    private List<Observador> observadores = new ArrayList<>();

    public RegistroConObservadores(RegistroParticipantes base) {
        this.base = base;
    }

    public void agregarObservador(Observador obs) {
        observadores.add(obs);
    }

    @Override
    public void registrar(Participante p) {
        base.registrar(p);
        for (Observador obs : observadores) {
            obs.notificar(p);
        }
    }
}