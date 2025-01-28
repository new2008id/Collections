import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Device memory
//        Car car1 = new Car("Audi", 1);
//        Car car2 = new Car("Audi", 1);
//        System.out.println(car1.equals(car2));
//
//        System.out.println(car1.hashCode());
//        System.out.println(car2.hashCode());
//        car2 = car1;

//        String brand = "Audi";
//        car2.setNumber(5);
//        System.out.println(car1.getBrand().equals(brand));

        // Iterable
//        CarCollection cars = new CarArrayList();
//        for (int i = 0; i < 10; i++) {
//            cars.add(new Car("Brand" + i, i));
//        }
//
//        for (Car car : cars) {
//            System.out.println(car.getBrand() + " " + car.getNumber());
//        }

        // TreeSet

//        Set<Car> cars = new TreeSet<>(new Comparator<Car>() {
//            @Override
//            public int compare(Car o1, Car o2) {
//                return o1.getBrand().compareTo(o2.getBrand());
//            }
//        });

//        Set<Car> cars = new TreeSet<>();
//        Random random = new Random();
//        int result = random.nextInt(0, 11);
//        for (int i = 0; i < 100; i++) {
////            cars.add(random.nextInt(0, 11));
//            cars.add(new Car("Brand" + i, i));
//        }
//
//        for (Car car : cars) {
//            System.out.println(car);
//        }

//         Practise TreeSet
//        Set<Integer> numbers = new TreeSet<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
////                 в порядке убывания
////                return o2 - o1;
//                return -o1.compareTo(o2);
//
//                // в порядке возрастания
////                return o1 - o2;
//            }
//        });
//        for (int i = 0; i < 100; i++) {
//            numbers.add((int) (Math.random() * 10));
//        }
//
//        for (int number : numbers) {
//            System.out.println(number);
//        }

        HashMap<CarOwner, Car> map = new HashMap<>();
        CarOwner key = new CarOwner(1, "Name", "LastName");
        map.put(key, new Car("brand1", 1));
        key.setId(8);
        Car car = map.get(key);
        System.out.println(car.getBrand());
    }
}
