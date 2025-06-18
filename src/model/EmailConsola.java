package model;

public class EmailConsola implements ServicioEmail {
    @Override
    public void enviar(String para, String asunto, String cuerpo) {
        System.out.println("---- Email ----");
        System.out.println("Para: " + para);
        System.out.println("Asunto: " + asunto);
        System.out.println("Cuerpo: " + cuerpo);
        System.out.println("----------------");
    }
}
