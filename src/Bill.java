import java.lang.reflect.Array;
import java.util.ArrayList;

public class Bill {

    private Burger burger;
    private ArrayList<Topping> toppings;

    public Bill(Burger burger, ArrayList<Topping> toppings){
        this.burger = burger;
        this.toppings = toppings;
    }

    public void generateReceipt(){
        Double total =  calculateTotal(); //;
        Double tax = total * 0.15;
        Double netTotal = total + tax;


        System.out.println("\n\tReceipt");
        System.out.println("\t`````````");
        System.out.println("1. " + burger.getName() + " - " + burger.getPrice() + "$");

        if (this.toppings.size() > 0){
            int i = 1;
            System.out.println("\n Extra : ");

            for (Topping topping:toppings){
                System.out.println(i +". " + topping.getName() + " - " + topping.getPrice() + "$");
            }
        }else{
            System.out.println("\n No Extra Toppings");
        }

        System.out.println("\n-----------------------------");
        System.out.println("Amount: " + String.format("%.2f",total) + "$");
        System.out.println("Tax: " + String.format("%.2f",tax) + "$");
        System.out.println("Total: " + String.format("%.2f",netTotal) + "$");
    }


    private Double calculateTotal(){
        Double temp = 0.0;
        temp += burger.getPrice();
        for (Topping topping: toppings){
            temp += topping.getPrice();
        }
        return temp;
    }




}
