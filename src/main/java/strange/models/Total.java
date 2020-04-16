package strange.models;

public class Total {
    private String total;
    private String male;
    private String female;

    public Total() {
    }

    public Total(String total, String male, String female) {
        this.total = total;
        this.male = male;
        this.female = female;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getFemale() {
        return female;
    }

    public void setFemale(String female) {
        this.female = female;
    }
}
