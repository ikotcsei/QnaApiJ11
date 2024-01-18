package somaog.QnaApiJ11.FileLoader;


import java.io.File;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
*   class for loading repository xml files dynamically
*
* */
public class FileLoader {
    public static void main(String[] args) {
        Runnable drawRunnable = new Runnable() {
            public void run() {
                printMsg();
                Set<String> myS = listFilesUsingJavaIO("C:\\Users\\ikotc");
                System.out.println(myS.toString());
            }
        };

        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
        exec.scheduleAtFixedRate(drawRunnable , 0, 1, TimeUnit.SECONDS);
    }



    public static Set<String> listFilesUsingJavaIO(String dir) {
        return Stream.of(new File(dir).listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());
    }

//    public static File findUsingIOApi(String sdir) {
//        File dir = new File(sdir);
//        if (dir.isDirectory()) {
//            Optional<File> opFile = Arrays.stream(dir.listFiles(File::isFile))
//                    .max((f1, f2) -> Long.compare(f1.lastModified(), f2.lastModified()));
//
//            if (opFile.isPresent()){
//                return opFile.get();
//            }
//        }
//
//        return null;
//    }

    public static void printMsg(){
        System.out.println("hello world.");
    }
}
