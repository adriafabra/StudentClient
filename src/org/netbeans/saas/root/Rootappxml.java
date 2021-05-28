/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.saas.root;

import java.io.IOException;
import org.netbeans.saas.RestConnection;
import org.netbeans.saas.RestResponse;

/**
 * Rootappxml Service
 *
 * @author adri
 */
public class Rootappxml {

    /**
     * Creates a new instance of Rootappxml
     */
    public Rootappxml() {
    }
    
    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Throwable th) {
        }
    }

    /**
     *
     * @return an instance of RestResponse
     */
    public static RestResponse downloadExam() throws IOException {
        String[][] pathParams = new String[][]{};
        String[][] queryParams = new String[][]{};
        RestConnection conn = new RestConnection("http://localhost:48476/ExamsWeb/webresources/udl.exams/download/{id}", pathParams, queryParams);
        sleep(1000);
        return conn.get(null);
    }

    /**
     *
     * @return an instance of RestResponse
     */
    public static RestResponse find() throws IOException {
        String[][] pathParams = new String[][]{};
        String[][] queryParams = new String[][]{};
        RestConnection conn = new RestConnection("http://localhost:48476/ExamsWeb/webresources/udl.exams/{id}", pathParams, queryParams);
        sleep(1000);
        return conn.get(null);
    }

    /**
     *
     * @return an instance of RestResponse
     */
    public static RestResponse searchByDescription() throws IOException {
        String[][] pathParams = new String[][]{};
        String[][] queryParams = new String[][]{};
        RestConnection conn = new RestConnection("http://localhost:48476/ExamsWeb/webresources/udl.exams/search/description/{description}", pathParams, queryParams);
        sleep(1000);
        return conn.get(null);
    }
}
