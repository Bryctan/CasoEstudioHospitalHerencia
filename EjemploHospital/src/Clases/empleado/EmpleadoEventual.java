package clases.empleado;

import javax.swing.JOptionPane;

public class EmpleadoEventual extends Empleado{

	private double honorariosPorHora;
	private String fechaTerminoContrato;
	
	public double getHonorariosPorHora() {
		return honorariosPorHora;
	}
	public void setHonorariosPorHora(double honorariosPorHora) {
		this.honorariosPorHora = honorariosPorHora;
	}
	public String getFechaTerminoContrato() {
		return fechaTerminoContrato;
	}
	public void setFechaTerminoContrato(String fechaTerminoContrato) {
		this.fechaTerminoContrato = fechaTerminoContrato;
	}
	
	@Override 
	public void registrarDatos() {
		super.registrarDatos();
		do {
			try {
				honorariosPorHora = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario Mensual"));
			} catch (Exception e) {
				System.out.println("El dato no puede ser texto");
			}
		} while (honorariosPorHora <= 0);
		fechaTerminoContrato = JOptionPane.showInputDialog("Ingrese fecha nacimiento (dd/mm/aaaa)");
		
	}
	
	@Override
	public void imprimirDatosPersona(String datos) {
		super.imprimirDatosPersona(datos);
		
		datos = "Horarios por hora: " +honorariosPorHora+"\n";
		datos += "Fecha Termino del Contrato: " + fechaTerminoContrato + "\n";
		
		System.out.println(datos);
	}
	
	
}
