package treesngraphs;

import java.util.ArrayList;

/**
 * Created by mayanknarasimhan on 23/12/14.
 *
 * Description:
 * An implementation of the nodes in a graph
 */
public class GraphNode {
    boolean visited;
    int data;
    ArrayList<GraphNode> adjacentNodes;

    public GraphNode () {
        adjacentNodes = new ArrayList<GraphNode>();
    }

    public GraphNode (int data) {
        this.data = data;
        adjacentNodes = new ArrayList<GraphNode>();
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ArrayList<GraphNode> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(ArrayList<GraphNode> adjacentNodes) {
        for (GraphNode node : adjacentNodes)
            this.adjacentNodes.add(node);
    }

    public void setAdjacentNode (GraphNode node) {
        this.adjacentNodes.add(node);
    }
}
