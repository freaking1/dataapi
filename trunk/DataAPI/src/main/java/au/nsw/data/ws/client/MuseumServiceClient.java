/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.nsw.data.ws.client;

import au.nsw.data.model.YDetail;
import au.nsw.data.ws.museums.MuseumDataService;
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
public class MuseumServiceClient implements DataSourceClient {

    public static MuseumServiceClient newInstance() {
        return new MuseumServiceClient();

    }

    public List<YDetail> findMuseumsBySuburbAndPostcode(String suburb, String postcode) {

        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(MuseumDataService.class);
        factory.setAddress("http://datasource.mwan228.staxapps.net/MuseumDataService");
        MuseumDataService client = (MuseumDataService) factory.create();
        List<YDetail> list = (List<YDetail>) client.findMuseumsBySuburbAndPostcode(suburb, postcode);

        if (list == null) {
            return null;
        }

        if (list.size() == 0) {
            return null;
        }

        return list;

    }

    public List<YDetail> findAllMuseums() {

        long timeout = Timeout.timeout;
        List<YDetail> list = null;
        try {

            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(MuseumDataService.class);
            factory.setAddress("http://datasource.mwan228.staxapps.net/MuseumDataService");
            MuseumDataService client = (MuseumDataService) factory.create();

            Client timeoutclient = ClientProxy.getClient(client);
            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) timeoutclient.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();
                policy.setConnectionTimeout(timeout);
                policy.setReceiveTimeout(timeout);
                conduit.setClient(policy);
            }
            list = (List<YDetail>) client.findAllMuseums();

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

    public List<YDetail> findMuseumsBySuburb(String suburb) {

        long timeout = Timeout.timeout;
        List<YDetail> list = null;
        try {
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(MuseumDataService.class);
            factory.setAddress("http://datasource.mwan228.staxapps.net/MuseumDataService");
            MuseumDataService client = (MuseumDataService) factory.create();

            Client timeoutclient = ClientProxy.getClient(client);
            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) timeoutclient.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();
                policy.setConnectionTimeout(timeout);
                policy.setReceiveTimeout(timeout);
                conduit.setClient(policy);
            }
            list = (List<YDetail>) client.findMuseumsBySuburb(suburb);

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

    public List<YDetail> findMuseumsByPostcode(String postcode) {


        long timeout = Timeout.timeout;
        List<YDetail> list = null;
        try {
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(MuseumDataService.class);
            factory.setAddress("http://datasource.mwan228.staxapps.net/MuseumDataService");
            MuseumDataService client = (MuseumDataService) factory.create();

            Client timeoutclient = ClientProxy.getClient(client);
            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) timeoutclient.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();
                policy.setConnectionTimeout(timeout);
                policy.setReceiveTimeout(timeout);
                conduit.setClient(policy);
            }
            list = (List<YDetail>) client.findMuseumsByPostcode(postcode);

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
        List<YDetail> list = MuseumServiceClient.newInstance().findMuseumsBySuburb("sydneydfafasf");
        //List<YDetail> list = MuseumServiceClient.newInstance().findMuseumsBySuburbAndPostcode("sydney", "2000");
        //List<YDetail> list = MuseumServiceClient.newInstance().findMuseumsByPostcode("2000");
        for (YDetail detail : list) {

            System.out.println(detail.getY_name());
            System.out.println(detail.getY_latitude());
            System.out.println(detail.getY_longitude());
            System.out.println(detail.getY_address());
            System.out.println(detail.getY_description());
        }
    }
}
