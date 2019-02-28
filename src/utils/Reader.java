package utils;

import pictures.Photo;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    public static Pair readPhotos(Scanner s){

        ArrayList<Photo> horizontalPhotos = new ArrayList<>();
        ArrayList<Photo> verticalPhotos = new ArrayList<>();


        int numberOfPhotos = Integer.valueOf(s.nextLine());
        for (int i = 0; i < numberOfPhotos; i++) {
            PhotoType type;
            switch(s.next()) {
                case "H": type = PhotoType.HORIZONTAL;
                           break;
                case "V": type = PhotoType.VERTICAL;
                            break;
                default:  type = PhotoType.HORIZONTAL;
            }
            int numberOfTags = Integer.valueOf(s.next());
            ArrayList<String> tags = new ArrayList<>();
            for (int j = 0; j <numberOfTags; j++) {
                tags.add(s.next());
            }
            s.nextLine();
            switch (type){
                case HORIZONTAL: horizontalPhotos.add(new Photo(PhotoType.HORIZONTAL, numberOfTags, tags, i));
                                break;
                case VERTICAL: verticalPhotos.add(new Photo(PhotoType.VERTICAL, numberOfTags, tags, i));
                                break;
            }

        }
        return new Pair<ArrayList<Photo>>(verticalPhotos, horizontalPhotos);
    }
}
