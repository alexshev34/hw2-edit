import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class hw2Task3 {
	
	  
    public static String winner(ArrayList<String> players) {
      
        String winner = null; //дальнейший победитель
        Integer maxPoints = 0;

        
        HashMap<String, Integer> list = new HashMap<>(); // храним сумму очков

        
        int index; // индекс для определения пробела

        for (int i = 0; i < players.size(); i++) {
            index = players.get(i).indexOf(" ");

            if (index > -1) {
                Integer points_sum;
                Integer points;
                String name;

                
                points = Integer.parseInt(players.get(i).substring(index+1));
                name =  players.get(i).substring(0, index);

                //заносим суммируя очки
                if (list.containsKey(name))
                    points_sum =  list.getOrDefault(name, 0) + points;
                else
                	points_sum = points;

                list.put(name, points_sum);

                // макс количество очков из всех игроков и его имя
                if (maxPoints < points_sum){
                    maxPoints = points_sum;
                    winner = name;
                }
            }
        }

        System.out.println("Победитель данной игры " + winner);
        return winner;
    }

    public static void main(String[] args) {
        ArrayList<String> players = new ArrayList<String>(Arrays.asList(new String[]{"Ivan 5", "Petr 3", "Alex 10", "Petr 8", "Ivan 6", "Alex 5", "Ivan 1", "Alex 5", "Petr 1"}));

        winner(players);
    }
}
