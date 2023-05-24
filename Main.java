import java.util.Scanner;
public class Main{

    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        double tempco;
        double[] points;
        double tempans=0;
        int count= 0;
        int calc;
        int temppoint1;
        int temppoint2;
        double avg;
        double avgans;
        int avgscale;
        double[] rescaled;
        int[] graph;
        graph = new int[861];
        points = new double[86];
        rescaled = new double[43];
        for (int i=20;i<861;i+=41){
            graph[i] = 2;
        }
        for (int i=0;i<41;i++){
            graph[(i+410)]=2;
        }
        System.out.println("What is the highest power of the polynomial?");
        int size = scan.nextInt();
        size++;
        double[] equation;
        equation = new double[size];
        System.out.println("Enter the coefficents of every term starting from the highest power decending");
        for (int i=0; i<size; i++){
            tempco = scan.nextDouble();
            equation[i]= tempco;
        }
        System.out.println("What is the scale of the x axis?");
        double xscale = scan.nextDouble();
        System.out.println("What is the scale of the y axis?");
        double yscale = scan.nextDouble();
        for (double j=(xscale*-21); j<(22*xscale);j+=xscale){
            points[count]=(double)j;
            count++;
            calc = 0;
            for (int k=(size-1);k>=0;k--){
                tempans+=(double)(equation[calc]*(Math.pow(j,k)));
                calc++;
            }
            points[count]=tempans;
            count++;
            tempans=0;
        }
        for (int i=0; i<43;i++){
            rescaled[i]=(points[(2*i)+1]/(yscale*1.0));
        }
        for (int i=-21;i<20;i++){
            if (rescaled[i+21]<0){
                temppoint1=(int)(rescaled[i+21]-0.5);
            } else {
                temppoint1=(int)(rescaled[i+21]+0.5);
            }
            if (rescaled[i+22]<0){
                temppoint2=(int)(rescaled[i+22]-0.5);
            } else {
                temppoint2=(int)(rescaled[i+22]+0.5);
            }
            if (temppoint2<=10&&temppoint2>=-10){
                graph[(((41*(10-temppoint2)))+(i+21))]=1;
            }
            if ((temppoint1-temppoint2>1||temppoint1-temppoint2<-1)){
                avg=((xscale*i)+(xscale*(i+1)))/2.0;
                calc=0;
                avgans=0;
                for (int k=(size-1);k>=0;k--){
                    avgans+=(double)(equation[calc]*(Math.pow(avg,k)));
                    calc++;
                }
                avgans/=yscale;
                if (avgans<0){
                    avgscale=(int)(avgans-0.5);
                } else {
                    avgscale=(int)(avgans+0.5);
                }
                if (temppoint1>10){
                    temppoint1=10;
                }
                if (temppoint1<-10){
                    temppoint1=-10;
                }
                if (temppoint2>10){
                    temppoint2=10;
                }
                if (temppoint2<-10){
                    temppoint2=-10;
                }
                if (temppoint1>temppoint2){
                    if (avgscale<0){
                        avgscale--;
                    }
                    if (temppoint1<avgscale){
                        for (int j=10;j>temppoint2;j--){
                            graph[(((41*(10-j)))+(i+21))]=1;
                        }
                    } else if (temppoint2>avgscale){
                        for (int j=temppoint1;j>-10;j--){
                            graph[(((41*(10-j)))+(i+20))]=1;
                            graph[820+(i+20)]=1;
                        }
                    } else{
                        for (int j=temppoint1;j>avgscale;j--){
                            graph[(((41*(10-j)))+(i+20))]=1;
                        }
                        for (int j=avgscale;j>temppoint2;j--){
                            graph[(((41*(10-j)))+(i+21))]=1;
                        }
                    }
                } else if (temppoint1<temppoint2) {
                    if (avgscale>=0){
                        avgscale++;
                    }
                    if (temppoint1>avgscale){
                        for (int j=-10;j<temppoint2;j++){
                            graph[(((41*(10-j)))+(i+21))]=1;
                        }
                    } else if (temppoint2<avgscale){
                        for (int j=temppoint1;j<10;j++){
                            graph[(((41*(10-j)))+(i+20))]=1;
                            graph[i+20]=1;
                        }
                    } else {
                        for (int j=temppoint1;j<avgscale;j++){
                            graph[(((41*(10-j)))+(i+20))]=1;
                        }
                        for (int j=avgscale;j<temppoint2;j++){
                            graph[(((41*(10-j)))+(i+21))]=1;
                        }
                    }
                }
            }
        }
        for (int i=0; i<861;i++){
            if ((i+1)%41==0){
                if (graph[i]==0){
                    System.out.print(" ");
                } else if (graph[i]==1){
                    System.out.print("O");
                } else {
                    System.out.print("X");
                }
                System.out.println();
            } else {
                if (graph[i]==0){
                    System.out.print(" ");
                } else if (graph[i]==1){
                    System.out.print("O");
                } else {
                    System.out.print("X");
                }
            }
        }
    }
}
