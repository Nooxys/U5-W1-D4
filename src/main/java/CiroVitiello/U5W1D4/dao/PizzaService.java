package CiroVitiello.U5W1D4.dao;

import CiroVitiello.U5W1D4.entities.Pizza;
import CiroVitiello.U5W1D4.exceptions.NoFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
    @Autowired
    private PizzaDAO pizzaDAO;

    public void savePizza(Pizza newPizza) {
        pizzaDAO.save(newPizza);
        System.out.println("Pizza created");
    }

    public List<Pizza> findAllDrinks() {
        return pizzaDAO.findAll();
    }

    public Pizza findById(long pizzaId) {
        return pizzaDAO.findById(pizzaId).orElseThrow(() -> new NoFoundException(pizzaId));
    }

    public void findByIdAndDelete(long pizzaID) {
        Pizza found = this.findById(pizzaID);
        pizzaDAO.delete(found);
        System.out.println("the pizza with " + pizzaID + " has been deleted!");
    }

    public void findByIdAndUpdate(long pizzaID, Pizza updatedPizza) {
        Pizza found = this.findById(pizzaID);
        found.setName(updatedPizza.getName());
        found.setCalories(updatedPizza.getCalories());
        found.setPrice(updatedPizza.getPrice());
        found.setXl(updatedPizza.isXl());
        found.setToppingList(updatedPizza.getToppingList());
        pizzaDAO.save(found);
        System.out.println("pizza " + pizzaID + "updated!");
    }

    public List<Pizza> filterByName(String name) {
        return pizzaDAO.findByName(name);
    }
}
