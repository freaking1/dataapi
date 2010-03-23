/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.nsw.data.action;

import au.nsw.data.dao.NSWDataSourceServiceDao;
import au.nsw.data.dao.NSWToiletDataSourceServiceDao;
import au.nsw.data.model.YDetail;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author frank
 */
public class TransormerAction extends ActionSupport implements ServletRequestAware, SessionAware {

    private HttpServletRequest request;
    private Map session;
    private NSWDataSourceServiceDao ndsdao;
    private NSWToiletDataSourceServiceDao ntsdao;
    private String suburb;
    private String type;
    private String postcode;

    @Override
    public String execute() {

        List<YDetail> finalList = new ArrayList<YDetail>();

        if (type.equalsIgnoreCase("park")) {
            List<YDetail> list = null;
            if (postcode.equalsIgnoreCase("")) {
                list = ndsdao.PClient().findParksBySuburb(suburb);
            } else {
                list = ndsdao.PClient().findParksByPostcode(postcode);
            }
            if (list != null && list.size() != 0) {
                finalList.addAll(list);
            }
        } else if (type.equalsIgnoreCase("aquarium")) {
            List<YDetail> list = null;
            if (postcode.equalsIgnoreCase("")) {
                list = ndsdao.AClient().findAquariumsBySuburb(suburb);
            } else {
                list = ndsdao.AClient().findAquariumsByPostcode(postcode);
            }
            if (list != null && list.size() != 0) {
                finalList.addAll(list);
            }
        } else if (type.equalsIgnoreCase("toilet")) {
            List<YDetail> list = null;
            if (postcode.equalsIgnoreCase("")) {
                try {
                    list = ntsdao.NClient().findToiletsBySuburb(suburb);
                } catch (Throwable ex) {
                    ex.printStackTrace();
                    list = null;
                }
            } else {
                try {
                    list = ntsdao.NClient().findToiletsByPostcode(postcode);
                } catch (Throwable ex) {
                    ex.printStackTrace();
                    list = null;
                }
            }
            if (list != null && list.size() != 0) {
                finalList.addAll(list);
            }
        } else if (type.equalsIgnoreCase("restaurant")) {
            List<YDetail> list = null;
            if (postcode.equalsIgnoreCase("")) {
                list = ndsdao.RClient().findRestaurantsBySuburb(suburb);
            } else {
                list = ndsdao.RClient().findRestaurantsByPostcode(postcode);
            }
            if (list != null && list.size() != 0) {
                finalList.addAll(list);
            }
        } else if (type.equalsIgnoreCase("sport")) {
            List<YDetail> list = null;
            if (postcode.equalsIgnoreCase("")) {
                list = ndsdao.SPClient().finsSportsBySuburb(suburb);
            } else {
                list = ndsdao.SPClient().findSportsByPostcode(postcode);
            }
            if (list != null && list.size() != 0) {
                finalList.addAll(list);
            }
        } else if (type.equalsIgnoreCase("supermarket")) {
            List<YDetail> list = null;
            if (postcode.equalsIgnoreCase("")) {
                list = ndsdao.SMClient().findShoopingCentersBySuburb(suburb);
            } else {
                list = ndsdao.SMClient().findShoopingCentersByPostcode(postcode);
            }
            if (list != null && list.size() != 0) {
                finalList.addAll(list);
            }
        } else if (type.equalsIgnoreCase("museum")) {
            List<YDetail> list = null;
            if (postcode.equalsIgnoreCase("")) {
                list = ndsdao.MClient().findMuseumsBySuburb(suburb);
            } else {
                list = ndsdao.MClient().findMuseumsByPostcode(postcode);
            }
            if (list != null && list.size() != 0) {
                finalList.addAll(list);
            }
        }

        if (finalList.size() == 0) {
            return Action.ERROR;
        } else {
            JSONArray results = new JSONArray();
            for (YDetail detail : finalList) {
                //System.out.println("result: " + detail.getY_name());
                results.add(detail);
            }
            // wrap the results to a json data
            JSONObject rspJSON = new JSONObject();
            try {
                rspJSON.put("results", results);
            } catch (Exception e) {
                //what we shoud do???
                System.out.println("Exception ririririri: ");
                e.printStackTrace();
            }
            session.put("result", rspJSON);
            session.put("type", type);
            return Action.SUCCESS;
        }
    }

    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;

    }

    public NSWDataSourceServiceDao getNdsdao() {
        return ndsdao;
    }

    public void setNdsdao(NSWDataSourceServiceDao ndsdao) {
        this.ndsdao = ndsdao;
    }

    public NSWToiletDataSourceServiceDao getNtsdao() {
        return ntsdao;
    }

    public void setNtsdao(NSWToiletDataSourceServiceDao ntsdao) {
        this.ntsdao = ntsdao;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public Map getSession() {
        return session;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
