package mx.com.baz.directory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends CrudRepository<Person,String> {

    public Iterable<Person> findByNameContains(@Param("n") String name);
}
