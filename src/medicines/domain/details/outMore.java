package medicines.domain.details;

public class outMore {
    private String sale_id;
    private String user_id;
    private String med_id;
    private String med_name;
    private double true_price;
    private double sale_discount;
    private int sale_num;
    private String sale_date;

    public String getSale_id() {
        return sale_id;
    }

    public void setSale_id(String sale_id) {
        this.sale_id = sale_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getMed_id() {
        return med_id;
    }

    public void setMed_id(String med_id) {
        this.med_id = med_id;
    }

    public String getMed_name() {
        return med_name;
    }

    public void setMed_name(String med_name) {
        this.med_name = med_name;
    }

    public double getTrue_price() {
        return true_price;
    }

    public void setTrue_price(double true_price) {
        this.true_price = true_price;
    }

    public double getSale_discount() {
        return sale_discount;
    }

    public void setSale_discount(double sale_discount) {
        this.sale_discount = sale_discount;
    }

    public int getSale_num() {
        return sale_num;
    }

    public void setSale_num(int sale_num) {
        this.sale_num = sale_num;
    }

    public String getSale_date() {
        return sale_date;
    }

    public void setSale_date(String sale_date) {
        this.sale_date = sale_date;
    }

    @Override
    public String toString() {
        return "outMore{" +
                "sale_id='" + sale_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", med_id='" + med_id + '\'' +
                ", med_name='" + med_name + '\'' +
                ", true_price=" + true_price +
                ", sale_discount=" + sale_discount +
                ", sale_num=" + sale_num +
                ", sale_date='" + sale_date + '\'' +
                '}';
    }
}
