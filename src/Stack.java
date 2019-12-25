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
        for (int i = (this.heapSize/d); i >= 0; i--)
            for (int j = 0; j < d; j++)
                heapify(array, d, i);

    }

    public void heapify (double array[], int d, int index)
    {
        int first_child = d*index + 1;
        if (first_child > this.heapSize)
            return;
        int largest = first_child;
        for (int i = first_child; (i < first_child+d) && (i <= this.heapSize); i++)
            if (array[i] > array[largest])
                largest = i;
        if (array[largest] <= array[index])
            largest = index;
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

        double max = array[0];
        array[0] = array[this.heapSize];
        this.heapSize -= 1;
        heapify(array, d,0);
        return max;
    }

    public void insert (double array[], int d, double item)
    {
        this.heapSize += 1;
        array[this.heapSize] = item;
        int parent;
        int parent_zero_count = 0;
        double temp;
        for (int index = this.heapSize; index >= 0; index /= d)
        {
            parent = this.get_parent(index, d);
            if (parent == 0)
            {
                if (parent_zero_count > 0)
                    return;
                parent_zero_count++;
            }
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
        for (int i= 0; i < array.length -1; i++)
        {
            System.out.print(array[i]+"  ");
        }
    }

}