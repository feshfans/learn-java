import com.kang.annotation.PrintMe;

/**
 * Created by kang on 16-5-12.
 */
public class Test {

    public static void main(String[] args) {
        test();
    }
    @PrintMe
    private static void test(){
        System.out.println("++++++++++++++++++++");
    }
}
