package com.mini.base.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HttpUtils {


	public static HttpResponse doPost(String url, Map<String, String> map,
			String charset) {
		HttpClient httpClient = null;
		HttpPost httpPost = null;
		try {
			httpClient = createSSLClientDefault();
			httpPost = new HttpPost(url);
			// 设置参数
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			if(map!=null){
                Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()) {
                    Entry<String, String> elem = (Entry<String, String>) iterator
                            .next();
                    list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
                }
                if (list.size() > 0) {
                    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,
                            charset);
                    httpPost.setEntity(entity);
                }
            }
			HttpResponse response = httpClient.execute(httpPost);
			/*if (response != null) {
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					result = EntityUtils.toString(resEntity, charset);
				}
			}*/
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	public static HttpResponse post(String url, HttpEntity entity) {
		// 创建HttpClientBuilder
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		// HttpClient
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
		// 依次是目标请求地址，端口号,协议类型
		RequestConfig reqConfig = RequestConfig.custom().build();
		// 请求地址
		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(reqConfig);
		try {//http://www.cnblogs.com/qiaoyeye/p/5101823.html  HttpClient如何解决302重定向问题
			httpPost.setEntity(entity);
			CloseableHttpResponse response = closeableHttpClient
					.execute(httpPost);
			// closeableHttpClient.close();
			return response;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 不需验证证书
	private static CloseableHttpClient createSSLClientDefault() {
		try {
			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(
					null, new TrustStrategy() {
						// 信任所有
						public boolean isTrusted(X509Certificate[] chain,
								String authType) throws CertificateException {
							return true;
						}
					}).build();
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
					sslContext);
			return HttpClients.custom().setSSLSocketFactory(sslsf).build();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}
		return HttpClients.createDefault();
	}

	public static CloseableHttpClient createSSLClientNeedJkc() {
		try {
			KeyStore trustStore = KeyStore.getInstance(KeyStore
					.getDefaultType());
			// 加载证书文件
			FileInputStream instream = new FileInputStream(new File(
					"conf/keystore.jks"));
			try {
				trustStore.load(instream, "coolcloud".toCharArray());
			} finally {
				instream.close();
			}
			SSLContext sslcontext = SSLContexts.custom()
					.loadTrustMaterial(trustStore).build();

			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
					sslcontext,
					SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
			return HttpClients.custom().setSSLSocketFactory(sslsf).build();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return HttpClients.createDefault();

	}
	public static void doGet(String urlWithParams) throws Exception {
		CloseableHttpClient httpClient = createSSLClientDefault();

		HttpGet httpget = new HttpGet(urlWithParams);

		CloseableHttpResponse response = httpClient.execute(httpget);
		System.out.println("StatusCode -> "
				+ response.getStatusLine().getStatusCode());

		HttpEntity entity = response.getEntity();
		String jsonStr = EntityUtils.toString(entity);// , "utf-8");
		System.out.println(jsonStr);

		httpget.releaseConnection();
	}
	public static String httpsGet(String httpsUrl) {
		CloseableHttpClient httpclient = createHttpsClient();
		HttpGet httpGet = new HttpGet(httpsUrl);
		try {
			HttpResponse httpResp = httpclient.execute(httpGet);
			int statusCode = httpResp.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				return EntityUtils.toString(httpResp.getEntity());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpGet.releaseConnection();
		}
		return null;
	}

	public static CloseableHttpClient createHttpsClient() {
		X509TrustManager x509mgr = new X509TrustManager() {
			@Override
			public void checkClientTrusted(X509Certificate[] xcs, String string) {

			}

			@Override
			public void checkServerTrusted(X509Certificate[] xcs, String string) {

			}

			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};
		SSLContext sslContext = null;
		try {
			sslContext = SSLContext.getInstance("TLS");
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		try {
			sslContext.init(null, new TrustManager[] { x509mgr }, null);
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
				sslContext, new String[] { "TLSv1" }, null,
				SSLConnectionSocketFactory.getDefaultHostnameVerifier());
		return HttpClients.custom().setSSLSocketFactory(sslsf).build();

	}

}
