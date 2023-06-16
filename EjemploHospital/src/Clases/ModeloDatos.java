package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

import clases.empleado.EmpleadoEventual;
import clases.empleado.EmpleadoPlanilla;
import clases.empleado.Medico;

public class ModeloDatos {

	HashMap<String, Paciente> pacientesMap;
	HashMap<String, EmpleadoPlanilla> empleadosPlanillaMap;
	HashMap<String, EmpleadoEventual> empleadosEventualMap;
	HashMap<String, Medico> medicosMap;
	ArrayList<CitaMedica> citasList;

	public ModeloDatos() {
		pacientesMap = new HashMap<String, Paciente>();
		empleadosPlanillaMap = new HashMap<String, EmpleadoPlanilla>();
		medicosMap = new HashMap<String, Medico>();
		empleadosEventualMap = new HashMap<String, EmpleadoEventual>();
		citasList = new ArrayList<CitaMedica>();
	}

	public void registrarPersona(Paciente miPaciente) {
		
		if (!pacientesMap.containsKey(miPaciente.getNumeroDeDNI()))
		{
		pacientesMap.put(miPaciente.getNumeroDeDNI(), miPaciente);
		System.out.println("Se ha registrado el paciente " + miPaciente.getNombre() + " Satisfactoriamente");
		} else {
			System.out.println("El documento: "+ miPaciente.getNumeroDeDNI()+" ya existe!");
		}
		
		
	}

	public void registrarPersona(EmpleadoPlanilla miEmpPlanilla) {
		
		if (!empleadosPlanillaMap.containsKey(miEmpPlanilla.getNumeroDeDNI())) {
			empleadosPlanillaMap.put(miEmpPlanilla.getNumeroDeDNI(), miEmpPlanilla);
			System.out.println("Se ha registrado el empleado por planilla " + miEmpPlanilla.getNombre() + " Satisfactoriamente");
		} else {
			System.out.println("El documento: "+ miEmpPlanilla.getNumeroDeDNI()+" ya existe!");
		}
		
	}

	public void registrarPersona(EmpleadoEventual miEmpEventual) {
		
		if (!empleadosEventualMap.containsKey(miEmpEventual.getNumeroDeDNI())) {
		empleadosEventualMap.put(miEmpEventual.getNumeroDeDNI(), miEmpEventual);
		System.out.println("Se ha registrado el empleado eventual " + miEmpEventual.getNombre() + " Satisfactoriamente");
		} else {
			System.out.println("El documento: "+ miEmpEventual.getNumeroDeDNI()+" ya existe!");
		}
		
		
	}

	public void registrarPersona(Medico miMedico) {
		
		if (!medicosMap.containsKey(miMedico.getNumeroDeDNI())) {
			medicosMap.put(miMedico.getNumeroDeDNI(), miMedico);
			System.out.println("Se ha registrado el Medico " + miMedico.getNombre() + " Satisfactoriamente");
		} else {
			System.out.println("El documento: "+ miMedico.getNumeroDeDNI()+" ya existe!");
		}
		
		
	}

