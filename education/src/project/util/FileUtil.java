package project.util;

import java.io.BufferedInputStream;   
import java.io.BufferedOutputStream;   
import java.io.BufferedReader;   
import java.io.BufferedWriter;   
import java.io.File;   
import java.io.FileInputStream;   
import java.io.FileNotFoundException;   
import java.io.FileOutputStream;   
import java.io.IOException;   
import java.io.InputStream;   
import java.io.InputStreamReader;   
import java.io.OutputStreamWriter;   
import java.io.RandomAccessFile;   
import java.io.StringReader;   
import java.util.Enumeration;   
import org.slf4j.Logger;   
import org.slf4j.LoggerFactory;   

/**
 * 文件工具类
 * @author cxw
 *
 */
public class FileUtil {   
    private static Logger log = LoggerFactory.getLogger(FileUtil.class);   
  
    /**  
     * 创建单个文件夹。  
     *   
     * @param dir  
     * @param ignoreIfExitst  
     *            true 表示如果文件夹存在就不再创建了。false是重新创建。  
     * @throws IOException  
     */  
    public static void createDir(String dir, boolean ignoreIfExitst)   
            throws IOException {   
        File file = new File(dir);   
  
        if (ignoreIfExitst && file.exists()) {   
            return;   
        }   
  
        if (file.mkdir() == false) {   
            throw new IOException("Cannot create the directory = " + dir);   
        }   
    }   
  
    /**  
     * 创建多个文件夹  
     *   
     * @param dir  
     * @param ignoreIfExitst  
     * @throws IOException  
     */  
    public static void createDirs(String dir, boolean ignoreIfExitst)   
            throws IOException {   
        File file = new File(dir);   
  
        if (ignoreIfExitst && file.exists()) {   
            return;   
        }   
  
        if (file.mkdirs() == false) {   
            throw new IOException("Cannot create directories = " + dir);   
        }   
    }   
  
    /**  
     * 删除一个文件。  
     *   
     * @param filename  
     * @throws IOException  
     */  
    public static void deleteFile(String filename) throws IOException {   
        File file = new File(filename);   
        log.trace("Delete file = " + filename);   
        if (file.isDirectory()) {   
            throw new IOException(   
                    "IOException -> BadInputException: not a file.");   
        }   
        if (file.exists() == false) {   
            throw new IOException(   
                    "IOException -> BadInputException: file is not exist.");   
        }   
        if (file.delete() == false) {   
            throw new IOException("Cannot delete file. filename = " + filename);   
        }   
    }   
  
    /**  
     * 删除文件夹及其下面的子文件夹  
     *   
     * @param dir  
     * @throws IOException  
     */  
    public static void deleteDir(File dir) throws IOException {   
        if (dir.isFile())   
            throw new IOException(   
                    "IOException -> BadInputException: not a directory.");   
        File[] files = dir.listFiles();   
        if (files != null) {   
            for (int i = 0; i < files.length; i++) {   
                File file = files[i];   
                if (file.isFile()) {   
                    file.delete();   
                } else {   
                    deleteDir(file);   
                }   
            }   
        }// if   
        dir.delete();   
    }   
  
    public static String getPathSeparator() {   
        return java.io.File.pathSeparator;   
    }   
  
    public static String getFileSeparator() {   
        return java.io.File.separator;   
    }   
  
    /**  
     * 获取到目录下面文件的大小。包含了子目录。  
     *   
     * @param dir  
     * @return  
     * @throws IOException  
     */  
    public static long getDirLength(File dir) throws IOException {   
        if (dir.isFile())   
            throw new IOException("BadInputException: not a directory.");   
        long size = 0;   
        File[] files = dir.listFiles();   
        if (files != null) {   
            for (int i = 0; i < files.length; i++) {   
                File file = files[i];   
                // file.getName();   
                // System.out.println(file.getName());   
                long length = 0;   
                if (file.isFile()) {   
                    length = file.length();   
                } else {   
                    length = getDirLength(file);   
                }   
                size += length;   
            }// for   
        }// if   
        return size;   
    }   
  
