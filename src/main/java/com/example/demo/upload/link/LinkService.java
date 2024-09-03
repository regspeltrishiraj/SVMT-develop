package com.example.demo.upload.link;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;

    public List<Link> getDisplayedLinks() {
        return linkRepository.findByIsDisplayedTrue();
    }

    public Link saveLink(Link link) {
        return linkRepository.save(link);
    }

    public void deleteLink(Long id) {
        linkRepository.deleteById(id);
    }
}
