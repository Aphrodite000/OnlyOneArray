import java.util.ArrayList;

public class Solution {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/e02fdb54d7524710a7d664d082bb7811?f=discussion
     * 来源：牛客网
     *
     * 思路：
     * 1、异或思想，一个数与自己异或为0，一个数与0异或为自己
     * 2、由于其它数字两两相同，所以所有数异或则得到这两个不同数的异或结果。取这个结果的第一个1作为标志位
     * 3、这个标志的1，必须是：这两个数在该位一个为0，一个为1
     * 4、这样可以将数组分为两组，一组在该标志位为1，一组在该标志位为0，这两个不同数字分别在这两组内
     * 5、将两组内的数分别异或，得到两个结果则为这两个不同的数
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int num=0;
        for(int i=0;i<array.length;i++){
            num^=array[i];//所有数异或，结果为不同的两个数字的异或
        }
        int count=0;//标志位，记录num中的第一个1出现的位置
        for(;count<array.length;count++){
            if((num&(1<<count))!=0){
                break;
            }
        }
        num1[0]=0;
        num2[0]=0;
        for(int i=0;i<array.length;i++){
            if((array[i]&(1<<count))==0){//标志位为0的为一组，异或后必得到一个数字（这里注意==的优先级高于&，需在前面加（））
                num1[0]^=array[i];
            }else{
                num2[0]^=array[i];//标志位为1的为一组
            }
        }
    }
    public void FindNumsAppearOnce2(int [] array,int num1[] , int num2[]) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<array.length;i++){
            if(list.contains(array[i])){
                list.remove(new Integer(array[i]));
            }else{
                list.add(array[i]);
            }
        }
        if(list.size()>1){
            num1[0]=list.get(0);
            num2[0]=list.get(1);
        }
    }
}
