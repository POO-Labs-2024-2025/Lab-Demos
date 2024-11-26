package org.example.design_patterns.command;

/**
 * Concrete command
 */
public class ResizeCommand implements Command {
    private final Image image;
    private int previousWidth;
    private int previousLength;
    private int nextWidth;
    private int nextLength;

    public ResizeCommand(Image image, int width, int length) {
        this.image = image;
        nextWidth = width;
        nextLength = length;
    }

    @Override
    public void execute() {
        previousWidth = image.getWidth();
        image.setWidth(nextWidth);

        previousLength = image.getLength();
        image.setLength(nextLength);
    }

    @Override
    public void undo() {
        nextWidth = previousWidth;
        previousWidth = image.getWidth();
        image.setWidth(nextWidth);

        nextLength = previousLength;
        previousLength = image.getLength();
        image.setLength(nextLength);
    }
}
