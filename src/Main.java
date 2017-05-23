import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by genius C on 5/21/2017.
 */
public class Main {
    public static void main(String[] args)
    {
        long numarInteratii = 0, kmax=0;
        int n;
        Double precizia = Math.pow(10,-14);
        Scanner newScanner = new Scanner(System.in);
        kmax=newScanner.nextLong();
        n=newScanner.nextInt();
        Matrix newMatrix = new Matrix(n);
        ArrayList<Double> matrice = new ArrayList<>();
        int test;
        try {
            test = readMatrix("C:\\Users\\tcarnaru\\Desktop\\Cn Tema5\\src\\a.txt", matrice);
        }
        catch (Exception e) {
            System.out.println("Probleme la citire");
            e.printStackTrace();
        }
        newMatrix.setMaxtrix(matrice);
        newMatrix.setT_matrix();
        newMatrix.showMaxtrix();
        System.out.println(" Blas bla bla ");
        newMatrix.showT_Matrix();

        //Primul algoritm
/*
        Double[][] V0= startMatrix(newMatrix,n);
        Double[][] V1 = startMatrix(newMatrix,n);
        Double norma = 0.0;
        numarInteratii = 0;
        do {
            Double[][] I2 = create2I(n);
            Double[][] I3 = create3I(n);

            V0=copyMatrix(V0,V1,n);

            Double[][] aux = new Double[n][n];
            aux = copyMatrix(aux,V0,n);
            aux = multiplyMatrix(newMatrix.getMaxtrix(),V0,n);
            I2= subtract_Matrixes(I2,aux,n);
            V1= multiplyMatrix(V0,I2,n);
            aux = subtract_Matrixes(V1,V0,n); // de aici se calculeaza norma
            norma=calc_Norma(aux,n);
            numarInteratii++;
        }while(norma>=precizia && numarInteratii<=kmax && norma<=Math.pow(10,10));
        Double[][] aux = new Double[n][n];
        Double[][] I= createI(n);
        aux=multiplyMatrix(newMatrix.getMaxtrix(),V1,n);
        I=subtract_Matrixes(aux,I,n);
        norma= calc_Norma(I,n);
        System.out.println("Matricea Finala");
        afisare(V1,n);
        System.out.println("Numarul de iteratii " + numarInteratii);
        System.out.println("Norma este ");
        System.out.println(norma);
*/



        //Al 2-lea algoritm
        /*
        Double[][] V0= startMatrix(newMatrix,n);
        Double[][] V1 = startMatrix(newMatrix,n);
        Double norma = 0.0;
        numarInteratii = 0;
        do {
            Double[][] I2 = create2I(n);
            Double[][] I3 = create3I(n);
            V0=copyMatrix(V0,V1,n);
            Double[][] aux = new Double[n][n];
            aux = copyMatrix(aux,V0,n);
            aux = multiplyMatrix(newMatrix.getMaxtrix(),V0,n);
            I3= subtract_Matrixes(I3,aux,n);
            aux= multiplyMatrix(aux,I3,n);
            I3 = create3I(n);
            I3 = subtract_Matrixes(I3,aux,n);
            V1= multiplyMatrix(V0,I3,n);
            aux = subtract_Matrixes(V1,V0,n); // de aici se calculeaza norma
            norma=calc_Norma(aux,n);
            numarInteratii++;
        }while(norma>=precizia && numarInteratii<=kmax && norma<=Math.pow(10,10));
        Double[][] aux = new Double[n][n];
        Double[][] I= createI(n);
        aux=multiplyMatrix(newMatrix.getMaxtrix(),V1,n);
        I=subtract_Matrixes(aux,I,n);
        norma= calc_Norma(I,n);
        System.out.println("Matricea Finala");
        afisare(V1,n);
        System.out.println("Numarul de iteratii " + numarInteratii);
        System.out.println("Norma este ");
        System.out.println(norma);
*/


        //Al 3-lea algoritm

        Double[][] V0= startMatrix(newMatrix,n);
        Double[][] V1 = startMatrix(newMatrix,n);
        Double norma = 0.0;
        numarInteratii = 0;
        do {
            Double[][] I2 = create2I(n);
            Double[][] I3 = create3I(n);
            Double[][] I= createI(n);
            Double[][] I4 = createI(n);
            V0=copyMatrix(V0,V1,n);
            Double[][] aux = new Double[n][n];
            aux = copyMatrix(aux,V0,n);
            aux = multiplyMatrix(V0,newMatrix.getMaxtrix(),n);
            I3= subtract_Matrixes(I3,aux,n);
            I3 = multiplyMatrix(I3,I3,n);
            I = subtract_Matrixes(I,aux,n);
            I = multiplyMatrix(I,I3,n);
            Double scale = 0.25;
            I = scaleMatrix(I,scale,n);
            I4 = add_Matrixes(I,I4,n);
            V1= multiplyMatrix(I4,V0,n);
            aux = subtract_Matrixes(V1,V0,n); // de aici se calculeaza norma
            norma=calc_Norma(aux,n);
            numarInteratii++;
        }while(norma>=precizia && numarInteratii<=kmax && norma<=Math.pow(10,10));
        Double[][] aux ;
        Double[][] I= createI(n);
        aux=multiplyMatrix(newMatrix.getMaxtrix(),V1,n);
        I=subtract_Matrixes(aux,I,n);
        norma= calc_Norma(I,n);
        System.out.println("Matricea Finala");
        afisare(V1,n);
        System.out.println("Numarul de iteratii " + numarInteratii);
        System.out.println("Norma este ");
        System.out.println(norma);

    }

