package CiroVitiello.U5W1D4.dao;

import CiroVitiello.U5W1D4.entities.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToppingDAO extends JpaRepository<Topping, Long> {
    
}
