package com.nordikhat.uts.services.login;

public class LoginResponse {
    private Metadatum[] metadata;
    private Object name;
    private Object email;

    public Metadatum[] getMetadata() { return metadata; }
    public void setMetadata(Metadatum[] value) { this.metadata = value; }

    public Object getName() { return name; }
    public void setName(Object value) { this.name = value; }

    public Object getEmail() { return email; }
    public void setEmail(Object value) { this.email = value; }
}
