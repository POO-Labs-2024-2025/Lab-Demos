package org.example.design_patterns.abstract_factory;

import org.example.design_patterns.abstract_factory.entities.Computer;
import org.example.design_patterns.abstract_factory.factories.PCFactory;
import org.example.design_patterns.abstract_factory.factories.ServerFactory;

/**
 * FACTORY HIDES THE IMPLEMENTATION (open-closed principle + encapsulation + OOP Principles)
 */
public class TestAbstractFactory {

    public static void main(String[] args) {
        testAbstractFactory();
    }

    private static void testAbstractFactory() {
        // Look how simply we use it by passing the factory
        Computer pc = ComputerFactory.getComputer(new PCFactory("2 GB", "500 GB", "2.4 GHz"));
        Computer server = ComputerFactory.getComputer(new ServerFactory("16 GB", "1 TB", "2.9 GHz"));

        // And here is how we can use the other type of factory
        Computer pcGaming = ComputerFactory.getGamingComputer(new PCFactory("2 GB", "500 GB", "2.4 GHz"));

        System.out.println("AbstractFactory PC Config::"+pc);
        System.out.println("AbstractFactory Server Config::"+server);
    }
}
