package Io;

import java.io.*;
import java.util.Arrays;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 *
 * java ./src/Io/CopyFile.java ./src/Io/input.ext ./src/Io/output.txt
 *
 * @author liaoxuefeng
 */
public class CopyFile {

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage:\n  java CopyFile.java <source> <target>");
            System.exit(1);
        }
        copy(args[0], args[1]);
    }

    static void copy(String source, String target) throws IOException {
        // 友情提示：测试时请使用无关紧要的文件
        try(InputStream input = new FileInputStream(source);
            OutputStream output = new FileOutputStream(target)){
            input.transferTo(output);
        }
    }

//    static void copy(String source, String target) throws IOException {
//        // 友情提示：测试时请使用无关紧要的文件
//        try(InputStream input = new FileInputStream(source);
//            OutputStream output = new FileOutputStream(target)){
//            byte[] buffer = new byte[10];
//
//            for (;;){
//                int read = input.read(buffer);
//                System.out.println(Arrays.toString(buffer));
//
//                if (read == -1){
////                    System.out.println(read);
//                    output.write(buffer);
//                    break;
////                    output.flush();
//                }
//            }
//        }
//    }
}
