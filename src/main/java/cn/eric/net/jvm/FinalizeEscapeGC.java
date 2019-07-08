package cn.eric.net.jvm;

/**
 * @author : junlinchen
 * @date: 2019/7/8 16:12
 * @version: 1.0
 * @Des :
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;
    public void isAlive() {
        System.out.println("yes, i am still alive[img]/images/smiles/icon_smile.gif&quot; alt=&quot;[/img]&quot");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize mehtod executed!&quot;");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();
        //对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
      // 因为Finalizer方法优先级很低，暂停0.5秒，以等待它
       Thread.sleep(500);
       if (SAVE_HOOK != null) {
          SAVE_HOOK.isAlive();
       } else {
           System.out.println("no, i am dead[img]/images/smiles/icon_sad.gif; alt=&quot;[/img]&quot;");
       }

     // 下面这段代码与上面的完全相同，但是这次自救却失败了
      SAVE_HOOK = null;
       System.gc();
// 因为Finalizer方法优先级很低，暂停0.5秒，以等待它
     Thread.sleep(500);
     if (SAVE_HOOK != null) {
         SAVE_HOOK.isAlive();
     } else {
         System.out.println("no, i am dead[img]/images/smiles/icon_sad.gif&quot; alt=&quot;[/img]&quot;");
     }
    }

}
