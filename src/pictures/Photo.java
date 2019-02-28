package pictures;

import utils.Pair;
import utils.PhotoType;

import java.util.ArrayList;

public class Photo {

    private int id;
    private PhotoType photoType;
    private int numberOfTags;
    private ArrayList<String> tags;
    private boolean combined;
    private Pair<Integer> ids;

    public Photo(PhotoType photoType, int numberOfTags, ArrayList<String> tags, Integer id) {
        this.photoType = photoType;
        this.numberOfTags = numberOfTags;
        this.tags = tags;
        this.id = id;
        this.combined = false;

    }

    public PhotoType getPhotoType() {
        return photoType;
    }

    public void setIds(Pair<Integer> ids) {
        this.combined = true;
        this.ids = ids;
    }

    public Pair<Integer> getIds() {
        return ids;
    }

    public void setPhotoType(PhotoType photoType) {
        this.photoType = photoType;
    }

    public int getNumberOfTags() {
        return numberOfTags;
    }

    public void setNumberOfTags(int numberOfTags) {
        this.numberOfTags = numberOfTags;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }


}
