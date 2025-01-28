import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarSetTest {

    private CarSet carSet;

    @BeforeEach
    void setUp() throws Exception {
        // init
        carSet = new CarHashSet();

        for (int i = 0; i < 100; i++) {
            carSet.add(new Car("brand" + i, i));
        }
    }

    @Test
    public void whenAdd3SimilarObjectsThenSizeIncreaseBy1() {
        assertEquals(100, carSet.size());
        assertTrue(carSet.add(new Car("BMW", 10)));
        assertFalse(carSet.add(new Car("BMW", 10)));
        assertFalse(carSet.add(new Car("BMW", 10)));
        assertEquals(101, carSet.size());
    }

    @Test
    public void whenSetClearedThenSizeBy0() {
        carSet.clear();
        assertEquals(0, carSet.size());
    }

    @Test
    public void whenElementRemovedThenSizeDecreased() {
        assertTrue(carSet.remove(new Car("brand30", 30)));
        assertEquals(99, carSet.size());

        assertFalse(carSet.remove(new Car("brand30", 30)));
        assertEquals(99, carSet.size());
    }

    @Test
    public void whenContainsTheCarThenReturnTrue() {
        assertTrue(carSet.contains(new Car("brand30", 30)));
    }

    @Test
    public void whenNotContainsTheCarThenReturnFalse() {
        assertFalse(carSet.contains(new Car("brand300", 300)));
    }

    @Test
    public void whenCarSetIsEmptyThenReturnFalse() {
        carSet.clear();
        assertFalse(carSet.contains(new Car("brand3", 3)));
    }

    @Test
    public void whenCarSetIsEmptyThenReturnFalseContinue() {
        carSet.clear();
        assertFalse(carSet.contains(new Car("brand33", 3)));
    }

//    @Test
//    public void addNullElementTest() {
//        assertThrows(NullPointerException.class, () -> carSet.add(null));
//    }
}