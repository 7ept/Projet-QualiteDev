package com.santavillage.event.state;

public record NormalState() implements CharacterState {
    @Override
    public String getSoundEffect() {
        return "la  chose se sent normalement normal.";
    }
}
