@file:Suppress("unused")

package external.framework7



import org.w3c.dom.HTMLElement

external interface CSSSelector

external interface Framework7Events {
    var init: (() -> Unit)?
    var darkModeChange: ((isDark: Boolean) -> Unit)?
    var online: (() -> Unit)?
    var offline: (() -> Unit)?
    var connection: ((isOnline: Boolean) -> Unit)?
}

external interface Framework7Class<E> {
    fun on(event: String, handler: dynamic)
    fun once(event: String, handler: dynamic)
    fun off(event: String, handler: dynamic = definedExternally)
    fun emit(event: String, vararg args: Any?)
}

external interface Framework7EventsClass<E> {
    fun on(event: String, handler: dynamic)
    fun once(event: String, handler: dynamic)
    fun off(event: String, handler: dynamic = definedExternally)
    fun emit(event: String, vararg args: Any?)
}

external interface Framework7Plugin {
    var name: String
    var install: (() -> Unit)?
    fun create(instance: Framework7): (() -> Unit)?
    var params: dynamic
    var proto: dynamic

    @JsName("static")
    var staticProps: dynamic

    var instance: dynamic
    var on: dynamic
    var clicks: dynamic
}

external interface Framework7Params {
    var el: dynamic /* String | HTMLElement */
    var name: String?
    var theme: String?

    var routes: Array<F7Route>?

    var darkMode: dynamic /* Boolean | String */ get() = definedExternally; set(value) = definedExternally
    var lazyModulesPath: String? get() = definedExternally; set(value) = definedExternally
    var init: Boolean? get() = definedExternally; set(value) = definedExternally
    var initOnDeviceReady: Boolean? get() = definedExternally; set(value) = definedExternally
    var iosTranslucentBars: Boolean? get() = definedExternally; set(value) = definedExternally
    var iosTranslucentModals: Boolean? get() = definedExternally; set(value) = definedExternally

    var colors: Framework7Colors
    var userAgent: String? get() = definedExternally; set(value) = definedExternally
    var url: String? get() = definedExternally; set(value) = definedExternally

    var on: dynamic get() = definedExternally; set(value) = definedExternally

    var view: dynamic get() = definedExternally; set(value) = definedExternally
}


external interface Framework7Colors {
    var primary: String?
    var red: String?
    var green: String?
    var blue: String?
    var pink: String?
    var yellow: String?
    var orange: String?
    var purple: String?
    var deeppurple: String?
    var lightblue: String?
    var teal: String?
    var lime: String?
    var deeporange: String?
    var white: String?
    var black: String?
}
external interface Events : Framework7EventsClass<Framework7Events>

external open class Framework7MainClass(parameters: Framework7Params = definedExternally) :
    Framework7Class<Framework7Events> {

    open var name: String
    open var routes: Array<F7Route>
    open var el: HTMLElement
    open var `$el`: dynamic

    open var rtl: Boolean
    open val dialog: DialogModule
    open var theme: String
    open var darkMode: Boolean

    open var data: dynamic
    open var methods: dynamic

    open var initialized: Boolean
    open var online: Boolean

    open var `$`: dynamic

    open var params: Framework7Params
    open var colors: dynamic

    open fun setColorTheme(hexColor: String)
    open fun setDarkMode(mode: dynamic /* Boolean | String */)
    open fun init()
    open fun loadModule(module: dynamic): dynamic
    open fun loadModules(modules: Array<dynamic>): dynamic

    open fun createStore(storeParameters: dynamic): dynamic
    override fun on(event: String, handler: Any?) = definedExternally
    override fun once(event: String, handler: Any?) = definedExternally

    override fun off(event: String, handler: Any?) = definedExternally
    override fun emit(event: String, vararg args: Any?) = definedExternally

    companion object {
        fun use(plugin: Framework7Plugin)
        fun use(plugins: Array<Framework7Plugin>)

        fun getDevice(overrides: dynamic = definedExternally): dynamic
        fun getSupport(): dynamic

        val device: dynamic
        val support: dynamic
        val utils: dynamic
        val Events: Events
        val Component: dynamic

        fun registerComponent(tagName: String, component: dynamic)
        fun unregisterComponent(tagName: String)
    }
}
external interface AsyncArgs {
    val router: dynamic
    val to: dynamic
    val from: dynamic
    val resolve: (params: F7AsyncResolveParams, options: F7RouteOptions?) -> Unit
    val reject: () -> Unit
}
operator fun AsyncArgs.component1() = router
operator fun AsyncArgs.component2() = to
operator fun AsyncArgs.component3() = from
operator fun AsyncArgs.component4() = resolve
operator fun AsyncArgs.component5() = reject
/**
 * Single route definition, matches Framework7 router docs (v8).
 *
 */
