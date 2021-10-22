package mx.coding.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.coding.DAO.IUsuarioDAO;
import mx.coding.model.Usuario;
import mx.coding.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	IUsuarioDAO dao;

	@Override
	public Usuario registrar(Usuario t) {
		return dao.save(t);
	}

	@Override
	public Usuario modificar(Usuario t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Usuario> listar() {
		return dao.findAll();
	}

	@Override
	public Optional<Usuario> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public int registroVisita(Integer n, Integer id) {
		return dao.registroVisita(n, id);
	}

	@Override
	public int validarUser(String username) {
		return 0;
	}

	/*
	 * @Override public UserDetails loadUserByUsername(String username) throws
	 * UsernameNotFoundException { Usuario usuario =
	 * dao.findOneByUsername(username); if (usuario == null) { throw new
	 * UsernameNotFoundException(String.format("El usuario no existe: ", username));
	 * }
	 * 
	 * 
	 * List<GrantedAuthority> authorities = new ArrayList<>();
	 * usuario.getRoles().forEach(rol -> { authorities.add(new
	 * SimpleGrantedAuthority(rol.getNombre())); });
	 * 
	 * UserDetails userDetails = new User(usuario.getUsername(), usuario.getPass(),
	 * null); return userDetails; }
	 */

}
