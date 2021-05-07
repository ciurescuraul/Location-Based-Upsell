import java.util.HashMap;
import java.util.Map;

public class FindArrayDuplicates
{

  public static void main(String[] args)
  {

    int[] numbers = { 2, 1, 3, 4, 3 };

    // for loop
    duplicateNumbersNestedForLoop(numbers);

    // hashmap
    duplicateNumbersHashMap(numbers);
  }

  private static void duplicateNumbersHashMap(int[] array)
  {
    Map<Integer, Integer> hashmap = new HashMap<>();

    for (int i = 0; i < array.length; i++)
    {

      for (int j = i + 1; j < array.length; j++)
      {
        if (array[i] == array[j])
        {
          hashmap.put(j, array[j]);
        }
      }
    }

    for (Map.Entry<Integer, Integer> entry : hashmap.entrySet())
    {
      System.out.println("HashMap duplicate value: " + entry.getValue());
    }

  }

  public static void duplicateNumbersNestedForLoop(int[] array)
  {

    for (int i = 0; i < array.length; i++)
    {

      for (int j = i + 1; j < array.length; j++)
      {

        if (array[i] == array[j])
        {

          System.out.println("NestedForLoop duplicate value: " + array[j]);

        }
      }
    }
  }

}
