package letCode;

import com.sun.activation.registries.MailcapParseException;

/**
 * 解决8皇后问题
 */
public class T08_12 {
    private int[][] qipan={
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0}
    };
    public void king(int[][] qipan,int rows,int clowns,int queenIndex,int queenIndex1){
//        int index = 0;
        if (queenIndex>=0&&queenIndex<=7&&queenIndex1>=0&&queenIndex1<=7){
            qipan[queenIndex][queenIndex1]=1;//第几个皇后就是第几行，然后用回溯法来判段这个皇后在第几列
            if (!checkQipan(qipan,rows,clowns,queenIndex,queenIndex1)){
                qipan[queenIndex][queenIndex1]=0;
                //回溯
                if (queenIndex1==clowns-1&&queenIndex>0){
                    int i = 0;
                    for (;i<clowns;i++){
                        if (qipan[queenIndex-1][i]==1)
                            break;
                    }
                    qipan[queenIndex-1][i]=0;
                    king(qipan,rows,clowns,queenIndex-1,i+1);
                }
                queenIndex1++;
                king(qipan,rows,clowns,queenIndex,queenIndex1);
            }else {
                king(qipan,rows,clowns,queenIndex+1,0);
            }
        }
    }
    public boolean checkQipan(int[][] qipan,int rows,int clowns,int x,int y){
        //根据king的函数可以知道已经可以保证一行只有一个皇后，所以我们只需要判单列或者斜对角线的位置
        //列判断
        for (int i=0;i<rows;i++){
            if (i==x)
                continue;
            if (qipan[i][y]==1)
                return false;
        }
        int x1 = x,y1=y;
        //左上角
        while ((x1-1>=0)&&(y1-1>=0)){
            if (qipan[--x1][--y1]==1)
                return false;
        }
        int x2 = x,y2=y;
        //左下角
        while ((x2+1<rows)&&(y2+1)<clowns){
            if (qipan[++x2][++y2]==1)
                return false;
        }
        int x3 = x,y3 = y;
        //左上角
        while ((x3-1>=0)&&(y3+1)<clowns){
            if (qipan[--x3][++y3]==1)
                return false;
        }
        int x4 = x,y4 = y;
        //左下角
        while ((x4+1<rows)&&(y4-1)>=0){
            if (qipan[++x4][--y4]==1)
                return false;
        }
        return true;
    }
    public void result(){
        for (int i =0;i<this.qipan.length;i++){
            for (int j=0;j<this.qipan[0].length;j++){
                System.out.print(qipan[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        T08_12 t0812 = new T08_12();
        t0812.king(t0812.qipan,8,8,0,0);
        t0812.result();
    }


}