    private static void afisare( Double[][] matrice,int size)
    {
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                System.out.print(matrice[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static Integer readMatrix(final String filePath, ArrayList<Double> matrice) throws IOException
    {
        Scanner in = new Scanner( new FileReader(filePath));
        while(in.hasNext()){
            matrice.add(Double.valueOf(in.next()));
        }
        return 1;
    }
    private static Double[][] createI(int size)
    {
        Double[][] I= new Double[size][size];
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(i==j) I[i][j]= 1.0;
                else I[i][j]=0.0;
            }
        }
        return I;
    }
    private static Double[][] create2I(int size)
    {
        Double[][] I2= new Double[size][size];
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(i==j) I2[i][j]= 2.0;
                else I2[i][j]=0.0;
            }
        }
        return I2;
    }
    private static Double[][] create3I(int size)
    {
        Double[][] I2= new Double[size][size];
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(i==j) I2[i][j]= 3.0;
                else I2[i][j]=0.0;
            }
        }
        return I2;
    }

    private static Double[][] scaleMatrix(Double[][] matrix, Double scale, int size)
    {
        Double[][] resultMatrix = new Double[size][size];
        Integer Sum;
        for ( int i=0; i<size; i++)
        {
            for( int j=0;j<size;j++)
            {
                resultMatrix[i][j] = matrix[i][j]*scale;
            }
        }
        return resultMatrix;
    }

    private static Double[][] startMatrix(Matrix matrix, int size)
    {
        Double[][] t_max;
        matrix.setInitial();
        t_max=matrix.getT_Maxtrix();
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                t_max[i][j]=t_max[i][j]/(matrix.getA1()*matrix.getA0());
            }
        }
        return t_max;
    }

    private static Double[][] multiplyMatrix( Double[][] matrix1, Double[][] matrix2, Integer size)
    {
        Double[][] resultMatrix = new Double[size][size];
        Double Sum;
        for ( int i=0; i<size; i++)
        {
            for( int j=0;j<size;j++)
            {
                Sum=0.0;
                for(int k=0;k<size;k++)
                {
                    Sum=Sum+matrix1[i][k]*matrix2[k][j];
                }
                resultMatrix[i][j]=Sum;
            }
        }
        return resultMatrix;
    }

    private static Double[][] subtract_Matrixes( Double[][] matrix1, Double[][] matrix2, Integer size)
    {
        Double[][] resultMatrix = new Double[size][size];
        Integer Sum;
        for ( int i=0; i<size; i++)
        {
            for( int j=0;j<size;j++)
            {
                resultMatrix[i][j] = matrix1[i][j]-matrix2[i][j];
            }
        }
        return resultMatrix;
    }
    private static Double[][] add_Matrixes( Double[][] matrix1, Double[][] matrix2, Integer size)
    {
        Double[][] resultMatrix = new Double[size][size];
        Integer Sum;
        for ( int i=0; i<size; i++)
        {
            for( int j=0;j<size;j++)
            {
                resultMatrix[i][j] = matrix1[i][j]+matrix2[i][j];
            }
        }
        return resultMatrix;
    }

    public static Double calc_Norma( Double[][] matrix, int size)
    {
        Double max1=0.0,Sum;
        for(int i=0;i<size;i++)
        {
            Sum=0.0;
            for(int j=0;j<size;j++)
            {
                Sum+=matrix[i][j];
            }
            if(Sum>max1) max1=Sum;
        }
        return max1;
    }

    private static Double[][] copyMatrix( Double[][] matrix1, Double[][] matrix2, Integer size)
    {
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++)
            {
                matrix1[i][j]=matrix2[i][j];
            }
        }
        return matrix1;
    }

}
