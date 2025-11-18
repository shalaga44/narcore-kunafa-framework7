@file:JsModule("dom7")
@file:JsNonModule
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package external.framework7.dom7

import kotlin.js.*
import org.w3c.dom.*
import org.w3c.dom.events.*

external interface OffsetResult {
    var top: Number
    var left: Number
}

external interface Dom7Array {
    var length: Number
    fun pop(): Element?
    fun push(vararg items: Element): Number
    fun concat(vararg items: ConcatArray<Element>): Array<Element>
    fun concat(vararg items: Any /* Element | ConcatArray<Element> */): Array<Element>
    fun join(separator: String = definedExternally): String
    fun reverse(): Array<Element>
    fun shift(): Element?
    fun slice(start: Number = definedExternally, end: Number = definedExternally): Array<Element>
    fun sort(compareFn: (a: Element, b: Element) -> Number = definedExternally): Dom7Array /* this */
    fun splice(start: Number, deleteCount: Number = definedExternally): Array<Element>
    fun splice(start: Number): Array<Element>
    fun splice(start: Number, deleteCount: Number, vararg items: Element): Array<Element>
    fun unshift(vararg items: Element): Number
    fun indexOf(searchElement: Element, fromIndex: Number = definedExternally): Number
    fun lastIndexOf(searchElement: Element, fromIndex: Number = definedExternally): Number
    fun every(callbackfn: (value: Element, index: Number, array: Array<Element>) -> Any, thisArg: Any = definedExternally): Boolean
    fun some(callbackfn: (value: Element, index: Number, array: Array<Element>) -> Any, thisArg: Any = definedExternally): Boolean
    fun forEach(callbackfn: (value: Element, index: Number, array: Array<Element>) -> Unit, thisArg: Any = definedExternally)
    fun <U> map(callbackfn: (value: Element, index: Number, array: Array<Element>) -> U, thisArg: Any = definedExternally): Array<U>
    @nativeGetter
    operator fun get(index: Number): Element?
    @nativeSetter
    operator fun set(index: Number, value: Element)
    fun addClass(vararg className: String): Dom7Array
    fun removeClass(vararg className: String): Dom7Array
    fun hasClass(vararg className: String): Dom7Array
    fun toggleClass(vararg className: String): Dom7Array
    fun prop(propName: String): Any
    fun prop(propName: String, propValue: Any): Dom7Array
    fun prop(propertiesObject: Any): Dom7Array
    fun attr(attrName: String): String
    fun attr(attrName: String, attrValue: String): Dom7Array
    fun attr(attributesObject: Any): Dom7Array
    fun removeAttr(attrName: String): Dom7Array
    fun `val`(): Any
    fun `val`(newValue: Any): Dom7Array
    fun data(key: String, value: Any): Dom7Array
    fun data(key: String): Any
    fun removeData(key: String)
    fun dataset(): Any
    fun transform(CSSTransformString: String): Dom7Array
    fun transition(transitionDuration: Number): Dom7Array
    fun on(eventName: String, handler: (event: Event) -> Unit, useCapture: Boolean = definedExternally): Dom7Array
    fun on(eventName: String, handler: (event: Event) -> Unit): Dom7Array
    fun on(eventName: String, delegatedTarget: String, handler: (event: Event) -> Unit, useCapture: Boolean = definedExternally): Dom7Array
    fun on(eventName: String, delegatedTarget: String, handler: (event: Event) -> Unit): Dom7Array
    fun once(eventName: String, handler: (event: Event) -> Unit, useCapture: Boolean = definedExternally): Dom7Array
    fun once(eventName: String, handler: (event: Event) -> Unit): Dom7Array
    fun once(eventName: String, delegatedTarget: String, handler: (event: Event) -> Unit, useCapture: Boolean = definedExternally): Dom7Array
    fun once(eventName: String, delegatedTarget: String, handler: (event: Event) -> Unit): Dom7Array
    fun off(eventName: String, handler: (event: Event) -> Unit, useCapture: Boolean = definedExternally): Dom7Array
    fun off(eventName: String, handler: (event: Event) -> Unit): Dom7Array
    fun off(eventName: String, delegatedTarget: String, handler: (event: Event) -> Unit, useCapture: Boolean = definedExternally): Dom7Array
    fun off(eventName: String, delegatedTarget: String, handler: (event: Event) -> Unit): Dom7Array
    fun trigger(eventName: String, eventData: Any = definedExternally): Dom7Array
    fun transitionStart(callback: () -> Unit): Dom7Array
    fun transitionEnd(callback: () -> Unit): Dom7Array
    fun animationEnd(callback: () -> Unit): Dom7Array
    fun width(): Number
    fun width(value: String): Dom7Array
    fun width(value: Number): Dom7Array
    fun outerWidth(includeMargin: Boolean = definedExternally): Number
    fun outerWidth(): Number
    fun outerWidth(value: String): Dom7Array
    fun outerWidth(value: Number): Dom7Array
    fun height(): Number
    fun height(value: String): Dom7Array
    fun height(value: Number): Dom7Array
    fun outerHeight(includeMargin: Boolean = definedExternally): Number
    fun outerHeight(): Number
    fun outerHeight(value: String): Dom7Array
    fun outerHeight(value: Number): Dom7Array
    fun offset(): OffsetResult
    fun offset(value: String): Dom7Array
    fun offset(value: Number): Dom7Array
    fun hide()
    fun show()
    fun css(property: String): dynamic /* String | Number */
    fun css(property: String, value: String): Dom7Array
    fun css(property: String, value: Number): Dom7Array
    fun css(propertiesObject: Any): Dom7Array
    fun scrollTop(): Number
    fun scrollTop(position: Number, duration: Number = definedExternally, callback: () -> Unit = definedExternally): Dom7Array
    fun scrollTop(position: Number): Dom7Array
    fun scrollTop(position: Number, duration: Number = definedExternally): Dom7Array
    fun scrollLeft(): Number
    fun scrollLeft(position: Number, duration: Number = definedExternally, callback: () -> Unit = definedExternally): Dom7Array
    fun scrollLeft(position: Number): Dom7Array
    fun scrollLeft(position: Number, duration: Number = definedExternally): Dom7Array
    fun scrollTo(left: Number, top: Number, duration: Number = definedExternally, callback: () -> Unit = definedExternally): Dom7Array
    fun add(html: String): Dom7Array
    fun add(vararg elements: Any /* Element | Dom7Array */): Dom7Array
    fun each(callback: (element: Any, index: Number) -> Unit): Dom7Array
    fun html(): String
    fun html(newInnerHTML: String): Dom7Array
    fun text(): String
    fun text(newTextContent: String): Dom7Array
    fun `is`(CSSSelector: String): Boolean
    fun `is`(CSSSelector: Element): Boolean
    fun `is`(CSSSelector: Dom7Array): Boolean
    fun index(): Number
    fun eq(index: Number): Dom7Array
    fun append(element: String): Dom7Array
    fun append(element: Element): Dom7Array
    fun append(element: Dom7Array): Dom7Array
    fun appendTo(element: String): Dom7Array
    fun appendTo(element: Element): Dom7Array
    fun appendTo(element: Dom7Array): Dom7Array
    fun prepend(element: String): Dom7Array
    fun prepend(element: Element): Dom7Array
    fun prepend(element: Dom7Array): Dom7Array
    fun prependTo(element: String): Dom7Array
    fun prependTo(element: Element): Dom7Array
    fun prependTo(element: Dom7Array): Dom7Array
    fun insertBefore(element: String): Dom7Array
    fun insertBefore(element: Element): Dom7Array
    fun insertBefore(element: Dom7Array): Dom7Array
    fun insertAfter(element: String): Dom7Array
    fun insertAfter(element: Element): Dom7Array
    fun insertAfter(element: Dom7Array): Dom7Array
    fun next(selector: String = definedExternally): Dom7Array
    fun nextAll(selector: String = definedExternally): Dom7Array
    fun prev(selector: String = definedExternally): Dom7Array
    fun prevAll(selector: String = definedExternally): Dom7Array
    fun siblings(selector: String = definedExternally): Dom7Array
    fun parent(selector: String = definedExternally): Dom7Array
    fun parents(selector: String = definedExternally): Dom7Array
    fun closest(selector: String = definedExternally): Dom7Array
    fun find(selector: String = definedExternally): Dom7Array
    fun children(selector: String = definedExternally): Dom7Array
    fun filter(callback: (element: Any, index: Number) -> Boolean): Dom7Array
    fun remove(): Dom7Array
    fun empty(): Dom7Array
    fun click(): Dom7Array
    fun click(handler: (event: Event) -> Unit): Dom7Array
    fun blur(): Dom7Array
    fun blur(handler: (event: Event) -> Unit): Dom7Array
    fun focus(): Dom7Array
    fun focus(handler: (event: Event) -> Unit): Dom7Array
    fun focusin(): Dom7Array
    fun focusin(handler: (event: Event) -> Unit): Dom7Array
    fun focusout(): Dom7Array
    fun focusout(handler: (event: Event) -> Unit): Dom7Array
    fun keyup(): Dom7Array
    fun keyup(handler: (event: Event) -> Unit): Dom7Array
    fun keydown(): Dom7Array
    fun keydown(handler: (event: Event) -> Unit): Dom7Array
    fun keypress(): Dom7Array
    fun keypress(handler: (event: Event) -> Unit): Dom7Array
    fun submit(): Dom7Array
    fun submit(handler: (event: Event) -> Unit): Dom7Array
    fun change(): Dom7Array
    fun change(handler: (event: Event) -> Unit): Dom7Array
    fun mousedown(): Dom7Array
    fun mousedown(handler: (event: Event) -> Unit): Dom7Array
    fun mousemove(): Dom7Array
    fun mousemove(handler: (event: Event) -> Unit): Dom7Array
    fun mouseup(): Dom7Array
    fun mouseup(handler: (event: Event) -> Unit): Dom7Array
    fun mouseenter(): Dom7Array
    fun mouseenter(handler: (event: Event) -> Unit): Dom7Array
    fun mouseleave(): Dom7Array
    fun mouseleave(handler: (event: Event) -> Unit): Dom7Array
    fun mouseout(): Dom7Array
    fun mouseout(handler: (event: Event) -> Unit): Dom7Array
    fun mouseover(): Dom7Array
    fun mouseover(handler: (event: Event) -> Unit): Dom7Array
    fun touchstart(): Dom7Array
    fun touchstart(handler: (event: Event) -> Unit): Dom7Array
    fun touchend(): Dom7Array
    fun touchend(handler: (event: Event) -> Unit): Dom7Array
    fun touchmove(): Dom7Array
    fun touchmove(handler: (event: Event) -> Unit): Dom7Array
    fun resize(handler: (event: Event) -> Unit): Dom7Array
    fun scroll(handler: (event: Event) -> Unit): Dom7Array
    fun animate(properties: Any, parameters: Any): Dom7Array
}

