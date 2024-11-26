package org.example.design_patterns.abstract_factory;

import org.example.design_patterns.abstract_factory.entities.Computer;
import org.example.design_patterns.abstract_factory.factories.ComputerAbstractFactory;

public class ComputerFactory {

    /**
     * So here we have the traditional method that needs a factory (PC or Server in this case) and it creates an instance.
     */
    public static Computer getComputer(ComputerAbstractFactory factory){
        return factory.createComputer();
    }

    /**
     * Here we use at maximum the fact that we have a class so we added a special method for entities with special characteristics.
     *
     * I strongly advise you to look at Refactoring Guru about Abstract Factory to see how we can make specialized factories.
     */
    public static Computer getGamingComputer(ComputerAbstractFactory factory){
        return factory.createGamingComputer();
    }
}
