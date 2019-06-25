
package com.example.week4_day1_hw.model.gitprofile;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileGit implements Parcelable
{

    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("html_url")
    @Expose
    private String htmlUrl;
    @SerializedName("repos_url")
    @Expose
    private String reposUrl;
    @SerializedName("events_url")
    @Expose
    private String eventsUrl;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("bio")
    @Expose
    private String bio;
    @SerializedName("public_repos")
    @Expose
    private Integer publicRepos;
    public final static Creator<ProfileGit> CREATOR = new Creator<ProfileGit>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ProfileGit createFromParcel(Parcel in) {
            return new ProfileGit(in);
        }

        public ProfileGit[] newArray(int size) {
            return (new ProfileGit[size]);
        }

    }
    ;

    protected ProfileGit(Parcel in) {
        this.login = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.htmlUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.reposUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.eventsUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.company = ((String) in.readValue((String.class.getClassLoader())));
        this.location = ((String) in.readValue((String.class.getClassLoader())));
        this.bio = ((String) in.readValue((String.class.getClassLoader())));
        this.publicRepos = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public ProfileGit() {
    }

    /**
     * 
     * @param id
     * @param eventsUrl
     * @param reposUrl
     * @param htmlUrl
     * @param bio
     * @param location
     * @param company
     * @param login
     * @param publicRepos
     * @param url
     */
    public ProfileGit(String login, Integer id, String url, String htmlUrl, String reposUrl, String eventsUrl, String company, String location, String bio, Integer publicRepos) {
        super();
        this.login = login;
        this.id = id;
        this.url = url;
        this.htmlUrl = htmlUrl;
        this.reposUrl = reposUrl;
        this.eventsUrl = eventsUrl;
        this.company = company;
        this.location = location;
        this.bio = bio;
        this.publicRepos = publicRepos;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getReposUrl() {
        return reposUrl;
    }

    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Integer getPublicRepos() {
        return publicRepos;
    }

    public void setPublicRepos(Integer publicRepos) {
        this.publicRepos = publicRepos;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(login);
        dest.writeValue(id);
        dest.writeValue(url);
        dest.writeValue(htmlUrl);
        dest.writeValue(reposUrl);
        dest.writeValue(eventsUrl);
        dest.writeValue(company);
        dest.writeValue(location);
        dest.writeValue(bio);
        dest.writeValue(publicRepos);
    }

    public int describeContents() {
        return  0;
    }

}
