//package org.example.leetcode;
//
//import java.util.Scanner;
//
//public class MTQZ3 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int q = sc.nextInt();
//        int[] a = new int[n];
//        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
//        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//            min = Math.min(min, a[i]);
//            max = Math.max(max, a[i]);
//        }
//
//        // 处理q次询问
//        while (q-- > 0) {
//            int l = sc.nextInt();
//            int r = sc.nextInt();
//
//            int tuanMax = -1;
//            for (int i = l - 1; i < r; i++) {
//                tuanMax = Math.max(a[i], tuanMax);
//            }
//
//            if (tuanMax == max) {
//                System.out.println("lose");
//                System.out.println(r-l+2);
//                continue;
//            }
//
//            // 向左寻找
//            int leftWinLoad = Integer.MAX_VALUE;
//            boolean leftWin = false, leftDraw = false;
//            for (int i = l - 2; i >= 0; i--) {
//                if (a[i] > tuanMax) {
//                    leftWinLoad = l - 1 - i;
//                    leftWin = true;
//                    break;
//                } else if (a[i] == tuanMax) {
////                    leftDrawLoad = l - 1 - i;
//                    leftDraw = true;
//                }
//            }
//            // 向右寻找
//            int rightWinLoad = Integer.MAX_VALUE, rightDrawLoad = Integer.MAX_VALUE;
//            boolean rightWin = false, rightDraw = false;
//            for (int i = r; i < n; i++) {
//                if (a[i] > tuanMax) {
//                    rightWinLoad = i - r + 1;
//                    rightWin = true;
//                    break;
//                } else if (a[i] == tuanMax) {
//                    rightDrawLoad = i - r + 1;
//                    rightDraw = true;
//                }
//            }
//
//            int leftDrawLoad = Integer.MAX_VALUE;
//            boolean leftDraw = false;
//
//            if (leftWin || rightWin) {
//                System.out.println("win");
//                System.out.println(r - l + 1 + Math.min(leftWinLoad, rightWinLoad));
//            } else if (leftDraw || rightDraw) {
//                System.out.println("draw");
//                System.out.println(r - l + 1 + Math.min(leftDrawLoad, rightDrawLoad));
//            } else {
//                System.out.println("lose");
//                System.out.println(r - l + 2);
//            }
//        }
//    }
//}