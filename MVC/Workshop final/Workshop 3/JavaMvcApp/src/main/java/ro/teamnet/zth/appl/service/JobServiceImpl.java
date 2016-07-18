package ro.teamnet.zth.appl.service;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.dao.JobDao;
import ro.teamnet.zth.appl.domain.Employee;
import ro.teamnet.zth.appl.domain.Job;

import java.util.List;

/**
 * Created by user on 7/18/2016.
 */

public class JobServiceImpl implements  JobService{
    private  final JobDao daoInstance = new JobDao();

    @Override
    public List<Job> findAllJobs() {
        return daoInstance.getAllJobs();
    }

    @Override
    public Job findOneJob(String id) {
      return daoInstance.getJobById(id);
    }

    @Override
    public void deleteOneJob(String id) {
        daoInstance.deleteJob(daoInstance.getJobById(id));
    }

    @Override
    public Job updateJob(Job job) {
        return daoInstance.updateJob(job);
    }

    @Override
    public Job createJob(Job job) {
        return daoInstance.insertJob(job);
    }
}