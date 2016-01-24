package com.wonolo.app.Wonolo.Client;

import com.wonolo.app.Wonolo.Assertions;
import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;

import java.io.InputStream;
import java.util.List;
import java.util.Objects;

import static com.wonolo.app.Wonolo.PageMethods.WonoloMethods.log;

public class Client_Requests {

   static HttpClient client = HttpClientBuilder.create().build();
   static HttpResponse response;

   //get header
   public Header[] set_headers() throws Exception {
      return new Header[]{new BasicHeader("Content-Type", "application/json"),
      };
   }

   //response handler
   private static String responseHandler() throws Exception {
      InputStream body = response.getEntity().getContent();
      String jsonResult = IOUtils.toString(body, "UTF-8");
      int code = response.getStatusLine().getStatusCode();
      if (code==200 || code==201 || code==409) {
         //log(jsonResult);
      }
      //else if (code==409 && body.equals("Event has ended")) {

      //}
      else {
         Assertions.wonolo_fail("Failed to Execute Get Response Code :" + code);
         //log(jsonResult);
      }
      response.getEntity().getContent().close();
      return jsonResult;
   }

   //Request Builder
   public String executeRequest(String type, String endpoint, String host, Header[] headers, List<NameValuePair> params) throws Exception {
      String url = host + endpoint;
      //url builder
      int j = 0;
      for (NameValuePair param : params) {
         if (Objects.equals(param.getName(), "id")) {
            url = url.replace(":id", param.getValue());
            j = params.lastIndexOf(param);
            break;
            }
         }

      //param builder
      if(params.size()>0) params.remove(j);
      if (!url.endsWith("?") && !(params.size() ==0))
         url += "?";
      String paramString = URLEncodedUtils.format(params, "utf-8");
      url += paramString;

      //handle request type
      if (Objects.equals(type, "get")) {
         HttpGet getRequest = new HttpGet(url);
         getRequest.setHeaders(headers);
         log_cURL(getRequest, headers, url, "GET");
         executeRequest(getRequest);

      }

      else if (Objects.equals(type, "post")) {
         HttpPost postRequest = new HttpPost(url);
         HttpEntity postParams = new UrlEncodedFormEntity(params);
         postRequest.setEntity(postParams);
         postRequest.setHeaders(headers);
         log_cURL(postRequest, headers, url, "POST");
         executeRequest(postRequest);


      } else if (Objects.equals(type, "put")) {
         //do other request types here
         HttpPut putRequest = new HttpPut(url);
         HttpEntity putParams = new UrlEncodedFormEntity(params);
         putRequest.setEntity(putParams);
         putRequest.setHeaders(headers);
         log_cURL(putRequest, headers, url, "PUT");
         executeRequest(putRequest);


      } else {
         HttpDelete deleteRequest = new HttpDelete(url);
         deleteRequest.setHeaders(headers);
         log_cURL(deleteRequest, headers, url, "DELETE");
         executeRequest(deleteRequest);

      }

      if (response.getEntity() != null) {
         return responseHandler();
      }
      else {
         return null;
      }

   }

   private void log_cURL(HttpUriRequest request, Header[] headers, String url, String requestType) throws Exception {
      String curl = "curl -X " + requestType + " " + url + " -i";
      for (Header header : headers) {
         curl += " -H " + header;
      }
      log(curl);
   }

   private HttpResponse executeRequest(HttpUriRequest request) throws Exception {
      response = client.execute(request);
      int responseCode = response.getStatusLine().getStatusCode();
      log(String.valueOf(responseCode));
      return response;
   }
}