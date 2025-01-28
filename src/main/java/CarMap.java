import java.util.List;
import java.util.Set;

public interface CarMap {
    void put(CarOwner key, Car value);

    Car get(CarOwner key);

    // множество ключей
    Set<CarOwner> keySet();

    // метод, возвращает все автомобили
    List<Car> values();

    boolean remove(CarOwner key);

    // возвращает размер коллекции
    int size();

    void clear();


}
