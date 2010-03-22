/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.nsw.data.ws.client;

import au.nsw.data.model.YDetail;
import au.nsw.data.ws.park.ParkDataService;
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
public class ParkServiceClient implements DataSourceClient {

    public static ParkServiceClient newInstance() {

        return new ParkServiceClient();

    }

    public List<YDetail> findParksBySuburbAndPostcode(String suburb, String postcode) {

        long timeout = Timeout.timeout;
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(ParkDataService.class);
        factory.setAddress("http://datasource.mwan228.staxapps.net/ParkDataService");
        ParkDataService client = (ParkDataService) factory.create();

        Client timeoutclient = ClientProxy.getClient(client);
        if (client != null) {
            HTTPConduit conduit = (HTTPConduit) timeoutclient.getConduit();
            HTTPClientPolicy policy = new HTTPClientPolicy();
            policy.setConnectionTimeout(timeout);
            policy.setReceiveTimeout(timeout);
            conduit.setClient(policy);
        }
        List<YDetail> list = (List<YDetail>) client.findParksBySuburbAndPostcode(suburb, postcode);

        if (list.size() == 0) {
            return null;
        }

        return list;
    }

    public List<YDetail> findAllParks() {

        long timeout = Timeout.timeout;
        List<YDetail> list = null;

        try {
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(ParkDataService.class);
            factory.setAddress("http://datasource.mwan228.staxapps.net/ParkDataService");
            ParkDataService client = (ParkDataService) factory.create();

            Client timeoutclient = ClientProxy.getClient(client);
            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) timeoutclient.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();
                policy.setConnectionTimeout(timeout);
                policy.setReceiveTimeout(timeout);
                conduit.setClient(policy);
            }
            list = (List<YDetail>) client.findAllParks();

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

    public List<YDetail> findParksBySuburb(String suburb) {

        long timeout = Timeout.timeout;
        List<YDetail> list = null;

        try {
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(ParkDataService.class);
            factory.setAddress("http://datasource.mwan228.staxapps.net/ParkDataService");
            ParkDataService client = (ParkDataService) factory.create();

            Client timeoutclient = ClientProxy.getClient(client);
            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) timeoutclient.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();
                policy.setConnectionTimeout(timeout);
                policy.setReceiveTimeout(timeout);
                conduit.setClient(policy);
            }
            list = (List<YDetail>) client.findParksBySuburb(suburb);

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

    public List<YDetail> findParksByPostcode(String postcode) {


        long timeout = Timeout.timeout;
        List<YDetail> list = null;

        try {
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(ParkDataService.class);
            factory.setAddress("http://datasource.mwan228.staxapps.net/ParkDataService");
            ParkDataService client = (ParkDataService) factory.create();

            Client timeoutclient = ClientProxy.getClient(client);
            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) timeoutclient.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();
                policy.setConnectionTimeout(timeout);
                policy.setReceiveTimeout(timeout);
                conduit.setClient(policy);
            }
            list = (List<YDetail>) client.findParksByPostcode(postcode);

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
        List<YDetail> list = ParkServiceClient.newInstance().findParksBySuburb("sydneyfdaf");
        //List<YDetail> list = ParkServiceClient.newInstance().findParksByPostcode("26434320");
        if (list == null) {
            System.out.println("no records found");
        } else {
            for (YDetail detail : list) {

                System.out.println(detail.getY_name());
                System.out.println(detail.getY_latitude());
                System.out.println(detail.getY_longitude());
                System.out.println(detail.getY_address());
                System.out.println(detail.getY_description());
            }
        }
        //System.out.println("Size: " + list.size());
    }
}
