package medicines.domain;

public class Medicine {
    private String med_name;
    private String med_id;
    private String mde_class;
    private String factor;  //厂家名称
    private int purchase_price; //进价
    private int sale_price; //售价
    private double discount;    //折扣
    private int validity;   //保质期
    private String img_url;

    public String getMed_name() {
        return med_name;
    }

    public void setMed_name(String med_name) {
        this.med_name = med_name;
    }

    public String getMed_id() {
        return med_id;
    }

    public void setMed_id(String med_id) {
        this.med_id = med_id;
    }

    public String getMde_class() {
        return mde_class;
    }

    public void setMde_class(String mde_class) {
        this.mde_class = mde_class;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
    }

    public int getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_price(int purchase_price) {
        this.purchase_price = purchase_price;
    }

    public int getSale_price() {
        return sale_price;
    }

    public void setSale_price(int sale_price) {
        this.sale_price = sale_price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getValidity() {
        return validity;
    }

    public void setValidity(int validity) {
        this.validity = validity;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "med_name='" + med_name + '\'' +
                ", med_id='" + med_id + '\'' +
                ", mde_class='" + mde_class + '\'' +
                ", factor='" + factor + '\'' +
                ", purchase_price=" + purchase_price +
                ", sale_price=" + sale_price +
                ", discount=" + discount +
                ", validity=" + validity +
                ", img_url='" + img_url + '\'' +
                '}';
    }
}
