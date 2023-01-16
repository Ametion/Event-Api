package com.worlds_events_api.worldseventsapi.tags;

import com.worlds_events_api.worldseventsapi.tags.requests.AddTagRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tag")
public class TagsController {
    private final TagsService tagsService;

    @Autowired
    public TagsController(TagsService tagsService) {
        this.tagsService = tagsService;
    }

    @GetMapping
    public ResponseEntity GetAllTags(){
        try{
            return ResponseEntity.ok(tagsService.GetAllTags());
        }catch(Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity AddTag(@RequestBody AddTagRequest addTagRequest){
        try{
            return ResponseEntity.ok(tagsService.AddTag(addTagRequest));
        }catch(Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
