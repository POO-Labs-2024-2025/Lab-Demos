package org.example.design_patterns.command;

import java.util.LinkedList;

/**
 * Invoker (the one that gives commands)
 */
public class Editor {
    // LinkedList is used as a Stack here and it tracks the changes made
    private final LinkedList<Command> history = new LinkedList<>();

    /**
     * Here we do stuff and REMEMBER THE COMMAND EXECUTED
     */
    public void edit(Command command) {
        history.push(command);
        command.execute();
    }

    /**
     * Here we undo stuff BASED ON OUR MEMORY
     */
    public void undo() {
        if (history.isEmpty()) return;

        Command command = history.pop();
        if (command != null) {
            command.undo();
        }
    }

    redo() {
        // take the last command
        // call execute on it
        // put it back in history
    }
}
