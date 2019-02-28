import pictures.Photo;
import utils.Pair;
import utils.Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File(args[0]);
        Pair<LinkedList<Photo>> photos = null;
        try {
            photos = Reader.readPhotos(new Scanner(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        LinkedList<Photo> verticalPhotos = photos.getFirstElement();
        LinkedList<Photo> horizontalPhotos = photos.getSecondElement();
        
    }
}
