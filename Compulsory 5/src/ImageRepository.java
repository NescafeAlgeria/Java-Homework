import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

class ImageRepository {
    private final List<Image> images = new ArrayList<>();

    public void addImage(Image image) throws ImageException {
        if (image == null) {
            throw new ImageException("Cannot add a null image.");
        }
        images.add(image);
    }

    public void displayImage(Image image) throws ImageException {
        if (image == null) {
            throw new ImageException("Image cannot be null.");
        }

        File file = new File(image.filePath());
        if (!file.exists()) {
            throw new ImageException("File not found: " + image.filePath());
        }

        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.open(file);
            } catch (IOException e) {
                throw new ImageException("Error opening file: " + e.getMessage());
            }
        } else {
            throw new ImageException("Desktop operations not supported.");
        }
    }
    public void listImages() {
        for (Image image : images) {
            System.out.println(image);
        }
    }
}
