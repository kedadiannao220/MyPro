package com.pgy.collection;

import java.lang.ref.*;
import java.util.LinkedList;

public class ReferenceDemo {

    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<VeryBig>();

    public static void checkQueue() {
        Reference<? extends VeryBig> inq = rq.poll();
        if (inq != null) {
            System.out.println("In queue: " + inq.get());
        }
    }

    public static void testSoftReference() {

    }

    public static void main(String[] args) {
        int size = 10;
        if (args.length > 0) {
            size = new Integer(args[0]);
        }
        LinkedList<SoftReference<VeryBig>> sa = new LinkedList<SoftReference<VeryBig>>();
        for (int i = 0; i < size; i++) {
            sa.add(new SoftReference<VeryBig>(new VeryBig("soft" + i), rq));
            System.out.println("Just created: " + sa.getLast());
            checkQueue();
        }

        LinkedList<WeakReference<VeryBig>> wa = new LinkedList<WeakReference<VeryBig>>();
        for (int i = 0; i < size; i++) {
            VeryBig big = new VeryBig("weak" + i);
            WeakReference<VeryBig> waBig = new WeakReference<VeryBig>(big, rq);
            wa.add(waBig);
            System.out.println("Just created: " + wa.getLast());
            checkQueue();
        }

        LinkedList<PhantomReference<VeryBig>> pa = new LinkedList<PhantomReference<VeryBig>>();
        for (int i = 0; i < size; i++) {
            pa.add(new PhantomReference<VeryBig>(new VeryBig("soft" + i), rq));
            System.out.println("Just created: " + pa.getLast());
            checkQueue();
        }
    }

}

class VeryBig {
    private static final int    SIZE = 10000;
    private              long[] la   = new long[SIZE];
    private String ident;

    public VeryBig(String id) {
        ident = id;
    }

    protected void finalize() {
        System.out.println("Finalizing" + ident);
    }
}
