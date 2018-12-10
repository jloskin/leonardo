package petproject.loskin.leonardo.util

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule
import okhttp3.OkHttpClient
import java.io.InputStream
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

@GlideModule
class AppGlideModule : AppGlideModule() {
  override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
    registry.replace(GlideUrl::class.java, InputStream::class.java, OkHttpUrlLoader.Factory(getUnsafeOkHttpClient()))
  }

  private fun getUnsafeOkHttpClient(): OkHttpClient {
    val trustAllCerts: TrustManager = object : X509TrustManager {
      override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()

      @Throws(CertificateException::class)
      override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
      }

      @Throws(CertificateException::class)
      override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
      }
    }

    return OkHttpClient.Builder().apply {
      sslSocketFactory(
        SSLContext.getInstance("SSL").apply {
          init(null, arrayOf(trustAllCerts), java.security.SecureRandom())
        }.socketFactory,
        trustAllCerts as X509TrustManager
      )
      hostnameVerifier { _, _ -> true }
    }.build()
  }
}