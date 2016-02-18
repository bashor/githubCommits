package jquery

import org.w3c.dom.Element
import js.dom.html.HTMLElement
import org.w3c.dom.Node
import org.w3c.dom.events.Event
import org.w3c.dom.events.PopStateEvent
import org.w3c.net.XMLHttpRequest

@native
interface JQueryAjaxSettings {
    var accepts: Any?
    var async: Boolean?
    val beforeSend: ((jqXHR: JQueryXHR, settings: JQueryAjaxSettings) -> Any)?
    var cache: Boolean?
    val complete: ((jqXHR: JQueryXHR, textStatus: String) -> Any)?
    var contents: Json?
    var contentType: Any?
    var context: Any?
    var converters: Json?
    var crossDomain: Boolean?
    var data: Any?
    val dataFilter: ((data: Any, ty: Any) -> Any)?
    var dataType: String?
    val error: ((jqXHR: JQueryXHR, textStatus: String, errorThrow: String) -> Any)?
    var global: Boolean?
    var headers: Json?
    var ifModified: Boolean?
    var isLocal: Boolean?
    var jsonp: String?
    var jsonpCallback: Any?
    var mimeType: String?
    var password: String?
    var processData: Boolean?
    var scriptCharset: String?
    var statusCode: Json?
    val success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)?
    var timeout: Number?
    var traditional: Boolean?
    var `type`: String?
    var url: String?
    var username: String?
    var xhr: Any?
    var xhrFields: Json?
}
@native
interface JQueryXHR : XMLHttpRequest, JQueryPromise<Any> {
//    override fun overrideMimeType(mimeType: String): Any
    fun abort(statusText: String? = null): Unit
}
@native
interface JQueryCallback {
    fun add(vararg callbacks: Any): Any
    fun disable(): Any
    fun empty(): Any
    fun fire(vararg arguments: Any): Any
    fun fired(): Boolean
    fun fireWith(context: Any, vararg args: Any): Any
    fun has(callback: Any): Boolean
    fun lock(): Any
    fun locked(): Boolean
    fun remove(vararg callbacks: Any): Any
}
@native
interface JQueryGenericPromise<T> {
    fun <U> (onFulfill: (value: T) -> U, onReject: ((reason: Any) -> U)? = null): JQueryGenericPromise<U>
    fun <U> (onFulfill: (value: T) -> JQueryGenericPromise<U>, onReject: ((reason: Any) -> U)? = null): JQueryGenericPromise<U>
    fun <U> then(onFulfill: (value: T) -> U, onReject: ((reason: Any) -> JQueryGenericPromise<U>)? = null): JQueryGenericPromise<U>
    fun <U> then(onFulfill: (value: T) -> JQueryGenericPromise<U>, onReject: ((reason: Any) -> JQueryGenericPromise<U>)? = null): JQueryGenericPromise<U>
}
@native
interface JQueryPromise<T> {
    fun always(vararg alwaysCallbacks: Any): JQueryPromise<T>
    fun done(vararg doneCallbacks: Any): JQueryPromise<T>
    fun fail(vararg failCallbacks: Any): JQueryPromise<T>
    fun progress(vararg progressCallbacks: Any): JQueryPromise<T>
    fun pipe(doneFilter: ((x: Any) -> Any)? = null, failFilter: ((x: Any) -> Any)? = null, progressFilter: ((x: Any) -> Any)? = null): JQueryPromise<Any>
    fun <U> then(onFulfill: (value: T) -> U, onReject: ((vararg reasons: Any) -> U)? = null, onProgress: ((vararg progression: Any) -> Any)? = null): JQueryPromise<U>
    fun <U> then(onFulfill: (value: T) -> JQueryGenericPromise<U>, onReject: ((vararg reasons: Any) -> U)? = null, onProgress: ((vararg progression: Any) -> Any)? = null): JQueryPromise<U>
    fun <U> then(onFulfill: (value: T) -> U, onReject: ((vararg reasons: Any) -> JQueryGenericPromise<U>)? = null, onProgress: ((vararg progression: Any) -> Any)? = null): JQueryPromise<U>
    fun <U> then(onFulfill: (value: T) -> JQueryGenericPromise<U>, onReject: ((vararg reasons: Any) -> JQueryGenericPromise<U>)? = null, onProgress: ((vararg progression: Any) -> Any)? = null): JQueryPromise<U>
//    fun then<U>(onFulfill: (vararg values: Any) -> U, onReject: ((vararg reasons: Any) -> U)? = null, onProgress: ((vararg progression: Any) -> Any)? = null): JQueryPromise<U>
//    fun then<U>(onFulfill: (vararg values: Any) -> JQueryGenericPromise<U>, onReject: ((vararg reasons: Any) -> U)? = null, onProgress: ((vararg progression: Any) -> Any)? = null): JQueryPromise<U>
//    fun then<U>(onFulfill: (vararg values: Any) -> U, onReject: ((vararg reasons: Any) -> JQueryGenericPromise<U>)? = null, onProgress: ((vararg progression: Any) -> Any)? = null): JQueryPromise<U>
//    fun then<U>(onFulfill: (vararg values: Any) -> JQueryGenericPromise<U>, onReject: ((vararg reasons: Any) -> JQueryGenericPromise<U>)? = null, onProgress: ((vararg progression: Any) -> Any)? = null): JQueryPromise<U>
}
@native
interface JQueryDeferred<T> : JQueryPromise<T> {
    override fun always(vararg alwaysCallbacks: Any): JQueryDeferred<T>
    override fun done(vararg doneCallbacks: Any): JQueryDeferred<T>
    override fun fail(vararg failCallbacks: Any): JQueryDeferred<T>
    override fun progress(vararg progressCallbacks: Any): JQueryDeferred<T>
    fun notify(vararg args: Any): JQueryDeferred<T>
    fun notifyWith(context: Any, vararg args: Any): JQueryDeferred<T>
    fun reject(vararg args: Any): JQueryDeferred<T>
    fun rejectWith(context: Any, vararg args: Any): JQueryDeferred<T>
    fun resolve(`val`: T): JQueryDeferred<T>
    fun resolve(vararg args: Any): JQueryDeferred<T>
    fun resolveWith(context: Any, vararg args: Any): JQueryDeferred<T>
    fun state(): String
    fun promise(target: Any? = null): JQueryPromise<T>
}
@native
interface BaseJQueryEventObject : Event {
    var data: Any
    var delegateTarget: Element
    fun isDefaultPrevented(): Boolean
    fun isImmediatePropogationStopped(): Boolean
    fun isPropagationStopped(): Boolean
    var namespace: String
//    fun preventDefault(): Any
    var relatedTarget: Element
    var result: Any
    fun stopImmediatePropagation(): Unit
//    fun stopPropagation(): Unit
    var pageX: Number
    var pageY: Number
    var which: Number
//    var metaKey: Any
}
@native
interface JQueryInputEventObject : BaseJQueryEventObject {
    var altKey: Boolean
    var ctrlKey: Boolean
    var metaKey: Boolean
    var shiftKey: Boolean
}
@native
interface JQueryMouseEventObject : JQueryInputEventObject {
    var button: Number
    var clientX: Number
    var clientY: Number
    var offsetX: Number
    var offsetY: Number
    override var pageX: Number
    override var pageY: Number
    var screenX: Number
    var screenY: Number
}
@native
interface JQueryKeyEventObject : JQueryInputEventObject {
    var char: Any
    var charCode: Number
    var key: Any
    var keyCode: Number
}

