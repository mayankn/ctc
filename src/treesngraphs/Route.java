package treesngraphs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by mayanknarasimhan on 23/12/14.
 *
 * Description:
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */
public class Route {
    Graph g;

    public static void main (String args[]) {
        GraphNode origin = new GraphNode(1);
        GraphNode n1 = new GraphNode(2);
        GraphNode n2 = new GraphNode(3);
        GraphNode n3 = new GraphNode(4);
        GraphNode n4 = new GraphNode(5);
        GraphNode n5 = new GraphNode(6);
        GraphNode destination = new GraphNode(7);
        n1.setAdjacentNode(n3);
        n1.setAdjacentNode(n4);
        n2.setAdjacentNode(n5);
        n2.setAdjacentNode(destination);
        origin.setAdjacentNode(n1);
        origin.setAdjacentNode(n2);
        Graph g = new Graph();
        g.addNode(origin);

        Route route = new Route(g);

        //System.out.println(route.isRoutePresent(origin, destination));
        //System.out.println(route.isRoutePresent(origin, new GraphNode(8)));
        route.printRoute(origin, destination);
    }

    public Route (Graph g) {
        this.g = g;
    }

    public boolean isRoutePresent (GraphNode origin, GraphNode destination) {
        if (g == null)
            return false;

        for (GraphNode n : g.getNodes())
            n.setVisited(false);
        Queue<GraphNode> q = new ArrayDeque<GraphNode>();
        q.add(origin);
        GraphNode u = null;
        while (!q.isEmpty()) {
            u = q.remove();
            if (!u.isVisited()) {
                for (GraphNode v : u.getAdjacentNodes()) {
                    if (!v.isVisited()) {
                        if (v.equals(destination))
                            return true;
                        q.add(v);
                    }
                }
                u.setVisited(true);
            }
        }
        return false;
    }

    public void printRoute (GraphNode origin, GraphNode destination) {
        if (isRoutePresent(origin, destination)) {
            for (GraphNode n : g.getNodes())
                n.setVisited(false);

            Queue<GraphNode> q = new ArrayDeque<GraphNode>();
            q.add(origin);
            GraphNode u = null;
            while (!q.isEmpty()) {
                u = q.remove();
                if (!u.isVisited()) {
                    System.out.print(u.getData() + " --> ");
                    for (GraphNode v : u.getAdjacentNodes()) {
                        if (!v.isVisited()) {
                            if (v.equals(destination)) {
                                System.out.println(v.getData());
                                return;
                            }
                            q.add(v);
                        }
                    }
                    u.setVisited(true);
                }
            }
        }
    }
}
