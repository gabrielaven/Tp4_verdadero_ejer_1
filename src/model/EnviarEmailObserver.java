package model;
public class EnviarEmailObserver implements Observador {
    private final ServicioEmail servicio;

    public EnviarEmailObserver(ServicioEmail servicio) {
        this.servicio = servicio;
    }

    @Override
    public void notificar(Participante p) {
        String asunto = "Gracias por inscribirte";
        String cuerpo = "Hola " + p.nombre() + ", tu inscripcion fue existosa";
        servicio.enviar(p.email(), asunto, cuerpo);
    }
}