	public void imprimirPacientes() {
		if (!pacientesMap.isEmpty()) {
			String msj = "PACIENTES REGISTRADOS \n";
			Iterator<String> iterador = pacientesMap.keySet().iterator();

			while (iterador.hasNext()) {
				String clave = iterador.next();
				pacientesMap.get(clave).imprimirDatosPersona(msj);
			}
		} else {
			JOptionPane.showMessageDialog(null, "No existen pacientes registrados!!", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public void imprimirEmpleadosEventuales() {
		
		if (!empleadosEventualMap.isEmpty()) {
			String msj = "EMPLEADOS EVENTUALES REGISTRADOS \n";

			for (String clave : empleadosEventualMap.keySet()) {
				empleadosEventualMap.get(clave).imprimirDatosPersona(msj);
			}
		} else {
			JOptionPane.showMessageDialog(null, "No existen Empleados Eventuales registrados!!", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public void imprimirEmpleadosPorPlanilla() {
		
		
		if (!empleadosPlanillaMap.isEmpty()) {
			String msj = "EMPLEADOS POR PLANILLA REGISTRADOS \n";

			for (EmpleadoPlanilla empleadoPlanilla : empleadosPlanillaMap.values()) {
				empleadoPlanilla.imprimirDatosPersona(msj);
			}
		} else {
			
			JOptionPane.showMessageDialog(null, "No existen Empleados Por Planilla registrados!!", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
		imprimirMedicos();
		

	}

	public void imprimirMedicos() {
	
		if (!medicosMap.isEmpty()) {
			String msj = "MEDICOS REGISTRADOS \n";
			for (Map.Entry<String, Medico> elemento : medicosMap.entrySet()) {
				elemento.getValue().imprimirDatosPersona(msj);
			}
		} else {
			
			JOptionPane.showMessageDialog(null, "No existen Medicos registrados!!", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public Paciente consultarPacientePorDocumento(String documentoPaciente) {
		Paciente miPaciente = null;

		if (pacientesMap.containsKey(documentoPaciente)) {
			miPaciente = pacientesMap.get(documentoPaciente);
		}

		return miPaciente;
	}

	public Medico consultarMedicoPorNombre(String nombreMedico) {
		for (Medico medico : medicosMap.values()) {
			if (pacientesMap.containsKey(nombreMedico)) {
				return medico;
			}

		}

		return null;
	}

	public void registrarCitaMedica(CitaMedica miCita) {
		citasList.add(miCita);
		System.out.println("Se ha registrado la cita exitosamente \n");
		System.out.println(miCita.informacionCitaMedica());
	}

	public void imprimirCitasMedicasProgramadas() {
		
		if (!citasList.isEmpty()) {
			String msj = "CITAS MEDICAS PROGRAMADAS \n";
			CitaMedica miCita = null;

			System.out.println(msj + "\n");

			if (citasList.size() > 0) {
				for (int i = 0; i < citasList.size(); i++) {
					miCita = citasList.get(i);
					System.out.println(miCita.informacionCitaMedica());
				}
			} else {
				System.out.println("No existen citas programadas");
			}
		} else {
			JOptionPane.showMessageDialog(null, "No existen Citas Medicas Programadas!!", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void consultarPacientePorDoc() {
	
		
		if (!pacientesMap.isEmpty()) {
			String consultarDocPaciente = JOptionPane.showInputDialog("Ingrese el documento del paciente a consultar");
			
			String msj = "PACIENTE REGISTRADO\n";
			
			if (pacientesMap.containsKey(consultarDocPaciente)) {
				pacientesMap.get(consultarDocPaciente).imprimirDatosPersona(msj);
			} else {
				System.out.println("El paciente con DNI: " + consultarDocPaciente + "no existe");
			}
		} else {
			JOptionPane.showMessageDialog(null, "No existen pacientes registrados!!", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
			
	}
	
	public void consultarEmpleadoEventualPorDoc() {
		
		if (!empleadosEventualMap.isEmpty()) {
			
			String consultarDocEmpleadoEventual = JOptionPane.showInputDialog("Ingrese el documento del empleado eventual a consultar");
			
			String msj = "EMPLEADO EVENTUAL REGISTRADO\n";
			
			if (empleadosEventualMap.containsKey(consultarDocEmpleadoEventual)) {
				empleadosEventualMap.get(consultarDocEmpleadoEventual).imprimirDatosPersona(msj);
			} else {
				System.out.println("El empleado eventual con DNI: " + consultarDocEmpleadoEventual+ "no existe");
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "No existen Empleados Eventuales registrados!!", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	
	}
	
	public void consultarEmpleadoPlanillaPorDoc() {
		
		if (!empleadosPlanillaMap.isEmpty()) {
			String consultarDocEmpleadoPlanilla = JOptionPane.showInputDialog("Ingrese el documento del empleado planilla a consultar");
			
			String msj = "EMPLEADO PLANILLA REGISTRADO\n";
			
			if (empleadosPlanillaMap.containsKey(consultarDocEmpleadoPlanilla)) {
				
				empleadosPlanillaMap.get(consultarDocEmpleadoPlanilla).imprimirDatosPersona(msj);
				
			} else {
				System.out.println("El empleado por planilla con DNI: " + consultarDocEmpleadoPlanilla+ "no existe");
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "No existen Empleados por planilla registrados!!", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
	public void consultarMedicoPorDoc() {
		if (!medicosMap.isEmpty()) {
			String msj = "EMPLADO PLANILLA REGISTRADO\n";
			
			String consultarDocMedico = JOptionPane.showInputDialog("Ingrese el documento del medico a consultar");
			
			if (medicosMap.containsKey(consultarDocMedico)) {
				medicosMap.get(consultarDocMedico).imprimirDatosPersona(msj);
			} else {
				System.out.println("El medico con DNI: " + consultarDocMedico+ "no existe");
			}
		} else {
			JOptionPane.showMessageDialog(null, "No existen Medicos registrados!!", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
		
		
		
	}

}
