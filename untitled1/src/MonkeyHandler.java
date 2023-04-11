import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MonkeyHandler{
    private ArrayList<Monkey> monkeys;
    private int rounds;

    public MonkeyHandler(){
        monkeys = new ArrayList<>();
    }

    public void startGame(){
        ArrayList<String> data = TxtHandler.createAllDataTable("/Users/PUCRS/Desktop/untitled1/src/0100macacos.txt");
        rounds = Integer.parseInt(data.get(0).split(" ")[1]);
       for(String line : data.subList(1, data.size())){
           String [] splitted = line.split(" ");
           int id = Integer.parseInt(splitted[1]);
           int coconut = Integer.parseInt(splitted[9]);
           int oddID = Integer.parseInt(splitted[7]);
           int evenID = Integer.parseInt(splitted[4]);
           Monkey paragon = new Monkey(id, coconut, oddID, evenID);
           for(int i = 11 ; i< splitted.length ; i++){
               int current = Integer.parseInt(splitted[i]);
               if(current % 2 == 0){paragon.addCoconutEVEN(1);}else{paragon.addCoconutODD(1);}
           }
           monkeys.add(paragon);
       }
       if(monkeys.size() == 1000){System.out.println("TUDO CERTO");}
       else{System.out.println("ERRADO REFAZ  ; size é " + monkeys.size() ); }
    }

    public void playGame(){
        System.out.println("O numero de rodadas é " + rounds);
        int currentRound = 1;
        while(currentRound < rounds){
            for(Monkey paragon : monkeys){
                Monkey receiverEVEN = getMonkeyByID(paragon.getIdEven());
                Monkey receiverODD = getMonkeyByID(paragon.getIdOdd());
                receiverODD.addCoconutODD(paragon.getCoconutsODD());
                receiverEVEN.addCoconutEVEN(paragon.getCoconutsEVEN());
                paragon.removeCoconutEVEN(paragon.getCoconutsEVEN());
                paragon.removeCoconutODD(paragon.getCoconutsODD());
            }
            System.out.println("round " + currentRound + "Concluido");
            currentRound+=1;
        }
        Collections.sort(monkeys, new CompareCoconuts());
        for(int i = 0 ; i< 6 ; i++){
            System.out.println(monkeys.get(i).getId() + " numero de coco " + monkeys.get(i).getCoconuts());
        }
    }

    private Monkey getMonkeyByID(int id){
        return monkeys.get(id);
    }

private class CompareCoconuts implements Comparator <Monkey>{
    public int compare(Monkey o1, Monkey o2) {
        int person_id1=o1.getCoconuts();
        int person_id2=o2.getCoconuts();
        if(person_id1 > person_id2){
            return -1;
        }
        else if(person_id1 < person_id2){
            return 1;
        }
        else return 0;
    }
}
}
