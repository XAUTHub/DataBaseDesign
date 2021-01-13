package medicines.domain.details;

public class Factory {
    private String fac_name;
    private String med_identify;
    private String production_date;
    private int purchase_price; //进价

    public int getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_price(int purchase_price) {
        this.purchase_price = purchase_price;
    }

    public String getFac_name() {
        return fac_name;
    }

    public void setFac_name(String fac_name) {
        this.fac_name = fac_name;
    }

    public String getMed_identify() {
        return med_identify;
    }

    public void setMed_identify(String med_identify) {
        this.med_identify = med_identify;
    }

    public String getProduction_date() {
        return production_date;
    }

    public void setProduction_date(String production_date) {
        this.production_date = production_date;
    }


}
