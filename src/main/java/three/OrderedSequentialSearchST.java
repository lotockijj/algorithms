package three;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OrderedSequentialSearchST <Key extends Comparable<Key>, Value> {
    private LinkedList<Node> nodes;

    public OrderedSequentialSearchST(){
        nodes = new LinkedList<>();
    }

    private class Node{
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "  " + value;
        }
    }

    public void put(Key key, Value value){
        Node node = new Node(key, value);
        int rank = getRankOfNode(node);
        nodes.add(rank, node);
    }

    private int getRankOfNode(Node node) {
        int lo = 0, hi = nodes.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = node.key.compareTo(nodes.get(mid).key);
            if (cmp > 0) hi = mid - 1;
            else if (cmp < 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            int indexOfCurrentNode = nodes.indexOf(node);
            int indexOfNextElement = indexOfCurrentNode < nodes.size() ? indexOfCurrentNode + 1 : nodes.size();
            Node nextNode = indexOfNextElement < nodes.size() ? nodes.get(indexOfNextElement) : null;
            stringBuilder.append(node.key + " - " + node.value + " next->\n ");
//            if (nextNode != null) {
//                stringBuilder.append(nextNode.key + "-" + nextNode.value + "\n");
//            } else {
//                stringBuilder.append("null \n");
//            }
        }
        return stringBuilder.toString();
    }

    public Node min(){
        return nodes.getLast();
    }

    public Node get(String time){
        int lo = 0, hi = nodes.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = time.compareTo(nodes.get(mid).key.toString());
            if (cmp > 0) hi = mid - 1;
            else if (cmp < 0) lo = mid + 1;
            else return nodes.get(mid);
        }
        return null;
    }

    public Node floor(String time){
        int lo = 0, hi = nodes.size() - 1;
        Node result = null;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = time.compareTo(nodes.get(mid).key.toString());
            result = nodes.get(hi);
            if (cmp > 0) hi = mid - 1;
            else if (cmp < 0) lo = mid + 1;
            else {
                result = nodes.get(mid);
                break;
            }
        }
        return result;
    }

    public Node ceiling(String time) {
        return floor(time);
    }

    public String select(int n) {
        return nodes.get(nodes.size() - n - 1).key.toString();
    }

    public List<Node> keys(String start, String finish) {
        List<Node> nodesKeys = new ArrayList<>();
        Node ceilingNodeBegin = ceiling(start);
        Node ceilingNodeEnd = ceiling(finish);
        int rankOfStartNode = getRankOfNode(ceilingNodeBegin);
        int rankOfFinishNode = getRankOfNode(ceilingNodeEnd);
        for (int i = rankOfStartNode; i > rankOfFinishNode; i--) {
            nodesKeys.add(nodes.get(i - 1));
        }
        return nodesKeys;
    }

    public Node max(){
        return nodes.getFirst();
    }

    public int size(){
        return nodes.size();
    }
}
