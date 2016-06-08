package com.kang.finalize;

import javax.validation.constraints.Null;

/**
 * Created by kang on 16-6-4.
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK= null;

    private void isAlive(){
        System.out.println("Yes, i am still alive ;");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed !");
        FinalizeEscapeGC.SAVE_HOOK=this;
    }

    public static void main(String[] args) throws InterruptedException {

        SAVE_HOOK=new FinalizeEscapeGC();

        SAVE_HOOK=null;
        //对象第一次自救
        System.gc();;
        //因为finalize方法优先级很低,所以暂停0.5秒以等待它
        Thread.sleep(500);

        if(SAVE_HOOK!=null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("No , i am dead ;");
        }


        //下面的代码与上面完全相同,但是这次却自救失败了
        SAVE_HOOK=null;
        //对象第一次自救
        System.gc();;
        //因为finalize方法优先级很低,所以暂停0.5秒以等待它
        Thread.sleep(500);

        if(SAVE_HOOK!=null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("No , i am dead ;");
        }
    }
}
