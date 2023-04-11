import java.util.ArrayList;

public class Monkey {
    private int id; // id do macaco
    private int coconuts; // quantidade de cocos

    private int coconutsODD;

    private int coconutsEVEN;
    private int idOdd; // para quem ele passa se for impar
    private int idEven; // para quem ele passa se for par

    public Monkey(int id, int coconuts, int idOdd, int idEven) {
        this.id = id;
        this.coconuts = 0;
        this.idOdd = idOdd;
        this.idEven = idEven;
        coconutsODD = 0;
        coconutsEVEN = 0;
    }

    public void addCoconutODD(int amount){
        coconutsODD+=amount;
        addCoconut(amount);
    }

    public void addCoconutEVEN(int amount){
        coconutsEVEN+= amount;
        addCoconut(amount);
    }

    public void removeCoconutODD(int amount){
        coconutsODD-=amount;
        removeCoconut(amount);
    }

    public void removeCoconutEVEN(int amount){
        coconutsEVEN=-amount;
        removeCoconut(amount);
    }

    public void resetODD(){
        coconutsODD = 0;
    }

    public void resetEven(){
        coconutsEVEN = 0;
    }

    public int getCoconutsODD() {
        return coconutsODD;
    }

    public int getCoconutsEVEN() {
        return coconutsEVEN;
    }

    public int getCoconuts() {
        return coconuts;
    }

    public int getIdOdd() {
        return idOdd;
    }

    public int getIdEven() {
        return idEven;
    }

    private void removeCoconut(int coco){
        coconuts-= coco;
    }

    private void addCoconut(int coco){
        coconuts+=coco;
    }

    public int getId() {
        return id;
    }


}
