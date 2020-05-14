package letCode;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * T08_12GUI
 *
 * @author linhu
 * @version 1.0
 * 2020/5/12 22:23
 **/
public class T08_12GUI extends Application {
    private static final int RECTANGLE_WIDTH = 100;
    private static final int RECTANGLE_HEIGHT = 100;
    private int[][] qipan=new int[8][8];
    public T08_12GUI(){

    }
    private GridPane gridPane = new GridPane();

    @Override
    public void start(Stage primaryStage) throws Exception {

        /**
         * 给窗口起名字
         */
        primaryStage.setTitle("八皇后问题");

        /*
        让窗口显示  如果不写这个函数  就不会显示窗口
         */
        Scene scene = new Scene(gridPane,800,800);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void drawShape(GridPane gridPane,int[][] qipan){
        for (int i = 0 ;i<qipan.length;i++){
            for (int j =0 ;j<qipan[0].length;j++){
                Rectangle rectangle = new Rectangle();
                rectangle.setWidth(RECTANGLE_WIDTH);
                rectangle.setHeight(RECTANGLE_HEIGHT);
                if (qipan[i][j]==1){
                    //进行绘画
//                    rectangle.setX(j*100);
//                    rectangle.setY(i*100);
//                    drawShape(gridPane,rectangle,i,j);
                    rectangle.setFill(Color.YELLOW);

                }else {
                    rectangle.setFill(Color.WHITE);

                }
                gridPane.add(rectangle,j,i);
            }
        }
    }

    public void setQipan(int[][] qipan){
//        GridPane gridPane = new GridPane();
//        gridPane.setGridLinesVisible(true);
        this.qipan = qipan;
        this.drawShape(gridPane,qipan);
    }

    public void king(int[][] qipan,int rows,int clowns,int queenIndex,int queenIndex1){
//        int index = 0;
        if (queenIndex>=0&&queenIndex<=7&&queenIndex1>=0&&queenIndex1<=7){
            qipan[queenIndex][queenIndex1]=1;//第几个皇后就是第几行，然后用回溯法来判段这个皇后在第几列
            setQipan(qipan);
            if (!checkQipan(qipan,rows,clowns,queenIndex,queenIndex1)){
                qipan[queenIndex][queenIndex1]=0;
                setQipan(qipan);
                //回溯
                if (queenIndex1==clowns-1&&queenIndex>0){
                    int i = 0;
                    for (;i<clowns;i++){
                        if (qipan[queenIndex-1][i]==1)
                            break;
                    }
                    qipan[queenIndex-1][i]=0;
                    setQipan(qipan);
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
        launch(args);
        new Thread(()->{
            T08_12GUI t0812 = new T08_12GUI();
            t0812.king(t0812.qipan,8,8,0,0);
            t0812.result();
        }).start();

    }

}
