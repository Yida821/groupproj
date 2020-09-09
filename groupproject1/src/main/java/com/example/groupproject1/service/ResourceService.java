package com.example.groupproject1.service;

import com.example.groupproject1.model.Resource;

import java.util.List;

public interface ResourceService {

    Resource findByResourceName(String resourceName);
    Resource findByResourceCode(int resourceCode);
    Resource saveResource(Resource resource);
    Resource updateResource(Resource resource);
    List<Resource> findAll();
    void deleteByResourceCode(int resourceCode);
}
