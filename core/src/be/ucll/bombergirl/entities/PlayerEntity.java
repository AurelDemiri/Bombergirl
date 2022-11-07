package be.ucll.bombergirl.entities;

import com.badlogic.ashley.core.Entity;

public class PlayerEntity extends Entity  {
    public enum States {
        IDLING_UP,
        IDLING_LEFT,
        IDLING_DOWN,
        IDLING_RIGHT,
        WALKING_UP,
        WALKING_LEFT,
        WALKING_DOWN,
        WALKING_RIGHT,
        DYING
    }
}
