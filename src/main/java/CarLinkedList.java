import java.util.Iterator;
import java.util.NoSuchElementException;

public class CarLinkedList implements CarList, CarQueue {
    private Node first;
    private Node last;
    private int size = 0;

    @Override
    public Car get(int index) {
        return getNode(index).value;
    }

    @Override
    public boolean add(Car car) {
        // если есть какой-либо элемент в коллекции, то добавляем его
        if (size == 0) {
            first = new Node(null, car, null);
            last = first;
        } else {
//            если в коллекции, уже что-то есть, то нужно создать новый объект Node
//            который станет последним, а элемент, который был последним, станет предпоследним
            Node secondLast = last;
            last = new Node(secondLast, car, null);
            secondLast.next = last;
        }
        size++;
        return true;
    }

    @Override
    public Car peek() {
        return size > 0 ? get(0) : null;
//
//        if (size > 0) {
//            return get(0);
//        } else {
//            return null;
//        }
    }

    @Override
    public Car poll() {
        Car car = get(0);
        removeAt(0);
        return car;
    }

    @Override
    public boolean add(Car car, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            return add(car);
        }
        Node nodeNext = getNode(index);
        Node nodePrevious = nodeNext.previous;
        Node newNode = new Node(nodePrevious, car, nodeNext);
        nodeNext.previous = newNode;
        if (nodePrevious != null) {
            nodePrevious.next = newNode;
        } else {
            first = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Car car) {
        int index = findElement(car);
        if (index != -1) {
            return removeAt(index);
        }
        return false;
    }


    @Override
    public boolean removeAt(int index) {
        Node node = getNode(index);
        Node nodeNext = node.next;
        Node nodePrevious = node.previous;
        if (nodeNext != null) {
            nodeNext.previous = nodePrevious;
        } else {
            last = nodePrevious;
        }
        if (nodePrevious != null) {
            nodePrevious.next = nodeNext;
        } else {
            first = nodeNext;
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean contains(Car car) {
        if (car == null) {
            return false;
        }
        return findElement(car) != -1;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private int findElement(Car car) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(car)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public Iterator<Car> iterator() {
        return new Iterator<Car>() {
            private Node currentNode = first;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public Car next() {
                if (currentNode == null) {
                    throw new NoSuchElementException();
                }
                Car car = currentNode.value;
                currentNode = currentNode.next;
                return car;
            }
        };
    }

    private static class Node {
        private Node previous;
        private final Car value;
        private Node next;

        public Node(Node previous, Car value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}
