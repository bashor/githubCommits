package jquery

import org.w3c.dom.Element
import js.dom.html.HTMLElement
import org.w3c.dom.Node
import org.w3c.dom.events.Event
import org.w3c.dom.events.PopStateEvent
import org.w3c.net.XMLHttpRequest

native
public trait JQueryAjaxSettings {
    public var accepts: Any?
    public var async: Boolean?
    public val beforeSend: ((jqXHR: JQueryXHR, settings: JQueryAjaxSettings) -> Any)?
    public var cache: Boolean?
    public val complete: ((jqXHR: JQueryXHR, textStatus: String) -> Any)?
    public var contents: Json?
    public var contentType: Any?
    public var context: Any?
    public var converters: Json?
    public var crossDomain: Boolean?
    public var data: Any?
    public val dataFilter: ((data: Any, ty: Any) -> Any)?
    public var dataType: String?
    public val error: ((jqXHR: JQueryXHR, textStatus: String, errorThrow: String) -> Any)?
    public var global: Boolean?
    public var headers: Json?
    public var ifModified: Boolean?
    public var isLocal: Boolean?
    public var jsonp: String?
    public var jsonpCallback: Any?
    public var mimeType: String?
    public var password: String?
    public var processData: Boolean?
    public var scriptCharset: String?
    public var statusCode: Json?
    public val success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)?
    public var timeout: Number?
    public var traditional: Boolean?
    public var `type`: String?
    public var url: String?
    public var username: String?
    public var xhr: Any?
    public var xhrFields: Json?
}
native
public trait JQueryXHR : XMLHttpRequest, JQueryPromise<Any> {
//    public override fun overrideMimeType(mimeType: String): Any
    public fun abort(statusText: String? = null): Unit
}
native
public trait JQueryCallback {
    public fun add(vararg callbacks: Any): Any
    public fun disable(): Any
    public fun empty(): Any
    public fun fire(vararg arguments: Any): Any
    public fun fired(): Boolean
    public fun fireWith(context: Any, vararg args: Any): Any
    public fun has(callback: Any): Boolean
    public fun lock(): Any
    public fun locked(): Boolean
    public fun remove(vararg callbacks: Any): Any
}
native
public trait JQueryGenericPromise<T> {
    public fun then<U>(onFulfill: (value: T) -> U, onReject: ((reason: Any) -> U)? = null): JQueryGenericPromise<U>
    public fun then<U>(onFulfill: (value: T) -> JQueryGenericPromise<U>, onReject: ((reason: Any) -> U)? = null): JQueryGenericPromise<U>
    public fun then<U>(onFulfill: (value: T) -> U, onReject: ((reason: Any) -> JQueryGenericPromise<U>)? = null): JQueryGenericPromise<U>
    public fun then<U>(onFulfill: (value: T) -> JQueryGenericPromise<U>, onReject: ((reason: Any) -> JQueryGenericPromise<U>)? = null): JQueryGenericPromise<U>
}
native
public trait JQueryPromise<T> {
    public fun always(vararg alwaysCallbacks: Any): JQueryPromise<T>
    public fun done(vararg doneCallbacks: Any): JQueryPromise<T>
    public fun fail(vararg failCallbacks: Any): JQueryPromise<T>
    public fun progress(vararg progressCallbacks: Any): JQueryPromise<T>
    public fun pipe(doneFilter: ((x: Any) -> Any)? = null, failFilter: ((x: Any) -> Any)? = null, progressFilter: ((x: Any) -> Any)? = null): JQueryPromise<Any>
    public fun then<U>(onFulfill: (value: T) -> U, onReject: ((vararg reasons: Any) -> U)? = null, onProgress: ((vararg progression: Any) -> Any)? = null): JQueryPromise<U>
    public fun then<U>(onFulfill: (value: T) -> JQueryGenericPromise<U>, onReject: ((vararg reasons: Any) -> U)? = null, onProgress: ((vararg progression: Any) -> Any)? = null): JQueryPromise<U>
    public fun then<U>(onFulfill: (value: T) -> U, onReject: ((vararg reasons: Any) -> JQueryGenericPromise<U>)? = null, onProgress: ((vararg progression: Any) -> Any)? = null): JQueryPromise<U>
    public fun then<U>(onFulfill: (value: T) -> JQueryGenericPromise<U>, onReject: ((vararg reasons: Any) -> JQueryGenericPromise<U>)? = null, onProgress: ((vararg progression: Any) -> Any)? = null): JQueryPromise<U>
//    public fun then<U>(onFulfill: (vararg values: Any) -> U, onReject: ((vararg reasons: Any) -> U)? = null, onProgress: ((vararg progression: Any) -> Any)? = null): JQueryPromise<U>
//    public fun then<U>(onFulfill: (vararg values: Any) -> JQueryGenericPromise<U>, onReject: ((vararg reasons: Any) -> U)? = null, onProgress: ((vararg progression: Any) -> Any)? = null): JQueryPromise<U>
//    public fun then<U>(onFulfill: (vararg values: Any) -> U, onReject: ((vararg reasons: Any) -> JQueryGenericPromise<U>)? = null, onProgress: ((vararg progression: Any) -> Any)? = null): JQueryPromise<U>
//    public fun then<U>(onFulfill: (vararg values: Any) -> JQueryGenericPromise<U>, onReject: ((vararg reasons: Any) -> JQueryGenericPromise<U>)? = null, onProgress: ((vararg progression: Any) -> Any)? = null): JQueryPromise<U>
}
native
public trait JQueryDeferred<T> : JQueryPromise<T> {
    public override fun always(vararg alwaysCallbacks: Any): JQueryDeferred<T>
    public override fun done(vararg doneCallbacks: Any): JQueryDeferred<T>
    public override fun fail(vararg failCallbacks: Any): JQueryDeferred<T>
    public override fun progress(vararg progressCallbacks: Any): JQueryDeferred<T>
    public fun notify(vararg args: Any): JQueryDeferred<T>
    public fun notifyWith(context: Any, vararg args: Any): JQueryDeferred<T>
    public fun reject(vararg args: Any): JQueryDeferred<T>
    public fun rejectWith(context: Any, vararg args: Any): JQueryDeferred<T>
    public fun resolve(`val`: T): JQueryDeferred<T>
    public fun resolve(vararg args: Any): JQueryDeferred<T>
    public fun resolveWith(context: Any, vararg args: Any): JQueryDeferred<T>
    public fun state(): String
    public fun promise(target: Any? = null): JQueryPromise<T>
}
native
public trait BaseJQueryEventObject : Event {
    public var data: Any
    public var delegateTarget: Element
    public fun isDefaultPrevented(): Boolean
    public fun isImmediatePropogationStopped(): Boolean
    public fun isPropagationStopped(): Boolean
    public var namespace: String
//    public fun preventDefault(): Any
    public var relatedTarget: Element
    public var result: Any
    public fun stopImmediatePropagation(): Unit
//    public fun stopPropagation(): Unit
    public var pageX: Number
    public var pageY: Number
    public var which: Number
//    public var metaKey: Any
}
native
public trait JQueryInputEventObject : BaseJQueryEventObject {
    public var altKey: Boolean
    public var ctrlKey: Boolean
    public var metaKey: Boolean
    public var shiftKey: Boolean
}
native
public trait JQueryMouseEventObject : JQueryInputEventObject {
    public var button: Number
    public var clientX: Number
    public var clientY: Number
    public var offsetX: Number
    public var offsetY: Number
    public override var pageX: Number
    public override var pageY: Number
    public var screenX: Number
    public var screenY: Number
}
native
public trait JQueryKeyEventObject : JQueryInputEventObject {
    public var char: Any
    public var charCode: Number
    public var key: Any
    public var keyCode: Number
}

