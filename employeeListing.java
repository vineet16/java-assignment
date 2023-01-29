import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import java.util.stream.Collectors; 

public class employeeListing {

  Map<String, List<String>> empList;
  TreeMap<Integer, String> headerColnum;

  public employeeListing() {
    this.empList = new HashMap<>();
    this.headerColnum = new TreeMap<Integer, String>();
  }


  public void generateEmployeesWoLastName() {
    
    List<String> names = this.empList.get("Name");
    
    List<Integer> keys = new ArrayList<>();
    for(int i = 0; i<names.size(); i++){
      String fullName = names.get(i).trim();
      
      if (fullName.indexOf(" ") == -1) {
       keys.add(i);
      }
    }

    List<List<String>> ans = new ArrayList<>();

    for(int i : keys) {

      List<String> keyList = new ArrayList<>();

      for(Map.Entry<Integer, String> m : this.headerColnum.entrySet()){
        String header = m.getValue();

        keyList.add(this.empList.get(header).get(i));
      }

      ans.add(keyList);
    }

    this.writeToCsv("single_name_employees.csv", ans);

  }


  public void generateRnDManagers() {
    // find managers and check if they are in RnD division
    List<String> roles = this.empList.get("Role");
    
    List<Integer> keys = new ArrayList<>();
    for(int i = 0; i<roles.size(); i++){
      if(roles.get(i).equals("Manager") && this.empList.get("Division").get(i).equals("R&D")) {
       keys.add(i);
      }
    }

    List<List<String>> ans = new ArrayList<>();

    for(int i : keys) {

      List<String> keyList = new ArrayList<>();

      for(Map.Entry<Integer, String> m : this.headerColnum.entrySet()){
        String header = m.getValue();

        keyList.add(this.empList.get(header).get(i));
      }

      ans.add(keyList);
    }

    this.writeToCsv("manager.csv", ans);

  }

  public void readCsv(String file) {

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {

        String line = br.readLine();
        
        if(line != null && !line.isEmpty()) {

          List<String> headers = Arrays.asList(line.split(","));
          for(int i =0; i<headers.size(); i++){
            List<String> values = new ArrayList<>();
            this.empList.put(headers.get(i), values);
            this.headerColnum.put(i, headers.get(i));
          }

          while((line = br.readLine()) != null){
              List<String> values = Arrays.asList(line.split(","));

              for(int i =0; i<values.size(); i++){
                String header = this.headerColnum.get(i);

                this.empList.get(header).add(values.get(i));
              }
          }
          
        }

    } catch (Exception e){
        System.out.println(e);
    }

  }

  public void writeToCsv(String file, List<List<String>> data) {
    try (FileWriter writer = new FileWriter(file)) {

      List<String> headers = new ArrayList<String>(this.headerColnum.values());
      writer.write(headers.stream().collect(Collectors.joining(",")));
      writer.write(System.getProperty( "line.separator" ));


      for( List<String> l : data) {

        String collect = l.stream().collect(Collectors.joining(","));

        writer.write(collect);
        writer.write(System.getProperty( "line.separator" ));
      }
      writer.close();
    } catch (Exception e){
        System.out.println(e);
    }
  }

  public static void main (String[] args) {

    String file = "employees.csv";

    employeeListing emp = new employeeListing();
    emp.readCsv(file);
    emp.generateRnDManagers();
    emp.generateEmployeesWoLastName();

  }
} 