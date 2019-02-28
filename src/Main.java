import pictures.CombinedPhoto;
import pictures.Photo;
import utils.Pair;
import utils.Reader;
import utils.Writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

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

        horizontalPhotos.addAll(verticalToHorizontal(verticalPhotos));

        Collections.sort(horizontalPhotos, new Comparator<Photo>() {
            @Override
            public int compare(Photo o1, Photo o2) {
                return o2.getNumberOfTags() - o1.getNumberOfTags();
            }
        });




        try {
            Writer.writeToFile(new PrintStream(new File("out_" + args[0])), solutionOne(horizontalPhotos));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
    
    public static ArrayList<Photo> verticalToHorizontal(ArrayList<Photo> photos) {
        ArrayList<Photo> rv = new ArrayList<>();
        for (int i = 0; i < photos.size(); i+=2) {
            rv.add(new CombinedPhoto(photos.get(i), photos.get(i + 1)));
        }
        return rv;
    }


    public static ArrayList<Photo> solutionOne(ArrayList<Photo> photos){
        //ArrayList<Photo> rv = new ArrayList<>();
        for (int i = 0; i < photos.size() - 3; i++) {
            //for (int j = i+1; j < photos.size() - 1; j++) {
                float commonTags = photos.get(i)
                        .getCommonNoOfTags(photos.get(i+1));
//                float minNumberOfTags = photos.get(i)
//                        .getMinNumberOfTags(photos.get(i+1));

            float commonTags2 = photos.get(i)
                    .getCommonNoOfTags(photos.get(i+2));
//            float minNumberOfTags2 = photos.get(i)
//                    .getMinNumberOfTags(photos.get(i+2));

                if (commonTags2 > commonTags) {

                    Photo aux = photos.get(i+1);
                    photos.set(i+1, photos.get(i+2));
                    photos.set(i+2, aux);


                }


//                if (0 <= commonTags && commonTags < 3/4 * minNumberOfTags) {
//                    Photo aux = photos.get(i+1);
//                    photos.set(i+1, photos.get(j));
//                    photos.set(j, aux);
//                    break;
//                }

            }

        return photos;
    }
//
//    public static ArrayList<Photo> solutionHash(ArrayList<Photo> photos){
//        ArrayList<Photo> rv = new ArrayList<>();
//        HashMap<String, List<Photo>> photosHashMap = new HashMap<>();
//        for(Photo photo: photos){
//            for(String tag:  photo.getTags())
//        }
//        for(String tag: photos.keySet()){
//            rv.add(photos.get(tag));
//        }
//
//        return rv;
//    }


}
