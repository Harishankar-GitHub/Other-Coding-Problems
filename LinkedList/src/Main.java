import java.util.*;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> cities = new LinkedList<>();
        addInOrder(cities,"Delhi");
        addInOrder(cities,"Chennai");
        addInOrder(cities,"Bangalore");
        addInOrder(cities,"Mumbai");
        addInOrder(cities,"Goa");

        Iterator<String> iterator = cities.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        visit(cities);
    }

    public static boolean addInOrder(LinkedList<String> cities, String newElement)
    {
        ListIterator<String> listIterator = cities.listIterator();

        while(listIterator.hasNext())
        {
            int comparison = listIterator.next().compareTo(newElement);
            if(comparison == 0)
            {
                System.out.println("Already exists !");
                return false;
            }
            else if(comparison > 0)
            {
                listIterator.previous();
                listIterator.add(newElement);
                return true;
            }
//            else if(comparison < 0)
//            {
//
//            }
        }
        listIterator.add(newElement);
        return true;
    }

    public static void visit(LinkedList<String> cities)
    {
        Scanner s = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();

        if(cities.isEmpty())
        {
            System.out.println("LinkedList is empty !");
        }
        else
        {
            System.out.println("First city : " + listIterator.next());
            printMenu();
        }

        while(!quit)
        {
            int action = s.nextInt();
            s.nextLine();
            switch(action)
            {
                case 0:
                    System.out.println("Successfully Exited !");
                    quit = true;
                    break;

                case 1:
                    if(!goingForward) // If this if block is not there, it won't work properly.
                        // Comment this if block and run to understand why it is important.
                    {
                        if(listIterator.hasNext())
                        {
                            listIterator.next();
                        }
                        goingForward = true;
                    }

                    if(listIterator.hasNext())
                    {
                        System.out.println("Now at " + listIterator.next());
                    }
                    else
                    {
                        System.out.println("Reached the end !");
                    }
                    break;

                case 2:
                    if(goingForward)  // If this if block is not there, it won't work properly.
                    // Comment this if block and run to understand y it is important.
                    {
                        if(listIterator.hasPrevious())
                        {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious())
                    {
                        System.out.println("Now at " + listIterator.previous());
                    }
                    else
                    {
                        System.out.println("At the beginning");
                    }
                    break;

                case 3:
                    printMenu();
                    break;
            }
        }
    }

    public static void printMenu()
    {
        System.out.println("Available actions : ");
        System.out.println
                (
                        "0 - Quit\n"+
                        "1 - Next\n"+
                        "2 - Previous\n"+
                        "3 - Print Menu\n"
                );
    }
}
