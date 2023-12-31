package clases.empleado;

import javax.swing.JOptionPane;

public class Medico extends EmpleadoPlanilla{

	private String especialidad;
	private int numeroDeConsultorio;
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public int getNumeroDeConsultorio() {
		return numeroDeConsultorio;
	}
	public void setNumeroDeConsultorio(int numeroDeConsultorio) {
		this.numeroDeConsultorio = numeroDeConsultorio;
	}
	
	@Override
	public void registrarDatos() {
		super.registrarDatos();
		especialidad = JOptionPane.showInputDialog("Ingrese su especialidad");
		do {
			try {
				numeroDeConsultorio = Integer.parseInt(JOptionPane.showInputDialog("Num consultororio"));
			} catch (Exception e) {
				System.out.println("El dato no puede ser texto");
			}
		} while (numeroDeConsultorio <= 0);
		
	}
	
	
	
}
