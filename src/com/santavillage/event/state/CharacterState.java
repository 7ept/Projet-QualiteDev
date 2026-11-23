package com.santavillage.event.state;

public sealed interface CharacterState permits NormalState, HungryState, ExhaustedState, PranksterState, MeltingState {
    String getSoundEffect();
}
