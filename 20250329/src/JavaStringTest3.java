public class JavaStringTest3 {
    // 方法改为静态，方便main直接调用
    public static boolean isPoli(String str) {
        if (str.isEmpty() || str.length() == 1) return true;
        char[] strArray = str.toCharArray();
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (strArray[left] != strArray[right]) {
                return false; // 发现不匹配立即返回false
            }
            left++;
            right--;
        }
        return true; // 全部匹配才返回true
    }

    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "abccba";
        System.out.println(isPoli(s1)); // 输出: false
        System.out.println(isPoli(s2)); // 输出: true
    }
}