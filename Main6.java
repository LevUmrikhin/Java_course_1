import java.util.Scanner;
import java.math.BigDecimal;

public class Main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id, name, scholarship: ");
        String fields = scanner.nextLine();
        fields = fields.replaceAll("\\s+", "");
        String[] fields1 = fields.split(",");
        scanner.close();

        // Create a Student object using the parsed fields
        int id = Integer.parseInt(fields1[0]);
        String name = fields1[1];
        BigDecimal scholarship = new BigDecimal(fields1[2]);

        Student student = new Student(id, name, scholarship);
        System.out.println(student);
    }

    static class Student {
        private int id;
        private String name;
        private BigDecimal scholarship;

        public Student(Integer id, String name, BigDecimal scholarship) {
            this.id = id;
            this.name = name;
            this.scholarship = scholarship;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public BigDecimal getScholarship() {
            return scholarship;
        }

        public void setScholarship(BigDecimal scholarship) {
            this.scholarship = scholarship;
        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + name.hashCode();
            result = 31 * result + scholarship.hashCode();
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            if (!(obj instanceof Student)) {
                return false;
            }
            Student other = (Student) obj;
            if (id != other.id) {
                return false;
            }
            if (!name.equals(other.name)) {
                return false;
            }
            return scholarship.equals(other.scholarship);
        }

        @Override
        public String toString() {
            return "Student{id=" + id +
                    ", name='" + name + '\'' +
                    ", scholarship=" + scholarship + '}';
        }
    }
}