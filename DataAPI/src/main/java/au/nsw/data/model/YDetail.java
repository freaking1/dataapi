/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.nsw.data.model;

import java.io.Serializable;

/**
 *
 * @author frank
 */
public class YDetail implements Serializable {
    
    private int y_id;
    private String y_type;
    private String y_name;
    private String y_description;
    private String y_address;
    private String y_suburb;
    private String y_state;
    private String y_postcode;
    private String y_phonenumber;
    private String y_email;
    private String y_website;
    private String y_latitude;
    private String y_longitude;
    private String y_sporttype;

    public YDetail() {
        this.y_sporttype = "";
    }

    public YDetail(String y_type, String y_name, String y_description, String y_address, String y_suburb, String y_state, String y_postcode, String y_phonenumber, String y_email, String y_website, String y_latitude, String y_longitude, String y_sporttype) {
        this.y_type = y_type;
        this.y_name = y_name;
        this.y_description = y_description;
        this.y_address = y_address;
        this.y_suburb = y_suburb;
        this.y_state = y_state;
        this.y_postcode = y_postcode;
        this.y_phonenumber = y_phonenumber;
        this.y_email = y_email;
        this.y_website = y_website;
        this.y_latitude = y_latitude;
        this.y_longitude = y_longitude;
        this.y_sporttype = y_sporttype;
    }

    public String getY_address() {
        return y_address;
    }

    public void setY_address(String y_address) {
        this.y_address = y_address;
    }

    public String getY_description() {
        return y_description;
    }

    public void setY_description(String y_description) {
        this.y_description = y_description;
    }

    public String getY_email() {
        return y_email;
    }

    public void setY_email(String y_email) {
        this.y_email = y_email;
    }

    public String getY_latitude() {
        return y_latitude;
    }

    public void setY_latitude(String y_latitude) {
        this.y_latitude = y_latitude;
    }

    public String getY_longitude() {
        return y_longitude;
    }

    public void setY_longitude(String y_longitude) {
        this.y_longitude = y_longitude;
    }

    public String getY_name() {
        return y_name;
    }

    public void setY_name(String y_name) {
        this.y_name = y_name;
    }

    public String getY_phonenumber() {
        return y_phonenumber;
    }

    public void setY_phonenumber(String y_phonenumber) {
        this.y_phonenumber = y_phonenumber;
    }

    public String getY_postcode() {
        return y_postcode;
    }

    public void setY_postcode(String y_postcode) {
        this.y_postcode = y_postcode;
    }

    public String getY_sporttype() {
        return y_sporttype;
    }

    public void setY_sporttype(String y_sporttype) {
        this.y_sporttype = y_sporttype;
    }

    public String getY_state() {
        return y_state;
    }

    public void setY_state(String y_state) {
        this.y_state = y_state;
    }

    public String getY_suburb() {
        return y_suburb;
    }

    public void setY_suburb(String y_suburb) {
        this.y_suburb = y_suburb;
    }

    public String getY_type() {
        return y_type;
    }

    public void setY_type(String y_type) {
        this.y_type = y_type;
    }

    public String getY_website() {
        return y_website;
    }

    public void setY_website(String y_website) {
        this.y_website = y_website;
    }

    public int getY_id() {
        return y_id;
    }

    public void setY_id(int y_id) {
        this.y_id = y_id;
    }
    
}
