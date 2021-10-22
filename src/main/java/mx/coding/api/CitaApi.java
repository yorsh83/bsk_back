package mx.coding.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.coding.exception.ModelNotFoundException;
import mx.coding.model.Cita;
import mx.coding.service.ICitaService;

@RestController
@RequestMapping("/citas")
public class CitaApi {

	@Autowired
	ICitaService service;

	private static final Logger log = LoggerFactory.getLogger(CitaApi.class);

	@PostMapping(value = "/agregar")
	public ResponseEntity<Cita> registrar(@RequestBody Cita cita) {
		log.info("*****Inicia registro de citas*****");
		return new ResponseEntity<Cita>(service.registrar(cita), HttpStatus.CREATED);
	}

	@GetMapping(value = "/listado", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cita>> listar() {
		log.info("*****Inicia listado de citas*****");
		List<Cita> lista = service.lstCitasActual();
		if (lista.isEmpty()) {
			throw new ModelNotFoundException("NO HAY DATOS A MOSTRAR");
		}
		return new ResponseEntity<List<Cita>>(lista, HttpStatus.OK);
	}
}
