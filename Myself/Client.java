public class Client {
    public static void main(String[] args) {
       AllyControlCenter acc;

       acc = new ConcreteAllyControlCenter("TheStarCraft Star team:");

       Observer player1,player2,player3,player4;


       player1 = new Player("Karrigan");
       acc.join(player1);
       player2 = new Player("UED");
        acc.join(player2);
       player3 = new Player("Karrigan");
        acc.join(player3);
       player4 = new Player("Reno");
       acc.join(player4);
       ((Player) player1).beAttacked(acc);
    }

}
