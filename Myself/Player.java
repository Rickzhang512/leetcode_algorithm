import java.util.*;
interface Observer{
    public String getName();
    public void setName(String name);
    public void help();


}

public class Player implements Observer{
    private String playerName;


    @Override
    public String getName() {
       return this.playerName;
    }

    @Override
    public void setName(String name) {
        this.playerName = name;
    }

    @Override
    public void help() {
        System.out.println("Hold on,"+this.playerName + "coming for help");
    }

    public void beAttacked(AllyControlCenter acc) {
        System.out.println(this.playerName + "is under attack!");
        acc.notifyObserver(playerName);
    }
}
abstract class AllyControlCenter{
    protected String allyName;
    protected ArrayList<Observer> players = new ArrayList<Observer>();
    public void setAllyName(String allyName) {

        this.allyName = allyName;
    }

    public String getAllyName() {
        return this.allyName;
    }

    public void join(Observer obs) {
        System.out.println(obs.getName()+"join"+ this.allyName + "allies:");
        players.add(obs);
    }

    public void quit(Observer obs) {
        System.out.println(obs.getName()+"quit"+ this.allyName + "allies:");
        players.remove(obs);
    }

    public abstract void notifyObserver(String name);
}



class ConcreteAllyControlCenter extends AllyControlCenter{
    public ConcreteAllyControlCenter(String allyName){
        System.out.println(allyName + " the ally is created successfully");
        System.out.println("-----------------------");
        this.allyName = allyName;
    }


    @Override
    public void notifyObserver(String name) {
        System.out.println(this.allyName + "Emergency notification, my ally"+name+" is under attack!");
        for(Observer obs:players){
            if(!((Observer)obs).getName().equalsIgnoreCase(name)){
                ((Observer)obs).help();
            }
        }
    }
}