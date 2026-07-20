package somaog.QnaApiJ11.FileLoader;

/*
   ez a class ca 60 masodpercenket ellenorzi h volt e a fileokban modositas, es ha igen
   reloadolja oket a memoriaba. a memoriat szinkronizalni kell az iras idejere.
   - read all files in root dir, print msg v. read all files listed in a file
   - add new file : dinamikus menuvaltoztatas :
        polling  : frontend asks for files / names every x sec
        long polling : frontend asks, server holds it open until changes happen
        SSE : open one connection where : server notify's frontend - SSE
        ups n downs : ... , sclae well ? ,

*
*/


import java.io.IOException;
import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.*;

public class FileLoadSchelduer implements Runnable {

    private final Path directory;
    private volatile boolean running = true;

    public FileLoadSchelduer(String directoryPath) {
        this.directory = Paths.get(directoryPath);
    }

    @Override
    public void run() {
        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {

            directory.register(
                    watchService,
                    ENTRY_CREATE,
                    ENTRY_DELETE,
                    ENTRY_MODIFY
            );

            System.out.println("Watching directory: " + directory);

            while (running) {
                WatchKey key = watchService.take(); // Blocks until an event occurs

                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    if (kind == OVERFLOW) {
                        continue;
                    }

                    Path fileName = (Path) event.context();
                    Path fullPath = directory.resolve(fileName);

                    System.out.println(kind.name() + ": " + fullPath);

                    if (kind == ENTRY_MODIFY) {
                        onFileModified(fullPath);
                    }
                }

                boolean valid = key.reset();
                if (!valid) {
                    break;
                }
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void onFileModified(Path file) {
        System.out.println("Modified: " + file);
        // Your custom logic here

//                block variable
//                        read file to mem
//                release var
//                        close file
    }

    public void stop() {
        running = false;
    }
}

//public class Main {
//
//    public static void main(String[] args) {
//
//        DirectoryWatcher watcher = new DirectoryWatcher("C:/temp");
//
//        Thread watcherThread = new Thread(watcher);
//        watcherThread.setDaemon(true); // Runs in background
//        watcherThread.start();
//
//        System.out.println("Application is running...");
//
//        // Your application logic here...
//    }
//}
