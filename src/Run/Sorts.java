package Run;

import java.util.Arrays;
public class Sorts
{
  public static int[] array;
  
  public Sorts(int[] array)
  {
    this.array = array;
  }
  
  public static void getArray()
  {
    for(int i = 0; i<array.length;i++)
    {
      System.out.print(array[i]+" ");
    }
    System.out.println();
  }
  public static void getAnyArray(int[] array)
  {
    for(int i = 0; i<array.length;i++)
    {
      System.out.print(array[i]+" ");
    }
    System.out.println();
  }
  public static void getAnyArray(boolean[] array)
  {
	  System.out.print("{");
    for(int i = 0; i<array.length;i++)
    {
      System.out.print(array[i]+" ");
    }
    System.out.println("}");
  }
  public void bubbleSort()
  {
    int temp;
    for(int i =0;i<array.length;i++)
    {
      for(int j =0;j<array.length-1;j++)
      {
        if(array[j]>array[j+1])
        {
            temp = array[j+1];
            array[j+1] = array[j];
            array[j] = temp;
        }
        
        
      }
    }
    System.out.println();
  }
    
  public void selectionSort()
  {
    int temp;
    
      for(int j =0;j<array.length;j++)
      {
        int min = j;
        for(int k =j+1;k<array.length;k++)
        {
         if(array[k]<array[min])
         {
             min = k;
         }
        }
       if(min!=j)
       {
         temp = array[min];
         array[min] = array[j];
         array[j] = temp;
        }
      }
    System.out.println();
  }
  
  public void insertionSort()
  {
    int temp;
    for(int i =1;i<array.length;i++)
    {
        for(int j =i;j>=1;j--)
        {
           if(array[j]< array[j-1])
           {  
            temp = array[j];
            array[j] = array[j-1];
            array[j-1] = temp;
           }
        }
    }
    System.out.println();
  }
  
  public void quickSort(int low, int high)
  {
    if(high == -1)
    {
      high = array.length-1;
    }
    if(high>low)
    {
       int pivotI = quickSortPivotDetermine(low,high);
       quickSort(low, pivotI-1);
       quickSort(pivotI+1, high);
    }
  }
  
  public int quickSortPivotDetermine(int low, int high)
  {
   int temp;
   int p = array[high];
   int count = low-1;
   for(int i = low;i<high;i++)
   {
     if(array[i]<=p)
     {
       count++;
       temp = array[i];
       array[i] = array[count];
       array[count] = temp;
     }
   }
   temp = array[high];
   array[high] = array[count+1];
   array[count+1] = temp;
   return count+1;
  }

  public void countingSort()
  {
   int[] countAr = new int[1000];
   for(int i : array)
   {
    countAr[i]++;    
   }
   int c = 0;
   for(int i = 0; i < countAr.length;i++)
   {
    if(countAr[i]!=0)
    {
      for(int j = 0; j<countAr[i];j++)
      {
        array[c] = i;
        c++;
      }
    }
   }
  }

  public void radixSort()
  {
    int temp;
    for(int i =10;i<=1000;i*=10)
    {
      for(int j =0;j<array.length;j++)
      {
        int min = j;
        for(int k =j+1;k<array.length;k++)
        {
          if(array[k]%i<array[min]%i)
          {
              min = k;
          }
        }
        if(min!=j)
        {
          temp = array[min];
          array[min] = array[j];
          array[j] = temp;
        }
      }
    }
  }

  public int[] mergeSort(int[] array)
  {
    if(array.length<=1)
    {
      return array;
    }
    int mid = array.length/2;
    int[] leftAr = Arrays.copyOfRange(array,0, mid);
    
    int[] rightAr = Arrays.copyOfRange(array,mid, array.length);

    int[] dividedLeft = mergeSort(leftAr);
    int[] dividedRight = mergeSort(rightAr);
    
    return merge(dividedLeft, dividedRight);
  }

  public int[] merge(int[] leftAr, int[] rightAr)
  {
    int temp;
    int[] mergedAr = new int[leftAr.length+rightAr.length];
    for(int i = 0; i<leftAr.length;i++)
    {
      mergedAr[i] = leftAr[i];
    }
    int c=0;
    for(int i = leftAr.length; i<rightAr.length+leftAr.length;i++)
    {
      mergedAr[i] = rightAr[c];
      c++;
    }
    /*System.out.println("LeftAr:");
    getAnyArray(leftAr);
    System.out.println("RightAr:");
    getAnyArray(rightAr);*/
    for(int j =0;j<mergedAr.length;j++)
    {
      int min = j;
      for(int k =j+1;k<mergedAr.length;k++)
      {
        if(mergedAr[k]<mergedAr[min])
        {
            min = k;
        }
      }
      if(min!=j)
      {
        temp = mergedAr[min];
        mergedAr[min] = mergedAr[j];
        mergedAr[j] = temp;
      }
    }
    /*System.out.println("MergedAr:");
    getAnyArray(mergedAr);*/
    return mergedAr;
  }

  public void linearSearch(int value)
  {
    //int value = (int)(Math.random()*1000);
    for(int i = 0; i<array.length;i++)
    {
        if(array[i] == value)
        {
          System.out.println("The value "+value+" is found at index "+i);
          return;
        }
    }
    System.out.println("The value "+value+" is not found");
  }

  public void binarySearch(int low, int high)
  {
    int value = 550;
    int mid = (high+low)/2;
    if(array[mid] == value)
    {
        System.out.println("The value "+value+" is found at index "+mid);
        return;
    }
    else if(high-low > 0)
    {
      if(value>array[mid])
      {
        binarySearch(mid+1, high);
      }
      else
      {
        binarySearch(low, mid-1);
      }
    }
    else
    {
    System.out.println("The value "+value+" is not found");
    }
  }
}
