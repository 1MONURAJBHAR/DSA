package basics;

import java.util.Scanner;

public class SwitchCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter fruit name: ");
//        String fruit = sc.next();

        System.out.print("Enter emp number (1-5): ");
        int emp = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter dept (IT/HR/DEV): ");
        String dept = sc.nextLine();

//        switch (fruit){
//            case "Mango":{
//                System.out.println("King of fruits");
//                break;
//            }
//            case "Apple":{
//                System.out.println("A sweet red fruit");
//                break;
//            }
//            case "Orange":{
//                System.out.println("Round fruit");
//                break;
//            }
//            case "Grapes":{
//                System.out.println("Green bubles of fruits");
//                break;
//            }
//            default:{
//                System.out.println("Please Enter a valid fruit:");
//            }
//        }

        //Enhanced switch
//        switch (fruit) {
//            case "Mango" ->  System.out.println("King of fruits");
//
//            case "Apple" -> System.out.println("A sweet red fruit");
//
//            case "Orange" -> System.out.println("Round fruit");
//
//            case "Grapes" -> System.out.println("Green bubles of fruits");
//
//            default -> System.out.println("Please Enter a valid fruit:");
//
//        }


//        switch (emp) {
//            case 1:
//                System.out.println("Monu Rajbhar");
//                break;
//
//            case 2:
//                System.out.println("Ujwal Katre");
//                break;
//
//            case 3:
//                System.out.println("Aryan Waghmare");
//                break;
//
//            case 4:
//                System.out.println("Pratik Patil");
//                break;
//
//            case 5:
//                System.out.println("Emp no. 5");
//
//                switch (dept) {
//                    case "IT":
//                        System.out.println("Department: IT");
//                        break;
//
//                    case "HR":
//                        System.out.println("Department: HR");
//                        break;
//
//                    case "DEV":
//                        System.out.println("Department: DEV");
//                        break;
//
//                    default:
//                        System.out.println("Department not found!");
//                }
//                break;
//
//            default:
//                System.out.println("Invalid employee number!");
//        }

        //Enhanced switch-case
        switch (emp) {
            case 1 -> System.out.println("Monu Rajbhar");
            case 2 -> System.out.println("Ujwal Katre");
            case 3 -> System.out.println("Aryan Waghmare");
            case 4 -> System.out.println("Pratik Patil");
            case 5 -> {
                System.out.println("Emp no. 5");

                switch (dept) {
                    case "IT" -> System.out.println("Department: IT");
                    case "HR" -> System.out.println("Department: HR");
                    case "DEV" -> System.out.println("Department: DEV");
                    default -> System.out.println("Department not found!");
                }
            }
            default -> System.out.println("Invalid employee number!");
        }
        sc.close();
    }
}
