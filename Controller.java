package ca.mcgill.cs.swdesign.finalCodeBase;

/**
 * An interface representing the user command when
 * interacting with the home entertainment system
 */
public interface Controller {

    /**
     * Play the next song
     */
    void next();

    /**
    *
    */
    void update(Queue pQueue);
}
