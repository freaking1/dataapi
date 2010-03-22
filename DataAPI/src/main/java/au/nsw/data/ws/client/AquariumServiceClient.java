/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.nsw.data.ws.client;

import au.nsw.data.model.YDetail;
import au.nsw.data.ws.aquarium.AquariumDataService;
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
public class AquariumServiceClient implements DataSourceClient {

    public static AquariumServiceClient newInstance() {
        return new AquariumServiceClient();
    }

    /***
     * find aquarims by suburb and postcode
     * @param suburb
     * @param postcode
     * @return
     */
    public List<YDetail> findAquariumsBySuburbAndPostcode(String suburb, String postcode) {

        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(AquariumDataService.class);
        factory.setAddress("http://datasource.mwan228.staxapps.net/AquariumDataService");
        AquariumDataService client = (AquariumDataService) factory.create();
        List<YDetail> list = (List<YDetail>) client.findAquariumsBySuburbAndPostcode(suburb, postcode);

        if (list == null) {
            return null;
        }

        if (list.size() == 0) {
            return null;
        }

        return list;
    }

    /***
     * find aquariums by suburb
     * @param suburb
     * @return
     */
    public List<YDetail> findAquariumsBySuburb(String suburb) {

        long timeout = Timeout.timeout;
        List<YDetail> list = null;
        try {
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(AquariumDataService.class);
            factory.setAddress("http://datasource.mwan228.staxapps.net/AquariumDataService");
            AquariumDataService client = (AquariumDataService) factory.create();

            Client timeoutclient = ClientProxy.getClient(client);
            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) timeoutclient.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();
                policy.setConnectionTimeout(timeout);
                policy.setReceiveTimeout(timeout);
                conduit.setClient(policy);
            }
            list = (List<YDetail>) client.findAquariumsBySuburb(suburb);

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

    /***
     * find aquariums by postcode
     * @param postcode
     * @return
     */
    public List<YDetail> findAquariumsByPostcode(String postcode) {

        long timeout = Timeout.timeout;
        List<YDetail> list = null;
        try {
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(AquariumDataService.class);
            factory.setAddress("http://datasource.mwan228.staxapps.net/AquariumDataService");
            AquariumDataService client = (AquariumDataService) factory.create();

            Client timeoutclient = ClientProxy.getClient(client);
            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) timeoutclient.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();
                policy.setConnectionTimeout(timeout);
                policy.setReceiveTimeout(timeout);
                conduit.setClient(policy);
            }
            list = (List<YDetail>) client.findAquariumsByPostcode(postcode);

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

    /***
     * find all aquariums
     * @return
     */
    public List<YDetail> findAllAquariums() {

        long timeout = Timeout.timeout;
        List<YDetail> list = null;
        try {
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(AquariumDataService.class);
            factory.setAddress("http://datasource.mwan228.staxapps.net/AquariumDataService");
            AquariumDataService client = (AquariumDataService) factory.create();

            Client timeoutclient = ClientProxy.getClient(client);
            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) timeoutclient.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();
                policy.setConnectionTimeout(timeout);
                policy.setReceiveTimeout(timeout);
                conduit.setClient(policy);
            }
            list = (List<YDetail>) client.findAllAquariums();

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

        List<YDetail> list = AquariumServiceClient.newInstance().findAquariumsBySuburb("bondi");
        //List<YDetail> list = AquariumServiceClient.newInstance().findAquariumsBySuburbAndPostcode("maroubra", "2035");
        //List<YDetail> list = AquariumServiceClient.newInstance().findAquariumsByPostcode("2035");

        if (list != null) {
            for (YDetail detail : list) {
                System.out.println(detail.getY_type());
                System.out.println(detail.getY_name());
                System.out.println(detail.getY_latitude());
                System.out.println(detail.getY_longitude());
                System.out.println(detail.getY_address());
                System.out.println(detail.getY_description());
            }
        } else {
            System.out.println("no records found");
        }
    }
}
