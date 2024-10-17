public class Flight {
    int age;
    int capacity;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Flight(int age, int capacity) {
        this.age = age;
        this.capacity = capacity;
    }


//    @Override
//    public int compareTo(Flight o) {
//        if (this.capacity > o.capacity) {
//            return 1;
//        } else if (this.capacity == o.capacity){
//            return 0;
//        } else {
//            return -1;
//        }
//    }

    @Override
    public String toString() {
        return "Flight{" +
                "age=" + age +
                ", capacity=" + capacity +
                '}';
    }
}
