package visitor_second_iteration;

public class NodeVisitor implements Visitor {
    public void visit(City city) {
        System.out.println("process XML");
    }

    public void visit(Industry xe) {
        System.out.println("process JSON");
    }

    public void visit(SightSeeing xe) {
        System.out.println("process JSON");
    }
}