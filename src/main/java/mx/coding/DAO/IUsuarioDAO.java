package mx.coding.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import mx.coding.model.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Integer> {

	Usuario findOneByUsername(String username);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE usuario SET visits = :n WHERE id_user = :id", nativeQuery = true)
	int registroVisita(Integer n, Integer id);

}
