package content

import kotlinx.browser.window
import kotlinx.coroutines.CompletableDeferred
import kotlin.js.Promise

suspend fun Content.Companion.load(info: ContentInfo): Content? {
    val completable = CompletableDeferred<Content?>()
    console.log("load content from ${info.url}")
    window.fetch(info.url).then {
        if (it.ok) it.text() else Promise<String?> { resolve, _ -> resolve(null) }
    }.then {
        val content = it?.let { Content(it) }
        completable.complete(content)
    }.catch {
        completable.completeExceptionally(it)
    }
    return completable.await()
}
