package CiroVitiello.U5W1D4.dao;

import CiroVitiello.U5W1D4.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaDAO extends JpaRepository<Pizza, Long> {
    List<Pizza> findByName(String name);
}
