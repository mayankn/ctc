package treesngraphs;

import java.util.ArrayList;

/**
 * Created by mayanknarasimhan on 23/12/14.
 *
 * Description:
 * An implementation of a graph data structure
 */
public class Graph {
    ArrayList<GraphNode> nodes;

    public Graph () {
        nodes = new ArrayList<GraphNode>();
    }

    public ArrayList<GraphNode> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<GraphNode> nodes) {
        this.nodes = nodes;
    }

    public void addNode (GraphNode n) {
        nodes.add(n);
    }
}
