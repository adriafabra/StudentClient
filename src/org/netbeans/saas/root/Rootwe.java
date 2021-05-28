/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.saas.root;

import java.io.IOException;
import java.io.InputStream;
import org.netbeans.saas.RestConnection;
import org.netbeans.saas.RestResponse;

/**
 * Rootwe Service
 *
 * @author adri
 */
public class Rootwe {

    /**
     * Creates a new instance of Rootwe
     */
    public Rootwe() {
    }
    
    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Throwable th) {
        }
    }

    /**
     *
     * @param content
     * @return an instance of RestResponse
     */
    public static RestResponse create(InputStream content) throws IOException {
        String[][] pathParams = new String[][]{};
        String[][] queryParams = new String[][]{};
        RestConnection conn = new RestConnection("http://localhost:48476/MyExams/webresources/udl.exams", pathParams, queryParams);
        sleep(1000);
        return conn.post(null, content);
    }

    /**
     *
     * @return an instance of RestResponse
     */
    public static RestResponse countREST() throws IOException {
        String[][] pathParams = new String[][]{};
        String[][] queryParams = new String[][]{};
        RestConnection conn = new RestConnection("http://localhost:48476/MyExams/webresources/udl.exams/count", pathParams, queryParams);
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
        RestConnection conn = new RestConnection("http://localhost:48476/MyExams/webresources/udl.exams/{id}", pathParams, queryParams);
        sleep(1000);
        return conn.get(null);
    }

    /**
     *
     * @param id
     * @param content
     * @return an instance of RestResponse
     */
    public static RestResponse edit(String id, InputStream content) throws IOException {
        String[][] pathParams = new String[][]{{"{id}", id}};
        String[][] queryParams = new String[][]{};
        RestConnection conn = new RestConnection("http://localhost:48476/MyExams/webresources/udl.grades/{id}", pathParams, queryParams);
        sleep(1000);
        return conn.put(null, content);
    }

    /**
     *
     * @param id
     * @param content
     * @return an instance of RestResponse
     */
    public static RestResponse edit(Integer id, InputStream content) throws IOException {
        String[][] pathParams = new String[][]{{"{id}", String.valueOf(id)}};
        String[][] queryParams = new String[][]{};
        RestConnection conn = new RestConnection("http://localhost:48476/MyExams/webresources/udl.exams/{id}", pathParams, queryParams);
        sleep(1000);
        return conn.put(null, content);
    }

    /**
     *
     * @param id
     * @param content
     * @return an instance of RestResponse
     */
    public static RestResponse modifyDescription(Integer id, InputStream content) throws IOException {
        String[][] pathParams = new String[][]{{"{id}", String.valueOf(id)}};
        String[][] queryParams = new String[][]{};
        RestConnection conn = new RestConnection("http://localhost:48476/MyExams/webresources/udl.exams/description/{id}", pathParams, queryParams);
        sleep(1000);
        return conn.put(null, content);
    }

    /**
     *
     * @return an instance of RestResponse
     */
    public static RestResponse getDescription() throws IOException {
        String[][] pathParams = new String[][]{};
        String[][] queryParams = new String[][]{};
        RestConnection conn = new RestConnection("http://localhost:48476/MyExams/webresources/udl.exams/description/{id}", pathParams, queryParams);
        sleep(1000);
        return conn.get(null);
    }

    /**
     *
     * @return an instance of RestResponse
     */
    public static RestResponse remove(Integer id) throws IOException {
        String[][] pathParams = new String[][]{{"{id}", String.valueOf(id)}};
        String[][] queryParams = new String[][]{};
        RestConnection conn = new RestConnection("http://localhost:48476/MyExams/webresources/udl.exams/{id}", pathParams, queryParams);
        sleep(1000);
        return conn.delete(null);
    }

    /**
     *
     * @return an instance of RestResponse
     */
    public static RestResponse delete() throws IOException {
        String[][] pathParams = new String[][]{};
        String[][] queryParams = new String[][]{};
        RestConnection conn = new RestConnection("http://localhost:48476/MyExams/webresources/udl.exams/description/{id}", pathParams, queryParams);
        sleep(1000);
        return conn.delete(null);
    }

    /**
     *
     * @return an instance of RestResponse
     */
    public static RestResponse downloadExam() throws IOException {
        String[][] pathParams = new String[][]{};
        String[][] queryParams = new String[][]{};
        RestConnection conn = new RestConnection("http://localhost:48476/MyExams/webresources/udl.exams/download/{id}", pathParams, queryParams);
        sleep(1000);
        return conn.get(null);
    }

    /**
     *
     * @return an instance of RestResponse
     */
    public static RestResponse findRange() throws IOException {
        String[][] pathParams = new String[][]{};
        String[][] queryParams = new String[][]{};
        RestConnection conn = new RestConnection("http://localhost:48476/MyExams/webresources/udl.exams/{from}/{to}", pathParams, queryParams);
        sleep(1000);
        return conn.get(null);
    }

    /**
     *
     * @return an instance of RestResponse
     */
    public static RestResponse remove() throws IOException {
        String[][] pathParams = new String[][]{};
        String[][] queryParams = new String[][]{};
        RestConnection conn = new RestConnection("http://localhost:48476/MyExams/webresources/udl.exams/delete/{id}", pathParams, queryParams);
        sleep(1000);
        return conn.delete(null);
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

    /**
     *
     * @return an instance of RestResponse
     */
    public static RestResponse searchById() throws IOException {
        String[][] pathParams = new String[][]{};
        String[][] queryParams = new String[][]{};
        RestConnection conn = new RestConnection("http://localhost:48476/ExamsWeb/webresources/udl.exams/search/{id}", pathParams, queryParams);
        sleep(1000);
        return conn.get(null);
    }

    /**
     *
     * @param content
     * @return an instance of RestResponse
     */
    public static RestResponse uploadExam(InputStream content) throws IOException {
        String[][] pathParams = new String[][]{};
        String[][] queryParams = new String[][]{};
        RestConnection conn = new RestConnection("http://localhost:48476/ExamsWeb/webresources/udl.exams", pathParams, queryParams);
        sleep(1000);
        return conn.post(null, content);
    }

}
