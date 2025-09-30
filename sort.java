import java.util.*;
public class sort {
    public static void merge(int arr[],int left,int mid,int right){
        int i=left;
        int j=mid+1;
        ArrayList<Integer>temp=new ArrayList<>();

        //compare both halves
        while(i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp.add(arr[i]);
                i++;
            }
            temp.add(arr[j]);
            j++;
    }
    while(i<=mid){
        temp.add(arr[i++]);
    }
    while(j<=right){
        temp.add(arr[j++]);
    }

    //copy back to original
    for(int k=left;k<=right;k++){
        arr[k]=temp.get(k-left);   //strts at 0
    }
    }

    public static void mergesort(int arr[],int left,int right){
        if(left>=right){
            return;
        }
        int mid=(left+right)/2;
        mergesort(arr,left,mid);
        mergesort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }

    public static void main(String args[]){
        int arr[]={38,27,43,3};
        mergesort(arr,0,arr.length-1);
        System.out.print(Arrays.toString(arr));
    }
}
