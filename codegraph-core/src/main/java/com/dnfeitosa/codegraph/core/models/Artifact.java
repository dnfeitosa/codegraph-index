package com.dnfeitosa.codegraph.core.models;

import java.util.ArrayList;
import java.util.List;

public class Artifact {

    private Long id;

    private String name;
    private Version version;
    private String organization;
    private String type;
    private String extension;

    private List<Artifact> dependencies = new ArrayList<>();

    public Artifact(String name, String organization, Version version, String type, String extension) {
        this(null, name, organization, version, type, extension);
    }

    public Artifact(Long id, String name, String organization, Version version, String type, String extension) {
        this.id = id;
        this.name = name;
        this.organization = organization;
        this.version = version;
        this.type = type;
        this.extension = extension;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Version getVersion() {
        return version;
    }

    public String getOrganization() {
        return organization;
    }

    public String getType() {
        return type;
    }

    public String getExtension() {
        return extension;
    }

    public void addDependency(Artifact artifact) {
        this.dependencies.add(artifact);
    }

    public List<Artifact> getDependencies() {
        return dependencies;
    }
}
