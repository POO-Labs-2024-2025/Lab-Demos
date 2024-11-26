package org.example.design_patterns.command;

public interface Command {
    /**
     * Every command executes something based on its logic on the Receiver (Image)
     */
    void execute();

    /**
     * Every command undoes something based on its logic on the Receiver (Image)
     */
    void undo();
}
