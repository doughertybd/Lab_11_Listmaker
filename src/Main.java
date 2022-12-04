import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> list = new ArrayList<>();
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args)
    {
        final String menu = "A = Add | D = Delete | P = Print | Q = Quit";
        boolean finished = false;
        String opt = "";
        do
        {
            displayList();
            opt = SafeInput.getRegExString(in, menu, "[AaDdPpQp]");
            opt = opt.toUpperCase();
            switch (opt)
            {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "P":
                    displayList();
                    break;
                case "Q":
                    finished = quitProgram();
                    break;
            }
        }
        while (!finished);
    }
    private static boolean quitProgram()
    {
        boolean quit = SafeInput.getYNConfirm(in, "Are you sure you want to quit?");
        return quit;
    }
    private static void deleteItem()
    {
        int item = SafeInput.getRangedInt(in, "Which item would you like to remove?", 1, list.size());
        item -= 1;
        list.remove(item);
    }
    private static void addItem()
    {
        String newItem = SafeInput.getNonZeroLenString(in, "What would you like to add to your list?");
        list.add(newItem);
    }
    private static void displayList()
    {
        System.out.println("---------------------------------------------------");
        if (list.size() !=0)
        {
            for (int x =0; x < list.size(); x++)
            {
                System.out.printf("%-3d%-15s", x+1, list.get(x));
            }
        }
        else
        {
            System.out.println("------              List Maker              -------");
        }
        System.out.println("\n---------------------------------------------------");
    }
}