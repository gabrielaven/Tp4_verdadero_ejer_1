package model;
public class EnviarEmailObserver implements Observador {
    private final ServicioEmail servicio;

    public EnviarEmailObserver(ServicioEmail servicio) {
        this.servicio = servicio;
    }

    @Override
    public void notificar(Participante p) {
        String asunto = "Gracias por registrarte";
        String cuerpo = "Hola " + p.nombre() + ", te registraste exitosamente en el concurso.";
        servicio.enviar(p.email(), asunto, cuerpo);
    }
}
