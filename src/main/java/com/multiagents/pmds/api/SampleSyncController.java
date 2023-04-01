package com.multiagents.pmds.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.multiagents.pmds.models.SampleSync;
import com.multiagents.pmds.repository.SampleSyncRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class SampleSyncController {

    @Autowired
    SampleSyncRepository sampleSyncRepository;

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(SampleSyncController.class);

    @PostMapping("/sync-sample")
    public void syncSample(@Valid @RequestBody String jsonSample) {
        logger.info("Syncing sample: " + jsonSample);
        Gson gson = new Gson();
        Type listType = new TypeToken<List<SampleSync>>(){}.getType();
        List<SampleSync> samples = gson.fromJson(jsonSample, listType);

        sampleSyncRepository.saveAll(samples);
    }

}
