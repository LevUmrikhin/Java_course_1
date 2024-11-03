import java.util.Scanner;
import java.util.Arrays;
public class Main5 {
    public static void main(String[] args) {
        System.out.println("Enter classname: ");
        Scanner scanner = new Scanner(System.in);
        String className = scanner.nextLine();
        System.out.println("Enter fields: ");
        String fields = scanner.nextLine();
        fields = fields.replaceAll("\\s+", "");
        String[] fields1= fields.split(",");
        System.out.println("Enter dataTypes of each field: ");
        String types = scanner.nextLine();
        types = types.replaceAll("\\s+", "");
        String[] types1= types.split(",");
        String pojoClass = generatePojo(className, fields1, types1);
        System.out.println(pojoClass);
        scanner.close();
        System.out.println(fields1.length); //bug

    }

    private static String generatePojo(String className, String[] fields1, String[] types1) {
             String s = "public class " + className + "{,\n";

            for (int i = 0; i < fields1.length; i++) {

                        s+= "  private String " + fields1[i] + ";\n";
            }
            s= s + "{";
            for (int i = 0; i < fields1.length; i++) {
                s += "public " + types1[i] + " get" + fields1[i] + "()" + " {\n"
                        + "return " + fields1[i] + ";\n";
                       s += "} \n"
                        + "public void set" + fields1[i] + "(" + className + ") {\n"
                        + "this." + fields1[i] + " = " + fields1[i] + ";\n";


            }

            return s;
        }



}
