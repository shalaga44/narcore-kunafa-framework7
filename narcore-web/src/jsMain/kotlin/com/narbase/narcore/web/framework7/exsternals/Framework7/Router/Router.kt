@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package external.framework7.Router

import external.framework7.dom7.Dom7Array
import kotlin.js.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.fetch.*

external interface ModalRouteParameters {
    var content: dynamic /* String? | HTMLElement? | Dom7Array? | Array<HTMLElement>? */
        get() = definedExternally
        set(value) = definedExternally
    var url: String?
        get() = definedExternally
        set(value) = definedExternally
    var component: dynamic /* Component? | Function<*>? | Any? */
        get() = definedExternally
        set(value) = definedExternally
    var componentUrl: String?
        get() = definedExternally
        set(value) = definedExternally
    val async: ((routeTo: Route, routeFrom: Route, resolve: Function<*>, reject: Function<*>) -> Unit)?
    val asyncComponent: (() -> Promise<Any>)?
}

external interface RouteCallbackCtx {
    var app: Any
    var to: Route
    var from: Route
    var resolve: Function<*>
    var reject: Function<*>
    var router: Router
    var direction: String? /* "forward" | "backward" */
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$0` {
    @nativeGetter
    operator fun get(event: String): ((e: Event, page: Any) -> Unit)?
    @nativeSetter
    operator fun set(event: String, value: (e: Event, page: Any) -> Unit)
}

external interface RouteParameters {
    var name: String?
        get() = definedExternally
        set(value) = definedExternally
    var path: String
    var viewName: String?
        get() = definedExternally
        set(value) = definedExternally
    var options: RouteOptions?
        get() = definedExternally
        set(value) = definedExternally
    var routes: Array<RouteParameters>?
        get() = definedExternally
        set(value) = definedExternally
    var modules: Array<Any>?
        get() = definedExternally
        set(value) = definedExternally
    var el: dynamic /* HTMLElement? | CSSSelector? */
        get() = definedExternally
        set(value) = definedExternally
    var pageName: String?
        get() = definedExternally
        set(value) = definedExternally
    // language="HTML"
    var content: dynamic /* String? | HTMLElement? | Dom7Array? | Array<HTMLElement>? */
        get() = definedExternally
        set(value) = definedExternally
    var url: String?
        get() = definedExternally
        set(value) = definedExternally
    var component: dynamic /* Component? | Function<*>? | Any? */
        get() = definedExternally
        set(value) = definedExternally
    var componentUrl: String?
        get() = definedExternally
        set(value) = definedExternally
    var async: ((ctx: RouteCallbackCtx) -> Unit)?
    val asyncComponent: (() -> Promise<Any>)?
    var id: String?
        get() = definedExternally
        set(value) = definedExternally
    var tabs: Array<RouteParameters>?
        get() = definedExternally
        set(value) = definedExternally
    var actions: Any? /* Actions.Parameters? & ModalRouteParameters? */
        get() = definedExternally
        set(value) = definedExternally
    var popup: Any? /* Popup.Parameters? & ModalRouteParameters? */
        get() = definedExternally
        set(value) = definedExternally
    var loginScreen: Any? /* LoginScreen.Parameters? & ModalRouteParameters? */
        get() = definedExternally
        set(value) = definedExternally
    var popover: Any? /* Popover.Parameters? & ModalRouteParameters? */
        get() = definedExternally
        set(value) = definedExternally
    var sheet: Any? /* Sheet.Parameters? & ModalRouteParameters? */
        get() = definedExternally
        set(value) = definedExternally
    var panel: Any? /* Panel.Parameters? & ModalRouteParameters? */
        get() = definedExternally
        set(value) = definedExternally
    var alias: dynamic /* String? | Array<Any>? */
        get() = definedExternally
        set(value) = definedExternally
    var redirect: dynamic /* String? | ((ctx: RouteCallbackCtx) -> Unit)? */
        get() = definedExternally
        set(value) = definedExternally
    var beforeEnter: dynamic /* Array<Function<*>>? | ((ctx: RouteCallbackCtx) -> Unit)? */
        get() = definedExternally
        set(value) = definedExternally
    var beforeLeave: dynamic /* Array<Function<*>>? | ((ctx: RouteCallbackCtx) -> Unit)? */
        get() = definedExternally
        set(value) = definedExternally
    var keepAlive: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var master: dynamic /* Boolean? | ((f7: Framework7, router: Router) -> Boolean)? */
        get() = definedExternally
        set(value) = definedExternally
    var detailRoutes: Array<RouteParameters>?
        get() = definedExternally
        set(value) = definedExternally
    var on: `T$0`?
        get() = definedExternally
        set(value) = definedExternally
}

external interface RouteOptions {
    var animate: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var history: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var browserHistory: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var reloadCurrent: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var reloadPrevious: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var reloadAll: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var clearPreviousHistory: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var ignoreCache: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var force: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var props: Any?
        get() = definedExternally
        set(value) = definedExternally
    var transition: String?
        get() = definedExternally
        set(value) = definedExternally
    var openIn: String? /* "popup" | "loginScreen" | "sheet" | "popover" | "panel" */
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$1` {
    @nativeGetter
    operator fun get(queryParameter: String): Any? /* Number? | String? */
    @nativeSetter
    operator fun set(queryParameter: String, value: Number?)
    @nativeSetter
    operator fun set(queryParameter: String, value: String?)
}

external interface NavigateParameters {
    var query: `T$1`?
        get() = definedExternally
        set(value) = definedExternally
    var params: `T$1`?
        get() = definedExternally
        set(value) = definedExternally
    var name: String?
        get() = definedExternally
        set(value) = definedExternally
    var path: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$2` {
    @nativeGetter
    operator fun get(queryParameter: String): String?
    @nativeSetter
    operator fun set(queryParameter: String, value: String?)
}

external interface Route {
    var url: String
    var path: String
    var query: `T$2`
    var params: `T$2`
    var name: String
    var hash: String
    var route: RouteParameters
    var props: Any?
}

external interface Page {
    @nativeGetter
    operator fun get(key: String): Dom7Array?
    @nativeSetter
    operator fun set(key: String, value: Dom7Array)
    var app: Any
    var view: Any
    var router: Router
    var name: String
    var el: HTMLElement
    var navbarEl: HTMLElement
    var from: String
    var to: String
    var position: String
    var direction: String
    var route: Route
    var pageFrom: Page
}

external interface `T$3` {
    var name: String
    var params: Any
    var query: Any
}

external interface Router  {
    @nativeGetter
    operator fun get(key: String): Dom7Array?
    @nativeSetter
    operator fun set(key: String, value: Dom7Array)
    var app: Any
    var view: Any
    var params: Any
    var el: HTMLElement
    var routes: Array<RouteParameters>
    var history: Array<String>
    var currentRoute: Route
    var previousRoute: Route
    var allowPageChange: Boolean
    fun generateUrl(parameters: `T$3`): String
    fun navigate(url: String, options: RouteOptions = definedExternally): Router
    fun navigate(url: String): Router
    fun navigate(parameters: NavigateParameters, options: RouteOptions = definedExternally): Router
    fun navigate(parameters: NavigateParameters): Router
    fun back(url: String = definedExternally, options: RouteOptions = definedExternally): Router
    fun refreshPage(props: Any = definedExternally): Router
    fun clearPreviousHistory(): Router
    fun updateCurrentUrl(url: String): Router
}

external interface SwipeBackData {
    var percentage: Number
    var currentPageEl: HTMLElement
    var previousPageEl: HTMLElement
    var currentNavbarEl: HTMLElement
    var previousNavbarEl: HTMLElement
}

external interface Events {
    fun routeChange(newRoute: Route, previousRoute: Route, router: Router)
    fun routeChanged(newRoute: Route, previousRoute: Route, router: Router)
    fun routeUrlUpdate(newRoute: Route, router: Router)
    fun routerAjaxSuccess(response: Response, options: RouteOptions)
    fun routerAjaxError(response: Response, options: RouteOptions)
    fun routerAjaxComplete(response: Response, options: RouteOptions)
    fun swipebackMove(data: SwipeBackData)
    fun swipebackBeforeChange(data: SwipeBackData)
    fun swipebackAfterChange(data: SwipeBackData)
    fun swipebackBeforeReset(data: SwipeBackData)
    fun swipebackAfterReset(data: SwipeBackData)
    fun pageMounted(page: Page)
    fun pageInit(page: Page)
    fun pageReinit(page: Page)
    fun pageBeforeIn(page: Page)
    fun pageAfterIn(page: Page)
    fun pageBeforeOut(page: Page)
    fun pageAfterOut(page: Page)
    fun pageBeforeRemove(page: Page)
    fun pageTabShow(pageEl: HTMLElement)
    fun pageTabHide(pageEl: HTMLElement)
    fun tabInit(newTabEl: HTMLElement, tabRoute: Route)
    fun tabMounted(newTabEl: HTMLElement, tabRoute: Route)
    fun tabBeforeRemove(oldTabEl: HTMLElement, newTabEl: HTMLElement, tabRoute: Route)
    fun modalInit(modalEl: HTMLElement, modalRoute: Route, modal: Any)
    fun modalMounted(modalEl: HTMLElement, modalRoute: Route, modal: Any)
    fun modalBeforeRemove(modalEl: HTMLElement, modalRoute: Route, modal: Any)
}

external interface DomEvents {
    @nativeGetter
    operator fun get(key: String): (() -> Unit)?
    @nativeSetter
    operator fun set(key: String, value: () -> Unit)
}

external interface `T$4` {
    var xhr: Array<Any?>
    var templates: Array<Any?>
    var components: Array<Any?>
}

external interface AppMethods {
    var cache: `T$4`
}

external interface AppParams {
    var router: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface AppEvents