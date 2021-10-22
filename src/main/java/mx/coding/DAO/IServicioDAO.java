package mx.coding.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.coding.model.Servicio;

public interface IServicioDAO extends JpaRepository<Servicio, Integer> {

}
