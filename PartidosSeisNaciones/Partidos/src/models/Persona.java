package models;

	import java.sql.Date;
import java.time.LocalDate;

	public abstract class Persona {
		
		private String nombreCompleto;
		private LocalDate fechaNacimiento;
		private int peso;		

		public Persona(String nombreCompleto, LocalDate randomBirthDate, int peso) {
			this.nombreCompleto = nombreCompleto;
			this.fechaNacimiento = randomBirthDate;
			this.peso = peso;
		}
		
		public int getPeso() {
			return peso;
		}

		public void setPeso(int peso) {
			this.peso = peso;
		}
		
		public String getNombreCompleto() {
			return nombreCompleto;
		}
		
		public void setFechaNacimiento(Date fecha) {
		}
		
		public LocalDate getFechaNacimiento() {
			return fechaNacimiento;
		}

		@Override
		public String toString() {
			return "\n\tNombre= " + nombreCompleto + ", fechaNacimiento= " + fechaNacimiento + ", peso=" + peso
					+ "]";
		}
	}
