package es.upm.farm.language.models;

public class ProductsForBuy {
    private String product;
    private Integer price;

    public ProductsForBuy(String product, int price) {
        this.product = product;
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public Integer getPrice() {
        return price;
    }
}