@native
interface JQueryPopStateEventObject : BaseJQueryEventObject {
    var originalEvent: PopStateEvent
}
@native
interface JQueryEventObject : BaseJQueryEventObject, JQueryInputEventObject, JQueryMouseEventObject, JQueryKeyEventObject, JQueryPopStateEventObject {
}
@native
interface JQuerySupport {
    var ajax: Boolean?
    var boxModel: Boolean?
    var changeBubbles: Boolean?
    var checkClone: Boolean?
    var checkOn: Boolean?
    var cors: Boolean?
    var cssFloat: Boolean?
    var hrefNormalized: Boolean?
    var htmlSerialize: Boolean?
    var leadingWhitespace: Boolean?
    var noCloneChecked: Boolean?
    var noCloneEvent: Boolean?
    var opacity: Boolean?
    var optDisabled: Boolean?
    var optSelected: Boolean?
    val scriptEval: (() -> Boolean)?
    var style: Boolean?
    var submitBubbles: Boolean?
    var tbody: Boolean?
}
@native
interface JQueryParam {
    fun invoke(obj: Any): String
    fun invoke(obj: Any, traditional: Boolean): String
}
@native
interface JQueryStatic {
    fun ajax(settings: JQueryAjaxSettings): JQueryXHR
    fun ajax(url: String, settings: JQueryAjaxSettings? = null): JQueryXHR
    fun ajaxPrefilter(dataTypes: String, handler: (opts: Any, originalOpts: Any, jqXHR: JQueryXHR) -> Any): Any
    fun ajaxPrefilter(handler: (opts: Any, originalOpts: Any, jqXHR: JQueryXHR) -> Any): Any
    var ajaxSettings: JQueryAjaxSettings
    fun ajaxSetup(): Unit
    fun ajaxSetup(options: JQueryAjaxSettings): Unit
    fun get(url: String, data: Any? = null, success: Any? = null, dataType: Any? = null): JQueryXHR
    fun getJSON(url: String, data: Any? = null, success: Any? = null): JQueryXHR
    fun getScript(url: String, success: Any? = null): JQueryXHR
    var param: JQueryParam
    fun post(url: String, data: Any? = null, success: Any? = null, dataType: Any? = null): JQueryXHR
    fun Callbacks(flags: String? = null): JQueryCallback
    fun holdReady(hold: Boolean): Any
    fun invoke(selector: String, context: Any? = null): JQuery
    fun invoke(element: Element): JQuery
    fun invoke(`object`: Any): JQuery
    fun invoke(elementArray: Array<Element>): JQuery
    fun invoke(`object`: JQuery): JQuery
//    fun invoke(func: Function): JQuery
    fun invoke(array: Array<Any>): JQuery
    fun invoke(): JQuery
    fun noConflict(removeAll: Boolean? = null): Any
    fun `when`<T>(vararg deferreds: JQueryGenericPromise<T>): JQueryPromise<T>
    fun `when`<T>(vararg deferreds: T): JQueryPromise<T>
    fun `when`<T>(vararg deferreds: Any): JQueryPromise<T>
    fun css(e: Any, propertyName: String, value: Any? = null): Any
    fun css(e: Any, propertyName: Any, value: Any? = null): Any
    var cssHooks: Json
    var cssNumber: Any
    fun data(element: Element, key: String, value: Any): Any
    fun data(element: Element, key: String): Any
    fun data(element: Element): Any
    fun dequeue(element: Element, queueName: String? = null): Any
    fun hasData(element: Element): Boolean
    fun queue(element: Element, queueName: String? = null): Array<Any>
    fun queue(element: Element, queueName: String, newQueueOrCallback: Any): JQuery
    fun removeData(element: Element, name: String? = null): JQuery
    fun <T> Deferred(beforeStart: ((deferred: JQueryDeferred<T>) -> Any)? = null): JQueryDeferred<T>
//    var fx: { tick: () => void; interval: number; stop: () => void; speeds: { slow: number; fast: number; }; off: boolean; step: any; }
    fun proxy(fn: (vararg args: Any) -> Any, context: Any, vararg args: Any): Any
    fun proxy(context: Any, name: String, vararg args: Any): Any
//    var Event: {
//        (name: string, eventProperties?: any): JQueryEventObject;
//        new (name: string, eventProperties?: any): JQueryEventObject;
//    }
    fun error(message: Any): JQuery
    var expr: Any
    var fn: Any
    var isReady: Boolean
    var support: JQuerySupport
    fun contains(container: Element, contained: Element): Boolean
    fun each(collection: Any, callback: (indexInArray: Any, valueOfElement: Any) -> Any): Any
    fun each(collection: JQuery, callback: (indexInArray: Number, valueOfElement: HTMLElement) -> Any): Any
    fun <T> each(collection: Array<T>, callback: (indexInArray: Number, valueOfElement: T) -> Any): Any
    fun extend(target: Any, vararg objs: Any): Any
    fun extend(deep: Boolean, target: Any, vararg objs: Any): Any
    fun globalEval(code: String): Any
    fun <T> grep(array: Array<T>, func: (elementOfArray: T, indexInArray: Number) -> Boolean, invert: Boolean? = null): Array<T>
    fun <T> inArray(value: T, array: Array<T>, fromIndex: Number? = null): Number
    fun isArray(obj: Any): Boolean
    fun isEmptyObject(obj: Any): Boolean
    fun isFunction(obj: Any): Boolean
    fun isNumeric(value: Any): Boolean
    fun isPlainObject(obj: Any): Boolean
    fun isWindow(obj: Any): Boolean
    fun isXMLDoc(node: Node): Boolean
    fun makeArray(obj: Any): Array<Any>
    fun map<T, U>(array: Array<T>, callback: (elementOfArray: T, indexInArray: Number) -> U): Array<U>
    fun map(array: Any, callback: (elementOfArray: Any, indexInArray: Any) -> Any): Any
    fun <T> merge(first: Array<T>, second: Array<T>): Array<T>
    fun merge<T, U>(first: Array<T>, second: Array<U>): Array<Any>
    fun noop(): Any
    fun now(): Number
    fun parseJSON(json: String): Any
    fun parseXML(data: String): Any
    fun queue(element: Element, queueName: String, newQueue: Array<Any>): JQuery
    fun trim(str: String): String
    fun `type`(obj: Any): String
    fun unique(arr: Array<Any>): Array<Any>
    fun parseHTML(data: String, context: HTMLElement? = null, keepScripts: Boolean? = null): Array<Any>
    fun Animation(elem: Any, properties: Any, options: Any): Any
}
@native
interface JQuery {
    fun ajaxComplete(handler: Any): JQuery
    fun ajaxError(handler: (event: Any, jqXHR: Any, settings: Any, exception: Any) -> Any): JQuery
    fun ajaxSend(handler: (event: Any, jqXHR: Any, settings: Any, exception: Any) -> Any): JQuery
    fun ajaxStart(handler: () -> Any): JQuery
    fun ajaxStop(handler: () -> Any): JQuery
    fun ajaxSuccess(handler: (event: Any, jqXHR: Any, settings: Any, exception: Any) -> Any): JQuery
    fun load(url: String, data: Any? = null, complete: Any? = null): JQuery
    fun serialize(): String
    fun serializeArray(): Array<Any>
    fun addClass(classNames: String): JQuery
    fun addClass(func: (index: Any, currentClass: Any) -> String): JQuery
    fun addBack(selector: String? = null): JQuery
    fun attr(attributeName: String): String
    fun attr(attributeName: String, value: Any): JQuery
    fun attr(map: Json): JQuery
    fun attr(attributeName: String, func: (index: Any, attr: Any) -> Any): JQuery
    fun hasClass(className: String): Boolean
    fun html(): String
    fun html(htmlString: String): JQuery
    fun html(htmlContent: (index: Number, oldhtml: String) -> String): JQuery
    fun html(obj: JQuery): JQuery
    fun prop(propertyName: String): Any
    fun prop(propertyName: String, value: Any): JQuery
    fun prop(map: Any): JQuery
    fun prop(propertyName: String, func: (index: Any, oldPropertyValue: Any) -> Any): JQuery
    fun removeAttr(attributeName: Any): JQuery
    fun removeClass(className: Any? = null): JQuery
    fun removeClass(func: (index: Any, cls: Any) -> Any): JQuery
    fun removeProp(propertyName: Any): JQuery
    fun toggleClass(className: Any, swtch: Boolean? = null): JQuery
    fun toggleClass(swtch: Boolean? = null): JQuery
    fun toggleClass(func: (index: Any, cls: Any, swtch: Any) -> Any): JQuery
    fun `val`(): Any
    fun `val`(value: Array<String>): JQuery
    fun `val`(value: String): JQuery
    fun `val`(value: Number): JQuery
    fun `val`(func: (index: Any, value: Any) -> Any): JQuery
    fun css(propertyName: String): String
    fun css(propertyNames: Array<String>): String
    fun css(properties: Any): JQuery
    fun css(propertyName: String, value: Any): JQuery
    fun css(propertyName: Any, value: Any): JQuery
    fun height(): Number
    fun height(value: Number): JQuery
    fun height(value: String): JQuery
    fun height(func: (index: Any, height: Any) -> Any): JQuery
    fun innerHeight(): Number
    fun innerHeight(value: Number): JQuery
    fun innerWidth(): Number
    fun innerWidth(value: Number): JQuery
//    fun offset(): { left: number; top: number; }
    fun offset(coordinates: Any): JQuery
    fun offset(func: (index: Any, coords: Any) -> Any): JQuery
    fun outerHeight(includeMargin: Boolean? = null): Number
    fun outerHeight(value: Number, includeMargin: Boolean? = null): JQuery
    fun outerWidth(includeMargin: Boolean? = null): Number
    fun outerWidth(value: Number, includeMargin: Boolean? = null): JQuery
//    fun position(): { top: number; left: number; }
    fun scrollLeft(): Number
    fun scrollLeft(value: Number): JQuery
    fun scrollTop(): Number
    fun scrollTop(value: Number): JQuery
    fun width(): Number
    fun width(value: Number): JQuery
    fun width(value: String): JQuery
    fun width(func: (index: Any, height: Any) -> Any): JQuery
    fun clearQueue(queueName: String? = null): JQuery
    fun data(key: String, value: Any): JQuery
    fun data(obj: Json): JQuery
    fun data(key: String? = null): Any
    fun dequeue(queueName: String? = null): JQuery
    fun removeData(nameOrList: Any? = null): JQuery
    fun promise(`type`: Any? = null, target: Any? = null): JQueryPromise<Any>
//    fun animate(properties: Any, duration: Any? = null, complete: Function? = null): JQuery
//    fun animate(properties: Any, duration: Any? = null, easing: String? = null, complete: Function? = null): JQuery
//    fun animate(properties: Any, options: { duration?: any; easing?: string; complete?: Function; step?: Function; queue?: boolean; specialEasing?: any; }): JQuery
    fun delay(duration: Number, queueName: String? = null): JQuery
    fun fadeIn(duration: Any? = null, callback: Any? = null): JQuery
    fun fadeIn(duration: Any? = null, easing: String? = null, callback: Any? = null): JQuery
    fun fadeOut(duration: Any? = null, callback: Any? = null): JQuery
    fun fadeOut(duration: Any? = null, easing: String? = null, callback: Any? = null): JQuery
    fun fadeTo(duration: Any, opacity: Number, callback: Any? = null): JQuery
    fun fadeTo(duration: Any, opacity: Number, easing: String? = null, callback: Any? = null): JQuery
    fun fadeToggle(duration: Any? = null, callback: Any? = null): JQuery
    fun fadeToggle(duration: Any? = null, easing: String? = null, callback: Any? = null): JQuery
    fun finish(): JQuery
    fun hide(duration: Any? = null, callback: Any? = null): JQuery
    fun hide(duration: Any? = null, easing: String? = null, callback: Any? = null): JQuery
    fun show(duration: Any? = null, callback: Any? = null): JQuery
    fun show(duration: Any? = null, easing: String? = null, callback: Any? = null): JQuery
    fun slideDown(duration: Any? = null, callback: Any? = null): JQuery
    fun slideDown(duration: Any? = null, easing: String? = null, callback: Any? = null): JQuery
    fun slideToggle(duration: Any? = null, callback: Any? = null): JQuery
    fun slideToggle(duration: Any? = null, easing: String? = null, callback: Any? = null): JQuery
    fun slideUp(duration: Any? = null, callback: Any? = null): JQuery
    fun slideUp(duration: Any? = null, easing: String? = null, callback: Any? = null): JQuery
    fun stop(clearQueue: Boolean? = null, jumpToEnd: Boolean? = null): JQuery
    fun stop(queue: Any? = null, clearQueue: Boolean? = null, jumpToEnd: Boolean? = null): JQuery
    fun toggle(duration: Any? = null, callback: Any? = null): JQuery
    fun toggle(duration: Any? = null, easing: String? = null, callback: Any? = null): JQuery
    fun toggle(showOrHide: Boolean): JQuery
    fun bind(eventType: String, eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun bind(eventType: String, eventData: Any, preventBubble: Boolean): JQuery
    fun bind(eventType: String, preventBubble: Boolean): JQuery
    fun bind(vararg events: Any): JQuery
    fun blur(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun blur(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun change(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun change(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun click(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun click(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun dblclick(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun dblclick(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun delegate(selector: Any, eventType: String, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun focus(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun focus(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun focusin(eventData: Any, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun focusin(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun focusout(eventData: Any, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun focusout(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun hover(handlerIn: (eventObject: JQueryEventObject) -> Any, handlerOut: (eventObject: JQueryEventObject) -> Any): JQuery
    fun hover(handlerInOut: (eventObject: JQueryEventObject) -> Any): JQuery
    fun keydown(eventData: Any? = null, handler: ((eventObject: JQueryKeyEventObject) -> Any)? = null): JQuery
    fun keydown(handler: (eventObject: JQueryKeyEventObject) -> Any): JQuery
    fun keypress(eventData: Any? = null, handler: ((eventObject: JQueryKeyEventObject) -> Any)? = null): JQuery
    fun keypress(handler: (eventObject: JQueryKeyEventObject) -> Any): JQuery
    fun keyup(eventData: Any? = null, handler: ((eventObject: JQueryKeyEventObject) -> Any)? = null): JQuery
    fun keyup(handler: (eventObject: JQueryKeyEventObject) -> Any): JQuery
    fun load(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun load(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun mousedown(): JQuery
    fun mousedown(eventData: Any, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mousedown(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseevent(eventData: Any, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseevent(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseenter(): JQuery
    fun mouseenter(eventData: Any, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseenter(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseleave(): JQuery
    fun mouseleave(eventData: Any, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseleave(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mousemove(): JQuery
    fun mousemove(eventData: Any, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mousemove(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseout(): JQuery
    fun mouseout(eventData: Any, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseout(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseover(): JQuery
    fun mouseover(eventData: Any, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseover(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseup(): JQuery
    fun mouseup(eventData: Any, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseup(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun off(events: String? = null, selector: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun off(eventsMap: Json, selector: Any? = null): JQuery
    fun on(events: String, selector: Any? = null, data: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun on(events: String, selector: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun on(eventsMap: Json, selector: Any? = null, data: Any? = null): JQuery
    fun one(events: String, selector: Any? = null, data: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun one(eventsMap: Json, selector: Any? = null, data: Any? = null): JQuery
    fun ready(handler: Any): JQuery
    fun resize(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun resize(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun scroll(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun scroll(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun select(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun select(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun submit(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun submit(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun trigger(eventType: String, vararg extraParameters: Any): JQuery
    fun trigger(event: JQueryEventObject): JQuery
    fun triggerHandler(eventType: String, vararg extraParameters: Any): Any
    fun unbind(eventType: String? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun unbind(eventType: String, fls: Boolean): JQuery
    fun unbind(evt: Any): JQuery
    fun undelegate(): JQuery
    fun undelegate(selector: Any, eventType: String, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun undelegate(selector: Any, events: Any): JQuery
    fun undelegate(namespace: String): JQuery
    fun unload(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun unload(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    var context: Element
    var jquery: String
    fun error(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun error(eventData: Any, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun pushStack(elements: Array<Any>): JQuery
    fun pushStack(elements: Array<Any>, name: Any, arguments: Any): JQuery
    fun after(vararg content: Any): JQuery
    fun after(func: (index: Any) -> Any): JQuery
    fun append(vararg content: Any): JQuery
    fun append(func: (index: Any, html: Any) -> Any): JQuery
    fun appendTo(target: Any): JQuery
    fun before(vararg content: Any): JQuery
    fun before(func: (index: Any) -> Any): JQuery
    fun clone(withDataAndEvents: Boolean? = null, deepWithDataAndEvents: Boolean? = null): JQuery
    fun detach(selector: Any? = null): JQuery
    fun empty(): JQuery
    fun insertAfter(target: Any): JQuery
    fun insertBefore(target: Any): JQuery
    fun prepend(vararg content: Any): JQuery
    fun prepend(func: (index: Any, html: Any) -> Any): JQuery
    fun prependTo(target: Any): JQuery
    fun remove(selector: Any? = null): JQuery
    fun replaceAll(target: Any): JQuery
    fun replaceWith(func: Any): JQuery
    fun text(): String
    fun text(textString: Any): JQuery
    fun text(textString: (index: Number, text: String) -> String): JQuery
    fun toArray(): Array<Any>
    fun unwrap(): JQuery
    fun wrap(wrappingElement: Any): JQuery
    fun wrap(func: (index: Any) -> Any): JQuery
    fun wrapAll(wrappingElement: Any): JQuery
    fun wrapInner(wrappingElement: Any): JQuery
    fun wrapInner(func: (index: Any) -> Any): JQuery
    fun each(func: (index: Any, elem: Element) -> Any): JQuery
    fun get(index: Number? = null): Any
    fun index(): Number
    fun index(selector: String): Number
    fun index(element: Any): Number
    var length: Number
    var selector: String
    fun get(x: String): Any
    fun set(x: String, value: Any)
    fun get(x: Number): HTMLElement
    fun set(x: Number, value: HTMLElement)
    fun add(selector: String, context: Any? = null): JQuery
    fun add(vararg elements: Any): JQuery
    fun add(html: String): JQuery
    fun add(obj: JQuery): JQuery
    fun children(selector: Any? = null): JQuery
    fun closest(selector: String): JQuery
    fun closest(selector: String, context: Element? = null): JQuery
    fun closest(obj: JQuery): JQuery
    fun closest(element: Any): JQuery
    fun closest(selectors: Any, context: Element? = null): Array<Any>
    fun contents(): JQuery
    fun end(): JQuery
    fun eq(index: Number): JQuery
    fun filter(selector: String): JQuery
    fun filter(func: (index: Any) -> Any): JQuery
    fun filter(element: Any): JQuery
    fun filter(obj: JQuery): JQuery
    fun find(selector: String): JQuery
    fun find(element: Any): JQuery
    fun find(obj: JQuery): JQuery
    fun first(): JQuery
    fun has(selector: String): JQuery
    fun has(contained: Element): JQuery
    fun `is`(selector: String): Boolean
    fun `is`(func: (index: Any) -> Any): Boolean
    fun `is`(element: Any): Boolean
    fun `is`(obj: JQuery): Boolean
    fun last(): JQuery
    fun map(callback: (index: Any, domElement: Element) -> Any): JQuery
    fun next(selector: String? = null): JQuery
    fun nextAll(selector: String? = null): JQuery
    fun nextUntil(selector: String? = null, filter: String? = null): JQuery
    fun nextUntil(element: Element? = null, filter: String? = null): JQuery
    fun nextUntil(obj: JQuery? = null, filter: String? = null): JQuery
    fun not(selector: String): JQuery
    fun not(func: (index: Any) -> Any): JQuery
    fun not(element: Any): JQuery
    fun not(obj: JQuery): JQuery
    fun offsetParent(): JQuery
    fun parent(selector: String? = null): JQuery
    fun parents(selector: String? = null): JQuery
    fun parentsUntil(selector: String? = null, filter: String? = null): JQuery
    fun parentsUntil(element: Element? = null, filter: String? = null): JQuery
    fun parentsUntil(obj: JQuery? = null, filter: String? = null): JQuery
    fun prev(selector: String? = null): JQuery
    fun prevAll(selector: String? = null): JQuery
    fun prevUntil(selector: String? = null, filter: String? = null): JQuery
    fun prevUntil(element: Element? = null, filter: String? = null): JQuery
    fun prevUntil(obj: JQuery? = null, filter: String? = null): JQuery
    fun siblings(selector: String? = null): JQuery
    fun slice(start: Number, end: Number? = null): JQuery
    fun queue(queueName: String? = null): Array<Any>
    fun queue(queueName: String, newQueueOrCallback: Any): JQuery
    fun queue(newQueueOrCallback: Any): JQuery
}

@native
var jQuery: JQueryStatic = noImpl

@native
var `$`: JQueryStatic = noImpl
