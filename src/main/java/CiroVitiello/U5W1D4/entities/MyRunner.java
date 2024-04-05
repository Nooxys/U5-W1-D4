package CiroVitiello.U5W1D4.entities;

import CiroVitiello.U5W1D4.U5W1D4Application;
import CiroVitiello.U5W1D4.dao.DrinkService;
import CiroVitiello.U5W1D4.dao.PizzaService;
import CiroVitiello.U5W1D4.dao.ToppingService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private DrinkService drinkService;
    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private ToppingService toppingService;


    @Autowired
    private Menu menu;
    @Autowired
    private Order order;

    @Override
    public void run(String... args) throws Exception {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5W1D4Application.class);
        Logger logger = ctx.getBean(Logger.class);

        menu.printMenu();
//      order.printOrder();
        logger.info("-----ORDER-----");
        logger.info("order number " + order.getNumber());
        logger.info("number of people " + order.getNumberOfPeople());
        logger.info("table " + order.getTable());
        logger.info("total " + order.getTotal());

        List<Drink> drinkList = (List<Drink>) ctx.getBean("drinks");
        drinkList.forEach(drink -> drinkService.saveDrink(drink));

        List<Topping> toppingList = (List<Topping>) ctx.getBean("toppings");
        toppingList.forEach(topping -> toppingService.saveToppings(topping));

        List<Pizza> pizzas = (List<Pizza>) ctx.getBean("pizzas");
        pizzas.forEach(pizza -> pizzaService.savePizza(pizza));

        pizzaService.filterByName("Pizza Margherita").forEach(System.out::println);
        drinkService.filterByCalories(500).forEach(drink -> System.out.println());
    }
}
