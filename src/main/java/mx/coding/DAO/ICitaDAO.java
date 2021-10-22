package mx.coding.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import mx.coding.model.Cita;

public interface ICitaDAO extends JpaRepository<Cita, Integer> {

	@Query(value = "SELECT * FROM cita WHERE date >= CURRENT_DATE AND status = 'pendiente'", nativeQuery = true)
	List<Cita> lstCitasActual();

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE cita SET status = 'completado' WHERE id_cita = :id", nativeQuery = true)
	int actualizarStatus(Integer id);

}
