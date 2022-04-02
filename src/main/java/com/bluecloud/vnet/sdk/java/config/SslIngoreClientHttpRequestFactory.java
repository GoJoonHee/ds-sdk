package com.bluecloud.vnet.sdk.java.config;

import org.springframework.http.client.SimpleClientHttpRequestFactory;

import javax.net.ssl.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

/**
 * @author dong.liping3
 * @version 1.0
 * @description 忽略ssl检查
 * @date 2020/10/29
 * @link
 * @see
 */
public class SslIngoreClientHttpRequestFactory extends SimpleClientHttpRequestFactory {

    /**
     * @param connection
     * @param httpMethod
     * @return void
     * @throws
     * @author dongliping
     * @description 准备链接
     * @date 2022/4/1
     * @todo
     */
    @Override
    protected void prepareConnection(HttpURLConnection connection, String httpMethod)
            throws IOException {
        if (connection instanceof HttpsURLConnection) {
            prepareHttpsConnection((HttpsURLConnection) connection);
        }
        super.prepareConnection(connection, httpMethod);
    }

    /**
     * @param connection
     * @return void
     * @throws
     * @author dongliping
     * @description 准备Https连接
     * @date 2022/4/1
     * @todo
     */
    private void prepareHttpsConnection(HttpsURLConnection connection) {
        connection.setHostnameVerifier(new SkipHostnameVerifier());
        try {
            connection.setSSLSocketFactory(createSslSocketFactory());
        } catch (Exception ex) {
            // Ignore
        }
    }

    /**
     * @param
     * @return javax.net.ssl.SSLSocketFactory
     * @throws
     * @author dongliping
     * @description 创建ssl SocketFactory
     * @date 2022/4/1
     * @todo
     */
    private SSLSocketFactory createSslSocketFactory() throws Exception {
        SSLContext context = SSLContext.getInstance("TLS");
        context.init(null, new TrustManager[]{new SkipX509TrustManager()},
                new SecureRandom());
        return context.getSocketFactory();
    }

    private class SkipHostnameVerifier implements HostnameVerifier {

        @Override
        public boolean verify(String s, SSLSession sslSession) {
            return true;
        }

    }

    private static class SkipX509TrustManager implements X509TrustManager {

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) {
        }

    }
}