external interface F7Route {
    // Basic identity
    var name: String?
    var path: String

    // Content-related
    var url: String?
    var content: String?
    var pageName: String?
    var el: dynamic /* HTMLElement? */

    // Component-based
    var component: dynamic
    var componentUrl: String?

    /**
     * Async route handler (old 4-arg style):
     * async(routeTo, routeFrom, resolve, reject) { ... }
     */
    var async: ((AsyncArgs) -> Unit)?

    // Nested routes
    var routes: Array<F7Route>?

    // View targeting
    var viewName: String?

    // Master-detail
    var master: dynamic /* Boolean | (app, router) -> Boolean */
    var detailRoutes: Array<F7Route>?

    // Routable tabs / modals / panels
    var tabs: Array<dynamic>?
    var actions: dynamic
    var popup: dynamic
    var loginScreen: dynamic
    var popover: dynamic
    var sheet: dynamic
    var panel: dynamic

    // Events
    var on: F7RouteEvents

    // Alias / redirect
    var alias: dynamic /* String | Array<String> */
    var redirect: dynamic /* String | (context: F7RouteContext) -> Unit */

    // Guards
    var beforeEnter: dynamic /* (F7RouteContext) -> Unit | Array<(F7RouteContext) -> Unit> */
    var beforeLeave: dynamic /* (F7RouteContext) -> Unit | Array<(F7RouteContext) -> Unit> */

    // Keep alive
    var keepAlive: Boolean?
}

/**
 * Options you can pass to resolve() or as route.options.
 */
external interface F7RouteOptions {
    var animate: Boolean?
    var history: Boolean?
    var browserHistory: Boolean?
    var reloadCurrent: Boolean?
    var reloadPrevious: Boolean?
    var reloadAll: Boolean?
    var clearPreviousHistory: Boolean?
    var ignoreCache: Boolean?
    var force: Boolean?
    var props: dynamic
    var transition: String?

    /** popup | popover | loginScreen | sheet | panel */
    var openIn: String?
}

/**
 * Context object in beforeEnter/beforeLeave/redirect async-style
 * if you ever switch to the new signature async({ app, to, from, resolve, reject }).
 */
external interface F7RouteContext {
    val app: dynamic
    val to: dynamic
    val from: dynamic
    val router: dynamic
    val resolve: (params: F7AsyncResolveParams, options: F7RouteOptions?) -> Unit
    val reject: () -> Unit
    val direction: String?
}

/**
 * Parameters you pass to resolve() in async routes.
 * You usually set exactly one of url/content/component/componentUrl,
 * plus optionally popup/loginScreen/sheet/panel.
 */
external interface F7AsyncResolveParams {
    var url: String?
    var content: String?
    var component: dynamic
    var componentUrl: String?

    var loginScreen: dynamic
    var popup: dynamic
    var sheet: dynamic
    var panel: dynamic
}

/**
 * Route-level page events (pageInit, pageAfterIn, etc).
 */
external interface F7RouteEvents {
    var pageBeforeIn: ((event: dynamic, page: dynamic) -> Unit)
    var pageAfterIn: ((event: dynamic, page: dynamic) -> Unit)
    var pageInit: ((event: dynamic, page: dynamic) -> Unit)
    var pageBeforeRemove: ((event: dynamic, page: dynamic) -> Unit)
}


external interface DialogButtonParameters {
    var text: String? get() = definedExternally; set(value) = definedExternally
    var strong: Boolean? get() = definedExternally; set(value) = definedExternally
    var color: String? get() = definedExternally; set(value) = definedExternally
    var close: Boolean? get() = definedExternally; set(value) = definedExternally
    var cssClass: String? get() = definedExternally; set(value) = definedExternally
    var keyCodes: Array<Int>? get() = definedExternally; set(value) = definedExternally
    var onClick: ((dialog: Dialog, e: dynamic) -> Unit)? get() = definedExternally; set(value) = definedExternally
}

external interface DialogEvents {
    var open: ((dialog: Dialog) -> Unit)? get() = definedExternally; set(value) = definedExternally
    var opened: ((dialog: Dialog) -> Unit)? get() = definedExternally; set(value) = definedExternally
    var close: ((dialog: Dialog) -> Unit)? get() = definedExternally; set(value) = definedExternally
    var closed: ((dialog: Dialog) -> Unit)? get() = definedExternally; set(value) = definedExternally
    var beforeDestroy: ((dialog: Dialog) -> Unit)? get() = definedExternally; set(value) = definedExternally
}

external interface DialogParameters {
    var el: dynamic /* HTMLElement | String */ get() = definedExternally; set(value) = definedExternally
    var containerEl: dynamic /* HTMLElement | String */ get() = definedExternally; set(value) = definedExternally
    var backdrop: Boolean? get() = definedExternally; set(value) = definedExternally
    var closeByBackdropClick: Boolean? get() = definedExternally; set(value) = definedExternally
    var animate: Boolean? get() = definedExternally; set(value) = definedExternally
    var title: String? get() = definedExternally; set(value) = definedExternally
    var text: String? get() = definedExternally; set(value) = definedExternally
    var content: String? get() = definedExternally; set(value) = definedExternally
    var buttons: Array<DialogButtonParameters>? get() = definedExternally; set(value) = definedExternally
    var verticalButtons: Boolean? get() = definedExternally; set(value) = definedExternally
    var destroyOnClose: Boolean? get() = definedExternally; set(value) = definedExternally
    var onClick: ((dialog: Dialog, index: Int) -> Unit)? get() = definedExternally; set(value) = definedExternally
    var cssClass: String? get() = definedExternally; set(value) = definedExternally
    var on: DialogEvents? get() = definedExternally; set(value) = definedExternally
}

