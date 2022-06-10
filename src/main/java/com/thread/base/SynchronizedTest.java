package com.thread.base;

/**
 * @author qcl
 * @version 1.0
 * @date 2022/6/10 10:15 AM
 * @description
 */
public class SynchronizedTest {

    public static void main(String[] args) {
        synchronized(Demo.class) {
            System.out.println("hello");
        }

        Demo demo = new Demo();
        demo.hello();
    }


}

class Demo {
    public synchronized void hello() {
        System.out.println("hello");
    }
}



//    Last modified 2022-6-10; size 716 bytes
//        MD5 checksum 55b84025609fd27903241aee0056ecbf
//        Compiled from "SynchronizedTest.java"
//public class com.thread.base.SynchronizedTest
//        minor version: 0
//        major version: 52
//        flags: ACC_PUBLIC, ACC_SUPER
//        Constant pool:
//        #1 = Methodref          #7.#25         // java/lang/Object."<init>":()V
//        #2 = Class              #26            // com/thread/base/Demo
//        #3 = Fieldref           #27.#28        // java/lang/System.out:Ljava/io/PrintStream;
//        #4 = String             #29            // hello
//        #5 = Methodref          #30.#31        // java/io/PrintStream.println:(Ljava/lang/String;)V
//        #6 = Class              #32            // com/thread/base/SynchronizedTest
//        #7 = Class              #33            // java/lang/Object
//        #8 = Utf8               <init>
//   #9 = Utf8               ()V
//           #10 = Utf8               Code
//           #11 = Utf8               LineNumberTable
//           #12 = Utf8               LocalVariableTable
//           #13 = Utf8               this
//           #14 = Utf8               Lcom/thread/base/SynchronizedTest;
//           #15 = Utf8               main
//           #16 = Utf8               ([Ljava/lang/String;)V
//           #17 = Utf8               args
//           #18 = Utf8               [Ljava/lang/String;
//           #19 = Utf8               StackMapTable
//           #20 = Class              #18            // "[Ljava/lang/String;"
//           #21 = Class              #33            // java/lang/Object
//           #22 = Class              #34            // java/lang/Throwable
//           #23 = Utf8               SourceFile
//           #24 = Utf8               SynchronizedTest.java
//           #25 = NameAndType        #8:#9          // "<init>":()V
//           #26 = Utf8               com/thread/base/Demo
//           #27 = Class              #35            // java/lang/System
//           #28 = NameAndType        #36:#37        // out:Ljava/io/PrintStream;
//           #29 = Utf8               hello
//           #30 = Class              #38            // java/io/PrintStream
//           #31 = NameAndType        #39:#40        // println:(Ljava/lang/String;)V
//           #32 = Utf8               com/thread/base/SynchronizedTest
//           #33 = Utf8               java/lang/Object
//           #34 = Utf8               java/lang/Throwable
//           #35 = Utf8               java/lang/System
//           #36 = Utf8               out
//           #37 = Utf8               Ljava/io/PrintStream;
//           #38 = Utf8               java/io/PrintStream
//           #39 = Utf8               println
//           #40 = Utf8               (Ljava/lang/String;)V
//           {
//public com.thread.base.SynchronizedTest();
//        descriptor: ()V
//        flags: ACC_PUBLIC
//        Code:
//        stack=1, locals=1, args_size=1
//        0: aload_0
//        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//        4: return
//        LineNumberTable:
//        line 9: 0
//        LocalVariableTable:
//        Start  Length  Slot  Name   Signature
//        0       5     0  this   Lcom/thread/base/SynchronizedTest;
//
//public static void main(java.lang.String[]);
//        descriptor: ([Ljava/lang/String;)V
//        flags: ACC_PUBLIC, ACC_STATIC
//        Code:
//        stack=2, locals=3, args_size=1
//        0: ldc           #2                  // class com/thread/base/Demo
//        2: dup
//        3: astore_1
//        4: monitorenter
//        5: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
//        8: ldc           #4                  // String hello
//        10: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
//        13: aload_1
//        14: monitorexit
//        15: goto          23
//        18: astore_2
//        19: aload_1
//        20: monitorexit
//        21: aload_2
//        22: athrow
//        23: return
//        Exception table:
//        from    to  target type
//        5    15    18   any
//        18    21    18   any
//        LineNumberTable:
//        line 12: 0
//        line 13: 5
//        line 14: 13
//        line 15: 23
//        LocalVariableTable:
//        Start  Length  Slot  Name   Signature
//        0      24     0  args   [Ljava/lang/String;
//        StackMapTable: number_of_entries = 2
//        frame_type = 255 /* full_frame */
//        offset_delta = 18
//        locals = [ class "[Ljava/lang/String;", class java/lang/Object ]
//        stack = [ class java/lang/Throwable ]
//        frame_type = 250 /* chop */
//        offset_delta = 4
//        }
