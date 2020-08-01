import java.util.*;

public class MostRepeatingElementInArray {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Enter the no. of elements : ");
        int numOfElements = s.nextInt();

        int arr[] = new int[numOfElements];

        System.out.println("Enter the elements : ");

        for (int i = 0; i<numOfElements; i++)
        {
            arr[i] = s.nextInt();
        }

        Map<Integer,Integer> maxMap = new HashMap<>();

        for (int a : arr)
        {
            if (maxMap.containsKey(a))
            {
                int count = maxMap.get(a);
                count++;
                maxMap.put(a,count);
            }
            else
            {
                maxMap.put(a,1);
            }
        }

//        for (Map.Entry<Integer,Integer> a : maxMap.entrySet())
//        {
//            System.out.println("Key : " + a.getKey() + " Value : " + a.getValue());
//        }

        int max = 0;

        for (Map.Entry<Integer,Integer> b : maxMap.entrySet())
        {
            if (b.getValue() > max)
            {
                max = b.getKey();
            }
        }

        List<Integer> newList = new ArrayList<>();

        for (Map.Entry<Integer,Integer> b : maxMap.entrySet())
        {
            if (b.getValue() > 1)
            {
                newList.add(b.getKey());
            }
        }

//        Collections.reverse(newList);
//        newList.remove(0);

        for (int a : newList)
        {
            System.out.println("Elements repeating more than once are : " + a);
        }

        System.out.println("Most repeated element : " + max);

        System.out.println("No. of elements in array : " + arr.length);

        System.out.println("Arrays.toString : " + Arrays.toString(arr));

        int[] intArr = new int[5];
        intArr[0] = 1;
        intArr[1] = 2;
        intArr[2] = 3;
        intArr[3] = 4;
        intArr[4] = 3;

        int num = 3;

        for (int i = 0; i<intArr.length; i++)
        {
            if (intArr[i] == num)
            {
                intArr[i] = 10;
                break;
            }
        }

        System.out.println("Printing array after replacing : " + Arrays.toString(intArr));


        int len = intArr.length;
        int[] newArr = new int[len];

        for (int i = 0; i<intArr.length; i++)
        {
            newArr[len-1] = intArr[i];
            len = len - 1;
        }

        System.out.println("Array after reverse : " + Arrays.toString(newArr));

        System.out.println("Array before sorting : " + Arrays.toString(intArr));

        Arrays.sort(intArr);

        System.out.println("Array after sorting : " + Arrays.toString(intArr));

        System.out.println("Number 4 found at : " + Arrays.binarySearch(intArr,4));
    }
}
