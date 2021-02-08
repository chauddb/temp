import java.lang.reflect.Array;
import java.util.ArrayList;

public class App {
        public static void main(String[] args){

                ArrayList<Topping> selectedToppings = new ArrayList<>();

                new Restaurant();
                Restaurant.displayBurgers();
                Burger selectedBurger = Restaurant.selectBurger();

                Restaurant.displayToppings(selectedBurger);
                Restaurant.chooseToppings(selectedBurger,selectedToppings);

                Bill bill = new Bill(selectedBurger,selectedToppings);
                bill.generateReceipt();
        }
}
