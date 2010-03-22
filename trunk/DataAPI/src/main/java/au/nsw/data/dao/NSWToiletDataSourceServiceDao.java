/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.nsw.data.dao;

import au.nsw.data.client.toilet.NSWToiletClient;


/**
 *
 * @author frank
 */
public class NSWToiletDataSourceServiceDao{

    public NSWToiletClient NClient() {
        return NSWToiletClient.newInstance();
    }
    
}
