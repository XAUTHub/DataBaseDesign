package medicines.domain.details;

public class out {
    private String sale_id;
    private String sale_date;

    public String getSale_id() {
        return sale_id;
    }

    public void setSale_id(String sale_id) {
        this.sale_id = sale_id;
    }

    public String getSale_date() {
        return sale_date;
    }

    public void setSale_date(String sale_date) {
        this.sale_date = sale_date;
    }

    @Override
    public String toString() {
        return "out{" +
                "sale_id='" + sale_id + '\'' +
                ", sale_date='" + sale_date + '\'' +
                '}';
    }
}
