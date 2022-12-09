import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
단독테스트를 위해 Main으로 작성되어 추후 수정 필요

StringBuilder operand=A,B,C등 피연산자
String [][] ttable=진리표를 담은 배열
StringBuilder truth=진리표 출력을 위한 변수
int leng= operand의 길이, 피연산자의 갯수
String[] alpha=곱연산의 배열
ands=alpha와 operand, leng을 set하는 함수
settruth=ttable을 Output을 제외하고 생성하는 함수
printtruth=진리표를 출력하는 함수

1. deepToString의 출력이 행렬의 형태가 아니어서 truth 사용
2. settruth에서 각 열의 규칙을 입력해야함, 규칙은 파악되었으나 입력이 문제
3. 입력식에 맞춰 계산하는 함수가 필요함
*/

public class Main {

    public static String[] alpha;
    public static StringBuilder operand = new StringBuilder();
    public static StringBuilder truth = new StringBuilder();
    public static String[][] ttable;
    public static int leng;
    public static int temp=0;
    public static int check=0;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String in = br.readLine();
        br.close();

        ands(in);

        System.out.println(operand);

        settruth();
        printtruth();


    }

    public static void ands(String in) {
        String[] and = in.split("\\+");

        for (int n = 0; n < and.length; n++) {
            alpha = and[n].split("");
            for (int m = 0; m < alpha.length; m++) {
                if (!operand.toString().contains(alpha[m])) {
                    operand.append(alpha[m]);
                }
            }
        }
        leng = operand.length();

    }

    public static void settruth() {
        ttable = new String[(int) Math.pow(2, leng) + 1][leng + 1];
        ttable[0][leng] = "Output";
        for (int n = 0; n < leng; n++) {
            ttable[0][n] = String.valueOf(operand.toString().charAt(n));
        }

        for(int c=0; c<leng-1; c++)
        {
            for(int r=1; r<(int) Math.pow(2, leng); r+=(int) Math.pow(2, leng-c+1))
            {
                if(check==0)
                {
                    for(int m=temp; m<r; m++)
                    {
                        ttable[m][c]="0";
                    }
                    check=1;
                }
                else
                {
                    check=0;
                    continue;
                }

                temp =r;
            }
        }



        /*
        for (int i = 1; i <= (int) Math.pow(2, leng); i++) {
            if (i <= (int) Math.pow(2, leng)/2) {
                ttable[i][0] = "0";
            } else
                ttable[i][0] = "1";


            if (i % 2 == 1) {
                ttable[i][leng-1] = "0";
            } else {
                ttable[i][leng-1] = "1";
            }


        }*/

    }

    public static void printtruth() {

        System.out.println(Arrays.deepToString(ttable));


    }


}