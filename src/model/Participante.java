package model;

public class Participante {
	private String nombre;
	private String numero;
	private String region;
	
	public Participante(String nombre,String numero ,String region) {
		if (nombre.isEmpty()) {
			throw new RuntimeException("el nombre ingresado es invalido");
		}
		if (region.isEmpty()) {
			throw new RuntimeException("el nombre ingresado es invalido");
		}
		this.nombre = nombre;
		this.numero = numero;
		this.region = region;
	}
	public String nombre() {
		return this.nombre;
	}

	public String numero() {
		return this.numero;
	}

	public String region() {
		return this.region;
	}

	private boolean validarTelefono(String telefono) {
		 String regex = "\\d{4}-\\d{6}";
		 return telefono.matches(regex);
		  }
}
