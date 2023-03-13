package controlador;

import java.util.ArrayList;

import conexionAPI.Conexion;
import longitudes.Longitud;
import temperaturas.Temperatura;
import volumen.Volumen;

//EN EL MAIN GRÁFICO, CUANDO APRETAMOS EL BOTON CONVERTIR, CREAMOS EL OBJETO CONTRALODOR
// CON LOS DATOS MAGNITUD, ORIGEN, DESTINO, TIPO DE CONVERSIIÓN, Y LLAMAMOS AL CONTROLADOR.
//Object[] Datos = new Object[]{"TipoConversion", "Origen", "destino", 3.14};
//Converti(Datos);



public class Controlador {
	
	
	
	
	
	public void Convertir(Object[] Datos) {
		String tipoConversion=(String) Datos[0];
		switch(tipoConversion) {
		case "Longitudes":
			Longitud longitud=new Longitud((double)Datos[3],(String)Datos[1]);
			Longitud longitudConvertido=longitud.convertir(longitud, (String)Datos[2]);
			System.out.println(Datos[3] + " " + Datos[1] + " equivalen a: " + longitudConvertido.getMagnitud()+  " " + longitudConvertido.getUnidad());
		break;
		case "Divisas":
			try {
				System.out.println(Conexion.obtenerCotizacion((String)Datos[1],(String)Datos[2]));
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		case "Temperaturas":
			Temperatura temperatura=new Temperatura((double)Datos[3],(String)Datos[1]);
			Temperatura temperaturaConvertida=temperatura.convertir(temperatura, (String)Datos[2]);
			System.out.println(Datos[3] + " " + Datos[1] + " equivalen a: " + temperaturaConvertida.getMagnitud()+  " " + temperaturaConvertida.getUnidad());
			break;
		case "Volumenes":
			Volumen volumen=new Volumen((double)Datos[3],(String)Datos[1]);
			Volumen volumenConvertido=volumen.convertir(volumen, (String)Datos[2]);
			System.out.println(Datos[3] + " " + Datos[1] + " equivalen a: " + volumenConvertido.getMagnitud()+  " " + volumenConvertido.getUnidad());
		break;
		default:
			System.out.println("Error fatal, cierre el programa y vuelva a iniciarlo");
		
		}
		
		
		
		
	}
	
	
	
	
}
