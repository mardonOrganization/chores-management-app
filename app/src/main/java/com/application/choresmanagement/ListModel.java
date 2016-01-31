package com.application.choresmanagement;

/**
 * Created by A27J on 25/08/2015.
 */
public class ListModel {

    private  String companyName ="";
    private  String Image="";
    private  String Url="";

    /*********** Set Methods ******************/

    public void setCompanyName(String CompanyName)
    {
        this.companyName = CompanyName;
    }

    public void setImage(String Image)
    {
        this.Image = Image;
    }

    public void setUrl(String Url)
    {
        this.Url = Url;
    }

    /*********** Get Methods ****************/

    public String getCompanyName()
    {
        return this.companyName;
    }

    public String getImage()
    {
        return this.Image;
    }

    public String getUrl()
    {
        return this.Url;
    }
}
