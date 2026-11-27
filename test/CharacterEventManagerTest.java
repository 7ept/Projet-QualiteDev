package test;

import com.santavillage.event.*;
import com.santavillage.event.state.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Random;

public class CharacterEventManagerTest {

    private static class StubCharacter implements EventTargetCharacter {
        String name = "Lutin";
        int hunger = 0;
        int fatigue = 0;
        int christmasMagic = 50;
        boolean indoors = false;
        boolean resting = false;

        @Override public String getName() { return name; }
        @Override public int getHunger() { return hunger; }
        @Override public void setHunger(int hunger) { this.hunger = hunger; }
        @Override public int getFatigue() { return fatigue; }
        @Override public void setFatigue(int fatigue) { this.fatigue = fatigue; }
        @Override public boolean isResting() { return resting; }
        @Override public boolean isIndoors() { return indoors; }
        @Override public void adjustChristmasMagic(int delta) { this.christmasMagic += delta; }
        @Override public String emitSound() { return "Ho ho!"; }
    }

    private static class StubSnowman extends StubCharacter {
        public StubSnowman() {
            this.name = "Bonhomme";
            this.indoors = true;
        }
    }

    private CharacterEventManager<EventTargetCharacter> manager;
    private StubCharacter elf;

    @BeforeEach
    void setUp() {
        elf = new StubCharacter();
        manager = new CharacterEventManager<>(new Random(42));
    }

    @Test
    void testInvalidInputsThrowException() 
    {
 
    }
    @Test
    void testZeroProbabilityDoesNothing() {

    }

    @Test
    void testSnowmanMeltsIndoors() 
    {
       
    }

    @Test
    void testHungerAndFatigueCapAt100() 
    {
    
    }

    @Test
    void testDefaultStateIsNormal() {
       
    }
}