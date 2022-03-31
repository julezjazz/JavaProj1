package model;
/** InHouse is derived from Part. */
public class InHouse extends Part {

    private int machineId;
    /** This is the constructor for InHouse objects. */
    public InHouse(int id, String name, double price, int stock, int min, int max, int machineId) {
        super(id, name, price, stock, min, max);
        this.machineId = machineId;
    }
    /** This sets the Machine ID for InHouse objects. */
    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }
    /** This returns the machine ID for InHouse objects. */
    public int getMachineId() {
        return machineId;
    }
}
