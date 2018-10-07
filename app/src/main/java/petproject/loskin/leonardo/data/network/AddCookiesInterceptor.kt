package petproject.loskin.leonardo.data.network

import okhttp3.Interceptor
import okhttp3.Response


class AddCookiesInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        for (cookie in ReceivedCookiesInterceptor.cookies) {
            builder.addHeader("Cookie", cookie)
        }
        return chain.proceed(builder.build())
    }
}