    /**  
     * 将文件清空。  
     *   
     * @param srcFilename  
     * @throws IOException  
     */  
    public static void emptyFile(String srcFilename) throws IOException {   
        File srcFile = new File(srcFilename);   
        if (!srcFile.exists()) {   
            throw new FileNotFoundException("Cannot find the file: "  
                    + srcFile.getAbsolutePath());   
        }   
        if (!srcFile.canWrite()) {   
            throw new IOException("Cannot write the file: "  
                    + srcFile.getAbsolutePath());   
        }   
  
        FileOutputStream outputStream = new FileOutputStream(srcFilename);   
        outputStream.close();   
    }   
  
    /**  
     * Write content to a fileName with the destEncoding 写文件。如果此文件不存在就创建一个。  
     *   
     * @param content  
     *            String  
     * @param fileName  
     *            String  
     * @param destEncoding  
     *            String  
     * @throws FileNotFoundException  
     * @throws IOException  
     */  
    public static void writeFile(String content, String fileName,   
            String destEncoding) throws FileNotFoundException, IOException {   
        File file = null;   
        try {   
            file = new File(fileName);   
            if (!file.exists()) {   
                if (file.createNewFile() == false) {   
                    throw new IOException("create file '" + fileName   
                            + "' failure.");   
                }   
            }   
            if (file.isFile() == false) {   
                throw new IOException("'" + fileName + "' is not a file.");   
            }   
            if (file.canWrite() == false) {   
                throw new IOException("'" + fileName + "' is a read-only file.");   
            }   
        } finally {   
            // we dont have to close File here   
        }   
  
        BufferedWriter out = null;   
        try {   
            FileOutputStream fos = new FileOutputStream(fileName);   
            out = new BufferedWriter(new OutputStreamWriter(fos, destEncoding));   
  
            out.write(content);   
            out.flush();   
        } catch (FileNotFoundException fe) {   
            log.error("Error", fe);   
            throw fe;   
        } catch (IOException e) {   
            log.error("Error", e);   
            throw e;   
        } finally {   
            try {   
                if (out != null)   
                    out.close();   
            } catch (IOException ex) {   
            }   
        }   
    }   
  
    /**  
     * 读取文件的内容，并将文件内容以字符串的形式返回。  
     *   
     * @param fileName  
     * @param srcEncoding  
     * @return  
     * @throws FileNotFoundException  
     * @throws IOException  
     */  
    public static String readFile(String fileName, String srcEncoding)   
            throws FileNotFoundException, IOException {   
  
        File file = null;   
        try {   
            file = new File(fileName);   
            if (file.isFile() == false) {   
                throw new IOException("'" + fileName + "' is not a file.");   
            }   
        } finally {   
            // we dont have to close File here   
        }   
  
        BufferedReader reader = null;   
        try {   
            StringBuffer result = new StringBuffer(1024);   
            FileInputStream fis = new FileInputStream(fileName);   
            reader = new BufferedReader(new InputStreamReader(fis, srcEncoding));   
  
            char[] block = new char[512];   
            while (true) {   
                int readLength = reader.read(block);   
                if (readLength == -1)   
                    break;// end of file   
                result.append(block, 0, readLength);   
            }   
            return result.toString();   
        } catch (FileNotFoundException fe) {   
            log.error("Error", fe);   
            throw fe;   
        } catch (IOException e) {   
            log.error("Error", e);   
            throw e;   
        } finally {   
            try {   
                if (reader != null)   
                    reader.close();   
            } catch (IOException ex) {   
            }   
        }   
    }   
  
