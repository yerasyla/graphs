import java.util.*;

public class Search<Vertex> {
    public int count;
    public ArrayList<Vertex> marked;
    public Map<Vertex, Vertex> edgeTo;
    public final Vertex source;

    public Search(Vertex source) {
        this.source = source;
        marked = new ArrayList<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Vertex v) {
        return marked.contains(v);
    }

    public Iterable<Vertex> pathTo(Vertex v) {
        if (!hasPathTo(v)) return null;
        LinkedList<Vertex> ls = new LinkedList<>();
        for (Vertex i = v; i != source; i = edgeTo.get(i)) {
            ls.push(i);
        }
        ls.push(source);

        return ls;
    }

    public int getCount() {
        return count;
    }
}

