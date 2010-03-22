/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.nsw.data.wsdladdress;

import java.util.Hashtable;

/**
 *
 * @author frank
 */
public class TypeTableInstance {
       public static Hashtable<String, String> addresstable = new Hashtable<String,String>();

       public TypeTableInstance(){
           
              addresstable.put("park", ParkAddress.address);
              addresstable.put("aquarium", AquariumAddress.address);
              addresstable.put("museum", MuseumAddress.address);
              addresstable.put("restaurant", RestaurantAddress.address);
              addresstable.put("supermarket", SupermarketAddress.address);
              addresstable.put("toilet", ToiletAddress.address);
              addresstable.put("sport", SportAddress.address);
       }
}
