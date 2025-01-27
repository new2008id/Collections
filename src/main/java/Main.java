public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Audi", 1);
        Car car2 = new Car("Audi", 1);
        System.out.println(car1.equals(car2));

        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());
//        car2 = car1;

//        String brand = "Audi";
//        car2.setNumber(5);
//        System.out.println(car1.getBrand().equals(brand));
    }
}
