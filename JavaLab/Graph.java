import java.util.TreeMap;
import java.util.ArrayList;

class Edge {

  private Integer v, w;    // The vertices of the edge.
  private int weight;      // The weight of the edge.

  public Edge(Integer first, Integer second, int edgeWeight) {
    // Constructor. Creates an edge from v to w with weight
    // edgeWeight.
    // Precondition: None.
    // Postcondition: The edge is created.
    v = first;
    w = second;
    weight = edgeWeight;
  } // end constructor

  public int getWeight() {
    // Returns the edge weight
    return weight;
  } // end getWeight

  public Integer getV() {
    // Returns the first vertex of the edge
    return v;
  } // end getV

  public Integer getW() {
    // Returns the second vertex of the edge
    return w;
  } // end getW
} // end Edge


class Graph {
  private int numVertices;   // number of vertices in the graph
  private int numEdges;      // number of edges in the graph

  // For each vertex, we need to keep track of the edges,
  // so for each edge, we need to store the second vertex and
  // the edge weight. This can be done as a <key, value> pair,
  // with the second vertex as the key, and the weight as the
  // value. The TreeMap data structure is used to store a list
  // these (key, value) pairs for each vertex, accessible as
  // adjList.get(v).
  private ArrayList<TreeMap<Integer, Integer>> adjList;

  public Graph(int n) {
    // Constructor for weighted graph.
    // Precondition: The number of vertices n should be
    // greater than zero.
    // Postcondition: Initializes the graph with n vertices.
    numVertices = n;
    numEdges = 0;
    adjList = new ArrayList<TreeMap<Integer, Integer>>();
    for (int i=0; i<numVertices; i++) {
      adjList.add(new TreeMap<Integer, Integer>());
    } // end for
  } // end constructor

  public int getNumVertices() {
    // Determines the number of vertices in the graph.
    // Precondition: None.
    // Postcondition: Returns the number of vertices in
    // the graph.
    return numVertices;
  } // end getNumVertices

  public int getNumEdges() {
    // Determines the number of edges in the graph.
    // Precondition: None.
    // Postcondition: Returns the number of edges in
    // the graph.
    return numEdges;
  } // end getNumEdges

  public int getEdgeWeight(Integer v, Integer w) {
    // Determines the weight of the edge between vertices
    // v and w.
    // Precondition: The edge must exist in the graph.
    // Postcondition: Returns the weight of the edge.
    return adjList.get(v).get(w);
  } // end getWeight

  public void addEdge(Integer v, Integer w, int wgt) {
    // Adds an edge from v to w with weight wgt to the graph.
    // Precondition: The vertices contained within
    // edge e exist in the graph.
    // Postcondition: An edge from v to w is part of the
    // graph.

    // Add the edge to both v's and w's adjacency list
    adjList.get(v).put(w, wgt);
    adjList.get(w).put(v, wgt);
    numEdges++;
  } // end addEdge

  public void addEdge(Edge e) {
    // Adds an edge to the graph.
    // Precondition: The vertices contained within
    // edge e exist in the graph.
    // Postcondition: Edge e is part of the graph.

    // Extract the vertices and weight from the edge e
    Integer v = e.getV();
    Integer w = e.getW();
    int weight = e.getWeight();
    addEdge(v, w, weight);
  } // end addEdge

  public void removeEdge(Edge e) {
    // Removes an edge from the graph.
    // Precondition: The vertices contained in the edge e
    // exist in the graph.
    // Postcondition: Edge e is no longer part of the graph.

    // Extract the vertices from the edge e
    Integer v = e.getV();
    Integer w = e.getW();

    // Remove the edge from v's and w's adjacency list
    adjList.get(v).remove(w);
    adjList.get(w).remove(v);
    numEdges--;
  } // end remove

  public Edge findEdge(Integer v, Integer w) {
    // Finds the edge connecting v and w.
    // Precondition: The edge exists.
    // Postcondition: Returns the edge with the weight.
    int wgt = adjList.get(v).get(w);
    return new Edge(v, w, wgt);
  } // end findEdge

  public boolean hasEdge(Integer v, Integer w) {
	  return (adjList.get(v).size() > 0 && adjList.get(v).containsKey(w));
  }
  
  // package access
  TreeMap<Integer,Integer> getAdjList(Integer v) {
    // Returns the adjacency list for given vertex
    // Precondition: The vertex exists in the graph
    // Postcondition: Returns the associated adjacency
    // list.
    return adjList.get(v);
  } // end getAdjList

} // end Graph
