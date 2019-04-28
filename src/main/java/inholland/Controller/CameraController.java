package inholland.Controller;


import inholland.Model.Camera;
import inholland.Service.CamerashopService;
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

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Camera> getAllCameras() {
        return service.getCameras();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Camera getCameraById(@PathVariable("id") int id) {
        return service.getCameraById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCamera(@RequestBody Camera camera) {
        service.addCamera(camera);
    }
}
