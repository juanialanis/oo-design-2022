package decorator.starbuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StarbuzzCoffeeTest {

    @Test
    public void randomCoffeeTest() {
        Beverage beverage = new Espresso();
        beverage = new Soy(beverage);
        beverage = new Whip(beverage);
        assertEquals(beverage.cost(), 2.24);
        assertEquals(beverage.getDescription(), "Espresso, Soy, Whip");
    }


    @Test
    public void doubleMochaSoyLatteWhipTest() {
        Beverage beverage = new HouseBlend();
        beverage = new Soy(beverage);
        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);
        assertEquals(beverage.cost(), 1.54);
        assertEquals(beverage.getDescription(), "House Blend Coffee, Soy, Mocha, Mocha, Whip");
    }

    @Test
    public void scotchDecoratorTest() {
        Beverage beverage = new HouseBlend();
        beverage = new Scotch(beverage);
        assertEquals(beverage.cost(), 1.19);
        assertEquals(beverage.getDescription(), "House Blend Coffee, Scotch");
    }
}
