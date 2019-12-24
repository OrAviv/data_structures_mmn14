import java.awt.event.MouseAdapter;

public class Stack
{
    private int heapSize;

    public Stack (double array[], int d)
    {
        this.build_heapify_stack(array, d);
    }

    public void build_heapify_stack (double array[], int d)
    {
        this.heapSize = array.length - 1;
        for (int i = (this.heapSize/d); i > 0; i--)
            for (int j = 0; j < d; j++)
                heapify(array, d, i);

    }

    public void heapify (double array[], int d, int index)
    {
        int first_child = d*index - (d-2);
        if (first_child > this.heapSize)
            return;
        int largest = index;

        for (int child = first_child; (child < (d + first_child)) && (child <= this.heapSize); child++)
        {
            if (array[child] > array[index])
            {
                largest = child;
                break;
            }
        }
        if (largest != index)
        {
            double temp = array[index];
            array[index] = array[largest];
            array[largest] = temp;
            heapify(array, d, largest);
        }
    }

    public double extract_max (double array[], int d)
    {
        if (this.heapSize < 1)
        {
            System.out.println("heap underflow");
            return Integer.MIN_VALUE;
        }

        double max = array[1];
        array[1] = array[this.heapSize];
        this.heapSize -= 1;
        heapify(array, d,1);
        return max;
    }

    public void insert (double array[], int d, double item)
    {
        this.heapSize += 1;
        array[this.heapSize] = item;
        int parent;
        double temp;
        for (int index = this.heapSize; index > 0; index /= d)
        {
            parent = this.get_parent(index, d);
            if (array[index] > array[parent])
            {
                temp = array[parent];
                array[parent] = array[index];
                array[index] = temp;
            }
        }
    }

    public int get_parent (int index, int d)
    {
        if (d == 0)
        {
            System.out.println("ERROR! trying to davide by 0, exiting....... ");
            System.exit(-1);
        }
        double parent = index/d;
        if ((parent - 1) % d == 0)
            return (int)(Math.floor(parent));
        else
            return (int)(Math.ceil(parent));
    }

    public void print_array(double array[], int d)
    {
        int multi=1;
        for (int i= 0; i < array.length -1; i++)
        {
            if ((i+1)%multi ==0)
            {
                System.out.println();
                multi = d*multi;
            }
            System.out.print(array[i]+"  ");
        }
    }

}