package mx.coding.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.coding.DAO.ICitaDAO;
import mx.coding.model.Cita;
import mx.coding.service.ICitaService;

@Service
public class CitaServiceImpl implements ICitaService {

	@Autowired
	ICitaDAO dao;

	private static final Logger log = LoggerFactory.getLogger(CitaServiceImpl.class);

	@Override
	public Cita registrar(Cita t) {
		return dao.save(t);
	}
	
	@Override
	public List<Cita> lstCitasActual() {
		return dao.lstCitasActual();
	}

	@Override
	public Cita modificar(Cita t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Cita> listar() {
		return dao.findAll();
	}

	@Override
	public Optional<Cita> listarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int actualizarStatus(Integer id) {
		return dao.actualizarStatus(id);
	}

}
