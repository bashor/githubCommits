package org.w3c.net

import org.w3c.dom.events.EventTarget
import org.w3c.dom.events.EventHandler
import org.w3c.dom.Document
import html5.files.Blob


native
trait XMLHttpRequestEventTarget : EventTarget {
    // event handlers
    var onloadstart: EventHandler
    var onprogress: EventHandler
    var onabort: EventHandler
    var onerror: EventHandler
    var onload: EventHandler
    var ontimeout: EventHandler
    var onloadend: EventHandler
}

native
trait XMLHttpRequestUpload : XMLHttpRequestEventTarget

native
trait XMLHttpRequestResponseType
//enum:
//"",
//"arraybuffer",
//"blob",
//"document",
//"json",
//"text"

native
trait FormData {
    fun append(name: String, value: Blob, filename: String? = null)
    fun append(name: String, value: String)
}

native
trait XMLHttpRequest : XMLHttpRequestEventTarget {
    // event handler
    var onreadystatechange: EventHandler
    val readyState: Short

    // request
    fun open(method: String, url: String)
    fun open(method: String, url: String, async: Boolean, username: String? = null, password: String? = null)
    fun setRequestHeader(header: String, value: String)
    var timeout: Long
    var withCredentials: Boolean
    val upload: XMLHttpRequestUpload
    fun send()
    fun send(data: String)
//    fun send(data: ArrayBufferView)
    fun send(data: Blob)
    fun send(data: Document)
    fun send(data: FormData)
    fun abort()

    // response
    val status: Short
    val statusText: String
    var responseType: XMLHttpRequestResponseType
    val response: Any
    val responseText: String
    val responseXML: Document?

    fun getResponseHeader(header: String): String?
    fun getAllResponseHeaders(): String
    fun overrideMimeType(mime: String)

    class object {
        // states
        val UNSENT = 0
        val OPENED = 1
        val HEADERS_RECEIVED = 2
        val LOADING = 3
        val DONE = 4
    }
}
