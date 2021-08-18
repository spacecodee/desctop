package utils;

import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Images {
    private static final String URL_MAIN = "src/main/resources/assets/img/";

    public static void addImg(String url, ImageView btn) {
        try {
            File fileImgFondo = new File(Images.URL_MAIN + url);
            Image imgFondo = new Image(fileImgFondo.toURI().toString());
            btn.setImage(imgFondo);
        } catch (Exception ex) {
            System.out.println("I'm Sorry, an current error, not image\n");
            ex.printStackTrace(System.out);
        }
    }

    public static void borderRadiusImgProfile(ImageView imageView) {
        Rectangle clip = new Rectangle(
                imageView.getFitWidth(), imageView.getFitHeight()
        );
        clip.setArcWidth(150);
        clip.setArcHeight(150);
        imageView.setClip(clip);

        // snapshot the rounded image.
        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);
        WritableImage image = imageView.snapshot(parameters, null);

        // remove the rounding clip so that our effect can show through.
        imageView.setClip(null);

        // store the rounded image in the imageView.
        imageView.setImage(image);
    }
}
