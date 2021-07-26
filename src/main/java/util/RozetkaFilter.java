package util;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RozetkaFilter {

    private String productType;
    private String brand;
    private int priceBounds;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPriceBounds() {
        return priceBounds;
    }

    public void setPriceBounds(int priceBounds) {
        this.priceBounds = priceBounds;
    }
}
