package com.santavillage.event;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import com.santavillage.event.state.*;



public class  CharacterEventManager<T  extends EventTargetCharacter >
{
    private final Random random;
    private final Map<T , CharacterState> currentStates = new HashMap<>();
    public CharacterEventManager()
    {
        this(new Random());


    }
    public CharacterEventManager(Random random)
    {
        this.random =Objects.requireNonNull(random);
    }
    public List<String> processRandomEvents(Collection<T> characters, double probability)
    {
        Objects.requireNonNull(characters);
        
        if (probability <0.0|| probability> 1.0)
        {
            throw new IllegalArgumentException("impossible ");
        }
        List<String> logs = new ArrayList<>();
        Iterator<T> it = characters.iterator();
        while (it.hasNext()) 
        {
            T character = it.next();
            if(random.nextDouble()<= probability)
                {
                    logs.add(applyRandomEffect(character));
                }    
        }
        return logs;
       
    }
    private String applyRandomEffect(T character)
    {
        if (character.getClass().getSimpleName().toLowerCase().contains("snowman") && character.isIndoors())
            {
                CharacterState melting = new MeltingState();
                currentStates.put(character, melting);
                character.adjustChristmasMagic(-15);
                return formatLog(character, melting);
            }   
            int choice = random.nextInt(3);
            CharacterState nextState;
            switch (choice) 
            {
                case 0:
                    int newHunger = Math.min(100, character.getHunger()+20);
                    character.setHunger(newHunger);
                    nextState = new HungryState(newHunger);
                    break;
                case 1:
                    int newFatigue = Math.min(100, character.getFatigue()+20);
                    character.setFatigue(newFatigue);
                    nextState = new ExhaustedState(newFatigue);
                    break;

                default:
                    return  character.getName() + "émet : " +character.emitSound();
            }
            currentStates.put(character, nextState);
            return formatLog(character, nextState);

    }
    private String formatLog(T character, CharacterState state)
    {
        return "état " + character.getName()+ " -> "+ state.getClass().getSimpleName() + " Son : "+ state.getSoundEffect();  
    }

    public CharacterState getCharacterState(T character)
    {
        return currentStates.getOrDefault(character, new NormalState());
    }

}