    /*  
     * 1 ABC 2 abC Gia su doc tu dong 1 lay ca thay 5 dong => 1 --> 5 3 ABC  
     */  
    public static String[] getLastLines(File file, int linesToReturn)   
            throws IOException, FileNotFoundException {   
  
        final int AVERAGE_CHARS_PER_LINE = 250;   
        final int BYTES_PER_CHAR = 2;   
  
        RandomAccessFile randomAccessFile = null;   
        StringBuffer buffer = new StringBuffer(linesToReturn   
                * AVERAGE_CHARS_PER_LINE);   
        int lineTotal = 0;   
        try {   
            randomAccessFile = new RandomAccessFile(file, "r");   
            long byteTotal = randomAccessFile.length();   
            long byteEstimateToRead = linesToReturn * AVERAGE_CHARS_PER_LINE   
                    * BYTES_PER_CHAR;   
  
            long offset = byteTotal - byteEstimateToRead;   
            if (offset < 0) {   
                offset = 0;   
            }   
  
            randomAccessFile.seek(offset);   
            // log.debug("SKIP IS ::" + offset);   
  
            String line = null;   
            String lineUTF8 = null;   
            while ((line = randomAccessFile.readLine()) != null) {   
                lineUTF8 = new String(line.getBytes("ISO8859_1"), "UTF-8");   
                lineTotal++;   
                buffer.append(lineUTF8).append("\n");   
            }   
        } finally {   
            if (randomAccessFile != null) {   
                try {   
                    randomAccessFile.close();   
                } catch (IOException ex) {   
                }   
            }   
        }   
  
        String[] resultLines = new String[linesToReturn];   
        BufferedReader in = null;   
        try {   
            in = new BufferedReader(new StringReader(buffer.toString()));   
  
            int start = lineTotal /* + 2 */- linesToReturn; // Ex : 55 - 10 = 45   
            // ~ offset   
            if (start < 0)   
                start = 0; // not start line   
            for (int i = 0; i < start; i++) {   
                in.readLine(); // loop until the offset. Ex: loop 0, 1 ~~ 2   
                // lines   
            }   
  
            int i = 0;   
            String line = null;   
            while ((line = in.readLine()) != null) {   
                resultLines[i] = line;   
                i++;   
            }   
        } catch (IOException ie) {   
            log.error("Error" + ie);   
            throw ie;   
        } finally {   
            if (in != null) {   
                try {   
                    in.close();   
                } catch (IOException ex) {   
                }   
            }   
        }   
        return resultLines;   
    }   
  
    /**  
     * 单个文件拷贝。  
     *   
     * @param srcFilename  
     * @param destFilename  
     * @param overwrite  
     * @throws IOException  
     */  
    public static void copyFile(String srcFilename, String destFilename,   
            boolean overwrite) throws IOException {   
  
        File srcFile = new File(srcFilename);   
        // 首先判断源文件是否存在   
        if (!srcFile.exists()) {   
            throw new FileNotFoundException("Cannot find the source file: "  
                    + srcFile.getAbsolutePath());   
        }   
        // 判断源文件是否可读   
        if (!srcFile.canRead()) {   
            throw new IOException("Cannot read the source file: "  
                    + srcFile.getAbsolutePath());   
        }   
  
        File destFile = new File(destFilename);   
  
        if (overwrite == false) {   
            // 目标文件存在就不覆盖   
            if (destFile.exists())   
                return;   
        } else {   
            // 如果要覆盖已经存在的目标文件，首先判断是否目标文件可写。   
            if (destFile.exists()) {   
                if (!destFile.canWrite()) {   
                    throw new IOException("Cannot write the destination file: "  
                            + destFile.getAbsolutePath());   
                }   
            } else {   
                // 不存在就创建一个新的空文件。   
                if (!destFile.createNewFile()) {   
                    throw new IOException("Cannot write the destination file: "  
                            + destFile.getAbsolutePath());   
                }   
            }   
        }   
  
        BufferedInputStream inputStream = null;   
        BufferedOutputStream outputStream = null;   
        byte[] block = new byte[1024];   
        try {   
            inputStream = new BufferedInputStream(new FileInputStream(srcFile));   
            outputStream = new BufferedOutputStream(new FileOutputStream(   
                    destFile));   
            while (true) {   
                int readLength = inputStream.read(block);   
                if (readLength == -1)   
                    break;// end of file   
                outputStream.write(block, 0, readLength);   
            }   
        } finally {   
            if (inputStream != null) {   
                try {   
                    inputStream.close();   
                } catch (IOException ex) {   
                    // just ignore   
                }   
            }   
            if (outputStream != null) {   
                try {   
                    outputStream.close();   
                } catch (IOException ex) {   
                    // just ignore   
                }   
            }   
        }   
    }   
  
