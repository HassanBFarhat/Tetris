package model;

import java.beans.PropertyChangeListener;

public interface PropertyChangeGamePieces extends BoardLayoutAndControls {

    /** A property name for current game piece to move down. */
    String PROPERTY_DOWN = "down";

    /** A property name for current game piece to move left. */
    String PROPERTY_LEFT = "left";

    /** A property name for current game piece to move right. */
    String PROPERTY_RIGHT = "right";

    /** A property name for current game piece to rotate clockwise. */
    String PROPERTY_ROTATE_CLOCKWISE = "clockwise";

    /** A property name for current game piece to rotate counter-clockwise. */
    String PROPERTY_ROTATE_COUNTER_CLOCKWISE = "counter clockwise";

    /** A property name for current game piece to drop down. */
    String PROPERTY_DROP = "drop";

    /** A property name for current game piece to drop down. */
    String PROPERTY_CHANGED = "changed board";

    /**
     * Add a PropertyChangeListener to the listener list. The listener is registered for
     * all properties. The same listener object may be added more than once, and will be
     * called as many times as it is added. If listener is null, no exception is thrown and
     * no action is taken.
     *
     * @param theListener The PropertyChangeListener to be added
     */
    void addPropertyChangeListener(PropertyChangeListener theListener);

    /**
     * Remove a PropertyChangeListener from the listener list. This removes a
     * PropertyChangeListener that was registered for all properties. If listener was added
     * more than once to the same event source, it will be notified one less time after being
     * removed. If listener is null, or was never added, no exception is thrown and no action
     * is taken.
     *
     * @param theListener The PropertyChangeListener to be removed
     */
    void removePropertyChangeListener(PropertyChangeListener theListener);

}
