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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.coding.exception.ModelNotFoundException;
import mx.coding.model.Usuario;
import mx.coding.service.ICitaService;
import mx.coding.service.IUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioApi {

	@Autowired
	private IUsuarioService service;

	@Autowired
	private ICitaService serviceC;

	private static final Logger log = LoggerFactory.getLogger(UsuarioApi.class);

	@PostMapping(value = "/agregar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> registrar(@RequestBody Usuario usu) {
		log.info("*****Inicia registro de usuario*****");
		Usuario usuario = new Usuario();
		//Visita visita = new Visita();
		//visita.setUsername(usu.getUsername());
		//visita.setVisits(0);
		usuario = service.registrar(usu);
		//serviceV.registrar(visita);
		// URI location =
		// ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usu.getIdUser()).toUri();
		// return ResponseEntity.created(location).build();
		return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
	}

	@PostMapping(value = "/validacion")
	public Usuario validar(@RequestParam("username") String username, @RequestParam("password") String password) {
		log.info("*****Inicia validacion de usuario*****");
		Usuario usuario = new Usuario();
		List<Usuario> lst = service.listar();
		for (Usuario u : lst) {
			if (username.equals(u.getUsername()) && password.equals(u.getPass())) {
				usuario.setIdUser(u.getIdUser());
				usuario.setUsername(u.getUsername());
				usuario.setPass(u.getPass());
				usuario.setWhats(u.getWhats());
				usuario.setVisits(u.getVisits());
				return usuario;
			} else {
				// throw new ModelNotFoundException("El usuario no existe");
				log.info("El usuario y/o contraseña no existe");
			}
		}
		return null;
	}

	@PostMapping(value = "/val_username")
	public int validar(@RequestParam("username") String username) {
		log.info("*****Inicia validado de usuario existente*****");
		int resp = 0;
		List<Usuario> lst = service.listar();
		if (lst.isEmpty()) {
			return resp;
		} else {
			for (Usuario u : lst) {
				if (u.getUsername().equals(username)) {
					log.info("El usuario ya existe");
					return resp = 1;
				} else {
					log.info("El usuario no existe");
				}
			}
		}
		return resp;
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Integer> actualizarVisita(@RequestBody Usuario usu, @PathVariable("id") int id) {
		log.info("*****Inicia actualizacion de visitas*****");
		usu.setIdUser(id);
		List<Usuario> lst = service.listar();
		for (Usuario u : lst) {
			if (id == u.getIdUser()) {
				int getVisita = u.getVisits();
				int visitaNew = getVisita + 1;
				usu.setVisits(visitaNew);
				int respV = service.registroVisita(usu.getVisits(), usu.getIdUser());
				int respC = serviceC.actualizarStatus(usu.getIdCita());
				return new ResponseEntity<Integer>(respV, HttpStatus.OK);
			} else {
				// throw new ModelNotFoundException("El usuario no existe");
				log.info("No se pudo registrar la visita");
			}
		}
		return null;
	}

	@GetMapping(value = "/visitas/{id}")
	public ResponseEntity<Optional<Usuario>> listarPorId(@PathVariable("id") int id) {
		log.info("*****Inicia listado de usuario por id*****");
		Optional<Usuario> usuario = service.listarPorId(id);
		if (!usuario.isPresent()) {
			throw new ModelNotFoundException("NO EXISTE EL ID: " + id);
		}
		return new ResponseEntity<Optional<Usuario>>(usuario, HttpStatus.OK);
	}

}
