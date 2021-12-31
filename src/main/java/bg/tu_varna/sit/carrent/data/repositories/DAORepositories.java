package bg.tu_varna.sit.carrent.data.repositories;

import java.util.List;

public interface DAORepositories<T> {
    void save(T obj);
    void update(T obj);
    void delete(T obj);
    List<T> getByIg(Long id);
    List<T> getAll();

}
