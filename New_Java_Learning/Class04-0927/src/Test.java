import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner n=new Scanner(System.in);
        int b=n.nextInt();
        int i;
        int d,e,f;
        d=e=f=0;
        for(i=0;i<b;i++){
            int c=n.nextInt();
            if(c>0){
                d++;
            }else if(c==0){
                e++;
            }else{
                f++;
            }
        }
        System.out.printf("正数%d个，零%d个，负数%d个",d,e,f);
    }

}