native
public trait JQueryPopStateEventObject : BaseJQueryEventObject {
    public var originalEvent: PopStateEvent
}
native
public trait JQueryEventObject : BaseJQueryEventObject, JQueryInputEventObject, JQueryMouseEventObject, JQueryKeyEventObject, JQueryPopStateEventObject {
}
native
public trait JQuerySupport {
    public var ajax: Boolean?
    public var boxModel: Boolean?
    public var changeBubbles: Boolean?
    public var checkClone: Boolean?
    public var checkOn: Boolean?
    public var cors: Boolean?
    public var cssFloat: Boolean?
    public var hrefNormalized: Boolean?
    public var htmlSerialize: Boolean?
    public var leadingWhitespace: Boolean?
    public var noCloneChecked: Boolean?
    public var noCloneEvent: Boolean?
    public var opacity: Boolean?
    public var optDisabled: Boolean?
    public var optSelected: Boolean?
    public val scriptEval: (() -> Boolean)?
    public var style: Boolean?
    public var submitBubbles: Boolean?
    public var tbody: Boolean?
}
native
public trait JQueryParam {
    public fun invoke(obj: Any): String
    public fun invoke(obj: Any, traditional: Boolean): String
}
native
public trait JQueryStatic {
    public fun ajax(settings: JQueryAjaxSettings): JQueryXHR
    public fun ajax(url: String, settings: JQueryAjaxSettings? = null): JQueryXHR
    public fun ajaxPrefilter(dataTypes: String, handler: (opts: Any, originalOpts: Any, jqXHR: JQueryXHR) -> Any): Any
    public fun ajaxPrefilter(handler: (opts: Any, originalOpts: Any, jqXHR: JQueryXHR) -> Any): Any
    public var ajaxSettings: JQueryAjaxSettings
    public fun ajaxSetup(): Unit
    public fun ajaxSetup(options: JQueryAjaxSettings): Unit
    public fun get(url: String, data: Any? = null, success: Any? = null, dataType: Any? = null): JQueryXHR
    public fun getJSON(url: String, data: Any? = null, success: Any? = null): JQueryXHR
    public fun getScript(url: String, success: Any? = null): JQueryXHR
    public var param: JQueryParam
    public fun post(url: String, data: Any? = null, success: Any? = null, dataType: Any? = null): JQueryXHR
    public fun Callbacks(flags: String? = null): JQueryCallback
    public fun holdReady(hold: Boolean): Any
    public fun invoke(selector: String, context: Any? = null): JQuery
    public fun invoke(element: Element): JQuery
    public fun invoke(`object`: Any): JQuery
    public fun invoke(elementArray: Array<Element>): JQuery
    public fun invoke(`object`: JQuery): JQuery
//    public fun invoke(func: Function): JQuery
    public fun invoke(array: Array<Any>): JQuery
    public fun invoke(): JQuery
    public fun noConflict(removeAll: Boolean? = null): Any
    public fun `when`<T>(vararg deferreds: JQueryGenericPromise<T>): JQueryPromise<T>
    public fun `when`<T>(vararg deferreds: T): JQueryPromise<T>
    public fun `when`<T>(vararg deferreds: Any): JQueryPromise<T>
    public fun css(e: Any, propertyName: String, value: Any? = null): Any
    public fun css(e: Any, propertyName: Any, value: Any? = null): Any
    public var cssHooks: Json
    public var cssNumber: Any
    public fun data(element: Element, key: String, value: Any): Any
    public fun data(element: Element, key: String): Any
    public fun data(element: Element): Any
    public fun dequeue(element: Element, queueName: String? = null): Any
    public fun hasData(element: Element): Boolean
    public fun queue(element: Element, queueName: String? = null): Array<Any>
    public fun queue(element: Element, queueName: String, newQueueOrCallback: Any): JQuery
    public fun removeData(element: Element, name: String? = null): JQuery
    public fun Deferred<T>(beforeStart: ((deferred: JQueryDeferred<T>) -> Any)? = null): JQueryDeferred<T>
//    public var fx: { tick: () => void; interval: number; stop: () => void; speeds: { slow: number; fast: number; }; off: boolean; step: any; }
    public fun proxy(fn: (vararg args: Any) -> Any, context: Any, vararg args: Any): Any
    public fun proxy(context: Any, name: String, vararg args: Any): Any
//    public var Event: {
//        (name: string, eventProperties?: any): JQueryEventObject;
//        new (name: string, eventProperties?: any): JQueryEventObject;
//    }
    public fun error(message: Any): JQuery
    public var expr: Any
    public var fn: Any
    public var isReady: Boolean
    public var support: JQuerySupport
    public fun contains(container: Element, contained: Element): Boolean
    public fun each(collection: Any, callback: (indexInArray: Any, valueOfElement: Any) -> Any): Any
    public fun each(collection: JQuery, callback: (indexInArray: Number, valueOfElement: HTMLElement) -> Any): Any
    public fun each<T>(collection: Array<T>, callback: (indexInArray: Number, valueOfElement: T) -> Any): Any
    public fun extend(target: Any, vararg objs: Any): Any
    public fun extend(deep: Boolean, target: Any, vararg objs: Any): Any
    public fun globalEval(code: String): Any
    public fun grep<T>(array: Array<T>, func: (elementOfArray: T, indexInArray: Number) -> Boolean, invert: Boolean? = null): Array<T>
    public fun inArray<T>(value: T, array: Array<T>, fromIndex: Number? = null): Number
    public fun isArray(obj: Any): Boolean
    public fun isEmptyObject(obj: Any): Boolean
    public fun isFunction(obj: Any): Boolean
    public fun isNumeric(value: Any): Boolean
    public fun isPlainObject(obj: Any): Boolean
    public fun isWindow(obj: Any): Boolean
    public fun isXMLDoc(node: Node): Boolean
    public fun makeArray(obj: Any): Array<Any>
    public fun map<T, U>(array: Array<T>, callback: (elementOfArray: T, indexInArray: Number) -> U): Array<U>
    public fun map(array: Any, callback: (elementOfArray: Any, indexInArray: Any) -> Any): Any
    public fun merge<T>(first: Array<T>, second: Array<T>): Array<T>
    public fun merge<T, U>(first: Array<T>, second: Array<U>): Array<Any>
    public fun noop(): Any
    public fun now(): Number
    public fun parseJSON(json: String): Any
    public fun parseXML(data: String): Any
    public fun queue(element: Element, queueName: String, newQueue: Array<Any>): JQuery
    public fun trim(str: String): String
    public fun `type`(obj: Any): String
    public fun unique(arr: Array<Any>): Array<Any>
    public fun parseHTML(data: String, context: HTMLElement? = null, keepScripts: Boolean? = null): Array<Any>
    public fun Animation(elem: Any, properties: Any, options: Any): Any
}
native
public trait JQuery {
    public fun ajaxComplete(handler: Any): JQuery
    public fun ajaxError(handler: (event: Any, jqXHR: Any, settings: Any, exception: Any) -> Any): JQuery
    public fun ajaxSend(handler: (event: Any, jqXHR: Any, settings: Any, exception: Any) -> Any): JQuery
    public fun ajaxStart(handler: () -> Any): JQuery
    public fun ajaxStop(handler: () -> Any): JQuery
    public fun ajaxSuccess(handler: (event: Any, jqXHR: Any, settings: Any, exception: Any) -> Any): JQuery
    public fun load(url: String, data: Any? = null, complete: Any? = null): JQuery
    public fun serialize(): String
    public fun serializeArray(): Array<Any>
    public fun addClass(classNames: String): JQuery
    public fun addClass(func: (index: Any, currentClass: Any) -> String): JQuery
    public fun addBack(selector: String? = null): JQuery
    public fun attr(attributeName: String): String
    public fun attr(attributeName: String, value: Any): JQuery
    public fun attr(map: Json): JQuery
    public fun attr(attributeName: String, func: (index: Any, attr: Any) -> Any): JQuery
    public fun hasClass(className: String): Boolean
    public fun html(): String
    public fun html(htmlString: String): JQuery
    public fun html(htmlContent: (index: Number, oldhtml: String) -> String): JQuery
    public fun html(obj: JQuery): JQuery
    public fun prop(propertyName: String): Any
    public fun prop(propertyName: String, value: Any): JQuery
    public fun prop(map: Any): JQuery
    public fun prop(propertyName: String, func: (index: Any, oldPropertyValue: Any) -> Any): JQuery
    public fun removeAttr(attributeName: Any): JQuery
    public fun removeClass(className: Any? = null): JQuery
    public fun removeClass(func: (index: Any, cls: Any) -> Any): JQuery
    public fun removeProp(propertyName: Any): JQuery
    public fun toggleClass(className: Any, swtch: Boolean? = null): JQuery
    public fun toggleClass(swtch: Boolean? = null): JQuery
    public fun toggleClass(func: (index: Any, cls: Any, swtch: Any) -> Any): JQuery
    public fun `val`(): Any
    public fun `val`(value: Array<String>): JQuery
    public fun `val`(value: String): JQuery
    public fun `val`(value: Number): JQuery
    public fun `val`(func: (index: Any, value: Any) -> Any): JQuery
    public fun css(propertyName: String): String
    public fun css(propertyNames: Array<String>): String
    public fun css(properties: Any): JQuery
    public fun css(propertyName: String, value: Any): JQuery
    public fun css(propertyName: Any, value: Any): JQuery
    public fun height(): Number
    public fun height(value: Number): JQuery
    public fun height(value: String): JQuery
    public fun height(func: (index: Any, height: Any) -> Any): JQuery
    public fun innerHeight(): Number
    public fun innerHeight(value: Number): JQuery
    public fun innerWidth(): Number
    public fun innerWidth(value: Number): JQuery
//    public fun offset(): { left: number; top: number; }
    public fun offset(coordinates: Any): JQuery
    public fun offset(func: (index: Any, coords: Any) -> Any): JQuery
    public fun outerHeight(includeMargin: Boolean? = null): Number
    public fun outerHeight(value: Number, includeMargin: Boolean? = null): JQuery
    public fun outerWidth(includeMargin: Boolean? = null): Number
    public fun outerWidth(value: Number, includeMargin: Boolean? = null): JQuery
//    public fun position(): { top: number; left: number; }
    public fun scrollLeft(): Number
    public fun scrollLeft(value: Number): JQuery
    public fun scrollTop(): Number
    public fun scrollTop(value: Number): JQuery
    public fun width(): Number
    public fun width(value: Number): JQuery
    public fun width(value: String): JQuery
    public fun width(func: (index: Any, height: Any) -> Any): JQuery
    public fun clearQueue(queueName: String? = null): JQuery
    public fun data(key: String, value: Any): JQuery
    public fun data(obj: Json): JQuery
    public fun data(key: String? = null): Any
    public fun dequeue(queueName: String? = null): JQuery
    public fun removeData(nameOrList: Any? = null): JQuery
    public fun promise(`type`: Any? = null, target: Any? = null): JQueryPromise<Any>
//    public fun animate(properties: Any, duration: Any? = null, complete: Function? = null): JQuery
//    public fun animate(properties: Any, duration: Any? = null, easing: String? = null, complete: Function? = null): JQuery
//    public fun animate(properties: Any, options: { duration?: any; easing?: string; complete?: Function; step?: Function; queue?: boolean; specialEasing?: any; }): JQuery
    public fun delay(duration: Number, queueName: String? = null): JQuery
    public fun fadeIn(duration: Any? = null, callback: Any? = null): JQuery
    public fun fadeIn(duration: Any? = null, easing: String? = null, callback: Any? = null): JQuery
    public fun fadeOut(duration: Any? = null, callback: Any? = null): JQuery
    public fun fadeOut(duration: Any? = null, easing: String? = null, callback: Any? = null): JQuery
    public fun fadeTo(duration: Any, opacity: Number, callback: Any? = null): JQuery
    public fun fadeTo(duration: Any, opacity: Number, easing: String? = null, callback: Any? = null): JQuery
    public fun fadeToggle(duration: Any? = null, callback: Any? = null): JQuery
    public fun fadeToggle(duration: Any? = null, easing: String? = null, callback: Any? = null): JQuery
    public fun finish(): JQuery
    public fun hide(duration: Any? = null, callback: Any? = null): JQuery
    public fun hide(duration: Any? = null, easing: String? = null, callback: Any? = null): JQuery
    public fun show(duration: Any? = null, callback: Any? = null): JQuery
    public fun show(duration: Any? = null, easing: String? = null, callback: Any? = null): JQuery
    public fun slideDown(duration: Any? = null, callback: Any? = null): JQuery
    public fun slideDown(duration: Any? = null, easing: String? = null, callback: Any? = null): JQuery
    public fun slideToggle(duration: Any? = null, callback: Any? = null): JQuery
    public fun slideToggle(duration: Any? = null, easing: String? = null, callback: Any? = null): JQuery
    public fun slideUp(duration: Any? = null, callback: Any? = null): JQuery
    public fun slideUp(duration: Any? = null, easing: String? = null, callback: Any? = null): JQuery
    public fun stop(clearQueue: Boolean? = null, jumpToEnd: Boolean? = null): JQuery
    public fun stop(queue: Any? = null, clearQueue: Boolean? = null, jumpToEnd: Boolean? = null): JQuery
    public fun toggle(duration: Any? = null, callback: Any? = null): JQuery
    public fun toggle(duration: Any? = null, easing: String? = null, callback: Any? = null): JQuery
    public fun toggle(showOrHide: Boolean): JQuery
    public fun bind(eventType: String, eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    public fun bind(eventType: String, eventData: Any, preventBubble: Boolean): JQuery
    public fun bind(eventType: String, preventBubble: Boolean): JQuery
    public fun bind(vararg events: Any): JQuery
    public fun blur(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    public fun blur(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun change(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    public fun change(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun click(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    public fun click(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun dblclick(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    public fun dblclick(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun delegate(selector: Any, eventType: String, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun focus(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    public fun focus(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun focusin(eventData: Any, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun focusin(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun focusout(eventData: Any, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun focusout(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun hover(handlerIn: (eventObject: JQueryEventObject) -> Any, handlerOut: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun hover(handlerInOut: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun keydown(eventData: Any? = null, handler: ((eventObject: JQueryKeyEventObject) -> Any)? = null): JQuery
    public fun keydown(handler: (eventObject: JQueryKeyEventObject) -> Any): JQuery
    public fun keypress(eventData: Any? = null, handler: ((eventObject: JQueryKeyEventObject) -> Any)? = null): JQuery
    public fun keypress(handler: (eventObject: JQueryKeyEventObject) -> Any): JQuery
    public fun keyup(eventData: Any? = null, handler: ((eventObject: JQueryKeyEventObject) -> Any)? = null): JQuery
    public fun keyup(handler: (eventObject: JQueryKeyEventObject) -> Any): JQuery
    public fun load(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    public fun load(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun mousedown(): JQuery
    public fun mousedown(eventData: Any, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun mousedown(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun mouseevent(eventData: Any, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun mouseevent(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun mouseenter(): JQuery
    public fun mouseenter(eventData: Any, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun mouseenter(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun mouseleave(): JQuery
    public fun mouseleave(eventData: Any, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun mouseleave(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun mousemove(): JQuery
    public fun mousemove(eventData: Any, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun mousemove(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun mouseout(): JQuery
    public fun mouseout(eventData: Any, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun mouseout(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun mouseover(): JQuery
    public fun mouseover(eventData: Any, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun mouseover(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun mouseup(): JQuery
    public fun mouseup(eventData: Any, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun mouseup(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun off(events: String? = null, selector: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    public fun off(eventsMap: Json, selector: Any? = null): JQuery
    public fun on(events: String, selector: Any? = null, data: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    public fun on(events: String, selector: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    public fun on(eventsMap: Json, selector: Any? = null, data: Any? = null): JQuery
    public fun one(events: String, selector: Any? = null, data: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    public fun one(eventsMap: Json, selector: Any? = null, data: Any? = null): JQuery
    public fun ready(handler: Any): JQuery
    public fun resize(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    public fun resize(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun scroll(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    public fun scroll(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun select(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    public fun select(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun submit(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    public fun submit(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun trigger(eventType: String, vararg extraParameters: Any): JQuery
    public fun trigger(event: JQueryEventObject): JQuery
    public fun triggerHandler(eventType: String, vararg extraParameters: Any): Any
    public fun unbind(eventType: String? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    public fun unbind(eventType: String, fls: Boolean): JQuery
    public fun unbind(evt: Any): JQuery
    public fun undelegate(): JQuery
    public fun undelegate(selector: Any, eventType: String, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    public fun undelegate(selector: Any, events: Any): JQuery
    public fun undelegate(namespace: String): JQuery
    public fun unload(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    public fun unload(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public var context: Element
    public var jquery: String
    public fun error(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun error(eventData: Any, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun pushStack(elements: Array<Any>): JQuery
    public fun pushStack(elements: Array<Any>, name: Any, arguments: Any): JQuery
    public fun after(vararg content: Any): JQuery
    public fun after(func: (index: Any) -> Any): JQuery
    public fun append(vararg content: Any): JQuery
    public fun append(func: (index: Any, html: Any) -> Any): JQuery
    public fun appendTo(target: Any): JQuery
    public fun before(vararg content: Any): JQuery
    public fun before(func: (index: Any) -> Any): JQuery
    public fun clone(withDataAndEvents: Boolean? = null, deepWithDataAndEvents: Boolean? = null): JQuery
    public fun detach(selector: Any? = null): JQuery
    public fun empty(): JQuery
    public fun insertAfter(target: Any): JQuery
    public fun insertBefore(target: Any): JQuery
    public fun prepend(vararg content: Any): JQuery
    public fun prepend(func: (index: Any, html: Any) -> Any): JQuery
    public fun prependTo(target: Any): JQuery
    public fun remove(selector: Any? = null): JQuery
    public fun replaceAll(target: Any): JQuery
    public fun replaceWith(func: Any): JQuery
    public fun text(): String
    public fun text(textString: Any): JQuery
    public fun text(textString: (index: Number, text: String) -> String): JQuery
    public fun toArray(): Array<Any>
    public fun unwrap(): JQuery
    public fun wrap(wrappingElement: Any): JQuery
    public fun wrap(func: (index: Any) -> Any): JQuery
    public fun wrapAll(wrappingElement: Any): JQuery
    public fun wrapInner(wrappingElement: Any): JQuery
    public fun wrapInner(func: (index: Any) -> Any): JQuery
    public fun each(func: (index: Any, elem: Element) -> Any): JQuery
    public fun get(index: Number? = null): Any
    public fun index(): Number
    public fun index(selector: String): Number
    public fun index(element: Any): Number
    public var length: Number
    public var selector: String
    public fun get(x: String): Any
    public fun set(x: String, value: Any)
    public fun get(x: Number): HTMLElement
    public fun set(x: Number, value: HTMLElement)
    public fun add(selector: String, context: Any? = null): JQuery
    public fun add(vararg elements: Any): JQuery
    public fun add(html: String): JQuery
    public fun add(obj: JQuery): JQuery
    public fun children(selector: Any? = null): JQuery
    public fun closest(selector: String): JQuery
    public fun closest(selector: String, context: Element? = null): JQuery
    public fun closest(obj: JQuery): JQuery
    public fun closest(element: Any): JQuery
    public fun closest(selectors: Any, context: Element? = null): Array<Any>
    public fun contents(): JQuery
    public fun end(): JQuery
    public fun eq(index: Number): JQuery
    public fun filter(selector: String): JQuery
    public fun filter(func: (index: Any) -> Any): JQuery
    public fun filter(element: Any): JQuery
    public fun filter(obj: JQuery): JQuery
    public fun find(selector: String): JQuery
    public fun find(element: Any): JQuery
    public fun find(obj: JQuery): JQuery
    public fun first(): JQuery
    public fun has(selector: String): JQuery
    public fun has(contained: Element): JQuery
    public fun `is`(selector: String): Boolean
    public fun `is`(func: (index: Any) -> Any): Boolean
    public fun `is`(element: Any): Boolean
    public fun `is`(obj: JQuery): Boolean
    public fun last(): JQuery
    public fun map(callback: (index: Any, domElement: Element) -> Any): JQuery
    public fun next(selector: String? = null): JQuery
    public fun nextAll(selector: String? = null): JQuery
    public fun nextUntil(selector: String? = null, filter: String? = null): JQuery
    public fun nextUntil(element: Element? = null, filter: String? = null): JQuery
    public fun nextUntil(obj: JQuery? = null, filter: String? = null): JQuery
    public fun not(selector: String): JQuery
    public fun not(func: (index: Any) -> Any): JQuery
    public fun not(element: Any): JQuery
    public fun not(obj: JQuery): JQuery
    public fun offsetParent(): JQuery
    public fun parent(selector: String? = null): JQuery
    public fun parents(selector: String? = null): JQuery
    public fun parentsUntil(selector: String? = null, filter: String? = null): JQuery
    public fun parentsUntil(element: Element? = null, filter: String? = null): JQuery
    public fun parentsUntil(obj: JQuery? = null, filter: String? = null): JQuery
    public fun prev(selector: String? = null): JQuery
    public fun prevAll(selector: String? = null): JQuery
    public fun prevUntil(selector: String? = null, filter: String? = null): JQuery
    public fun prevUntil(element: Element? = null, filter: String? = null): JQuery
    public fun prevUntil(obj: JQuery? = null, filter: String? = null): JQuery
    public fun siblings(selector: String? = null): JQuery
    public fun slice(start: Number, end: Number? = null): JQuery
    public fun queue(queueName: String? = null): Array<Any>
    public fun queue(queueName: String, newQueueOrCallback: Any): JQuery
    public fun queue(newQueueOrCallback: Any): JQuery
}

native
public var jQuery: JQueryStatic = noImpl

native
public var `$`: JQueryStatic = noImpl
