package CiroVitiello.U5W1D4.dao;

import CiroVitiello.U5W1D4.entities.Drink;
import CiroVitiello.U5W1D4.exceptions.NoFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkService {
    @Autowired
    private DrinkDAO drinkDAO;

    public void saveDrink(Drink newDrink) {
        drinkDAO.save(newDrink);
        System.out.println("Drink created");
    }

    public List<Drink> findAllDrinks() {
        return drinkDAO.findAll();
    }

    public Drink findById(long drinkId) {
        return drinkDAO.findById(drinkId).orElseThrow(() -> new NoFoundException(drinkId));
    }

    public void findByIdAndDelete(long drinkID) {
        Drink found = this.findById(drinkID);
        drinkDAO.delete(found);
        System.out.println("the drink with " + drinkID + " has been deleted!");
    }

    public void findByIdAndUpdate(long drinkId, Drink updatedDrink) {
        Drink found = this.findById(drinkId);
        found.setName(updatedDrink.getName());
        found.setCalories(updatedDrink.getCalories());
        found.setPrice(updatedDrink.getPrice());
        drinkDAO.save(found);
        System.out.println("drink " + drinkId + "updated!");
    }

    public List<Drink> filterByCalories(int calories) {
        return drinkDAO.findByCaloriesLessThan(calories);
    }
}
