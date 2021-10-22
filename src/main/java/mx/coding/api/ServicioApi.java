package mx.coding.api;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.coding.exception.ModelNotFoundException;
import mx.coding.model.Servicio;
import mx.coding.service.IServicioService;

@RestController
@RequestMapping("/servicios")
public class ServicioApi {

	private static final Logger log = LoggerFactory.getLogger(ServicioApi.class);

	@Autowired
	IServicioService service;

	@GetMapping(value = "/listado", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Servicio>> listar() {
		log.info("*****Inicia listado de servicios*****");
		List<Servicio> lista = service.listar();
		if (lista.isEmpty()) {
			throw new ModelNotFoundException("NO HAY DATOS A MOSTRAR");
		}
		return new ResponseEntity<List<Servicio>>(service.listar(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Servicio>> listarPorId(@PathVariable("id") Integer id) {
		log.info("*****Inicia listado de servicios por id*****");
		Optional<Servicio> serv = service.listarPorId(id);
		if (!serv.isPresent()) {
			throw new ModelNotFoundException("NO EXISTE EL ID: " + id);
		}
		return new ResponseEntity<Optional<Servicio>>(serv, HttpStatus.OK);
	}
}
