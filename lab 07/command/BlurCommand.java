package org.example.design_patterns.command;

/**
 * Concrete command
 */
public class BlurCommand implements Command {
    private final Image image;
    private int previousBlurStrength;
    private int nextBlurStrength;

    public BlurCommand(Image image, int blurStrength) {
        this.image = image;
        this.nextBlurStrength = blurStrength;
    }

    @Override
    public void execute() {
        previousBlurStrength = image.getBlurStrength();
        image.setBlurStrength(nextBlurStrength);
    }

    @Override
    public void undo() {
        nextBlurStrength = previousBlurStrength;
        previousBlurStrength = image.getBlurStrength();
        image.setBlurStrength(nextBlurStrength);
    }
}
