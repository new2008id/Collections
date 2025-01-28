public interface CarQueue extends CarCollection {
    boolean add(Car car);

    Car peek(); // возвращает первый элемент из коллекции

    Car poll(); // возврвщает первый элемент из коллекции и удаляет его
}
