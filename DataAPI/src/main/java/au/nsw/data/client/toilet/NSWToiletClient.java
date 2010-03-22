/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.nsw.data.client.toilet;

import au.nsw.data.model.YDetail;
import au.nsw.data.ws.toilet.NSWToiletService;
import java.util.List;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

/**
 *
 * @author frank
 */
public class NSWToiletClient {

    public static NSWToiletClient newInstance() {

        return new NSWToiletClient();

    }

    public List<YDetail> findToiletsBySuburbAndPostcode(String suburb, String postcode) throws Throwable {

        long timeout = 10000L;
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(NSWToiletService.class);
        factory.setAddress("http://toilet.mwan228.staxapps.net/NSWToiletService");
        NSWToiletService client = (NSWToiletService) factory.create();

        Client timeoutclient = ClientProxy.getClient(client);
        if (client != null) {
            HTTPConduit conduit = (HTTPConduit) timeoutclient.getConduit();
            HTTPClientPolicy policy = new HTTPClientPolicy();
            policy.setConnectionTimeout(timeout);
            policy.setReceiveTimeout(timeout);
            conduit.setClient(policy);
        }

        List<YDetail> list = client.findToiletsBySuburbAndPostcode(suburb, postcode);

        if (list.size() == 0) {

            return null;

        }

        return list;

    }

    public List<YDetail> findToiletsBySuburb(String suburb) throws Throwable {

        long timeout = 10000L;
        List<YDetail> list = null;
        try {

            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(NSWToiletService.class);
            factory.setAddress("http://toilet.mwan228.staxapps.net/NSWToiletService");
            NSWToiletService client = (NSWToiletService) factory.create();

            Client timeoutclient = ClientProxy.getClient(client);
            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) timeoutclient.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();
                policy.setConnectionTimeout(timeout);
                policy.setReceiveTimeout(timeout);
                conduit.setClient(policy);
            }
            list = client.findToiletsBySuburb(suburb);

            if (list == null) {
                return null;
            }

            if (list.size() == 0) {

                return null;

            }
        } catch (Throwable t) {
            t.printStackTrace();
            return null;
        }
        return list;

    }

    public List<YDetail> findToiletsByPostcode(String postcode) throws Throwable {

        long timeout = 10000L;
        List<YDetail> list = null;

        try {

            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(NSWToiletService.class);
            factory.setAddress("http://toilet.mwan228.staxapps.net/NSWToiletService");
            NSWToiletService client = (NSWToiletService) factory.create();
            list = client.findToiletsByPostcode(postcode);

            Client timeoutclient = ClientProxy.getClient(client);
            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) timeoutclient.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();
                policy.setConnectionTimeout(timeout);
                policy.setReceiveTimeout(timeout);
                conduit.setClient(policy);
            }
            
            if (list == null) {

                return null;
            }

            if (list.size() == 0) {

                return null;

            }
        } catch (Throwable t) {
            t.printStackTrace();
            return null;
        }
        return list;

    }

    public static void main(String args[]) throws Throwable {
        List<YDetail> list = NSWToiletClient.newInstance().findToiletsBySuburb("kingsford");
        //List<YDetail> list = NSWToiletClient.newInstance().findToiletsByPostcode("2032");
        //List<YDetail> list = NSWToiletClient.newInstance().findToiletsBySuburbAndPostcode("kingsford", "2032");

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


    }
}
