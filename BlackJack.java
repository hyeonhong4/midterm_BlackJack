import java.util.Scanner;
public class BlackJack{
  public static void main(String[] args){
    Scanner P1 = new Scanner(System.in);
    System.out.println("P1-What is your name?");
    String A = P1.nextLine();
    Player p1 = new Player(A);
    Scanner P2 = new Scanner(System.in);
    System.out.println("P2-What is your name?");
    String B = P2.nextLine();
    Player p2 = new Player(B);
    p1.money=10;
    p2.money=10;
    while(3>1){
      if(p1.money==0 || p2.money==0){
        System.out.println("No Money & Game Over");
        break;}
          
      p1.bet = bet(p1);
      while (3>1){
        if(p1.bet==0) {
          System.out.println("You at least 1$");
          p1.bet=bet(p1);
        }
        else{
          break;
        }
      }
      
      p2.bet = bet(p2);
      while (3>1){
        if(p2.bet==0) {
          System.out.println("You at least 1$");
          p2.bet=bet(p2);
        }
        else{
          break;
        }
      }
      p1.total = play_human(p1);
      p2.total=play_human(p2);
      p1.total = card(p1);
      p2.total= card(p2);
      System.out.println(p1.name+" bet = "+p1.bet);
      System.out.println(p2.name+" bet = "+p2.bet);
      int computer_total = play_computer();
      if(p1.total>21){
        p1.total=0;
      }
      if(p2.total>21){
        p2.total=0;
        
      }
      calculate_winner(p1,p2,computer_total);
      
      Scanner Re = new Scanner(System.in);
      System.out.println("Play again? (Y)");
      String C = Re.nextLine();
      if(C.equals("Y")){
        continue;}
      break;
    }}
  public static int card(Player x){
       while(3>1){
         String[] myArray;
         myArray = new String[4];
         myArray[0]="◇";
         myArray[1]="♤";
         myArray[2]="♡";
         myArray[3]="♧";
         if(x.total<21){
           Scanner in = new Scanner(System.in);
           System.out.println(x.name+" total ="+x.total);
           System.out.println(x.name+" Do you want another card (Y/N)");
           String s = in.nextLine();
           if(s.equals("Y")){
             int human_card3 = (int)(Math.random()*13)+1;
             if(human_card3>10){
               x.card=x.card+human_card3;
               human_card3=10;}
             if(human_card3==1){
               System.out.println("New Card A");
               Scanner T = new Scanner(System.in);
               System.out.println("You Choice 1 or 11");
               int V = T.nextInt();
               if(V==11){
                 human_card3=11;
               }
               else{
                 human_card3=1;
               }
             }
             String human_card3_object= myArray[(int)(Math.random()*4)];
             x.total=x.total+human_card3;
             System.out.println("New Card = "+human_card3_object+human_card3);  
             System.out.println("new human_total "+ x.total);
             if (x.total<21){
               x.bet=bet(x);}
             continue;
           }
           else if(s.equals("N")){
             System.out.println(x.name+" total ="+x.total);
             break;
           }
           else{
             continue;
           }
         }
         else{
           break;} 
       }
  return x.total;}
          
    
    
  
  public static int bet(Player x){
    while(3>1){
      System.out.println(x.name+" has "+x.money);
      if(x.money==0){
        System.out.println("You Not Money");
        break;}
      Scanner Money = new Scanner(System.in);
      System.out.println("How much will you bet?");
      int M = Money.nextInt();
      if(M<=x.money && M>=0){
        x.bet=x.bet+M;
        x.money = x.money - M;
        break;
      }
      else{
        System.out.println("You bet your money");
      }}
    return x.bet;}
  public static int play_human(Player x){
    String[] myArray;
    myArray = new String[4];
    myArray[0]="◇";
    myArray[1]="♤";
    myArray[2]="♡";
    myArray[3]="♧";
    int human_card1 = (int)(Math.random()*13)+1;
    int human_card2 = (int)(Math.random()*13)+1;
    String human_card1_object= myArray[(int)(Math.random()*4)];
    String human_card2_object= myArray[(int)(Math.random()*4)];
    if(human_card1>10){
      x.card=x.card+human_card1;
      human_card1=10;
    }
    if (human_card2>10){
      x.card=x.card+human_card2;
      human_card2=10;
    }
    
    System.out.print(x.name);
    System.out.println(" player got");
    System.out.println(human_card1_object+human_card1+" and "+human_card2_object+human_card2);
    if(human_card1==1){
      Scanner T = new Scanner(System.in);
      System.out.println("You Choice 1 or 11");
      int V = T.nextInt();
      if(V==11){
        human_card1=11;
      }
      else{
        human_card1=1;
      }
    }
    if(human_card2==1){
      Scanner T = new Scanner(System.in);
      System.out.println("You Choice 1 or 11");
      int V = T.nextInt();
      if(V==11){
        human_card2=11;
      }
      else{
        human_card2=1;}
    }
    int human_total = human_card1 + human_card2;
    x.bet=bet(x);
    return human_total;
  }
  public static int play_computer(){
    String[] myArray;
    myArray = new String[4];
    myArray[0]="◇";
    myArray[1]="♤";
    myArray[2]="♡";
    myArray[3]="♧";
    int computer_card1 = (int)(Math.random()*14)+1;
    int computer_card2 = (int)(Math.random()*14)+1;
    String computer_card1_object= myArray[(int)(Math.random()*4)];
    String computer_card2_object= myArray[(int)(Math.random()*4)];
    if(computer_card1>11){
      computer_card1=10;}
    if(computer_card2>11){
      computer_card2=10;}
    int computer_total = computer_card1 + computer_card2;
    System.out.println("Computer player got");
    System.out.println(computer_card1_object+computer_card1+" and "+computer_card2_object+computer_card2);
    while(3>1){
      if (computer_total<11){
        int computer_card3 = (int)(Math.random()*14)+1;
        if(computer_card3>11){
          computer_card3=10;}
        String computer_card3_object= myArray[(int)(Math.random()*4)];
        System.out.println("Computer player got New Card "+computer_card3_object+computer_card3);
        computer_total = computer_total+computer_card3;
        System.out.println("New Computer total ="+computer_total);
      }
      else{
        break;}
    }return computer_total;
  }
  
