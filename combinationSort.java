import java.util.*;

public class combinationSort {

  public combinationSort() {

  }

  public Map<String, List<String>> sort2Ways(List<String> inputString){

    List<String> L1 = new ArrayList<>();
    List<String> L2 = new ArrayList<>();
    
    L1.addAll(inputString);
    this.sortListWithFirstCharacter(L1);

    L2.addAll(inputString);    
    this.sortListWithCharThenNumber(L2);

    Map<String, List<String>> soln = new HashMap<>();
    soln.put("L1", L1);
    soln.put("L2", L2);
    return soln;
  }

  public void sortListWithFirstCharacter(List<String> list){
    Collections.sort(list, new Comparator<String>(){
        @Override
        public int compare(String s1, String s2){

            if (s1.equalsIgnoreCase(s2))
                return 0;

            String prefix1 = s1.replaceAll("\\d", "");
            String prefix2 = s2.replaceAll("\\d", "");
            return prefix1.compareToIgnoreCase(prefix2);
        }
    });

    return;
  }

  public void sortListWithCharThenNumber(List<String> list){
    Collections.sort(list, new Comparator<String>(){
        @Override
        public int compare(String s1, String s2){

            if (s1.equalsIgnoreCase(s2))
                return 0;

            String prefix1 = s1.replaceAll("\\d", "");
            String prefix2 = s2.replaceAll("\\d", "");

            if (!prefix1.equalsIgnoreCase(prefix2))
                return prefix1.compareToIgnoreCase(prefix2);

            int number1 = Integer.parseInt(s1.replaceAll("\\D", ""));
            int number2 = Integer.parseInt(s2.replaceAll("\\D", ""));
            return number2 - number1;
        }
    });

    return;
  }

  public static void main (String[] args) {

    List<String> combStrings = Arrays.asList("d34", "g54", "d12", "b87", "g1", "c65", "g40", "g5", "d77");

    combinationSort sorter = new combinationSort();
    Map<String,List<String>> sol = sorter.sort2Ways(combStrings); 

    for(Map.Entry<String, List<String>> entry : sol.entrySet()) {
      System.out.println(entry.getKey() + " : " + entry.getValue());
    }
  }
} 