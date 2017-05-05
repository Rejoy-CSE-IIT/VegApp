package com.geometry.vegapp.j_project_core.b_seed_section.a_recycler_view_seed_options;


public class d_recycler_view_seed_options_datamodel_class
{


    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public String getAuth() {
        return Auth;
    }

    public void setAuth(String auth) {
        Auth = auth;
    }

    public d_recycler_view_seed_options_datamodel_class(String optionName, String auth) {
        this.optionName = optionName;
        Auth = auth;
    }

    String optionName;
    String Auth;




}
