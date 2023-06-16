import javax.swing.JOptionPane;

import clases.CitaMedica;
import clases.ModeloDatos;
import clases.Paciente;
import clases.empleado.EmpleadoEventual;
import clases.empleado.EmpleadoPlanilla;
import clases.empleado.Medico;

public class Procesos {

	ModeloDatos miModeloDatos;
	
	public Procesos() {
		miModeloDatos = new ModeloDatos();
		presentarMenuOpciones();
	}

	private void presentarMenuOpciones() {
		String menu = "MENU HOSPITAL\n\n";
		menu +="1. Registrar paciente\n";
		menu +="2. Registrar empleado\n";
		menu +="3. Registrar cita medica\n";
		menu +="4. Imprimir Informacion\n";
		menu +="5. Imprimir Informacion por documento\n";
		menu +="6. Salir\n\n";
		menu +="Ingrese una opcion\n";
		
		int opcion =0;
		
		
		do {
			
			try {
				opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
			} catch (Exception e) {
				System.out.println("La opcion no puede ser texto");
			}
			
			switch (opcion) {
			case 1: registrarPaciente(); break;
			case 2: registrarEmpleado(); break;
			case 3: registrarCitaMedica(); break;
			case 4: imprimirInformacion(); break;
			case 5: imprimirPorDocumento(); break;
			case 6: System.out.println("El sistema ha terminado!"); break;
			default: System.out.println("No existe el codigo, verifique nuevamente");break;
			}
			
		} while (opcion != 6);
		
		
		
	}
	

	private void registrarPaciente() {
		Paciente miPaciente = new Paciente();
		miPaciente.registrarDatos();
		miModeloDatos.registrarPersona(miPaciente);
	}
	
	
	private void registrarEmpleado() {
		String menuTipoEmpleado = "Registro de Empleado \n";
		menuTipoEmpleado +="1. Empleado eventual \n";
		menuTipoEmpleado +="2. Empleado por planilla \n";
		menuTipoEmpleado +="Seleccione el tipo de empleado a registrar\n";
		
		int tipoEmpleado = 0;
		try {
			tipoEmpleado = Integer.parseInt(JOptionPane.showInputDialog(menuTipoEmpleado));
		} catch (Exception e) {
			System.out.println("La opcion no puede ser texto");
		}
		
	switch (tipoEmpleado) {
	
	case 1:
		EmpleadoEventual miEmpleadoEventual = new EmpleadoEventual();
		miEmpleadoEventual.registrarDatos();
		miModeloDatos.registrarPersona(miEmpleadoEventual);
		break;
	case 2:
		String resp = JOptionPane.showInputDialog("Ingrese si, si es un medico de lo contrario es otro tipo de empleado");
		
		if (resp.equalsIgnoreCase("si")) {
			Medico miMedico = new Medico();
			miMedico.registrarDatos();
			miModeloDatos.registrarPersona(miMedico);
		} else {
			EmpleadoPlanilla miEmpleadoPlanilla = new EmpleadoPlanilla();
			miEmpleadoPlanilla.registrarDatos();
			miModeloDatos.registrarPersona(miEmpleadoPlanilla);
		}
	
		break;	
		
	default:
		System.out.println("El tipo de empleado no es valido, intentelo nuevamente");
		break;
	}
		
		
	}
	

private void imprimirInformacion() {
		
		String menuImprimir = "MENU IMPRESIONES \n";
		menuImprimir += "1. Listar pacientes\n";
		menuImprimir += "2. Listar Empleados Eventuales \n";
		menuImprimir += "3. Listar Empleados Por Planilla\n";
		menuImprimir += "4. Listar Medicos \n";
		menuImprimir += "5. Listar Citas Programadas \n";
		menuImprimir += "Ingrese una opcion \n";
		
		System.out.println("****************************************************");
		int opcion = 0;
		try {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(menuImprimir));
		} catch (Exception e) {
			System.out.println("La opcion no puede ser texto");
		}
		
		
		switch (opcion) {
		case 1:
			miModeloDatos.imprimirPacientes();
			break;
		case 2:
			miModeloDatos.imprimirEmpleadosEventuales();
			break;
		case 3:
			miModeloDatos.imprimirEmpleadosPorPlanilla();
			break;
		case 4:
			miModeloDatos.imprimirMedicos();
			break;
		case 5:
			miModeloDatos.imprimirCitasMedicasProgramadas();
			break;
		default:
			System.out.println("No existe esa opcion");
			break;
		}
	}

	private void registrarCitaMedica() {
		String documentoPaciente = JOptionPane.showInputDialog("Ingrese el documento del paciente");
		
		Paciente pacienteEncontrado = miModeloDatos.consultarPacientePorDocumento(documentoPaciente);
		
		if (pacienteEncontrado != null) {
			
			String nombreMedico = JOptionPane.showInputDialog("Ingrese el nombre del medico");
			Medico medicoEncontrado = miModeloDatos.consultarMedicoPorNombre(nombreMedico);
			
			if (medicoEncontrado != null) {
				String servicio = JOptionPane.showInputDialog("Ingrese el servicio o motivo de la consulta");
				String fechaConsulta = JOptionPane.showInputDialog("Ingrese la fecha de la consulta");
				String horaConsulta = JOptionPane.showInputDialog("Ingrese la hora de la consulta");
				
				String lugar = "La cita sera en el consulta " + medicoEncontrado.getNumeroDeConsultorio();
				CitaMedica miCita = new CitaMedica(pacienteEncontrado, medicoEncontrado, servicio, fechaConsulta, horaConsulta, lugar);
				miModeloDatos.registrarCitaMedica(miCita);
			} else {
				System.out.println("El medico no se encuentra registrado en el sistema");
			}
			
		} else {
			System.out.println("El paciente no se encuentra registrado en el sistema");
		}
		
	}
	
	
	public void imprimirPorDocumento() {
		String submenuImprimir = "MENU IMPRESIONES POR DOCUMENTO\n";
		submenuImprimir += "1. Imprimir paciente por documento\n";
		submenuImprimir += "2. Imprimir empleado eventual por documento\n";
		submenuImprimir += "3. Imprimir empleado de planilla por documento \n";
		submenuImprimir += "4. Imprimir medico por documento \n";
		submenuImprimir += "5. Salir \n";
		submenuImprimir += "Ingrese una opcion \n";
		
		System.out.println("****************************************************");
		
		int opcion = 0;
		try {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(submenuImprimir));
		} catch (Exception e) {
			System.out.println("La opcion no puede ser texto");
		}
		
	
		
		
		switch (opcion) {
		case 1:
			miModeloDatos.consultarPacientePorDoc();
			break;
		case 2:
			miModeloDatos.consultarEmpleadoEventualPorDoc();
			break;
		case 3:
			miModeloDatos.consultarEmpleadoPlanillaPorDoc();
			break;
		case 4:
			miModeloDatos.consultarMedicoPorDoc();
			break;
		case 5:
			break;
		default:
			System.out.println("No existe esa opcion");
			break;
		}
		
		
	}
	

	
	
}
