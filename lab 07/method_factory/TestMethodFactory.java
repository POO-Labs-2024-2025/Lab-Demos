package org.example.design_patterns.method_factory;

import org.example.design_patterns.method_factory.entities.Computer;

/**
 * FACTORY HIDES THE IMPLEMENTATION (open-closed principle + encapsulation + OOP Principles)
 */
public class TestMethodFactory {
    public static void main(String[] args) {
        // Look how simply we use it without having to pass a factory instance this time.
        Computer pc = ComputerFactory.getComputer("pc", "2 GB", "500 GB", "2.4 GHz");
        Computer server = ComputerFactory.getComputer("server", "16 GB", "1 TB", "2.9 GHz");

        System.out.println("Factory PC Config::"+pc);
        System.out.println("Factory Server Config::"+server);
    }
}
