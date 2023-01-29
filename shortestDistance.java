import java.util.*;

public class shortestDistance {

  public shortestDistance() {

  }

  public double minDistanceforPath(Integer[] start, String path){

    Integer[] destination = new Integer[2];

    Integer x = start[0];
    Integer y = start[1];

    for (int i = 0; i < path.length(); i++) {
      switch(path.charAt(i)){
        case 'N' :
            x++;
            break;
        case 'E' :
            y++;
            break;
        case 'S' :
            x--;
            break;
        case 'W' :
            y--;
            break;
        default :
            break;
      }
    }

    if(x < 0 || y< 0){
      return 0;
    }

    return Math.sqrt((y - start[1]) * (y - start[1]) + (x - start[0]) * (x - start[0]));

  }

  public static void main (String[] args) {

    Integer[] StartPoint = new Integer[]{1, 2};
    String path = new String("NEWS");

    shortestDistance dist = new shortestDistance();
    double ans = dist.minDistanceforPath(StartPoint, path);

    System.out.println(String.format("%.1f", ans));
  }
} 