package ai.beans;

import java.util.Date;

public class SessionTrackerBean {

    private String ip;
    private Date lastAccess;

    public SessionTrackerBean() {
    }

    public String getIp() {
        return ip;
    }

    public Date getLastAccess() {
        return lastAccess;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setLastAccess(Date lastAccess) {
        this.lastAccess = lastAccess;
    }
}
