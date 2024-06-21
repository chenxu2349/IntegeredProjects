package org.example.behaviourPatterns.chainOfResponsibility;

public class HandlerB extends Handler {
    public void handle() {
        boolean handled = false;
        System.out.println("Operation B is done...");
        if (!handled && successor != null) {
            successor.handle();
        }
    }
}
