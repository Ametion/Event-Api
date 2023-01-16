package com.worlds_events_api.worldseventsapi.tags;

import com.worlds_events_api.worldseventsapi.database.entities.Tag;
import com.worlds_events_api.worldseventsapi.database.repositories.ITagsRepo;
import com.worlds_events_api.worldseventsapi.tags.requests.AddTagRequest;
import com.worlds_events_api.worldseventsapi.tags.responses.TagResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TagsService {
    private final ITagsRepo tagsRepo;

    @Autowired
    public TagsService(ITagsRepo tagsRepo) {
        this.tagsRepo = tagsRepo;
    }

    public ArrayList<TagResponse> GetAllTags() throws Exception {
        try{
            var arr = new ArrayList<TagResponse>();

            var tags = tagsRepo.findAll();

            tags.forEach(t -> arr.add(new TagResponse(t.getId(), t.getTag())));

            return arr;
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

    public boolean AddTag(AddTagRequest addTagRequest) throws Exception {
        try{
            var tag = new Tag(addTagRequest.tag);

            tagsRepo.save(tag);

            return true;
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }
}
