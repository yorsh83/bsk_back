package mx.coding.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.coding.DAO.IServicioDAO;
import mx.coding.model.Servicio;
import mx.coding.service.IServicioService;

@Service
public class ServicioServiceImpl implements IServicioService {

	@Autowired
	IServicioDAO dao;

	@Override
	public Servicio registrar(Servicio t) {
		return dao.save(t);
	}

	@Override
	public Servicio modificar(Servicio t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public List<Servicio> listar() {
		return dao.findAll();
	}

	@Override
	public Optional<Servicio> listarPorId(int id) {
		return dao.findById(id);
	}

}
