import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ImageRepository repository = new ImageRepository();

        try {
            // Adding sample images
            Image img1 = new Image("A", LocalDate.now(), "C:/Images/A.png");
            Image img2 = new Image("B", LocalDate.now(), "C:/Images/B.jpg");

            repository.addImage(img1);
            repository.addImage(img2);

            // Listing images
            repository.listImages();

            // Displaying an image
            repository.displayImage(img1);
        } catch (ImageException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}