    /**  
     * 单个文件拷贝。  
     *   
     * @param srcFile  
     * @param destFile  
     * @param overwrite  
     *            是否覆盖目的文件  
     * @throws IOException  
     */  
    public static void copyFile(File srcFile, File destFile, boolean overwrite)   
            throws IOException {   
  
        // 首先判断源文件是否存在   
        if (!srcFile.exists()) {   
            throw new FileNotFoundException("Cannot find the source file: "  
                    + srcFile.getAbsolutePath());   
        }   
        // 判断源文件是否可读   
        if (!srcFile.canRead()) {   
            throw new IOException("Cannot read the source file: "  
                    + srcFile.getAbsolutePath());   
        }   
  
        if (overwrite == false) {   
            // 目标文件存在就不覆盖   
            if (destFile.exists())   
                return;   
        } else {   
            // 如果要覆盖已经存在的目标文件，首先判断是否目标文件可写。   
            if (destFile.exists()) {   
                if (!destFile.canWrite()) {   
                    throw new IOException("Cannot write the destination file: "  
                            + destFile.getAbsolutePath());   
                }   
            } else {   
                // 不存在就创建一个新的空文件。   
                if (!destFile.createNewFile()) {   
                    throw new IOException("Cannot write the destination file: "  
                            + destFile.getAbsolutePath());   
                }   
            }   
        }   
  
        BufferedInputStream inputStream = null;   
        BufferedOutputStream outputStream = null;   
        byte[] block = new byte[1024];   
        try {   
            inputStream = new BufferedInputStream(new FileInputStream(srcFile));   
            outputStream = new BufferedOutputStream(new FileOutputStream(   
                    destFile));   
            while (true) {   
                int readLength = inputStream.read(block);   
                if (readLength == -1)   
                    break;// end of file   
                outputStream.write(block, 0, readLength);   
            }   
        } finally {   
            if (inputStream != null) {   
                try {   
                    inputStream.close();   
                } catch (IOException ex) {   
                    // just ignore   
                }   
            }   
            if (outputStream != null) {   
                try {   
                    outputStream.close();   
                } catch (IOException ex) {   
                    // just ignore   
                }   
            }   
        }   
    }   
  
    /**  
     * 拷贝文件，从源文件夹拷贝文件到目的文件夹。 <br>  
     * 参数源文件夹和目的文件夹，最后都不要带文件路径符号，例如：c:/aa正确，c:/aa/错误。  
     *   
     * @param srcDirName  
     *            源文件夹名称 ,例如：c:/test/aa 或者c:\\test\\aa  
     * @param destDirName  
     *            目的文件夹名称,例如：c:/test/aa 或者c:\\test\\aa  
     * @param overwrite  
     *            是否覆盖目的文件夹下面的文件。  
     * @throws IOException  
     */  
    public static void copyFiles(String srcDirName, String destDirName,   
            boolean overwrite) throws IOException {   
        File srcDir = new File(srcDirName);// 声明源文件夹   
        // 首先判断源文件夹是否存在   
        if (!srcDir.exists()) {   
            throw new FileNotFoundException(   
                    "Cannot find the source directory: "  
                            + srcDir.getAbsolutePath());   
        }   
  
        File destDir = new File(destDirName);   
        if (overwrite == false) {   
            if (destDir.exists()) {   
                // do nothing   
            } else {   
                if (destDir.mkdirs() == false) {   
                    throw new IOException(   
                            "Cannot create the destination directories = "  
                                    + destDir);   
                }   
            }   
        } else {   
            // 覆盖存在的目的文件夹   
            if (destDir.exists()) {   
                // do nothing   
            } else {   
                // create a new directory   
                if (destDir.mkdirs() == false) {   
                    throw new IOException(   
                            "Cannot create the destination directories = "  
                                    + destDir);   
                }   
            }   
        }   
  
        // 循环查找源文件夹目录下面的文件（屏蔽子文件夹），然后将其拷贝到指定的目的文件夹下面。   
        File[] srcFiles = srcDir.listFiles();   
        if (srcFiles == null || srcFiles.length < 1) {   
            // throw new IOException ("Cannot find any file from source   
            // directory!!!");   
            return;// do nothing   
        }   
  
        // 开始复制文件   
        int SRCLEN = srcFiles.length;   
  
        for (int i = 0; i < SRCLEN; i++) {   
            // File tempSrcFile = srcFiles[i];   
            File destFile = new File(destDirName + File.separator   
                    + srcFiles[i].getName());   
            // 注意构造文件对象时候，文件名字符串中不能包含文件路径分隔符";".   
            // log.debug(destFile);   
            if (srcFiles[i].isFile()) {   
                copyFile(srcFiles[i], destFile, overwrite);   
            } else {   
                // 在这里进行递归调用，就可以实现子文件夹的拷贝   
                copyFiles(srcFiles[i].getAbsolutePath(), destDirName   
                        + File.separator + srcFiles[i].getName(), overwrite);   
            }   
        }   
    }   
  
   
  
