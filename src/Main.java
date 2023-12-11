import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static ArrayList<String> myArrList = new ArrayList<>();
    public static void main(String[] args) {

        boolean done = false;
        String menuOpt;



        do {
            menuOpt = SafeInput.getRegExString(in, "Menu options: \nA (add): \nD (delete): \nP (print): \nQ (quit): ", "^[AaDdPpQq]$");
            menuOpt = menuOpt.toUpperCase();




            switch (menuOpt){

                case "A":

                    addItem();
                    break;

                case "D":

                    deleteItem();
                    break;

                case "P":

                    printList();
                    break;

                case "Q":

                    quitProg();
                    break;

            }
            System.out.println();


        } while (!done);


    }


    private static void addItem(){

        String add = SafeInput.getNonZeroLenStrings(in, "Add to array");
        myArrList.add(add);
    }

    private static void deleteItem(){
        int delete = SafeInput.getRangedInt(in, "Enter item number that you want deleted:", 1, myArrList.size());
        String item = myArrList.remove(delete-1);
        System.out.println("Succesfully deleted: " + item);

    }

    private static void quitProg(){
        if (SafeInput.getYNConfirm(in, "Are you sure you want to quit? [Y,N]: ")) {
            System.out.println("Exiting program...");
            System.exit(0);
        }
    }

    private static void printList(){
        System.out.println();
        if (myArrList.isEmpty()) {
            System.out.println("There are no items on the list");
        } else {
            System.out.println("---- Current List ----");
            for (int x = 0; x < myArrList.size(); x++) {
                System.out.println((x + 1) + ". " + myArrList.get(x));

            }
        }

    }

    private static void displayItems(){

        System.out.println("-----Current List-----");
        for (int x = 0; x < myArrList.size(); x++) {

            System.out.println((x + 1) + ". " + myArrList.get(x));
        }
    }
}
