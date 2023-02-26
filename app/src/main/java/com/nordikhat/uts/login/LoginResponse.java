package com.nordikhat.uts.login;

public class LoginResponse {
    private MetadataResponse[] metadata;
    private String name;
    private String email;

    public MetadataResponse[] getMetadata() { return metadata; }
    public void setMetadata(MetadataResponse[] value) { this.metadata = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getEmail() { return email; }
    public void setEmail(String value) { this.email = value; }
}
