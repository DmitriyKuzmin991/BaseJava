import java.io.File;

/**
 * gkislin
 * 21.07.2016
 */
public class MainFile {
    public static void main(String[] args) {
//        String filePath = ".\\.gitignore";
//
//        File file = new File(filePath);
//        try {
//            System.out.println(file.getCanonicalPath());
//        } catch (IOException e) {
//            throw new RuntimeException("Error", e);
//        }

        File dir = new File("C:\\Users\\Dmitriy\\Documents\\Java\\basejava");
        fileThree2(dir);
//        System.out.println(dir.isDirectory());
//        String[] list = dir.list();
//        if (list != null) {
//            for (String name : list) {
//                System.out.println(name);
//            }
//        }

//        try (FileInputStream fis = new FileInputStream(filePath)) {
//            System.out.println(fis.read());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
    private static void fileThree(File file) {
        if (file.isDirectory()) {
            System.out.println("directory : " + file.getName());
            for (File item : file.listFiles()) {
                System.out.print("-------------------");
                fileThree(item);
            }
        } else {
            System.out.println("file : " + file.getName());
        }
    }
    private static void fileThree2(File file) {
        if (file.isDirectory()) {
            System.out.println("Directory : " + file.getName() );
            for (String fileName : file.list()) {
                fileThree2(new File(file.getPath(), fileName));
            }
        } else {
            System.out.println("        " + file.getName());
        }
    }
}
