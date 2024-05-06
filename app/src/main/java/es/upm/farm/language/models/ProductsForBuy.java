package es.upm.farm.language.models;

public class ProductsForBuy {
    private final String product;
    private final Integer price;

    private Integer own = Integer.MAX_VALUE;


    public ProductsForBuy(String product, int price) {
        this.product = product;
        this.price = price;
    }

    public ProductsForBuy(String product, int price, Integer own) {
        this.product = product;
        this.price = price;
        this.own = own;
    }

    public String getProduct() {
        return product;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getOwn() {
        return own;
    }
}
