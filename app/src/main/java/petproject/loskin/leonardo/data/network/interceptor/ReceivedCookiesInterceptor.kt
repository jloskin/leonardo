package petproject.loskin.leonardo.data.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class ReceivedCookiesInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalResponse = chain.proceed(chain.request())
        cookies.addAll(originalResponse.headers("Set-Cookie"))
        return originalResponse
    }

    companion object {
        val cookies: MutableSet<String> = HashSet()
    }
}