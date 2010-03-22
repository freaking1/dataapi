/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.nsw.data.ws.client;

import au.nsw.data.model.YDetail;
import au.nsw.data.ws.restaurant.RestaurantDataService;
import java.util.List;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

/**
 *
 * @author mingyiwang
 */
public class RestaurantServiceClient implements DataSourceClient {

    public static RestaurantServiceClient newInstance() {
        return new RestaurantServiceClient();
    }

    public List<YDetail> findRestaurantsBySuburbAndPostcode(String suburb, String postcode) {

        long timeout = Timeout.timeout;
        List<YDetail> list = null;
        try {
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(RestaurantDataService.class);
            factory.setAddress("http://datasource.mwan228.staxapps.net/RestaurantDataService");
            RestaurantDataService client = (RestaurantDataService) factory.create();

            Client timeoutclient = ClientProxy.getClient(client);
            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) timeoutclient.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();
                policy.setConnectionTimeout(timeout);
                policy.setReceiveTimeout(timeout);
                conduit.setClient(policy);
            }
            list = (List<YDetail>) client.findRestaurantsBySuburbAndPostcode(suburb, postcode);

            if (list == null) {
                return null;
            }

            if (list.size() == 0) {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    public List<YDetail> findRestaurantsBySuburb(String suburb) {

        long timeout = Timeout.timeout;
        List<YDetail> list = null;

        try {
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(RestaurantDataService.class);
            factory.setAddress("http://datasource.mwan228.staxapps.net/RestaurantDataService");
            RestaurantDataService client = (RestaurantDataService) factory.create();

            Client timeoutclient = ClientProxy.getClient(client);
            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) timeoutclient.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();
                policy.setConnectionTimeout(timeout);
                policy.setReceiveTimeout(timeout);
                conduit.setClient(policy);
            }
            list = (List<YDetail>) client.findRestaurantsBySuburb(suburb);

            if (list == null) {
                return null;
            }

            if (list.size() == 0) {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    public List<YDetail> findRestaurantsByPostcode(String postcode) {

        long timeout = Timeout.timeout;
        List<YDetail> list = null;
        try {
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(RestaurantDataService.class);
            factory.setAddress("http://datasource.mwan228.staxapps.net/RestaurantDataService");
            RestaurantDataService client = (RestaurantDataService) factory.create();

            Client timeoutclient = ClientProxy.getClient(client);
            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) timeoutclient.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();
                policy.setConnectionTimeout(timeout);
                policy.setReceiveTimeout(timeout);
                conduit.setClient(policy);
            }
            list = (List<YDetail>) client.findRestaurantsByPostcode(postcode);

            if (list == null) {
                return null;
            }

            if (list.size() == 0) {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    public List<YDetail> findAllRestaruants() {

        long timeout = Timeout.timeout;
        List<YDetail> list = null;

        try {
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(RestaurantDataService.class);
            factory.setAddress("http://datasource.mwan228.staxapps.net/RestaurantDataService");
            RestaurantDataService client = (RestaurantDataService) factory.create();

            Client timeoutclient = ClientProxy.getClient(client);
            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) timeoutclient.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();
                policy.setConnectionTimeout(timeout);
                policy.setReceiveTimeout(timeout);
                conduit.setClient(policy);
            }
            list = (List<YDetail>) client.findAllRestaruants();

            if (list == null) {
                return null;
            }

            if (list.size() == 0) {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    public static void main(String args[]) {
        List<YDetail> list = RestaurantServiceClient.newInstance().findRestaurantsBySuburb("kingsford");
        // List<YDetail> list = RestaurantServiceClient.newInstance().findRestaurantsByPostcode("2032");

        if (list == null) {
            System.out.println("no records found");
        } else {
            for (YDetail detail : list) {
                System.out.println(detail.getY_type());
                System.out.println(detail.getY_name());
                System.out.println(detail.getY_latitude());
                System.out.println(detail.getY_longitude());
                System.out.println(detail.getY_address());
                System.out.println(detail.getY_description());
            }
            System.out.println(list.size());
        }
    }
}
