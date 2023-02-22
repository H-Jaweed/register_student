import java.util.Scanner;

public class Service {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    private static Scanner scanner = new Scanner(System.in);
    private static Student[] students = new Student[]{};
    private static int lastIndexStudent;


    private String getScannerString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    private int getScannerInt(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }

    private void Menu() {
        System.out.println("""
                1)Add student
                2)Show all student
                3)Search student by index
                4)Exit""");
    }

    public void implemenetMenu() {
        while (true) {
            Menu();
            int choice = getScannerInt(ANSI_BLUE + "Enter choice: " + ANSI_RESET);
            System.out.println();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    showAllStudent(students);
                    break;
                case 3:
                    searchStudentByIndex(students);
                    break;
                case 4:
                    return;
                default:
                    System.out.println(ANSI_RED+"Wrong operation!!!"+ANSI_RESET);
            }
        }
    }
    private void addStudent() {
        int count = getScannerInt("Enter the number of students you want to include: ");
        if(students!=null) {
            students = expandStudentCount(count);
        }
        for (int i = lastIndexStudent; i <students.length; i++) {
            students[i] = new Student();
            scanner = new Scanner(System.in);
            System.out.print("Enter name: ");
            students[i].setName(scanner.nextLine());
            System.out.print("Enter surname: ");
            students[i].setSurName(scanner.nextLine());
            System.out.print("Enter age: ");
            students[i].setAge(scanner.nextInt());
            System.out.println(ANSI_YELLOW + "Student successfully added!" + ANSI_RESET);
            System.out.println();
            lastIndexStudent++;
        }
    }
    private Student[] expandStudentCount(int count) {
        Student[] expandedStudent = new Student[students.length + count];
        for (int i = 0; i < students.length; i++) {
            expandedStudent[i] = students[i];
        }
        return expandedStudent;
    }

    private void showAllStudent(Student[] students) {
       if (students.length!=0) {
            for (int i = 0; i < students.length; i++) {
                System.out.println(ANSI_CYAN + i + ") " + students[i].getName() + " " + students[i].getSurName() + " " + students[i].getAge()+" yas" + ANSI_RESET);
            }
        } else System.out.println(ANSI_RED + "Student list is empty!!!" + ANSI_RESET);
        System.out.println();
    }

    private void searchStudentByIndex(Student[] students) {
        if (students.length != 0) {
            int index = getScannerInt("Type the index of the student you want to search: ");
            System.out.println(ANSI_CYAN + students[index].getName() + " " + students[index].getSurName() + " " + students[index].getAge()+" yas" + ANSI_RESET);
        } else System.out.println(ANSI_RED + "Student list is empty!!!" + ANSI_RESET);
        System.out.println();
    }
}
