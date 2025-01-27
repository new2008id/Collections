import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarListTest {
    private CarList carList;

    @BeforeEach
    void setUp() throws Exception {
        carList = new CarLinkedList();

        for (int i = 0; i < 100; i++) {
            carList.add(new Car("brand" + i, i));
        }
    }

    @Test // add()
    public void whenAdded100ElementsThenSizeMustBe100() {
        assertEquals(100, carList.size());
    }

    @Test // remove by index
    public void whenElementRemovedByIndexThenSizeMustBeDecreased() { // удалили элемент по индексу, размер должен быть уменьшен
        assertTrue(carList.removeAt(5)); // Убедились, что вернулось true и удаление прошло успешно
        assertEquals(99, carList.size());
    }

    @Test // remove()
    public void whenElementRemovedThenSizeMustBeDecreased() {
        Car car = new Car("Tayota", 15);
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test // remove none existent element()
    public void whenNonExistentElementRemovedThenReturnFalse() {
        Car car = new Car("Tayota", 15);
        assertFalse(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test // clear()
    public void whenListClearedThenSizeMustBe0() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test // get()
    public void whenIndexOutOfBoundsThenThrownException() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> carList.get(100));
    }

    @Test // get() unknown exception
    public void methodGetReturnedRightValue() {
        Car car = carList.get(0);
        assertEquals("brand0", car.getBrand());
    }

    @Test
    public void insertIntoMiddle() { // вставка элемента в середину списка
        Car car = new Car("BMW", 1);
        carList.add(car, 50);
        Car carFromList = carList.get(50);
        assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public void insertIntoFirstPosition() { // вставка элемента в начало списка
        Car car = new Car("BMW", 1);
        carList.add(car, 0);
        Car carFromList = carList.get(0);
        assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public void insertIntoLastPosition() { // вставка элемента в конец списка
        Car car = new Car("BMW", 1);
        carList.add(car, 100);
        Car carFromList = carList.get(100);
        assertEquals("BMW", carFromList.getBrand());
    }


}