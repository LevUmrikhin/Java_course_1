import java.util.Scanner;
import java.util.Arrays;
public class Main4 {
    public static void main(String[] args) {
        System.out.println("Enter arrays: ");
        Scanner scanner = new Scanner(System.in);
        String string= scanner.nextLine();
        String[] array = string.split(" ");
        int[] array1= parseArray(array[0]);
        int[] array2= parseArray(array[1]); //tested



        scanner.close();
        String array3AsString = Arrays.toString(array1).concat(Arrays.toString(array2));

       int[] array3 = parseArray(array3AsString);

        Arrays.sort(array3);
        array3AsString = Arrays.toString(array3);
        System.out.println(array3AsString);

    }
  public static int[] parseArray(String string) {

      string = string.replaceAll("[\\[\\](){}]", ",").replaceAll("\\s+", "").replaceAll(",{2,}", ",");
      string = string.substring(1);
      string= string.substring(0,string.length()-1);
      String[] string1 = string.split(",");
      String string2= string.join("", string1);



      int[] array = new int[string2.length()];
        for (int i = 0; i < string2.length(); i++) {
            array[i] = string2.charAt(i)-'0';
        }
        return array;
  }
}