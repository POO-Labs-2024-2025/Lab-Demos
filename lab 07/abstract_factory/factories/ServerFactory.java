package org.example.design_patterns.abstract_factory.factories;

import org.example.design_patterns.abstract_factory.entities.Computer;
import org.example.design_patterns.abstract_factory.entities.Server;

/**
 * First example, a PC factory that only creates PCs.
 *
 * This could use a Singleton and even a Builder if you want.
 */
public class ServerFactory implements ComputerAbstractFactory {

    private String ram;
    private String hdd;
    private String cpu;

    public ServerFactory(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }

    /**
     * Here we create and return a PC by default.
     *
     * If you want you can pass PC parameters here, not in the constructor.
     */
    @Override
    public Computer createComputer() {
        return new Server(ram, hdd, cpu);
    }

    /**
     * If we want we can create another specialized factory, one that creates custom types of Servers.
     *
     * We could have also simply created another class GamingServerFactory, but this works too.
     *
     * I would like inheritance more than the approach presented here since we force to always have 2 methods,
     * maybe there aren't GamingServers, what do we do then? It doesn't make sense does it? Well if we created
     * a GamingPCFactory class it would work much better and avoid the issue described.
     */
    public Computer createGamingComputer() {
        return new PC("16GB", "1TB", "Ryzen 9000x3D")
    }

}
