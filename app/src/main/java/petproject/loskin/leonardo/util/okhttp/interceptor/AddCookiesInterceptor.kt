package petproject.loskin.leonardo.util.okhttp.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response


class AddCookiesInterceptor(
  private val cookies: Set<String>
) : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response =
    chain.request().newBuilder()
      .addHeader("Cookie", cookies.joinToString(";"))
      .let(Request.Builder::build)
      .let(chain::proceed)
}