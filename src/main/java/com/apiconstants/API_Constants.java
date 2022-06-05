package com.apiconstants;

public enum API_Constants {

    BASE_URL("https://api.predic8.de:443"),
    CATEGORIES("/shop/categories/"),
    CREATE_USER("/shop/customers/");
    private String appconstant;
    public String getValue(){
        return this.appconstant;
    }
    API_Constants(String appconstant) {
        this.appconstant = appconstant;
    }
}
