
package com.example.week4_day1_hw.model.gitprofile;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RepoObject implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("owner")
    @Expose
    private Owner owner;
    @SerializedName("html_url")
    @Expose
    private String htmlUrl;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("language")
    @Expose
    private String language;
    public final static Creator<RepoObject> CREATOR = new Creator<RepoObject>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RepoObject createFromParcel(Parcel in) {
            return new RepoObject(in);
        }

        public RepoObject[] newArray(int size) {
            return (new RepoObject[size]);
        }

    }
    ;

    protected RepoObject(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.fullName = ((String) in.readValue((String.class.getClassLoader())));
        this.owner = ((Owner) in.readValue((Owner.class.getClassLoader())));
        this.htmlUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((Object) in.readValue((Object.class.getClassLoader())));
        this.language = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public RepoObject() {
    }

    /**
     * 
     * @param htmlUrl
     * @param description
     * @param name
     * @param owner
     * @param language
     * @param fullName
     */
    public RepoObject(String name, String fullName, Owner owner, String htmlUrl, Object description, String language) {
        super();
        this.name = name;
        this.fullName = fullName;
        this.owner = owner;
        this.htmlUrl = htmlUrl;
        this.description = description;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(fullName);
        dest.writeValue(owner);
        dest.writeValue(htmlUrl);
        dest.writeValue(description);
        dest.writeValue(language);
    }

    public int describeContents() {
        return  0;
    }

}
