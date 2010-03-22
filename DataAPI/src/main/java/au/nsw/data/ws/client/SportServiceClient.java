/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.nsw.data.ws.client;

import au.nsw.data.model.YDetail;
import au.nsw.data.ws.sport.SportClubDataService;
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
public class SportServiceClient implements DataSourceClient {

    public static SportServiceClient newInstance() {
        return new SportServiceClient();
    }

    public List<YDetail> findSportsBySuburbAndType(String suburb, String postcode, String sporttype) {

        long timeout = Timeout.timeout;

        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(SportClubDataService.class);
        factory.setAddress("http://datasource.mwan228.staxapps.net/SportClubDataService");
        SportClubDataService client = (SportClubDataService) factory.create();

        Client timeoutclient = ClientProxy.getClient(client);
        if (client != null) {
            HTTPConduit conduit = (HTTPConduit) timeoutclient.getConduit();
            HTTPClientPolicy policy = new HTTPClientPolicy();
            policy.setConnectionTimeout(timeout);
            policy.setReceiveTimeout(timeout);
            conduit.setClient(policy);
        }
        List<YDetail> list = (List<YDetail>) client.findSportsBySuburbAndType(suburb, postcode, sporttype);

        if (list.size() == 0) {
            return null;
        }

        return list;

    }

    public List<YDetail> findSportsByPostcodeAndType(String postcode, String sporttype) {

        long timeout = Timeout.timeout;
        List<YDetail> list = null;

        try {
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(SportClubDataService.class);
            factory.setAddress("http://datasource.mwan228.staxapps.net/SportClubDataService");
            SportClubDataService client = (SportClubDataService) factory.create();

            Client timeoutclient = ClientProxy.getClient(client);
            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) timeoutclient.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();
                policy.setConnectionTimeout(timeout);
                policy.setReceiveTimeout(timeout);
                conduit.setClient(policy);
            }
            list = (List<YDetail>) client.findSportsByPostcodeAndType(postcode, sporttype);

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

    public List<YDetail> findAllSports() {

        long timeout = Timeout.timeout;
        List<YDetail> list = null;

        try {
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(SportClubDataService.class);
            factory.setAddress("http://datasource.mwan228.staxapps.net/SportClubDataService");
            SportClubDataService client = (SportClubDataService) factory.create();

            Client timeoutclient = ClientProxy.getClient(client);
            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) timeoutclient.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();
                policy.setConnectionTimeout(timeout);
                policy.setReceiveTimeout(timeout);
                conduit.setClient(policy);
            }
            list = (List<YDetail>) client.findAllSports();

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

    public List<YDetail> findSportsBySuburbAndPostcode(String suburb, String postcode) {

        long timeout = Timeout.timeout;
        List<YDetail> list = null;

        try {
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(SportClubDataService.class);
            factory.setAddress("http://datasource.mwan228.staxapps.net/SportClubDataService");
            SportClubDataService client = (SportClubDataService) factory.create();

            Client timeoutclient = ClientProxy.getClient(client);
            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) timeoutclient.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();
                policy.setConnectionTimeout(timeout);
                policy.setReceiveTimeout(timeout);
                conduit.setClient(policy);
            }
            list = (List<YDetail>) client.findSportsBySuburbAndPostcode(suburb, postcode);

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

    public List<YDetail> findSportsByType(String sporttype) {

        long timeout = Timeout.timeout;
        List<YDetail> list = null;

        try {
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(SportClubDataService.class);
            factory.setAddress("http://datasource.mwan228.staxapps.net/SportClubDataService");
            SportClubDataService client = (SportClubDataService) factory.create();

            Client timeoutclient = ClientProxy.getClient(client);
            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) timeoutclient.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();
                policy.setConnectionTimeout(timeout);
                policy.setReceiveTimeout(timeout);
                conduit.setClient(policy);
            }
            list = (List<YDetail>) client.findSportsByType(sporttype);

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

    public List<YDetail> findSportsByPostcode(String postcode) {
        long timeout = Timeout.timeout;
        List<YDetail> list = null;

        try {
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(SportClubDataService.class);
            factory.setAddress("http://datasource.mwan228.staxapps.net/SportClubDataService");
            SportClubDataService client = (SportClubDataService) factory.create();

            Client timeoutclient = ClientProxy.getClient(client);
            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) timeoutclient.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();
                policy.setConnectionTimeout(timeout);
                policy.setReceiveTimeout(timeout);
                conduit.setClient(policy);
            }
            list = (List<YDetail>) client.findSportsByPostcode(postcode);

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

    public List<YDetail> finsSportsBySuburb(String suburb) {
        
        long timeout = Timeout.timeout;
        List<YDetail> list = null;

        try {
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(SportClubDataService.class);
            factory.setAddress("http://datasource.mwan228.staxapps.net/SportClubDataService");
            SportClubDataService client = (SportClubDataService) factory.create();

            Client timeoutclient = ClientProxy.getClient(client);
            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) timeoutclient.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();
                policy.setConnectionTimeout(timeout);
                policy.setReceiveTimeout(timeout);
                conduit.setClient(policy);
            }
            list = (List<YDetail>) client.findSportsBySuburb(suburb);

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


        //List<YDetail> list = dao.findBySuburbAndType("Young","2594","Clubs--golf");
        //List<YDetail> list =SportServiceClient.newInstance().findSportsByType("Clubs--Life Saving &/Or Surfing");
        List<YDetail> list = SportServiceClient.newInstance().finsSportsBySuburb("maroubra");
        //List<YDetail> list = SportServiceClient.newInstance().findSportsByPostcode("2035");
        //List<YDetail> list = dao.findAllBySuburb("Young", "2594");

        if (list == null) {
            System.out.println("no records found");
        } else {
            for (YDetail ss : list) {
                System.out.println(ss.getY_type());
                System.out.println(ss.getY_sporttype());
                System.out.println(ss.getY_latitude());
                System.out.println(ss.getY_longitude());
                System.out.println(ss.getY_suburb());
                System.out.println(ss.getY_address());
                System.out.println(ss.getY_postcode());
                System.out.println("-------------------------------------------------");

            }
        }
    }
}