@Suppress("EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface Dom7 {
    @nativeInvoke
    operator fun invoke(): Dom7Array
    @nativeInvoke
    operator fun invoke(selector: String, context: Element = definedExternally): Dom7Array
    @nativeInvoke
    operator fun invoke(selector: String): Dom7Array
    @nativeInvoke
    operator fun invoke(selector: String, context: Dom7Array = definedExternally): Dom7Array
    @nativeInvoke
    operator fun invoke(element: Element): Dom7Array
    @nativeInvoke
    operator fun invoke(element: Document): Dom7Array
    @nativeInvoke
    operator fun invoke(elementArray: Array<Element>): Dom7Array
    @nativeInvoke
    operator fun invoke(event: EventTarget): Dom7Array
    var fn: Any

    companion object : Dom7 by definedExternally
}

external var add: () -> Unit

external var addClass: () -> Unit

external var animate: () -> Unit

external var animationEnd: () -> Unit

external var append: () -> Unit

external var appendTo: () -> Unit

external var attr: () -> Unit

external var blur: () -> Unit

external var change: () -> Unit

external var children: () -> Unit

external var click: () -> Unit

external var closest: () -> Unit

external var css: () -> Unit

external var data: () -> Unit

external var dataset: () -> Unit

external var detach: () -> Unit

