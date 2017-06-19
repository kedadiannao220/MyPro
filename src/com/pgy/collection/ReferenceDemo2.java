package com.pgy.collection;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferenceDemo2 {
    private static ReferenceQueue<Object> objQueue = new ReferenceQueue<Object>();

    public static void main(String[] args) {
        Object obj = null;
        System.out.println("****************testSoftReference*******************");
        testSoftReference(obj);
        System.out.println("****************testWeakReference*******************");
        testWeakReference(obj);
        System.out.println("****************testPhantomReference*******************");
        testPhantomReference(obj);
    }

    private static void testSoftReference(Object obj) {
        obj = new Object();
        SoftReference<Object> sr = new SoftReference<Object>(obj, objQueue);

        System.out.println(sr.get());
        System.out.println(objQueue.poll());
        obj = null;
        System.gc();

        System.out.println(sr.get());
        System.out.println(objQueue.poll());
    }

    private static void testWeakReference(Object obj) {
        obj = new Object();
        WeakReference<Object> wr = new WeakReference<Object>(obj, objQueue);
        System.out.println(wr.get());
        System.out.println(objQueue.poll());
        obj = null;
        System.gc();

        System.out.println(wr.get());
        System.out.println(objQueue.getClass());
    }

    private static void testPhantomReference(Object obj) {
        obj = new Object();
        PhantomReference<Object> pr = new PhantomReference<Object>(obj, objQueue);

        System.out.println(pr.get());
        System.out.println(objQueue.poll());
        obj = null;
        System.gc();

        System.out.println(pr.get());
        System.out.println(objQueue.poll());
    }

}
//console
//****************testSoftReference*******************
//java.lang.Object@280bca
//null
//java.lang.Object@280bca
//null
//****************testWeakReference*******************
//java.lang.Object@1817fe89
//null
//null
//java.lang.ref.WeakReference@717e5fde
//****************testPhantomReference*******************
//null
//null
//null
//java.lang.ref.PhantomReference@39fc0f04

