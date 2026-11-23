package com.santavillage.event;

public interface EventTargetCharacter 
{
    String getName();
    int getHunger();
    void setHunger(int hunger);
    int getFatigue();
    void setFatigue(int fatigue);
    boolean isResting();
    boolean isIndoors();
    void adjustChristmasMagic(int delta);
    String emitSound();    
}