external var each: () -> Unit

external var empty: () -> Unit

external var eq: () -> Unit

external var filter: () -> Unit

external var find: () -> Unit

external var focus: () -> Unit

external var focusin: () -> Unit

external var focusout: () -> Unit

external var hasClass: () -> Unit

external var height: () -> Unit

external var hide: () -> Unit

external var html: () -> Unit

external var insertAfter: () -> Unit

external var insertBefore: () -> Unit

external var `is`: () -> Unit

external var keydown: () -> Unit

external var keypress: () -> Unit

external var keyup: () -> Unit

external var mousedown: () -> Unit

external var mouseenter: () -> Unit

external var mouseleave: () -> Unit

external var mousemove: () -> Unit

external var mouseout: () -> Unit

external var mouseover: () -> Unit

external var mouseup: () -> Unit

external var next: () -> Unit

external var nextAll: () -> Unit

external var off: () -> Unit

external var offset: () -> Unit

external var on: () -> Unit

external var once: () -> Unit

external var outerHeight: () -> Unit

external var outerWidth: () -> Unit

external var parent: () -> Unit

external var parents: () -> Unit

external var prepend: () -> Unit

external var prependTo: () -> Unit

external var prev: () -> Unit

external var prevAll: () -> Unit

external var prop: () -> Unit

external var remove: () -> Unit

external var removeAttr: () -> Unit

external var removeClass: () -> Unit

external var removeData: () -> Unit

external var resize: () -> Unit

external var scroll: () -> Unit

external var scrollLeft: () -> Unit

external var scrollTo: () -> Unit

external var scrollTop: () -> Unit

external var show: () -> Unit

external var siblings: () -> Unit

external var stop: () -> Unit

external var styles: () -> Unit

external var submit: () -> Unit

external var text: () -> Unit

external var toggleClass: () -> Unit

external var touchend: () -> Unit

external var touchmove: () -> Unit

external var touchstart: () -> Unit

external var transform: () -> Unit

external var transition: () -> Unit

external var transitionStart: () -> Unit

external var transitionEnd: () -> Unit

external var trigger: () -> Unit

external var `val`: () -> Unit

external var value: () -> Unit

external var width: () -> Unit

external interface ConcatArray<T> {
    val length: Number
    @nativeGetter
    operator fun get(n: Number): T?
    @nativeSetter
    operator fun set(n: Number, value: T)
    fun join(separator: String = definedExternally): String
    fun slice(start: Number = definedExternally, end: Number = definedExternally): Array<T>
}