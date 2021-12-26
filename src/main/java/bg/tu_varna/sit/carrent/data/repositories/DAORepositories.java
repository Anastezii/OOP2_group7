package bg.tu_varna.sit.carrent.data.repositories;

import bg.tu_varna.sit.carrent.data.entities.Client;

import java.util.List;
import java.util.Optional;

public interface DAORepositories<T> {
    void save(T obj);
    void update(T obj);
    void delete(T obj);
    List<T> getByIg(Long id);
    List<T> getAll();

}
