package cn.eric.net.jvm;

/**
 * @author : junlinchen
 * @date: 2019/7/8 15:29
 * @version: 1.0
 * @Des : 虚拟机栈和本地方法栈溢出
 *
 * 规范中描述了两种异常：
 * 如果线程请求的栈深度大于虚拟机所允许的最大深度，将抛出StackOverflowError异常。
 * 如果虚拟机在扩展栈时无法申请到足够的内存空间，则抛出OutOfMemoryError异常。
 */
public class JavaVMStackSOF {
    private int stackLength = 1;
    public void stackLeack(){
        stackLength++;
        stackLeack();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeack();
        }catch (Throwable e){
            System.out.println("stack length:"+oom.stackLength);
            throw e;
        }
    }

//　　public static void main(String[] args) throws Throwable {
//　　JavaVMStackSOF oom = new JavaVMStackSOF();
//　　try {
//　　oom.stackLeak();
//　　} catch (Throwable e) {
//　　System.out.println("stack length:" + oom.stackLength);
//　　throw e;
//　　}
//　　}
}
