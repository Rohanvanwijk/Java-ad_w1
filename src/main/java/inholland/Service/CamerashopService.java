package inholland.Service;

import inholland.Model.Camera;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CamerashopService {
    List<Camera> cameras = new ArrayList<Camera>(
            Arrays.asList(
                    new Camera(1, "Canon", "1Dx mk2"),
                    new Camera(2, "Nikon", "D5"),
                    new Camera(3, "Sony", "a9")
            )

    );

    public List<Camera> getCameras() {
        return cameras;
    }

    public Camera getCameraById(int id) {
        for (Camera camera : cameras
             ) {
            if(camera.getId() == id) {
                return camera;
            }
        }
        return null;
    }

    public void addCamera(Camera camera) {
        cameras.add(camera);
    }

    public void removeCamera(Camera camera) {
        cameras.remove(camera);
    }
}
