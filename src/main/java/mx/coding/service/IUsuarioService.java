package mx.coding.service;

import mx.coding.model.Usuario;

public interface IUsuarioService extends ICRUD<Usuario> {

	int registroVisita(Integer n, Integer id);
	
	int validarUser(String username);

}
