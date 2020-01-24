/*
 * Created by ferdyhaspin on 1/23/20 7:46 PM
 */

package app.ferdyhaspin.quotes.utils

import kotlinx.coroutines.*

fun <T> lazyDeffered(block: suspend CoroutineScope.() -> T): Lazy<Deferred<T>> {
    return lazy {
        GlobalScope.async(start = CoroutineStart.LAZY) {
            block.invoke(this)
        }
    }
}