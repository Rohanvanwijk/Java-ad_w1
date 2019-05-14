package inholland.Controller;


import inholland.Model.Camera;
import inholland.Service.CamerashopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cameras")
public class CameraController {

    private CamerashopService service;

    public CameraController(CamerashopService service) {
        this.service = service;
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Camera> getAllCameras(
            @RequestParam(required = false) boolean sorted,
            @RequestParam(required = false, defaultValue = "0") int minimum,
            @RequestParam(required = false, defaultValue = "" + Integer.MAX_VALUE) int maximum
    ) {
        return service.getCameras(sorted, minimum, maximum);
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Camera getCameraById(@PathVariable("id") int id) {
        return service.getCameraById(id);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void addCamera(@RequestBody Camera camera) {
        service.addCamera(camera);
    }

    @GetMapping(value = "brand/{brand}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Camera> getCameraByBrand(@PathVariable("brand") String brand) {
        return service.getCamerasByBrand(brand);
    }

    @DeleteMapping(value = "remove/{id}")
    public void removeCameraById(@PathVariable("id") int id) {
        service.removeCameraById(id);
    }

    @PutMapping(value = "{id}")
    public String updateCameraById(@PathVariable("id") int id, @RequestBody Camera camera) {
        service.updateCameraById(id, camera);
        return "Updated: cam id " + id;
    }

}
