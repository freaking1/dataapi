/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.nsw.data.ws.client;

import au.nsw.data.model.YDetail;
import au.nsw.data.ws.supermarket.SupermarketDataService;
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
public class SupermarketServiceClient implements DataSourceClient {

    public static SupermarketServiceClient newInstance() {
        return new SupermarketServiceClient();
    }

    public List<YDetail> findShoopingCentersBySuburbAndPostcode(String suburb, String postcode) {

        long timeout = Timeout.timeout;
        List<YDetail> list = null;

        try {
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(SupermarketDataService.class);
            factory.setAddress("http://datasource.mwan228.staxapps.net/SupermarketDataService");
            SupermarketDataService client = (SupermarketDataService) factory.create();

            Client timeoutclient = ClientProxy.getClient(client);
            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) timeoutclient.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();
                policy.setConnectionTimeout(timeout);
                policy.setReceiveTimeout(timeout);
                conduit.setClient(policy);
            }
            list = (List<YDetail>) client.findShoopingCentersBySuburbAndPostcode(suburb, postcode);

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

    public List<YDetail> findAllShoopingCenters() {

        long timeout = Timeout.timeout;
        List<YDetail> list = null;

        try {
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(SupermarketDataService.class);
            factory.setAddress("http://datasource.mwan228.staxapps.net/SupermarketDataService");
            SupermarketDataService client = (SupermarketDataService) factory.create();

            Client timeoutclient = ClientProxy.getClient(client);
            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) timeoutclient.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();
                policy.setConnectionTimeout(timeout);
                policy.setReceiveTimeout(timeout);
                conduit.setClient(policy);
            }
            list = (List<YDetail>) client.findAllShoopingCenters();

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

    public List<YDetail> findShoopingCentersBySuburb(String suburb) {

        long timeout = Timeout.timeout;
        List<YDetail> list = null;

        try {
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(SupermarketDataService.class);
            factory.setAddress("http://datasource.mwan228.staxapps.net/SupermarketDataService");
            SupermarketDataService client = (SupermarketDataService) factory.create();

            Client timeoutclient = ClientProxy.getClient(client);
            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) timeoutclient.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();
                policy.setConnectionTimeout(timeout);
                policy.setReceiveTimeout(timeout);
                conduit.setClient(policy);
            }
            list = (List<YDetail>) client.findShoopingCentersBySuburb(suburb);

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

    public List<YDetail> findShoopingCentersByPostcode(String postcode) {

        long timeout = Timeout.timeout;
        List<YDetail> list = null;
        try {
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(SupermarketDataService.class);
            factory.setAddress("http://datasource.mwan228.staxapps.net/SupermarketDataService");
            SupermarketDataService client = (SupermarketDataService) factory.create();

            Client timeoutclient = ClientProxy.getClient(client);
            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) timeoutclient.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();
                policy.setConnectionTimeout(timeout);
                policy.setReceiveTimeout(timeout);
                conduit.setClient(policy);
            }
            list = (List<YDetail>) client.findShoopingCentersByPostcode(postcode);

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


       // List<YDetail> list = SupermarketServiceClient.newInstance().findShoopingCentersByPostcode("20363123");
        List<YDetail> list = SupermarketServiceClient.newInstance().findShoopingCentersBySuburb("kingsford");
        if (list == null) {
            System.out.println("no record found");
        } else {
            for (YDetail detail : list) {
                System.out.println(detail.getY_address());
                System.out.println(detail.getY_name());
            }
        }
    }
}
