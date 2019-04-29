package inholland.Service;

import inholland.Model.Camera;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;

@Service
public class CamerashopService {
    List<Camera> cameras = new ArrayList<Camera>(
            Arrays.asList(
                    new Camera(1, "Canon", "1Dx mk2", 5299.00, 40),
                    new Camera(2, "Nikon", "D5", 5999.00, 20),
                    new Camera(3, "Sony", "a9", 5999.00, 23),
                    new Camera(4, "Canon", "400D", 90.44,65),
                    new Camera(5, "Nikon", "D3400", 449.00, 3),
                    new Camera(6, "Sony", "a6300", 709.00, 9)
            )

    );

    public List<Camera> getCameras(boolean sorted, int minimum, int maximum) {
        Stream<Camera> cameraStream = cameras.stream().filter(m -> m.getPrice() >= minimum && m.getPrice() <= maximum);

        if(sorted) {
            cameraStream = cameraStream.sorted(Comparator.comparingDouble(Camera::getPrice));
        }

        return cameraStream.collect(Collectors.toList());
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

    public void removeCameraById(int id) {
        Optional<Camera> op = cameras.stream().filter(x -> x.getId() == id).findFirst();
        Camera cam = op.get();
        cameras.remove(cam);
    }

    public List<Camera> getCamerasByBrand(String brand) {
        Stream<Camera> cameraStream = cameras.stream().filter(camera -> camera.getBrand().equals(brand));
        return cameraStream.sorted(Comparator.comparingInt(Camera::getAmount).reversed()).collect(Collectors.toList());
    }

    public void updateCameraById(int id, Camera camera) {
        Camera camera1 = getCameraById(id);
        camera1.setAmount(camera.getAmount());
        camera1.setBrand(camera.getBrand());
        camera1.setModel(camera.getModel());
        camera1.setPrice(camera.getPrice());
    }
}
