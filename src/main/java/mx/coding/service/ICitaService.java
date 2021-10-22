package mx.coding.service;

import java.util.List;

import mx.coding.model.Cita;

public interface ICitaService extends ICRUD<Cita> {

	List<Cita> lstCitasActual();
	
	int actualizarStatus(Integer id);
}
