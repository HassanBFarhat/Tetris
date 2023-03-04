package model;

import java.beans.PropertyChangeListener;

/**
 * This is an interface that stores the property change string values
 * and has the add/remove Property Change Listeners that Board.java
 * should implement.
 *
 * @author Hassan Farhat
 * @version Winter 2023
 */
public interface PropertyChangeGamePieces {

    /** A property name for current game piece to move down. */
    String PROPERTY_DOWN = "down";

    /** A property name for current game piece to move left. */
    String PROPERTY_LEFT = "left";

    /** A property name for current game piece to move right. */
    String PROPERTY_RIGHT = "right";

    /** A property name for current game piece to rotate clockwise. */
    String PROPERTY_RCW = "clockwise";

    /** A property name for current game piece to rotate counter-clockwise. */
    String PROPERTY_RCCW = "counter clockwise";

    /** A property name for current game piece to drop down. */
    String PROPERTY_DROP = "drop";

    /** A property name for current game piece to drop down. */
    String PROPERTY_CHANGED = "changed board";

    /**
     * Add a PropertyChangeListener to the listener list. The listener
     * is registered for all properties. The same listener object may be
     * added more than once, and will be called as many times as it is
     * added. If listener is null, no exception is thrown and no action is taken.
     *
     * @param theListener The PropertyChangeListener to be added
     */
    void addPropertyChangeListener(PropertyChangeListener theListener);

    /**
     * Remove a PropertyChangeListener from the listener list. This removes a
     * PropertyChangeListener that was registered for all properties. If listener
     * was added more than once to same event, it's notified one less time after
     * removal. If listener null/never added, no exception thrown and no action taken.
     *
     * @param theListener The PropertyChangeListener to be removed
     */
    void removePropertyChangeListener(PropertyChangeListener theListener);

}