    private static void createDirectory(String directory, String subDirectory) {   
        String dir[];   
        File fl = new File(directory);   
        try {   
            if (subDirectory == "" && fl.exists() != true) {   
                fl.mkdir();   
            } else if (subDirectory != "") {   
                dir = subDirectory.replace('\\', '/').split("/");   
                for (int i = 0; i < dir.length; i++) {   
                    File subFile = new File(directory + File.separator + dir[i]);   
                    if (subFile.exists() == false)   
                        subFile.mkdir();   
                    directory += File.separator + dir[i];   
                }   
            }   
        } catch (Exception ex) {   
            System.out.println(ex.getMessage());   
        }   
    }   
  
    /**  
     *   
     * 拷贝文件夹中的所有文件到另外一个文件夹  
     *   
     * @param srcDirector  
     *            源文件夹  
     *   
     * @param desDirector  
     *            目标文件夹  
     *   
     */  
  
    public static void copyFileWithDirector(String srcDirector,   
            String desDirector) throws IOException {   
        (new File(desDirector)).mkdirs();   
        File[] file = (new File(srcDirector)).listFiles();   
        for (int i = 0; i < file.length; i++) {   
            if (file[i].isFile()) {   
                log.debug("拷贝：" + file[i].getAbsolutePath() + "-->"  
                        + desDirector + "/" + file[i].getName());   
                FileInputStream input = new FileInputStream(file[i]);   
                FileOutputStream output = new FileOutputStream(desDirector   
                        + "/" + file[i].getName());   
                byte[] b = new byte[1024 * 5];   
                int len;   
                while ((len = input.read(b)) != -1) {   
                    output.write(b, 0, len);   
                }   
                output.flush();   
                output.close();   
                input.close();   
            }   
            if (file[i].isDirectory()) {   
                log.debug("拷贝：" + file[i].getAbsolutePath() + "-->"  
                        + desDirector + "/" + file[i].getName());   
                copyFileWithDirector(srcDirector + "/" + file[i].getName(),   
                        desDirector + "/" + file[i].getName());   
            }   
        }   
    }   
  
    /**  
     * 删除文件夹  
     *   
     * @param folderPath  
     *            folderPath 文件夹完整绝对路径  
     */  
    public static void delFolder(String folderPath) throws Exception {   
        // 删除完里面所有内容   
        delAllFile(folderPath);   
        String filePath = folderPath;   
        filePath = filePath.toString();   
        File myFilePath = new File(filePath);   
        // 删除空文件夹   
        myFilePath.delete();   
    }   
  
    /**  
     * 删除指定文件夹下所有文件  
     *   
     * @param path  
     *            文件夹完整绝对路径  
     */  
    public static boolean delAllFile(String path) throws Exception {   
        boolean flag = false;   
        File file = new File(path);   
        if (!file.exists()) {   
            return flag;   
        }   
        if (!file.isDirectory()) {   
            return flag;   
        }   
        String[] tempList = file.list();   
        File temp = null;   
        for (int i = 0; i < tempList.length; i++) {   
            if (path.endsWith(File.separator)) {   
                temp = new File(path + tempList[i]);   
            } else {   
                temp = new File(path + File.separator + tempList[i]);   
            }   
            if (temp.isFile()) {   
                temp.delete();   
            }   
            if (temp.isDirectory()) {   
                // 先删除文件夹里面的文件   
                delAllFile(path + "/" + tempList[i]);   
                // 再删除空文件夹   
                delFolder(path + "/" + tempList[i]);   
                flag = true;   
            }   
        }   
        return flag;   
    }   
  
}  

