import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarCollectionTest {

    private CarCollection carCollection;

    @BeforeEach
    void setUp() {
        carCollection = new CarHashSet();

        for (int i = 0; i < 100; i++) {
            carCollection.add(new Car("brand" + i, i));
        }
    }

    @Test
    public void whenContainsTheCarThenReturnTrue() {
        assertTrue(carCollection.contains(new Car("brand30", 30)));
    }

    @Test
    public void whenNotContainsTheCarThenReturnFalse() {
        assertFalse(carCollection.contains(new Car("brand300", 30)));
    }

    @Test
    public void whenCarSetIsEmptyThenReturnFalse() {
        carCollection.clear();
        assertFalse(carCollection.contains(new Car("brand3", 3)));
    }

    @Test
    public void testForEach() {
        int index = 0;
        for (Car car : carCollection) {
            index++;
        }
        assertEquals(100, index);
    }

//    @Test
//    public void addNullElementTest() {
//        assertThrows(NullPointerException.class, () -> carCollection.add(null));
//    }
}