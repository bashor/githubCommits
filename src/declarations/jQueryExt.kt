@file:Suppress("unused")

package jquery

@JsName("\$")
external val jq: JQuery

/// TODO noinline
@Suppress("NOTHING_TO_INLINE")
inline fun <T> JQuery.getJSON(url: String, noinline callback: (data: T, status: String, jqXHR: Any) -> Unit): Unit = asDynamic().getJSON(url, callback)

@Suppress("NOTHING_TO_INLINE")
inline fun JQuery.show(): JQuery = asDynamic().show()

@Suppress("NOTHING_TO_INLINE")
inline fun JQuery.hide(): JQuery = asDynamic().hide()
