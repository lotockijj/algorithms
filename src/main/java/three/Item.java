package three;

public class Item <Key extends Comparable<Key>, Value> implements Comparable<Item>{
    public Key key;
    public Value value;

    public Item(Key key, Value value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Item item) {
        if(item.key instanceof String && isDigit(item.key)){
            int itemKey = Integer.valueOf(item.key.toString());
            int thisItemKey = Integer.valueOf(this.key.toString());
            if(thisItemKey > itemKey) return 1;
            if(thisItemKey < itemKey) return -1;
            if(thisItemKey == itemKey) {
                if(item.value instanceof Integer && isDigit(item.value)) {
                    int itemValue = Integer.valueOf(item.value.toString());
                    int thisItemValue = Integer.valueOf(this.value.toString());
                    if (thisItemValue > itemValue) return 1;
                    if (thisItemValue < itemValue) return -1;
                    if (thisItemValue == itemValue) return 0;
                }
            }
        }
        return this.key.compareTo((Key) item.key);
    }

    private boolean isDigit(Object value) {
        return isDigit((Comparable) value);
    }

    private boolean isDigit(Comparable key) {
        String str = key.toString();
        for (int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))){
                return true;
            }
        }
        return false;
    }
}