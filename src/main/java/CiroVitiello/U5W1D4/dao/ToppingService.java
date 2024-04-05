package CiroVitiello.U5W1D4.dao;

import CiroVitiello.U5W1D4.entities.Topping;
import CiroVitiello.U5W1D4.exceptions.NoFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToppingService {
    @Autowired
    private ToppingDAO toppingDAO;

    public void saveToppings(Topping newTopping) {
        toppingDAO.save(newTopping);
        System.out.println("topping created");
    }

    public List<Topping> findAllToppings() {
        return toppingDAO.findAll();
    }

    public Topping findById(long toppingID) {
        return toppingDAO.findById(toppingID).orElseThrow(() -> new NoFoundException(toppingID));
    }

    public void findByIdAndDelete(long toppingID) {
        Topping found = this.findById(toppingID);
        toppingDAO.delete(found);
        System.out.println("the topping with " + toppingID + " has been deleted!");
    }

    public void findByIdAndUpdate(long toppingID, Topping updatedTopping) {
        Topping found = this.findById(toppingID);
        found.setName(updatedTopping.getName());
        found.setCalories(updatedTopping.getCalories());
        found.setPrice(updatedTopping.getPrice());
        toppingDAO.save(found);
        System.out.println("topping " + toppingID + "updated!");
    }
}
