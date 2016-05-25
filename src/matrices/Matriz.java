// **************************************************** 
//*********** ***** matriz.java ********************* 
// Clase matriz 
// Se definen las distintas operaciones a realizar con matrices 
// Funcion traspuesta 
// Funcion producto 
// Funcion opuesta 
// Funcion suma 
// Funcion iguales 
// Funcion minimo 
// Funcion Reduccion de Gauss 
// Funcion Simplex 
// Autor: Francisco Gutierrez Martin 
// Fecha: 24/9/99 
// Copiarlo en el directorio matrices 
// **************************************************************** 
package matrices;

public class Matriz {

    // Devuelve en T la matriz traspuesta de A 
    // f,c representan el numero de filas y de columnas de A 
    public static void traspuesta(int [][]A,int f,int c,int [][]T) { 
        int i,j; 
        for (i=0;i<f;i++) 
            for (j=0;j<c;j++) 
                T[j][i]=A[i][j]; 
    }

    // Devuelve en P la matriz producto de A y B 
    // Af : numero de filas de A 
    // Bc : numero de columnas de B 
    // cf: numero de columnas y filas de A y B 
    public static void producto(int [][]A,int [][]B, int Af, int Bc, int cf,int [][]P) { 
        int i,j,k; 
            for (i=0;i<Af;i++) 
                for (j=0;j<Bc;j++) 
                    for (k=0;k<cf;k++) 
                        P[i][j] += A[i][k] * B[k][j]; 
    }

    // Devuelve en OP la matriz opuesta de A 
    // f,c representan el numero de filas y de columnas de A 
    public static void opuesta(int [][]A ,int f, int c,int [][]OP) { 
        int i,j; 
        for (i=0;i<f;i++) 
            for (j=0;j<c;j++) 
                OP[i][j]=-A[i][j]; 
    }

    // Devuelve en S la matriz suma de A y B 
    // f,c representan el numero de filas y de columnas de A y B 
    public static void suma(int [][]A,int [][]B,int f, int c,int [][]S) { 
        int i,j; 
            for (i=0;i<f;i++) 
                for (j=0;j<c;j++) 
                    S[i][j]=A[i][j] + B[i][j]; 
    }

    public static boolean iguales(int [][]A,int [][]B, int f, int c) { 
        int i,j; 
        boolean igual=true; 
        for (i=0;i<f;i++) 
            for (j=0;j<c;j++) 
                if (A[i][j]!= B[i][j]) 
                    return (false); 
        return (igual); 
    }

    // Devuelve la posicion del minimo de la matriz A de una fila 
    public static int posminimo(double []A) { 
        int i, pos=0, size; 
        double valminimo;

        valminimo= A[0]; 
        size= A.length; 
        for (i=1;i<size;i++) 
            if (valminimo > A[i]) { 
                valminimo=A[i]; 
                pos=i; 
            } 
        return (pos); 
    }

    public static void R_Gauss(double [][]M,int f,int c,int x, int y) { 
        // x, y son los indices del pivote en la matriz M 
        // f, c son el tamaño de la matriz 
        int i,j,m; 
        double k; 
        double []B= new double [f];

        // para cada una de las filas de la matriz 
        for (i=0;i<f;i++) 
            if (i==x) // si es la fila del pivote no la cambia 
                continue; 
            else { 
                for (m=0;m<f;m++) 
                    B[m]= M[m][y]; 
                    k= - M[i][y]; 
                    // multiplicar la fila del pivote y sumarle la fila 
                    for (j=0;j<c;j++) 
                        M[i][j] += -M[x][j] * B[i]; 
            } // del else 
    }

    public static void Gauss(double [][]M,int f,int c) { 
        // f, c son el tamaño de la matriz 
        int i,j,k; 
        double []B= new double [c];

        // para cada una de las filas de la matriz 
        for (i=0;i<(f-1);i++) 
            for (k=i+1;k<f;k++){ 
                for (j=0;j<c;j++) 
                    B[j]= -M[k][i]* M[i][j] + M[i][i]*M[k][j]; 
                    for (j=0;j<c;j++) 
                        M[k][j] = B[j]; 
            } 
    }

}
