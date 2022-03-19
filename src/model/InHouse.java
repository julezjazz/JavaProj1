package model;

public class InHouse extends Part {

    private int machineId;

    public InHouse(int id, String name, double price, int stock, int min, int max, int machineId) {
        super(id, name, price, stock, min, max);
        this.machineId = machineId;
    }

    public void setMachineId(int machineId) {
        this.machineId = machineId;
        //is this okay even though we've already used a parameter named machineId to set this?
    }

    public int getMachineId() {
        return machineId;
    }
}
