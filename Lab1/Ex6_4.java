package Lab1.Lab1;
import java.util.Scanner;
public class Ex6_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = 0;
        long y;
        String mon = "";
        String year = "";
        do {
            System.out.println("Enter a month (January / Jan. / Jan / 1):");
            String month = scanner.nextLine();
            mon = month;
            switch (month) {
                case "1":
                case "Jan":
                case "Jan.":
                case "January":
                case "3":
                case "Mar":
                case "Mar.":
                case "March":
                case "5":
                case "May":
                case "7":
                case "July":
                case "Jul":
                case "8":
                case "Aug":
                case "Aug.":
                case "August":
                case "10":
                case "Oct":
                case "Oct.":
                case "October":
                case "12":
                case "Dec":
                case "Dec.":
                case "December":
                    m = 1;
                    break;

                case "2":
                case "Feb":
                case "Feb.":
                case "February":
                    m = 3;
                    break;

                case "4":
                case "Apr":
                case "Apr.":
                case "April":
                case "6":
                case "June":
                case "Jun":
                case "9":
                case "Sep":
                case "Sept.":
                case "September":
                case "11":
                case "Nov":
                case "Nov.":
                case "November":
                    m = 2;
                    break;

                default:
                    break;
            }
        }while (m == 0);

        do {
            System.out.println("Enter a year: ");
            year = scanner.nextLine();
            try {
                y = Long.parseLong(year);
            } catch (NumberFormatException e){
                year = "";
                continue;
            }
            y = Long.parseLong(year);
            if(y<0){
                year = "";

            }
        } while (year.isBlank());

        if(m == 1){
            System.out.println("The number of days in "+ mon +"/ "+year+" is 31 days");
        }

        else if(m == 2){
            System.out.println("The number of days in "+ mon +"/"+year+" is 30 days");
        }

        else{
            if(Long.parseLong(year) % 400==0){
                System.out.println("The number of days in "+ mon +"/"+year+" is 29 days");
            }
            else if (Long.parseLong(year) % 100==0) {
                System.out.println("The number of days in "+ mon +"/"+year+" is 28 days");
            }
            else {
                System.out.println("The number of days in "+ mon +"/"+year+" is 29 days");
            }
        }

    }
}
