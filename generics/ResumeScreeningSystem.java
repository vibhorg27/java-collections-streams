package com.bridgelabz.generics;


import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String candidateName;
    private int experienceYears;

    public JobRole(String candidateName, int experienceYears) {
        this.candidateName = candidateName;
        this.experienceYears = experienceYears;
    }

    public String getCandidateName() { return candidateName; }
    public int getExperienceYears() { return experienceYears; }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " Applicant: " + candidateName + ", Experience: " + experienceYears + " years";
    }
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }
}

class Resume<T extends JobRole> {
    private List<T> resumes = new ArrayList<>();

    public void addResume(T resume) {
        resumes.add(resume);
    }

    public List<T> getResumes() {
        return resumes;
    }
}

class ResumeProcessor {
    public static <T extends JobRole> void processResume(Resume<T> resume) {
        System.out.println("Processing Resumes:");
        for (T r : resume.getResumes()) {
            System.out.println(r);
        }
    }

    public static void processMultipleResumes(List<? extends JobRole> resumes) {
        System.out.println("Batch Processing Multiple Resumes:");
        for (JobRole resume : resumes) {
            System.out.println(resume);
        }
    }
}

public class ResumeScreeningSystem {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> softwareResumes = new Resume<>();
        Resume<DataScientist> dataResumes = new Resume<>();
        Resume<ProductManager> productResumes = new Resume<>();

        softwareResumes.addResume(new SoftwareEngineer("Vibhor", 5));
        softwareResumes.addResume(new SoftwareEngineer("Shreyas", 8));

        dataResumes.addResume(new DataScientist("Mayank", 3));
        dataResumes.addResume(new DataScientist("Kanika", 6));

        productResumes.addResume(new ProductManager("Leon", 7));
        productResumes.addResume(new ProductManager("Asmit", 10));

        System.out.println("Individual Resume Processing:");
        ResumeProcessor.processResume(softwareResumes);
        ResumeProcessor.processResume(dataResumes);
        ResumeProcessor.processResume(productResumes);

        List<JobRole> allResumes = new ArrayList<>();
        allResumes.add(new SoftwareEngineer("Amir", 4));
        allResumes.add(new DataScientist("Faizal", 5));
        allResumes.add(new ProductManager("Chirag", 9));

        System.out.println("\nBatch Resume Processing:");
        ResumeProcessor.processMultipleResumes(allResumes);
    }
}

