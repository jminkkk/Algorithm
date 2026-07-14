class LRUCache {

    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        // key가 존재하지 않는 경우 - -1 반환
        if (!map.containsKey(key)) return -1;

        // key가 존재하는 경우 - 기존 값 제거 및 신규로 앞에 추가
        Node node = map.get(key);
        remove(node);
        addFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = new Node(key, value);
        // 이미 존재하는 key인 경우, 기존 값 제거 및 신규로 앞에 추가
        if (map.containsKey(key)) {
            Node existing = map.get(key);
            remove(existing);
            addFront(node);
            map.put(key, node);
            return;
        }

        // 신규 key인 경우
            // 용량이 차지 않은 경우 - 신규로 앞에 추가
        if (map.size() < capacity) {
            map.put(key, node);
            addFront(node);
            return;
        }

            // 용량이 찬 경우 - 기존 가장 낮은 값 제거 및 신규로 앞에 추가
        Node last = tail.prev;
        remove(last);
        map.remove(last.key);
        addFront(node);
        map.put(key, node);
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void addFront(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        next.prev = node;
        node.next = next;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */