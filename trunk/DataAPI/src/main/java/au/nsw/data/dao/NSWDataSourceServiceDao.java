/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.nsw.data.dao;
import au.nsw.data.ws.client.AquariumServiceClient;
import au.nsw.data.ws.client.MuseumServiceClient;
import au.nsw.data.ws.client.ParkServiceClient;
import au.nsw.data.ws.client.RestaurantServiceClient;
import au.nsw.data.ws.client.SportServiceClient;
import au.nsw.data.ws.client.SupermarketServiceClient;

/**
 *
 * @author mingyiwang
 */
public class NSWDataSourceServiceDao{

    public AquariumServiceClient AClient() {
        return AquariumServiceClient.newInstance();
    }

    public MuseumServiceClient MClient() {
        return MuseumServiceClient.newInstance();
    }

    public ParkServiceClient PClient() {
        return ParkServiceClient.newInstance();
    }

    public RestaurantServiceClient RClient() {
        return RestaurantServiceClient.newInstance();
    }

    public SportServiceClient SPClient() {
        return SportServiceClient.newInstance();
    }

    public SupermarketServiceClient SMClient() {
        return SupermarketServiceClient.newInstance();
    }
}
