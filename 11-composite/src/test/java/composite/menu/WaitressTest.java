package composite.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WaitressTest {

    Waitress waitress;

    MenuComponent pancakeHouseMenu;
    MenuComponent dinerMenu;
    MenuComponent cafeMenu;
    MenuComponent dessertMenu;
    MenuComponent cakesMenu;
    MenuComponent breakfastMenu;
    MenuComponent allMenus;

    public void init() {
        pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
        dinerMenu = new Menu("DINER MENU", "Lunch");
        cafeMenu = new Menu("CAFE MENU", "Dinner");
        dessertMenu = new Menu("DESSERT MENU", "Dessert of course!");
        cakesMenu = new Menu("CAKES MENU", "Cakes");
        breakfastMenu = new Menu("BREAKFAST MENU", "Coffe and cakes!");
        allMenus = new Menu("ALL MENUS", "All menus combined");
    }

    public void allMenus() {
        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(breakfastMenu);
    }

    public void breakfastMenu() {
        breakfastMenu.add(cakesMenu);
        breakfastMenu.add(cafeMenu);
    }

    public void pancakeHouseMenu() {
        pancakeHouseMenu.add(new MenuItem("K&B's Pancake Breakfast", "Pancakes with scrambled eggs and toast",
                new String[] { "vegetarian", "breakfast", "pancake" }, 2.99));
        pancakeHouseMenu.add(new MenuItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage",
                new String[] { "vegetarian", "breakfast", "pancake" }, 2.99));
        pancakeHouseMenu
                .add(new MenuItem("Blueberry Pancakes", "Pancakes made with fresh blueberries and blueberry syrup",
                        new String[] { "vegetarian", "breakfast", "pancake" }, 3.49));
        pancakeHouseMenu.add(new MenuItem("Waffles", "Waffles with your choice of blueberries or strawberries",
                new String[] { "vegetarian", "breakfast", "pancake" }, 3.59));
    }

    public void dinerMenu() {
        dinerMenu.add(new MenuItem("Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat",
                new String[] { "vegetarian", "dinner" }, 2.99));
        dinerMenu.add(
                new MenuItem("BLT", "Bacon with lettuce & tomato on whole wheat", new String[] { "dinner" }, 2.99));
        dinerMenu.add(new MenuItem("Soup of the day", "A bowl of the soup of the day, with a side of potato salad",
                new String[] { "dinner" }, 3.29));
        dinerMenu.add(new MenuItem("Hot Dog", "A hot dog, with saurkraut, relish, onions, topped with cheese",
                new String[] { "dinner" }, 3.05));
        dinerMenu.add(new MenuItem("Steamed Veggies and Brown Rice", "A medly of steamed vegetables over brown rice",
                new String[] { "dinner" }, 3.99));

        dinerMenu.add(new MenuItem("Pasta", "Spaghetti with marinara sauce, and a slice of sourdough bread",
                new String[] { "dinner" }, 3.89));

        dinerMenu.add(dessertMenu);
    }

    public void dessertMenu() {
        dessertMenu.add(new MenuItem("Apple Pie", "Apple pie with a flakey crust, topped with vanilla icecream",
                new String[] { "dessert" }, 1.59));
        dessertMenu.add(new MenuItem("Cheesecake", "Creamy New York cheesecake, with a chocolate graham crust",
                new String[] { "dessert" }, 1.99));
        dessertMenu.add(
                new MenuItem("Sorbet", "A scoop of raspberry and a scoop of lime", new String[] { "dessert" }, 1.89));
    }

    public void cafeMenu() {
        cafeMenu.add(new MenuItem("Veggie Burger and Air Fries",
                "Veggie burger on a whole wheat bun, lettuce, tomato, and fries", new String[] { "coffee" }, 3.99));
        cafeMenu.add(new MenuItem("Soup of the day", "A cup of the soup of the day, with a side salad",
                new String[] { "coffee" }, 3.69));
        cafeMenu.add(new MenuItem("Burrito", "A large burrito, with whole pinto beans, salsa, guacamole",
                new String[] { "coffee" }, 4.29));
    }

    public void cakesMenu() {
        cakesMenu.add(new MenuItem("Chocotorta", "A cake with chocolinas and cream of dulce de leche and milk cream",
                new String[] { "cake", "vegetarian" }, 1));
        cakesMenu.add(new MenuItem("Cheesecake", "A cake with cheese and slim dough and red berries jelly",
                new String[] { "cake", "vegetarian" }, 1));
    }

    @BeforeEach
    public void setUp() {
        init();
        allMenus();
        breakfastMenu();
        pancakeHouseMenu();
        dinerMenu();
        dessertMenu();
        cafeMenu();
        cakesMenu();
        waitress = new Waitress(allMenus);
    }

    @Test
    public void printMenuTest() {
        waitress.printMenu();
    }

    @Test
    public void printVegetarianMenuTest() {
        waitress.printVegetarianMenu();
    }

    @Test
    public void printDinnerMenuTest() {
        waitress.printDinnerMenu();
    }
}
