package org.traccar.web.shared.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gwt.user.client.rpc.IsSerializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

@Entity
@Table(name="application_settings")
public class ApplicationSettings implements IsSerializable {

    private static final long serialVersionUID = 1;
    public static final short DEFAULT_UPDATE_INTERVAL = 15000;
    public static final short DEFAULT_NOTIFICATION_EXPIRATION_PERIOD = 12 * 60;
    public static final String DEFAULT_MATCH_SERVICE_URL = "https://router.project-osrm.org/match";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    @JsonIgnore
    private long id;

    public ApplicationSettings() {
        registrationEnabled = true;
        updateInterval = DEFAULT_UPDATE_INTERVAL;
        defaultPasswordHash = PasswordHashMethod.MD5;
        eventRecordingEnabled = true;
        language = "default";
        notificationExpirationPeriod = DEFAULT_NOTIFICATION_EXPIRATION_PERIOD;
        matchServiceURL = DEFAULT_MATCH_SERVICE_URL;
    }

    private boolean registrationEnabled;

    private Short updateInterval;

    @Enumerated(EnumType.STRING)
    private PasswordHashMethod defaultPasswordHash;

    @Column(nullable = true)
    private boolean disallowDeviceManagementByUsers;

    @Column(nullable = true)
    @JsonIgnore
    private boolean eventRecordingEnabled;

    @Column(nullable = true)
    private int notificationExpirationPeriod;

    public void setRegistrationEnabled(boolean registrationEnabled) {
        this.registrationEnabled = registrationEnabled;
    }

    public boolean getRegistrationEnabled() {
        return registrationEnabled;
    }

    public Short getUpdateInterval() {
        return updateInterval;
    }

    public void setUpdateInterval(Short updateInterval) {
        this.updateInterval = updateInterval;
    }

    public boolean isDisallowDeviceManagementByUsers() {
        return disallowDeviceManagementByUsers;
    }

    public void setDisallowDeviceManagementByUsers(boolean disallowDeviceManagementByUsers) {
        this.disallowDeviceManagementByUsers = disallowDeviceManagementByUsers;
    }

    public PasswordHashMethod getDefaultHashImplementation() {
        return defaultPasswordHash;
    }

    public void setDefaultHashImplementation(PasswordHashMethod hash) {
        this.defaultPasswordHash = hash;
    }

    public boolean isEventRecordingEnabled() {
        return eventRecordingEnabled;
    }

    public void setEventRecordingEnabled(boolean eventRecordingEnabled) {
        this.eventRecordingEnabled = eventRecordingEnabled;
    }

    @JsonIgnore
    private String language;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonIgnore
    private String salt;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @JsonIgnore
    private String bingMapsKey;

    public String getBingMapsKey() {
        return bingMapsKey;
    }

    public void setBingMapsKey(String bingMapsKey) {
        this.bingMapsKey = bingMapsKey;
    }

    public int getNotificationExpirationPeriod() {
        return notificationExpirationPeriod;
    }

    public void setNotificationExpirationPeriod(int notificationExpirationPeriod) {
        this.notificationExpirationPeriod = notificationExpirationPeriod;
    }

    private String matchServiceURL;

    public String getMatchServiceURL() {
        return matchServiceURL;
    }

    public void setMatchServiceURL(String matchServiceURL) {
        this.matchServiceURL = matchServiceURL;
    }

    @Column(nullable = true)
    private boolean allowCommandsOnlyForAdmins;

    public boolean isAllowCommandsOnlyForAdmins() {
        return allowCommandsOnlyForAdmins;
    }

    public void setAllowCommandsOnlyForAdmins(boolean allowCommandsOnlyForAdmins) {
        this.allowCommandsOnlyForAdmins = allowCommandsOnlyForAdmins;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ApplicationSettings)) {
            return false;
        }

        ApplicationSettings other = (ApplicationSettings) object;
        
        return this.id == other.id;
    }
}
