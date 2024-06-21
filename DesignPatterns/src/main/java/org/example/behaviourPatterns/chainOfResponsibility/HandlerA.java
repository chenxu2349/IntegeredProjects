package org.example.behaviourPatterns.chainOfResponsibility;

public class HandlerA extends Handler {
    @Override
    public void handle() {
        boolean handled = false;
        System.out.println("Operation A is done...");
        handled = true;
        // 如果当前处理器没有完成处理，就转发给下一个handler
        if (!handled && successor != null) {
            successor.handle();
        }
    }
}
