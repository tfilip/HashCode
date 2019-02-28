import pictures.CombinedPhoto;
import pictures.Photo;
import utils.Pair;
import utils.Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File(args[0]);
        Pair<ArrayList<Photo>> photos = null;
        try {
            photos = Reader.readPhotos(new Scanner(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Photo> verticalPhotos = photos.getFirstElement();
        ArrayList<Photo> horizontalPhotos = photos.getSecondElement();

        Collections.sort(verticalPhotos, new Comparator<Photo>() {
            @Override
            public int compare(Photo o1, Photo o2) {
                return o2.getNumberOfTags() - o1.getNumberOfTags();
            }
        });

        verticalPhotos.addAll(verticalToHorizontal(horizontalPhotos));

        Collections.sort(horizontalPhotos, new Comparator<Photo>() {
            @Override
            public int compare(Photo o1, Photo o2) {
                return o2.getNumberOfTags() - o1.getNumberOfTags();
            }
        });

    }
    
    public static ArrayList<Photo> verticalToHorizontal(ArrayList<Photo> photos) {
        ArrayList<Photo> rv = new ArrayList<>();
        for (int i = 0; i < photos.size(); i+=2) {
            rv.add(new CombinedPhoto(rv.get(i), rv.get(i + 1)));
        }
        return rv;
    }
}
