package mx.yorsh;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import mx.coding.model.Usuario;

@SpringBootTest
class BskBackendApplicationTests {

	@Test
	void crearUsuario() {
		Usuario u = new Usuario();
		u.setUsername("m");
		u.setPass("de");
		
		
	}

}
