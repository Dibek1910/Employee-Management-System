import java.util.*;
import java.io.*;

/*************************** MENU OF EMS ****************************/

class MainMenu {
    public void menu() {
        System.out.println("*******************************************");
        System.out.println("\t  EMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("*******************************************");
        System.out.println("\n\nPress 1 : To Add Employee Details");
        System.out.println("Press 2 : To View Employee Details");
        System.out.println("Press 3 : To Remove an Employee");
        System.out.println("Press 4 : To Update Employee Details");
        System.out.println("Press 5 : To Exit the EMS Portal");
    }
}

/************************ To add details of Employee *********************/

class Employee_Add {
    public void createFile() {
        Scanner sc = new Scanner(System.in);

        EmployDetail emp = new EmployDetail();
        emp.getInfo();
        try {
            File f1 = new File("file" + emp.employ_id + ".txt");
            if (f1.createNewFile()) {
                FileWriter myWriter = new FileWriter(f1);
                myWriter.write("Employee ID: " + emp.employ_id + "\n" +
                        "Employee Name: " + emp.name + "\n" +
                        "Father's Name: " + emp.father_name + "\n" +
                        "Employee Contact: " + emp.employ_contact + "\n" +
                        "Email Information: " + emp.email + "\n" +
                        "Employee Position: " + emp.position + "\n" +
                        "Employee Salary: " + emp.employ_salary);
                myWriter.close();
                System.out.println("\nEmployee has been Added :)\n");
                System.out.print("\nPress Enter to Continue...");
                sc.nextLine();
            } else {
                System.out.println("\nEmployee already exists :(");
                System.out.print("\nPress Enter to Continue...");
                sc.nextLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

/************************* Taking Employee Details ************************/

class EmployDetail {
    String name;
    String father_name;
    String email;
    String position;
    String employ_id;
    String employ_salary;
    String employ_contact;

    public void getInfo() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee's Name: ");
        name = sc.nextLine();

        System.out.print("Enter Employee's Father's Name: ");
        father_name = sc.nextLine();

        System.out.print("Enter Employee's ID: ");
        employ_id = sc.nextLine();

        System.out.print("Enter Employee's Email ID: ");
        email = sc.nextLine();

        System.out.print("Enter Employee's Position: ");
        position = sc.nextLine();

        System.out.print("Enter Employee's Contact Info: ");
        employ_contact = sc.nextLine();

        System.out.print("Enter Employee's Salary: ");
        employ_salary = sc.nextLine();
    }
}

/************************ To Show details of Employee *********************/

class Employee_Show {
    public void viewFile(String id) throws Exception {
        File file = new File("file" + id + ".txt");
        if (file.exists()) {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } else {
            System.out.println("\nEmployee does not exist :(");
        }
    }
}

/***************************** To Remove Employee *************************/

class Employee_Remove {
    public void removeFile(String id) {
        File file = new File("file" + id + ".txt");
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("\nEmployee has been removed successfully.");
            }
        } else {
            System.out.println("\nEmployee does not exist :(");
        }
    }
}

/************************ To Update details of Employee ********************/

class Employee_Update {
    public void updateFile(String id) {
        File file = new File("file" + id + ".txt");
        if (file.exists()) {
            try {
                Scanner sc = new Scanner(file);
                String fileContext = "";
                while (sc.hasNextLine()) {
                    fileContext += sc.nextLine() + "\n";
                }
                FileWriter myWriter = new FileWriter(file);
                Scanner input = new Scanner(System.in);

                System.out.print("Please Enter the detail you want to update: ");
                String detail = input.nextLine();

                System.out.print("Please Enter the updated info: ");
                String updatedInfo = input.nextLine();

                fileContext = fileContext.replaceFirst(detail + ".*", detail + ": " + updatedInfo);
                myWriter.write(fileContext);
                myWriter.close();
                System.out.println("\nEmployee details have been updated successfully.");
            } catch (IOException e) {
                System.out.println(e);
            }
        } else {
            System.out.println("\nEmployee does not exist :(");
        }
    }
}

/************************ To Exit from the EMS Portal *********************/

class CodeExit {
    public void out() {
        System.out.println("\n*****************************************");
        System.out.println("Thank You For Using My Software :) ");
        System.out.println("*****************************************");
        System.exit(0);
    }
}

/***************************** Main Class *******************************/

class EmployManagementSystem {
    public static void main(String[] args) {
        /** To clear the output Screen **/
        System.out.print("\033[H\033[2J");

        Scanner sc = new Scanner(System.in);
        Employee_Show epv = new Employee_Show();

        int choice = 0;

        /*** Calling MainMenu Class function ***/
        MainMenu obj1 = new MainMenu();
        obj1.menu();

        /*** Initializing loop for Menu Choices ***/
        while (choice != 5) {
            System.out.print("\nPlease Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            /** Switch Case Statements **/
            switch (choice) {
                case 1: {
                    /** Creating class object and calling function using that object **/
                    Employee_Add ep = new Employee_Add();
                    ep.createFile();

                    obj1.menu();
                    break;
                }

                case 2: {
                    System.out.print("\nPlease Enter Employee's ID: ");
                    String id = sc.nextLine();
                    try {
                        epv.viewFile(id);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.print("\nPress Enter to Continue...");
                    sc.nextLine();
                    obj1.menu();
                    break;
                }

                case 3: {
                    System.out.print("\nPlease Enter Employee's ID: ");
                    String id = sc.nextLine();
                    Employee_Remove epr = new Employee_Remove();
                    epr.removeFile(id);

                    System.out.print("\nPress Enter to Continue...");
                    sc.nextLine();
                    obj1.menu();
                    break;
                }

                case 4: {
                    System.out.print("\nPlease Enter Employee's ID: ");
                    String id = sc.nextLine();
                    try {
                        epv.viewFile(id);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    Employee_Update epu = new Employee_Update();
                    epu.updateFile(id);

                    System.out.print("\nPress Enter to Continue...");
                    sc.nextLine();
                    System.out.print("\033[H\033[2J");
                    obj1.menu();
                    break;
                }

                case 5: {
                    CodeExit obj = new CodeExit();
                    obj.out();
                }

                default: {
                    System.out.println("\nInvalid choice! Please enter a valid option.");
                    obj1.menu();
                }
            }
        }
    }
}
