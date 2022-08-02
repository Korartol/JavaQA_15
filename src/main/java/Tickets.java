public class Tickets implements Comparable<Tickets> {
    protected int id;
    protected int price;  // стоимость билета
    protected String departure; // вылет
    protected String arrival;  // прилет
    protected int time;  // время в пути

    public Tickets(int id, int price, String departure, String arrival, int time) {
        this.id = id;
        this.price = price;
        this.departure = departure;
        this.arrival = arrival;
        this.time = time;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }

    public String getDeparture() {
        return departure;
    }

//    public void setDeparture(String departure) {
//        this.departure = departure;
//    }

    public String getArrival() {
        return arrival;
    }

//    public void setArrival(String arrival) {
//        this.arrival = arrival;
//    }
//
//    public int getTime() {
//        return time;
//    }
//
//    public void setTime(int time) {
//        this.time = time;
//    }

    @Override
    public int compareTo(Tickets o) {
        if (this.price > o.price) {
            return 1;
        } else if (this.price < o.price) {
            return -1;
        } else {
            return 0;
        }
    }
}