external interface Dialog {
    val app: dynamic /* Framework7 */ get() = definedExternally
    val el: HTMLElement? get() = definedExternally
    val `$el`: dynamic get() = definedExternally
    val backdropEl: HTMLElement? get() = definedExternally
    val `$backdropEl`: dynamic get() = definedExternally
    val params: DialogParameters
    val opened: Boolean

    fun open(animate: Boolean = definedExternally): Dialog
    fun close(animate: Boolean = definedExternally): Dialog

    fun setProgress(progress: Number, duration: Number = definedExternally)
    fun setTitle(title: String)
    fun setText(text: String)

    fun destroy()

    fun on(event: String, handler: (Dialog, dynamic) -> Unit)
    fun once(event: String, handler: (Dialog, dynamic) -> Unit)
    fun off(event: String, handler: (Dialog, dynamic) -> Unit)
    fun off(event: String)
    fun emit(event: String, vararg args: Any?)
}

external interface Framework7DialogShortcutParameters {
    var title: String? get() = definedExternally; set(value) = definedExternally
    var buttonOk: String? get() = definedExternally; set(value) = definedExternally
    var buttonCancel: String? get() = definedExternally; set(value) = definedExternally
    var usernamePlaceholder: String? get() = definedExternally; set(value) = definedExternally
    var passwordPlaceholder: String? get() = definedExternally; set(value) = definedExternally
    var preloaderTitle: String? get() = definedExternally; set(value) = definedExternally
    var progressTitle: String? get() = definedExternally; set(value) = definedExternally
    var destroyPredefinedDialogs: Boolean? get() = definedExternally; set(value) = definedExternally
    var keyboardActions: Boolean? get() = definedExternally; set(value) = definedExternally
    var autoFocus: Boolean? get() = definedExternally; set(value) = definedExternally
}

external interface DialogModule {
    fun create(params: DialogParameters = definedExternally): Dialog
    fun destroy(el: dynamic /* HTMLElement | String | Dialog */)
    fun get(el: dynamic /* HTMLElement | String */): Dialog?
    fun open(el: dynamic /* HTMLElement | String */, animate: Boolean = definedExternally): Dialog
    fun close(el: dynamic = definedExternally, animate: Boolean = definedExternally): Dialog

    fun alert(text: String, title: String, callback: (() -> Unit)? = definedExternally): Dialog
    fun alert(text: String, callback: (() -> Unit)? = definedExternally): Dialog

    fun confirm(
        text: String,
        title: String,
        callbackOk: (() -> Unit)? = definedExternally,
        callbackCancel: (() -> Unit)? = definedExternally,
    ): Dialog

    fun confirm(
        text: String,
        callbackOk: (() -> Unit)? = definedExternally,
        callbackCancel: (() -> Unit)? = definedExternally,
    ): Dialog

    fun prompt(
        text: String,
        title: String,
        callbackOk: ((value: String) -> Unit)? = definedExternally,
        callbackCancel: ((value: String) -> Unit)? = definedExternally,
        defaultValue: String = definedExternally,
    ): Dialog

    fun prompt(
        text: String,
        callbackOk: ((value: String) -> Unit)? = definedExternally,
        callbackCancel: ((value: String) -> Unit)? = definedExternally,
        defaultValue: String = definedExternally,
    ): Dialog

    fun login(
        text: String,
        title: String,
        callbackOk: ((username: String, password: String) -> Unit)? = definedExternally,
        callbackCancel: ((username: String, password: String) -> Unit)? = definedExternally,
    ): Dialog

    fun login(
        text: String,
        callbackOk: ((username: String, password: String) -> Unit)? = definedExternally,
        callbackCancel: ((username: String, password: String) -> Unit)? = definedExternally,
    ): Dialog

    fun password(
        text: String,
        title: String,
        callbackOk: ((password: String) -> Unit)? = definedExternally,
        callbackCancel: ((password: String) -> Unit)? = definedExternally,
    ): Dialog

    fun password(
        text: String,
        callbackOk: ((password: String) -> Unit)? = definedExternally,
        callbackCancel: ((password: String) -> Unit)? = definedExternally,
    ): Dialog

    fun preloader(title: String = definedExternally, color: String = definedExternally): Dialog
    fun progress(title: String = definedExternally, progress: Number = definedExternally, color: String = definedExternally): Dialog
}