  public static void calculate_winner(Player p1,Player p2,int computer_total){
    if(p1.total<=21 && computer_total<p1.total && p2.total<p1.total){
      p1.money=p1.money+p1.bet*2;
      System.out.println(p1.name+" Wins");
      System.out.println(p1.name+" has $"+p1.money);
      System.out.println("computer Loses $"+p1.bet);
      System.out.println(p2.name+" Loses $"+p2.bet);
      System.out.println("computer Get $"+p2.bet);
      System.out.println(p2.name+" has $"+(p2.money));
    }
    else if(p2.total<=21 && computer_total<p2.total && p2.total>p1.total){
      p2.money=p2.money+p2.bet*2;
      System.out.println(p2.name+" Wins");;
      System.out.println(p2.name+" has $"+p2.money);
      System.out.println("computer Loses $"+p2.bet);
      System.out.println(p1.name+" Loses $"+(p1.bet));
      System.out.println("computer Get $"+p1.bet);
      System.out.println(p1.name+" has $"+(p1.money));  
    }
    else if(p1.total==p2.total && p1.total>computer_total && p1.total<=21){
      if(p1.card>p2.card){ 
        p1.money=p1.money+p1.bet*2;
        System.out.println(p1.name+" Wins");
        System.out.println(p1.name+" has $"+p1.money);
        System.out.println("computer Loses $"+p1.bet);
        System.out.println(p2.name+" Loses $"+p2.bet);
        System.out.println("computer Get $"+p2.bet);
        System.out.println(p2.name+" has $"+(p2.money));
        }
      if(p2.card>p1.card){
        p2.money=p2.money+p2.bet*2;
        System.out.println(p2.name+" Wins");;
        System.out.println(p2.name+" has $"+p2.money);
        System.out.println("computer Loses $"+p2.bet);
        System.out.println(p1.name+" Loses $"+(p1.bet));
        System.out.println("computer Get $"+p1.bet);
        System.out.println(p1.name+" has $"+(p1.money)); 
      }
      else{
        System.out.println("Draw");
        p1.money=p1.money+p1.bet;
        p2.money=p2.money+p2.bet;
        System.out.println(p1.name+" has$"+(p1.money));
        System.out.println(p2.name+" has$"+(p2.money));
      }
    }
    else{
      System.out.println("Computer Wins");
      System.out.println(p1.name+" Loses $"+(p1.bet));
      System.out.println(p1.name+" Loses $"+(p2.bet));
      System.out.println("computer Get $"+(p1.bet+p2.bet));
      System.out.println(p1.name+" has$"+(p1.money));
      System.out.println(p2.name+" has$"+(p2.money));
    }
    p1.bet=0;
    p2.bet=0;
  }
}
