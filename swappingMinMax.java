import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class swappingMinMax {

    public swappingMinMax() {
    }

    public Integer minmax(List<Integer> a, List<Integer> b) {

        Integer maxa = 0;
        Integer maxb = 0;

        for(Integer ele : a){
            if(ele > maxa) maxa = ele;
        }
        for(Integer ele : b){
            if(ele > maxb) maxb = ele;
        }

        if(maxa >= maxb) {
            maxb = 0;
            for(int i = 0; i< a.size(); i++){
                if(a.get(i) != maxa && a.get(i) < b.get(i)) {
                    int temp = a.get(i);
                    a.set(i, b.get(i));
                    b.set(i, temp);
                }
                if(b.get(i) > maxb) maxb = b.get(i);
            }
        } else {
            maxa = 0;
            for(int i = 0; i< a.size(); i++){
                if(b.get(i) != maxb && b.get(i) < a.get(i)){
                    int temp = b.get(i);
                    b.set(i, a.get(i));
                    a.set(i, temp);
                }
                if(a.get(i) > maxa) maxa = a.get(i);
            }
        }

        return maxb*maxa;

    }

    public static void main(String[] args) throws FileNotFoundException {
//        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 6, 5,1,2));
//        List<Integer> b = new ArrayList<>(Arrays.asList(3, 4, 3, 2, 2, 5));

//        List<Integer> a = new ArrayList<>(Arrays.asList(8,7,9,6,5,6,6,5,6,4,6,7,8,5,4,3,2,1,4,5,6,7,8,7,8));
//        List<Integer> b = new ArrayList<>(Arrays.asList(2,4,5,6,7,6,7,8,9,8,7,6,7,6,5,4,3,2,3,4,5,5,5,4,5));

        List<Integer> a = new ArrayList<>(Arrays.asList(1,2,3,2,3,4,5,3,5,6,7,8));
        List<Integer> b = new ArrayList<>(Arrays.asList(2,1,5,3,4,6,4,3,2,3,1,2));

        swappingMinMax minMax = new swappingMinMax();

        Integer ans = minMax.minmax(a, b);

//        System.out.println(ans);

    }
}
