package org.example.design_patterns.command;

/**
 * Why use Command? You can have UNDO, REDO, EXECUTE.
 *
 * What are the differences between Strategy, Command and Visitor?
 *
 * Visitor:
 * - Many to Many relationship
 * - easy to add another command, hard to add another entity
 *
 * Strategy:
 * - One to Many relationship
 *
 * Command:
 * - Undo, Redo, Execute possibilities
 */
public class TestCommand {

    public static void main(String[] args) {
        // We need a reference to our image since we perform operations
        Image image = new Image(100, 100);

        // We need a reference to our commands since those are memorized.
        // If you want you can create those using a factory directly inside the Invoker.
        Command blurCommand = new BlurCommand(image, 5);
        Command resizeCommand = new ResizeCommand(image, 50, 50);

        // We need to create an invoker
        Editor editor = new Editor();

        // EXECUTE COMMANDS!!!
        editor.edit(blurCommand);
        editor.edit(resizeCommand);

        // UNDO EXAMPLE
        editor.undo();

        System.out.println(image.getLength() + " " + image.getWidth() + " " + image.getBlurStrength());
    }
}
