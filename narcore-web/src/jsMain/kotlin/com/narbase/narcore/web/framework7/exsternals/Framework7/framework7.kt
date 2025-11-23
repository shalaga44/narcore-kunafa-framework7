@file:Suppress("unused")

package external.framework7

// Top-level app params
external interface Framework7Params {
    /** Root element selector or element */
    var el: dynamic /* String | HTMLElement */

    /** App name */
    var name: String?

    /** Default/global routes */
    var routes: Array<F7Route>?
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
/* {router: Router, to: {…}, from: {…}, resolve: ƒ, reject: ƒ, …}*/
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