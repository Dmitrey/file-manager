import java.io.File;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        //String separator = System.getProperty("file.separator");
        URL location = Main.class.getProtectionDomain().getCodeSource().getLocation();
        String path = location.toString();
        if(System.getProperty("os.name").equals("Linux"))
            path = path.replace("file:","").replace("filec.jar",""); // для линукса
        else
            path = path.replace("file:/","").replace("filec.jar","");  //для винды
        File file = new File(path);
        System.out.println("FILE OR DIRECTORY EXISTS: " + file.exists()+"\n");
        if(file.exists() && file.isDirectory()) {
            System.out.println("FILES AMOUNT: " + countFiles(file));//включает в себя сам jar файл программы)))
        }
    }

    public static long countFiles(File file){
        long files_count = 0;
        File[] arr = file.listFiles();
        for (File f:arr){
            if(f.isDirectory())
                files_count += countFiles(f);
            else files_count++;
        }
        return files_count;
    }
}