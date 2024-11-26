package org.example.design_patterns.method_factory;

import org.example.design_patterns.method_factory.entities.Computer;
import org.example.design_patterns.method_factory.entities.PC;
import org.example.design_patterns.method_factory.entities.Server;

/***
 * Method factory advantages:
 * - easy to extend as it is only a method (no need to create a new class, but this can also be a disadvantage as the file
 * gets bigger and bigger)
 * - best utilized for objects that have a common parent
 */
public class ComputerFactory {

    /**
     * This can be static or Singleton.
     *
     * Singleton advantages:
     * - easy to extend (getOfficeComputer/getGamingComputer)
     * - better for DI
     * - can be stateful (you can have metrics for example)
     *
     * Static advantages:
     * - easy to use
     * - no need to create an instance
     * - thread-safe
     * - more performant theoretically
     */
    public static Computer getComputer(String type, String ram, String hdd, String cpu) {
        // Use switch-case if you have lots of branches
        if ("PC".equalsIgnoreCase(type)) {
            return new PC(ram, hdd, cpu);
        } else if ("Server".equalsIgnoreCase(type)) {
            return new Server(ram, hdd, cpu);
        }

        return null;
    }
}
