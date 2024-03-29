package com.ws.jvm;

import java.util.Scanner;

import static com.ws.jvm.SizeOfObject.*;
/**
 * @author tianmai.fh
 * @date 2014-03-18 20:17
 */

public class SizeOfObjectTest {
    /**
     * -XX:+UseCompressedOops: mark/8 + metedata/4 + 4 = 16
     * -XX:-UseCompressedOops: mark/8 + metedata/4 + 4 + padding/4 = 24
     */
    static class A {
        Object reference ;

    }
    static class Ae extends A {
        int b;
    }

    static class Boolean1 {

        int b1;

    }
    static class Boolean2 {

        boolean b1;
        boolean b2;
    }

    static class Boolean3 {

        boolean b1;
        boolean b2;
        boolean b3;
    }

    static class AA {
        int a;
        long l;
        int b;
        double d;
    }

    /**
     * -XX:+UseCompressedOops: mark/4 + metedata/8 + 4 + 4 + padding/4 = 24
     * -XX:-UseCompressedOops: mark/8 + metedata/8 + 4 + 4 = 24
     */
    static class B {
        int a;
        int b;
    }

    /**
     * -XX:+UseCompressedOops: mark/4 + metedata/8 + 4 + 4 + padding/4 = 24
     * -XX:-UseCompressedOops: mark/8 + metedata/8 + 8 + 4 + padding/4 = 32
     */
    static class B2 {
        int b2a;
        Integer b2b;
    }

    /**
     * 不考虑对象头：
     * 4 + 4 + 4 * 3 + 3 * sizeOf(B)
     */
    static class C extends A {
        int ba;
        B[] as = new B[3];

        C() {
            for (int i = 0; i < as.length; i++) {
                as[i] = new B();
            }
        }
    }

    static class D extends B {
        int da;
        Integer[] di = new Integer[3];
    }

    /**
     * 会算上A的实例字段
     */
    static class E extends A {
        int ea;
        int eb;
    }

    public static void main(String[] args) throws IllegalAccessException {
        System.out.println("sizeOf(new A())=" + sizeOf(new A()));
       /* System.out.println("sizeOf(new Ae())=" + sizeOf(new Ae()));
        System.out.println("sizeOf(new AA())=" + sizeOf(new AA()));
        System.out.println("sizeOf(new Object())=" + sizeOf(new Object()));

        System.out.println("sizeOf(new Boolean1())=" + sizeOf(new Boolean1()));
        System.out.println("sizeOf(new Boolean2())=" + sizeOf(new Boolean2()));
        System.out.println("sizeOf(new Boolean3())=" + sizeOf(new Boolean3()));*/
        Scanner s = new Scanner(System.in);
        s.nextLine();
        /*System.out.println(new File("./target/classes").getAbsolutePath());
        System.out.println("sizeOf(new Object())=" + sizeOf(new Object()));
        System.out.println("sizeOf(new A())=" + sizeOf(new A()));
        System.out.println("sizeOf(new B())=" + sizeOf(new B()));
        System.out.println("sizeOf(new B2())=" + sizeOf(new B2()));
        System.out.println("sizeOf(new B[3])=" + sizeOf(new B[3]));
        System.out.println("sizeOf(new C())=" + sizeOf(new C()));
        System.out.println("fullSizeOf(new C())=" + fullSizeOf(new C()));
        System.out.println("sizeOf(new D())=" + sizeOf(new D()));
        System.out.println("fullSizeOf(new D())=" + fullSizeOf(new D()));
        System.out.println("sizeOf(new int[3])=" + sizeOf(new int[3]));
        System.out.println("sizeOf(new Integer(1)=" + sizeOf(new Integer(1)));
        System.out.println("sizeOf(new Integer[0])=" + sizeOf(new Integer[0]));
        System.out.println("sizeOf(new Integer[1])=" + sizeOf(new Integer[1]));
        System.out.println("sizeOf(new Integer[2])=" + sizeOf(new Integer[2]));
        System.out.println("sizeOf(new Integer[3])=" + sizeOf(new Integer[3]));
        System.out.println("sizeOf(new Integer[4])=" + sizeOf(new Integer[4]));
        System.out.println("sizeOf(new A[3])=" + sizeOf(new A[3]));
        System.out.println("sizeOf(new E())=" + sizeOf(new E()));*/
    }
}
