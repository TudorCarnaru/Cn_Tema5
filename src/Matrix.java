import java.util.ArrayList;

/**
 * Created by genius C on 5/21/2017.
 */
public class Matrix {
    private Integer dimensiuneMatrice;
    private Double [][]maxtrix;
    private Double [][] t_matrix;
    private Double A1=0.0, A0=0.0;

    Matrix(Integer dimensiuneMatrice)
    {
        this.dimensiuneMatrice = dimensiuneMatrice;
        maxtrix= new Double[dimensiuneMatrice][dimensiuneMatrice];
        t_matrix = new Double[dimensiuneMatrice][dimensiuneMatrice];
    }
    public Integer getDimensiuneMatrice() {
        return dimensiuneMatrice;
    }

    public Double[][] getMaxtrix()
    {
        return this.maxtrix;
    }
    public Double[][] getT_Maxtrix()
    {
        return this.t_matrix;
    }

    public void showMaxtrix() {
        for(int i=0;i<dimensiuneMatrice;i++)
        {
            for( int j =0; j<dimensiuneMatrice;j++)
            {
                System.out.print(this.maxtrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void showT_Matrix() {
        for(int i=0;i<dimensiuneMatrice;i++)
        {
            for( int j =0; j<dimensiuneMatrice;j++)
            {
                System.out.print(this.t_matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void setMaxtrix(ArrayList<Double> matrix) {
        int k=0;
        for(int i=0;i<dimensiuneMatrice;i++)
        {
            for( int j =0; j<dimensiuneMatrice;j++)
            {
                this.maxtrix[i][j]= matrix.get(k++);
            }
        }
    }

    public void setT_matrix()
    {
        for( int i=0; i<dimensiuneMatrice;i++)
        {
            for(int j=0;j<dimensiuneMatrice;j++)
            {
                t_matrix[j][i]=maxtrix[i][j];
            }
        }
    }

    public void setInitial()
    {
        Double max1=0.0,Sum;
        for(int i=0;i<dimensiuneMatrice;i++)
        {
            Sum=0.0;
            for(int j=0;j<dimensiuneMatrice;j++)
            {
                Sum+=maxtrix[i][j];
            }
            if(Sum>max1) max1=Sum;
        }
        A1=max1;
        max1=0.0;
        for(int i=0;i<dimensiuneMatrice;i++)
        {
            Sum=0.0;
            for(int j=0;j<dimensiuneMatrice;j++)
            {
                Sum+=maxtrix[j][i];
            }
            if(Sum>max1) max1=Sum;
        }
        A0=max1;
    }


    public Double getA0() {
        return A0;
    }

    public Double getA1() {
        return A1;
    }
}
