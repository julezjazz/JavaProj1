package model;
/** Outsourced is derived from Part. */
public class Outsourced extends Part{

    private String companyName;
    /** This is the constructor for Outsourced objects. */
    public Outsourced(int id, String name, double price, int stock, int min, int max, String companyName) {
        super(id, name, price, stock, min, max);
        this.companyName = companyName;
    }
    /** This method sets the company name for Outsourced objects. */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    /** This returns the company name for an Outsourced object. */
    public String getCompanyName() {
        return companyName;
    }
}
