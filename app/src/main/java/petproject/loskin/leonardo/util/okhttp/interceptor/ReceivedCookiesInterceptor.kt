package petproject.loskin.leonardo.util.okhttp.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class ReceivedCookiesInterceptor(
    private val cookies: MutableSet<String>
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response =
        chain.proceed(chain.request()).apply {
            if (cookies.isEmpty()) cookies.addAll(headers("Set-Cookie").filter { it.contains("PHPSESSID") })
        }
}