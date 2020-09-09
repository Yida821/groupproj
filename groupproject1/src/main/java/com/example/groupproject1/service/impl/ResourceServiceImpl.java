package com.example.groupproject1.service.impl;

import com.example.groupproject1.dao.ResourceRepository;
import com.example.groupproject1.model.Resource;
import com.example.groupproject1.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public Resource findByResourceName(String resourceName){
        return resourceRepository.findByResourceName(resourceName);
    }

    @Override
    public Resource findByResourceCode(int resource_code) {
        return resourceRepository.findByResourceCode(resource_code);

    }

   @Override
    public void deleteByResourceCode(int resourceCode){
        resourceRepository.deleteByResourceCode(resourceCode);
    }

    @Override
    public Resource saveResource(Resource resource) {
        return resourceRepository.save(resource);

    }

    @Override
    public Resource updateResource(Resource resource) {
        return resourceRepository.save(resource);
    }
    @Override
    public List<Resource> findAll() {
        return resourceRepository.findAll();
    }
}
