package io.agileintelligence.ppmtool.services;

import io.agileintelligence.ppmtool.domain.Project;
import io.agileintelligence.ppmtool.exception.ProjectIdException;
import io.agileintelligence.ppmtool.repositories.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {



    @Autowired
    private ProjectRepo projectRepo ;

    public Project saveOrUpdateProject(Project project){
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepo.save(project);
        }catch( Exception e){
            throw new ProjectIdException("Project ID '"+project.getProjectIdentifier().toUpperCase()+"' Already Exists");
        }
    }

    public Project findByProjectId( String projectId){

        Project project = projectRepo.findByProjectIdentifier(projectId.toUpperCase());

        if(project==null)
            throw new ProjectIdException("project ID '"+projectId+"' doesnt exists");

        return project;
    }

    public Iterable<Project> findAllProjects(){
        return projectRepo.findAll();
    }

    public void deleteByProjectId(String projectId) {
        Project project = projectRepo.findByProjectIdentifier(projectId.toUpperCase());

        if(project==null)
            throw new ProjectIdException("project ID '"+projectId+"' doesnt exists");

        projectRepo.delete(project);
    }
}
