package medicines.domain.details;

public class in {
    private String purchase_id;
    private String purchase_date;

    public String getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(String purchase_id) {
        this.purchase_id = purchase_id;
    }

    public String getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(String purchase_date) {
        this.purchase_date = purchase_date;
    }

    @Override
    public String toString() {
        return "in{" +
                "purchase_id='" + purchase_id + '\'' +
                ", purchase_date='" + purchase_date + '\'' +
                '}';
    }
}
