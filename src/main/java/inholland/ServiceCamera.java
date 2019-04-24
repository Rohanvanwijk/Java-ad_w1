package inholland;


import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceCamera {

    List<ModelCamera> cameras = new ArrayList<ModelCamera>(
            Arrays.asList(
            new ModelCamera("1", "Canon", "1dx"),
            new ModelCamera("2", "Sony", "A7"),
            new ModelCamera("3", "Nikon", "D5")
    ));

    public List<ModelCamera> getCameras() {
        return cameras;
    }

    public ModelCamera getModelCamera(String id) {
        for(ModelCamera camera : cameras) {
            if(camera.getId().equals(id)) {
                return camera;
            }
        }
        return null;
    }

    public void addCamera(ModelCamera camera) {
        cameras.add(camera);
    }
}
