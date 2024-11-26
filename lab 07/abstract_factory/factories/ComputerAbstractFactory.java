package org.example.design_patterns.abstract_factory.factories;

import org.example.design_patterns.abstract_factory.entities.Computer;

/**
 * We need this to create as many specialized factories as we want.
 *
 * Advantages for Abstract Factory:
 * - very easy to create specialized factories that can create other entities
 * - easy to store stateful data besides the factory (usage, metrics etc.)
 * - if we want we can create entities that do not share the same parent
 */
public interface ComputerAbstractFactory {
    Computer createComputer();

    /**
     * You will see in a bit what we do with this.
     */
    Computer createGamingComputer();
}
