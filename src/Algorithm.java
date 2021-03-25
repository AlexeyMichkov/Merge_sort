public class Algorithm
{
    public static void main(String[] args) {
        int[] massif = {5, 2, 4, 6, 1, 3, 2, 6};
        System.out.print("Изначальный массив: ");
        for (int i = 0; i < massif.length; i++)
            System.out.print(massif[i] + " ");
        System.out.println("");
        massif = Sort(massif);
        System.out.print("Массив после сортировки: ");
        for (int i = 0; i < massif.length; i++)
            System.out.print(massif[i] + " ");
    }

    public static int[] Sort(int X[]) {
        if (X.length == 1)
            return X;
        else {
            int half = (int) Math.floor(X.length / 2);
            int halfFirst[] = new int[half];
            int halfSecond[] = new int[X.length - half];
            for (int i = 0; i < X.length; i++) {
                if (i < half)
                    halfFirst[i] = X[i];
                else
                    halfSecond[i - half] = X[i];
            }
            halfFirst = Sort(halfFirst);
            halfSecond = Sort(halfSecond);
            X = SortNext(halfFirst, halfSecond);
            return X;
        }
    }
    public static int[] SortNext(int A[], int B[]) {
        int C[] = new int [A.length + B.length];
        int a = 0, b = 0;
        for (int i = 0; i < A.length + B.length; i++) {
            if (a == A.length) {
                C[i] = B[b];
                b++;
            }
            else if (b == B.length) {
                C[i] = A[a];
                a++;
            }
            else if (A[a] > B[b]) {
                C[i] = B[b];
                b++;
            }
            else {
                C[i] = A[a];
                a++;
            }
        }
        return C;
    }
}
