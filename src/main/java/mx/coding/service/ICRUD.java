package mx.coding.service;

import java.util.List;
import java.util.Optional;

public interface ICRUD<T> {

	T registrar(T t);

	T modificar(T t);

	void eliminar(int id);

	List<T> listar();

	Optional<T> listarPorId(int id);
}
