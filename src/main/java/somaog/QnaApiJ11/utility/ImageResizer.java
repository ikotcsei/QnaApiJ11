package somaog.QnaApiJ11.utility;

import org.imgscalr.Scalr;
import org.springframework.core.io.FileSystemResource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class ImageResizer {
    public static void main(String[] args) throws IOException {
//        resizeImage(new File("E:\\IdeaProjects\\QnaApiJ11\\react_basic.png"), Path.of(""),800,600);
        try{
            File inputFile = new File(new FileSystemResource("").getFile().getAbsolutePath()+"\\src\\main\\resources\\static\\caching.jpg");
            String outPutPath = new FileSystemResource("").getFile().getAbsolutePath()+"\\src\\main\\resources\\static\\caching_out.jpg";
            resizeImage(inputFile, Path.of(outPutPath),1024,768);
//            System.out.println(new FileSystemResource("").getFile().getAbsolutePath()+"\\src\\main\\resources\\static\\caching.jpg");
        }catch (Exception e){

        }
    }
    public static void resizeImage(File inputFile, Path outputPath, int width, int height) throws IOException {
        BufferedImage originalImage = ImageIO.read(inputFile);
        BufferedImage resizedImage = Scalr.resize(originalImage, Scalr.Method.QUALITY, width, height);
        ImageIO.write(resizedImage, "jpg", outputPath.toFile());
    }
}

