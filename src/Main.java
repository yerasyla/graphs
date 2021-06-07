//Find the shortest path from Kostanay to Shymkent also find the distance

import java.util.List;

// Find the sum of the square of weights of all the edges.
public class Main {

    public static void main(String[] args) {
        WeightedGraphPlus<Object> graph = new WeightedGraphPlus<Object>();  //new WeightedGraph<>(true);

        graph.addEdge("Almaty", "Astana", 2.1);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Astana", 7.9);
        graph.addEdge("Astana", "Kostanay", 3.5);
        graph.addEdge("Shymkent", "Kyzylorda", 5.4);

        System.out.println("sum of the square of weights of all the edges: "+ graph.weightStorage);

        System.out.println("Dijkstra:");
        DijkstraSearch<Object> djk = new DijkstraSearch<Object>(graph, "Kostanay");
        outputPath(djk, "Shymkent");
        System.out.println("The distance is: "+djk.getShortestDistance("Shymkent"));


//        System.out.println("DFS:");
//        Search<Object> dfs = new DepthFirstSearch<Object>(graph, "Almaty");
//        outputPath(dfs, "Kyzylorda");
//
//        System.out.println("\n--------------------------------");
//
//        System.out.println("BFS:");
//        Search<Object> bfs = new BreadthFirstSearch<Object>(graph, "Almaty");
//        outputPath(bfs, "Kyzylorda");
    }

    public static void outputPath(Search<Object> search, String key) {
        for (Object v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }
    }
}

class WeightedGraphPlus<Vertex> extends WeightedGraph{
    double weightStorage =0.0;
    @Override
    public void addEdge(Object source, Object dest, double weight) {
        super.addEdge(source,dest,weight);
        weightStorage = weightStorage+Math.pow(weight,2);

    }
}

