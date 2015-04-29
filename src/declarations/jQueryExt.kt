package jquery

native("\$")
val jq: JQuery = noImpl

native
fun JQuery.getJSON<T>(url: String, callback: (data: T, status: String, jqXHR: Any) -> Unit): Unit = noImpl

native
fun JQuery.show(): JQuery = noImpl
native
fun JQuery.hide(): JQuery = noImpl
