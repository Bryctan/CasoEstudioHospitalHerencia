package clases.empleado;

import javax.swing.JOptionPane;

public class EmpleadoPlanilla extends Empleado{

	private double salarioMensual;
	private double porcentajeAdicionalPorHoraExtra;
	
	
	public double getSalarioMensual() {
		return salarioMensual;
	}
	public void setSalarioMensual(double salarioMensual) {
		this.salarioMensual = salarioMensual;
	}
	public double getPorcentajeAdicionalPorHoraExtra() {
		return porcentajeAdicionalPorHoraExtra;
	}
	public void setPorcentajeAdicionalPorHoraExtra(double porcentajeAdicionalPorHoraExtra) {
		this.porcentajeAdicionalPorHoraExtra = porcentajeAdicionalPorHoraExtra;
	}
	
	
	@Override
	public void registrarDatos() {
		super.registrarDatos();
		
		do {
			try {
				salarioMensual = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario Mensual"));
			} catch (Exception e) {
				System.out.println("El dato no puede ser texto");
			}
		} while (salarioMensual <= 0);
		
		do {
			try {
				porcentajeAdicionalPorHoraExtra = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el Porcentaje Adicional por Hora Extra"));
			} catch (Exception e) {
				System.out.println("El dato no puede ser texto");
			}
		} while (porcentajeAdicionalPorHoraExtra <= 0);
		
		
	}
	
	@Override
	public void imprimirDatosPersona(String datos) {
		super.imprimirDatosPersona(datos);
		datos = "Salario Mensual: "+ salarioMensual + "\n";
		datos += "Porcentaje Adicional Por Hora Extra: "+ porcentajeAdicionalPorHoraExtra+ "\n";
		
		System.out.println(datos);
	}
	
	
	
	
}
