package basics;

public class conditions {
    public static void main(String[] args) {
        int salary = 2500;
//        if(salary > 10000){
//           salary =  salary+ 2000;
//        }else{
//            salary = salary+1000;
//        }

        //mutltiple if-else conditions

        if(salary>10000){
            salary += 2000;
        }else if(salary>2000){
            salary += 3000;
        }else{
            salary += 1000;
        }

        System.out.println(salary);
    }
}
