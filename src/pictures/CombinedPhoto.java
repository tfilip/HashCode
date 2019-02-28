package pictures;

import utils.PhotoType;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class CombinedPhoto extends Photo {

    private int firstId;
    private int secondId;

    public CombinedPhoto(Photo photoA,Photo photoB) {

        super(photoA.getPhotoType(),
                (photoA.getNumberOfTags() + photoB.getNumberOfTags()), photoA.getTags(), -1);

        for(String tag: photoB.getTags()) {
            if(!photoA.getTags().contains(tag)){
                photoA.getTags().add(tag);
            }
        }

        firstId = photoA.getId();
        secondId = photoB.getId();

    }

    @Override
    public String toString() {
        return firstId + " " + secondId +"\n";
    }
}
