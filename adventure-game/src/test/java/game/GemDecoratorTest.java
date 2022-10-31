package game;

import org.junit.jupiter.params.provider.MethodSource;

import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import java.util.stream.Stream;

public class GemDecoratorTest {
  
    static Stream<Arguments> oneDiamondGemGenerator() {
        return Stream.of(
            Arguments.of(new Fist(), 20),
            Arguments.of(new Wand(), 60),
            Arguments.of(new Mace(), 40)
        );
    }     
        
    static Stream<Arguments> oneSilmarilGemGenerator() {
        return Stream.of(                
            Arguments.of(new Fist(), 100),
            Arguments.of(new Wand(), 900),
            Arguments.of(new Mace(), 400)
        );
    }

    static Stream<Arguments> twoDiamondGemGenerator() {
        return Stream.of(
            Arguments.of(new Fist(), 40),
            Arguments.of(new Mace(), 80),
            Arguments.of(new Wand(), 120)
        );
    }
    
    static Stream<Arguments> twoSilmarilGemGenerator() {
        return Stream.of(
            Arguments.of(new Fist(), 10000),
            Arguments.of(new Mace(), 160000),
            Arguments.of(new Wand(), 810000)
        );
    }                           
            
    static Stream<Arguments> oneDiamondAndOneSilmarilGemGenerator() {
        return Stream.of(
            Arguments.of(new Fist(), 400),
            Arguments.of(new Mace(), 1600),
            Arguments.of(new Wand(), 3600)    
        );
    }

    static Stream<Arguments> oneSilmarilAndOneDiamondGemGenerator() {
        return Stream.of(
            Arguments.of(new Fist(), 200),
            Arguments.of(new Mace(), 800),
            Arguments.of(new Wand(), 1800)
        );
    }

    
    
    static Stream<Arguments> fourSilmarilGemGenerator() {
        return Stream.of(
            Arguments.of(new Fist(), 100000000),
            Arguments.of(new Mace(), 160000),
            Arguments.of(new Wand(), 810000)
        );
    }

    static Stream<Arguments> eightDiamonodGemGenerator() {
        return Stream.of(
            Arguments.of(new Fist(), 1280),
            Arguments.of(new Mace(), 640),
            Arguments.of(new Wand(), 480)
        );
    }


    static Stream<Arguments> threeSilmarilTwoDiamondGemGenerator() {
        return Stream.of(
            Arguments.of(new Fist(), 200000000),
            Arguments.of(new Mace(), 160000),
            Arguments.of(new Wand(), 810000)
        );
    }

    static Stream<Arguments> fiveDiamonodTwoSilmarilGemGenerator() {
        return Stream.of(
            Arguments.of(new Fist(), 102400),
            Arguments.of(new Mace(), 640),
            Arguments.of(new Wand(), 480)
        );
    }


    @ParameterizedTest
    @MethodSource("oneDiamondGemGenerator")
    public void oneDiamondGemTest(Weapon weapon, int damage) {
        weapon = new DiamondGem(weapon);
        assertEquals(weapon.getDamage(),damage);
    }

    @ParameterizedTest
    @MethodSource("oneSilmarilGemGenerator")
    public void oneSilmarilGemTest(Weapon weapon, int damage) {
        weapon = new SilmarilGem(weapon);
        assertEquals(weapon.getDamage(),damage);
    }

    @ParameterizedTest
    @MethodSource("twoDiamondGemGenerator")
    public void twoDiamondGemTest(Weapon weapon, int damage) {
        weapon = new DiamondGem(weapon);
        weapon = new DiamondGem(weapon);
        assertEquals(weapon.getDamage(),damage);
    }

    @ParameterizedTest
    @MethodSource("twoSilmarilGemGenerator")
    public void twoSilmarilGemTest(Weapon weapon, int damage) {
        weapon = new SilmarilGem(weapon);
        weapon = new SilmarilGem(weapon);
        assertEquals(weapon.getDamage(),damage);
    }

    @ParameterizedTest
    @MethodSource("oneDiamondAndOneSilmarilGemGenerator")
    public void oneDiamondAndOneSilmarilGemTest(Weapon weapon, int damage) {
        weapon = new DiamondGem(weapon);
        weapon = new SilmarilGem(weapon);
        assertEquals(weapon.getDamage(),damage);
    }

    @ParameterizedTest
    @MethodSource("oneSilmarilAndOneDiamondGemGenerator")
    public void oneSilmarilAndOneDiamondGemTest(Weapon weapon, int damage) {
        weapon = new SilmarilGem(weapon);
        weapon = new DiamondGem(weapon);
        assertEquals(weapon.getDamage(),damage);
    }

    @ParameterizedTest
    @MethodSource("fourSilmarilGemGenerator")
    public void fourSilmarilGemTest(Weapon weapon, int damage) {
        weapon = new SilmarilGem(weapon);
        weapon = new SilmarilGem(weapon);
        weapon = new SilmarilGem(weapon);
        weapon = new SilmarilGem(weapon);
        assertEquals(weapon.getDamage(),damage);
    }

    @ParameterizedTest
    @MethodSource("eightDiamonodGemGenerator")
    public void eightDiamonodGemTest(Weapon weapon, int damage) {
        weapon = new DiamondGem(weapon);
        weapon = new DiamondGem(weapon);
        weapon = new DiamondGem(weapon);
        weapon = new DiamondGem(weapon);
        weapon = new DiamondGem(weapon);
        weapon = new DiamondGem(weapon);
        weapon = new DiamondGem(weapon);
        weapon = new DiamondGem(weapon);
        assertEquals(weapon.getDamage(),damage);
    }

    @ParameterizedTest
    @MethodSource("threeSilmarilTwoDiamondGemGenerator")
    public void threeSilmarilTwoDiamondGemTest(Weapon weapon, int damage) {
        weapon = new SilmarilGem(weapon);
        weapon = new SilmarilGem(weapon);
        weapon = new SilmarilGem(weapon);
        weapon = new DiamondGem(weapon);
        weapon = new DiamondGem(weapon);
        assertEquals(weapon.getDamage(),damage);
    }

    @ParameterizedTest
    @MethodSource("fiveDiamonodTwoSilmarilGemGenerator")
    public void fiveDiamonodTwoSilmarilGemTest(Weapon weapon, int damage) {
        weapon = new DiamondGem(weapon);
        weapon = new DiamondGem(weapon);
        weapon = new DiamondGem(weapon);
        weapon = new DiamondGem(weapon);
        weapon = new DiamondGem(weapon);
        weapon = new SilmarilGem(weapon);
        weapon = new SilmarilGem(weapon);
        assertEquals(weapon.getDamage(),damage);
    }

}