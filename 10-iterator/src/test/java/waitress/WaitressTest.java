package waitress;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WaitressTest {

    Waitress waitress;

    @BeforeEach
    public void setUp() {
        ArrayList<Menu> menus = new ArrayList<>();
        menus.add(new DinerMenu());
        menus.add(new PancakeHouseMenu());
        menus.add(new CoffeMenu());
        waitress = new Waitress(menus);
    }

    // @Test
    // public void iteratorTest() {
    //     waitress.printMenu();
    // }

    @Test
    public void deleteTest() {
        waitress.printMenu();
        waitress.deleteLastItemOfMenus();
        waitress.printMenu();
    }
}
