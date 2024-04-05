package CiroVitiello.U5W1D4.dao;

import CiroVitiello.U5W1D4.entities.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkDAO extends JpaRepository<Drink, Long> {
    List<Drink> findByCaloriesLessThan(int calories);

}
