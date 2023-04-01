package three;

import java.util.LinkedList;

public class TimeSt <Key extends Comparable<Key>, Value>{
    private LinkedList<Node> nodes;

    public TimeSt(){
        nodes = new LinkedList<>();
    }

    private class Node{
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public void put(Key key, Value value){
        Node node = new Node(key, value, null);
        int rank = getRankOfNode(0, nodes.size(), node);
        nodes.add(rank, node);
    }

    private int getRankOfNode(int low, int hi, Node node) {
        int mid = low + (hi - low)/2;
        if(hi == low) return mid;
        while(low <= hi){
            if(!nodes.isEmpty() && node.key.compareTo(nodes.get(mid).key) > 0){
                return getRankOfNode(low, mid - 1, node);
            } else if (!nodes.isEmpty() && node.key.compareTo(nodes.get(mid).key) < 0){
                return getRankOfNode(mid + 1, hi, node);
            } else if(node.key.compareTo(nodes.get(mid).key) == 0){
                return mid;
            }
        }
        return mid;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        nodes.forEach(e -> stringBuilder.append(e.key + " - " + e.value + "\n"));
        return stringBuilder.toString();
    }
}
