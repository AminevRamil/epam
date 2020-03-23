package shkryl.task7.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;


public final class Utils {
    private static Logger logger = LoggerFactory.getLogger(Utils.class);;

    private Utils() {

    }

    public static String getFileNameFromAbsoluteFileName(String path) {
        File f = new File(path);
        return f.getName();
    }

    public static String getFileAbsolutePathWithoutExtension(File file) {
        String filePath = file.getAbsolutePath();
        if (filePath.lastIndexOf(".") != -1 && filePath.lastIndexOf(".") != 0) {
            return filePath.substring(0, filePath.lastIndexOf("."));
        } else return "";
    }

    public static byte[] readFile(String fileName) throws ClassNotFoundException {

        File f = new File(fileName + ".class");
        if (!f.isFile()) {
            throw new ClassNotFoundException("Нет такого класса " + fileName);
        }
        InputStream ins = null;

        //С помощью потока считываем файл в массив байт
        try {
            ins = new BufferedInputStream(new FileInputStream(f));
            byte[] b = new byte[(int) f.length()];
            ins.read(b);
            return b;
        } catch (IOException e) {
            logger.error(e.toString());
            System.out.println(e.toString());
        } finally {
            try {
                ins.close();
            } catch (Exception e) {
                logger.error(e.toString());
                System.out.println(e.toString());
            }
            ;
        }
        return null;
    }
}
