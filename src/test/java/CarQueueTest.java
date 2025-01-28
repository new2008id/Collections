import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarQueueTest {
    private CarQueue carQueue;

    @BeforeEach
    void setUp() {
//        carQueue = new C
        // init

        carQueue = new CarLinkedList();
        for (int i = 0; i < 10; i++) {
            carQueue.add(new Car("brand" + i, i));
        }
    }

    @Test
    public void add() {
        assertEquals(10, carQueue.size());
    }

    @Test
    public void peek() {
        Car car = carQueue.peek();
        assertEquals("brand0", car.getBrand());
        assertEquals(10, carQueue.size());

    }

    @Test
    public void poll() {
        Car car = carQueue.poll();
        assertEquals("brand0", car.getBrand());
        assertEquals(9, carQueue.size());

    }
}