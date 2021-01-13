package medicines.domain;

import java.util.Date;

public class Storage {
    private String med_id;
    private int stock_num;
    private String production_date;

    public String getMed_id() {
        return med_id;
    }

    public void setMed_id(String med_id) {
        this.med_id = med_id;
    }

    public int getStock_num() {
        return stock_num;
    }

    public void setStock_num(int stock_num) {
        this.stock_num = stock_num;
    }

    public String getProduction_date() {
        return production_date;
    }

    public void setProduction_date(String production_date) {
        this.production_date = production_date;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "med_id='" + med_id + '\'' +
                ", stock_num=" + stock_num +
                ", production_date=" + production_date +
                '}';
    }
}
