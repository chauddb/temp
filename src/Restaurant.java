import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {

    private static Scanner input;
    private static ArrayList<Burger> fridge = new ArrayList<>();;

    public Restaurant(){
        this.prepareBurgers();
    }

    public static void displayBurgers(){
        System.out.println("\n\t\tBrampton Burgers");
        System.out.println("\n\t\t````````````````");

        int i = 1;
        for (Burger burger: fridge){
            System.out.println(i+".\t"+burger);
            System.out.println("--------------------------\n");
            i++;
        }
    }

    public static void displayToppings(Burger burger){
        System.out.println("\n\nPlease add some toppings");
        System.out.println("````````````````````````");

        int i = 1;
        for (Topping topping: burger.getToppings()){
            System.out.println(i+".\t"+topping);
            i++;
        }
        System.out.println("0.\tThat's all");
    }


    public static Burger selectBurger(){
        Burger burger;

        System.out.print("Select: ");

        try{
            input = new Scanner(System.in);
            int choice  = input.nextInt();

            if(choice > 3 || choice < 1){
                Error("Please select a burger shown in the list");
                burger = selectBurger();
            }else{
                burger = fridge.get(choice-1);
            }
        }catch(Exception e){
            Error("Please select a burger shown in the list");
            burger = selectBurger();
        }
        return burger;
    }


    public static void chooseToppings(Burger burger,ArrayList<Topping> toppings){
        System.out.print("\nChoose any " + burger.getMaxToppings()+" toppings : ");

        try {
            input = new Scanner(System.in);
            int choice = input.nextInt();

            if (choice == 0){
                return;
            }else if(choice > burger.getMaxToppings()) {
                Error("\nPlease select the right topping");
                chooseToppings(burger,toppings);
            }else{
                toppings.add(burger.getToppings().get(choice-1));
            }
        }catch (Exception e){
            Error("\n Please select the right topping");
            chooseToppings(burger,toppings);
        }

        if(burger.getMaxToppings() != toppings.size()){
            chooseToppings(burger,toppings);
        }



    }


    private void prepareBurgers(){
        Topping tomato =  new Topping("Tomato", 0.6);
        Topping cheese =  new Topping("Cheese", 1.2);
        Topping carrot=  new Topping("Carrot", 1.1);
        Topping lettuce =  new Topping("Lettuce", 0.8);
        Topping bacon =  new Topping("Bacon", 2.0);
        Topping olives =  new Topping("Olives", 0.3);

        Burger bburger = new BasicBurger("Basic",5.4,4 );
        Burger hburger = new HealthyBurger("Healthy",6.2,6 );
        Burger dburger = new DeluxeBurger("Deluxe",8.7,2 );

        bburger.setToppings(tomato);
        bburger.setToppings(cheese);
        bburger.setToppings(carrot);
        bburger.setToppings(lettuce);

        hburger.setToppings(tomato);
        hburger.setToppings(cheese);
        hburger.setToppings(carrot);
        hburger.setToppings(lettuce);
        hburger.setToppings(bacon);
        hburger.setToppings(olives);

        dburger.setToppings(bacon);
        dburger.setToppings(olives);

        this.fridge.add(bburger);
        this.fridge.add(hburger);
        this.fridge.add(dburger);

    }

    private static void Error(String error){
        System.out.println(error);
    }

}
