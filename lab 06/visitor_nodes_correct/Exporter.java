package visitor_second_iteration;

class Main {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        Visitor v = new NodeVisitor();

        for (Node e : nodes) {
            e.accept(v);
        }
    }
}
