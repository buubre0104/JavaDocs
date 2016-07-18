package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.api.annotations.MyRequestObject;
import ro.teamnet.zth.api.annotations.MyRequestParam;
import ro.teamnet.zth.appl.domain.Job;
import ro.teamnet.zth.appl.service.JobService;
import ro.teamnet.zth.appl.service.JobServiceImpl;

import java.util.List;

/**
 * Created by user on 7/15/2016.
 */
@MyController(urlPath = "/jobs")
public class JobController {
    private final JobService instance = new JobServiceImpl();

    @MyRequestMethod(urlPath = "/all")
    public List<Job> getAllJobs(){
        return instance.findAllJobs();
    }

    @MyRequestMethod(urlPath = "/one")
    public Job getOneJob(@MyRequestParam(name="id")String id){
        return instance.findOneJob(id);
    }

    @MyRequestMethod(urlPath = "/delete", methodType = "DELETE")
    public void deleteOneJob(@MyRequestParam(name="id")String id){
        instance.deleteOneJob(id);
    }
    @MyRequestMethod(urlPath = "/edit", methodType = "PUT")
    public Job updateJob(@MyRequestObject Job job){
        return instance.updateJob(job);
    }


    @MyRequestMethod(urlPath = "/create", methodType = "POST")
    public Job createJob(@MyRequestObject Job job) {
        return instance.createJob(job);
    }
}
