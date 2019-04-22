package ProducerAndConsumer;

public class Goods {

    private String name;
    private Double price;

    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
    public Goods(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}
