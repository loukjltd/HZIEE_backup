import java.util.*;
class Biaodashi {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        String bds = in.next();//从操作台获取表达式
        Jisuan j=new Jisuan(bds);//创建Jisuan类并将表达式输入
        System.out.println(j.suan());//将结果输出
    }
}
//栈的元素类
class Node {
    char data;
    double num;
    Node next = null;
    Node pre = null;

    Node(char data) {
        this.data = data;
    }
    Node(double num) {
        this.num = num;
    }


    public char getdata() {
        return data;
    }
    public double getnum() {
        return num;
    }


    public Node getnext() {
        return next;
    }

    public void setnext(Node next) {
        this.next = next;
    }

    public Node getpre() {
        return pre;

    }

    public void setpre(Node pre) {
        this.pre = pre;
    }
}
//栈操作类
class Lianbiao {
    Node hear = null;
    Node tail = null;
    Node prenode = null;
    int a = 0; // 记录栈长度

    Lianbiao(Node hear) {
        this.hear = hear;
        tail = hear;
        prenode = hear;
    }

    public Node gethear() {
        return hear;

    }

    // 链表元素的添加
    public void add(Node node) {
        node.setpre(prenode);
        node.setnext(null);
        prenode.setnext(node);
        prenode = node;
        a++;
    }

    // 元素的输出
    public Node del() {
        Node sc = null;
        Node n = hear;
        int i = a;
        if (a == 0) {
            System.out.print("错误！----栈空！");
        } else {
            while (i > 0) {
                n = n.getnext();
                if (i == 1) {
                    prenode = n.getpre();
                    n.getpre().setnext(null);
                    sc = n;
                }
                i--;
            }
            a--;
        }
        return sc;
    }

}
//表达式计算类
class Jisuan {
    int jieshu = 0;//用于判断运算是否结束
    int n = 0;     //用于读取表达式，指向当前使用字符
    char[] c;
    //计算类的构造函数
    Jisuan(String bds) {
        bds=bds+"#";//为了便于计算在表达式字符串后面加#
        c = bds.toCharArray();//将String型字符串转换为char型数组
    }
    // 创建字符栈
    Node hear = new Node(' ');//为了方便栈操作，默认有一个栈底，使用栈时可以忽略
    Lianbiao zhifu = new Lianbiao(hear);//创建栈，用来存放运算符
    // 创建数值栈
    Node hear1 = new Node('0');
    Lianbiao shuzhi=new Lianbiao(hear1);//创建栈，用来存放数值
    //获取运算时运算优先类
    public char youxian(char a,char b){
        int i=0,j=0;
        //创建一个char型二维数组用于存放运算优先表
        char[][] pri = { // 运算符优先表
                // +    -    *    /    （         ）         #      横向为表达式当前运算符
                /* + */	{ '>', '>', '<', '<', '<', '>', '>' },
                /* - */	{ '>', '>', '<', '<', '<', '>', '>' },
                /* * */	{ '>', '>', '>', '>', '<', '>', '>' },
                /* / */	{ '>', '>', '>', '>', '<', '>', '>' },
                /*（    */	{ '<', '<', '<', '<', '<', '=', ' ' },
                /* ） */	{ '>', '>', '>', '>', ' ', '>', '>' },
                /* # */	{ '<', '<', '<', '<', '<', ' ', 's' }, };
//纵向为运算符栈栈顶的运算符
        if(a=='+'){i=0;}
        if(a=='-'){i=1;}
        if(a=='*'){i=2;}
        if(a=='/'){i=3;}
        if(a=='('){i=4;}
        if(a==')'){i=5;}
        if(a=='#'){i=6;}
        if(b=='+'){j=0;}
        if(b=='-'){j=1;}
        if(b=='*'){j=2;}
        if(b=='/'){j=3;}
        if(b=='('){j=4;}
        if(b==')'){j=5;}
        if(b=='#'){j=6;}
        return pri[i][j];
    }
    //运算类
    public double js(double a,char c,double b){
        double jieguo=0;
        if(c=='+'){jieguo=a+b;}
        if(c=='-'){jieguo=a-b;}
        if(c=='*'){jieguo=a*b;}
        if(c=='/'){jieguo=a/b;}
        return jieguo;

    }
    //读取表达式中数值，因为表达式是以char型数组存放表达式，通过此函数转换为double型
    public double duqushuzhi(char[] c){
        String s="";//创建一个String型数值s用来存放char型数值
        //表达式中可能存在多位的数值，所以通过一个循环将其转变为一个double型数值
        while(c[n] != '+' && c[n] != '-' && c[n] != '*' && c[n] != '/'
                && c[n] != '(' && c[n] != ')' && c[n] != '#'){//如果不是指定运算符，那么就是数值
            s=s+c[n];n++;
        }
        double d=Double.valueOf(s);//将String型数值转换为double型
        return d;
    }
    //计算    ***表达式求值核心内容
    public double suan(){
        double d=0;//存放最终结果
        double qian=0,hou=0;
        zhifu.add(new Node('#'));
        while(jieshu==0)
        {

            if (c[n] != '+' && c[n] != '-' && c[n] != '*' && c[n] != '/'
                    && c[n] != '(' && c[n] != ')' && c[n] != '#') //不是运算符则就是数值，进数值栈
            {		shuzhi.add(new Node(duqushuzhi(c)));}//进栈时调用上方的方法得到double型数值
            else{switch(youxian(zhifu.prenode.getdata(),c[n])){//调用上方方法 并输入栈顶运算符和当前表达式运算符比较

                case '<'://栈顶元素优先级低
                    zhifu.add(new Node(c[n]));//将当前表达式运算符入栈作为新的栈顶
                    n++;                      //n++   指向下一个字符 继续循环
                    break;
                case'='://脱括号进入下一字节          出现'='时一定是栈顶运算符为'('  表达式当前运算符为')'
                    zhifu.del();        //消除栈顶运算符'('    继续循环
                    n++;
                    break;
                case'>':              //退栈并将运算结果入栈
                    hou=shuzhi.del().getnum();  //取出数值栈当前栈顶 作为运算数
                    qian=shuzhi.del().getnum(); //取出数值栈当前栈顶 作为第二个运算数   注意：结合上一句一共从栈中去两个数值
                    shuzhi.add(new Node(js(qian,zhifu.del().getdata(),hou)));
                    //取出运算符栈栈顶并和两个运算符一起输入运算函数中计算结果并将结果入数值栈    继续循环
                    break;
                case's'://当出现's'时，运算符栈已经没有除'#'以外的运算符，计算完毕
                    d=shuzhi.del().getnum();//此时数值栈中只有一个数值就是最终结果
                    jieshu=1;              //停止循环
            }

            }
        }
        return d;    //返回最后结果

    }}


