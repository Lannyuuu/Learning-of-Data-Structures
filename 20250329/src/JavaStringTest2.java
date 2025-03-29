public class JavaStringTest2 {
    public static void main(String[] args) {
        //反转字符串
        String mystr = "abcdef";
        char[] mystrArray = mystr.toCharArray();
        System.out.println(mystrArray);
        int left = 0;
        int right = mystr.length()-1;
        //遍历字符串数组
        //1 2 3 4 5 6
        //0 1 2 3 4 5
        //字符串长度为6
        //1 2 3 4 5 6 7
        //0 1 2 3 4 5 6
        //实现每一个字符元素互换
        while(left < right){
            char temp;
            temp = mystrArray[left];
            mystrArray[left] = mystrArray[right];
            mystrArray[right] = temp;
            left++;
            right--;
        }
        System.out.println(mystrArray);
    }
}
