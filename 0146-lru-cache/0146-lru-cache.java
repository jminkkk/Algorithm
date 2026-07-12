class LRUCache {
	Node head;
	Node tail;
	int capacity;
	Map<Integer, Node> map;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<>();
		this.head = new Node(-1, -1);
		this.tail = new Node(-1, -1);
		head.next = tail;
		tail.prev = head;
	}
	
	class Node {
		int key;
		int value;
		Node next;
		Node prev;
		
		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	public void put(int key, int value) {
        Node newNode = new Node(key, value);
        if (map.containsKey(key)) {
            Node existing = map.get(key);
            map.put(key, newNode);
            removeNode(existing);
            addFirst(newNode);
            return;
        }
		
		if (map.size() == capacity) {
            removeNode(tail.prev);
		}

		addFirst(newNode);
	}
	
	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}
		
		// 캐시 히트
		Node node = map.get(key);		
        removeNode(node);
        addFirst(node);
        return node.value;
	}

    private void addFirst(Node node) {
        Node next = head.next;
        node.prev = head;
        head.next = node;
        node.next = next;
        next.prev = node;
        map.put(node.key, node);
    }

    private void removeNode(Node node) {
        map.remove(node.key);
        Node next = node.next;
        Node prev = node.prev;
        next.prev = prev;
        prev.next = next;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */