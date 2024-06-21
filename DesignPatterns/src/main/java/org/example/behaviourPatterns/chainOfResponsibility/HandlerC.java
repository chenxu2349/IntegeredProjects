package org.example.behaviourPatterns.chainOfResponsibility;

public class HandlerC extends Handler {
    public void handle() {
        boolean handled = false;
        System.out.println("Operation C is done...");
        if (!handled && successor != null) {
            successor.handle();
        }
    }
}
